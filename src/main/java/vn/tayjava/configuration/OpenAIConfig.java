package vn.tayjava.configuration;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import java.util.List;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAIConfig {
  private SecurityScheme createAPIKeyScheme() {
    return new SecurityScheme().type(SecurityScheme.Type.HTTP)
        .bearerFormat("JWT")
        .scheme("bearer");
  }
  @Bean
  public OpenAPI openAPI(@Value("${open.api.title}") String title,
      @Value("${open.api.version}") String version,
      @Value("${open.api.description}") String description,
      @Value("${open.api.serverUrl}") String serverUrl,
      @Value("${open.api.serverName}") String serverName
  ) {
    return new OpenAPI().info(new Info().title(title)
            .version(version).description(description)
            .license(new License().name("API license").url("htt://domain.vn/license")))
        .servers(List.of(new Server().url(serverUrl).description(serverName)))
        .components(
            new Components().addSecuritySchemes(
                "BearerAuth",createAPIKeyScheme()
            )
        ).security(List.of(new SecurityRequirement().addList("bearerAuth")));
  }

  /**
   * des: cau hinh ve sau cho microservice
   *
   * @return
   */
  @Bean
  public GroupedOpenApi groupedOpenApi() {
    return GroupedOpenApi.builder()
        .group("api-service")
        .packagesToScan("vn.tayjava.controller")//scan tat ca bean controller trong package do
        .build();
  }
}
