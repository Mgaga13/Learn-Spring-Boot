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
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("!prod")
public class OpenAIConfig {
  private SecurityScheme createAPIKeyScheme() {
    return new SecurityScheme().type(SecurityScheme.Type.HTTP)
        .bearerFormat("JWT")
        .scheme("bearer");
  }
//  @Bean
//  public OpenAPI openAPI(@Value("${open.api.title}") String title,
//      @Value("${open.api.version}") String version,
//      @Value("${open.api.description}") String description,
//      @Value("${open.api.serverUrl}") String serverUrl,
//      @Value("${open.api.serverName}") String serverName
//  ) {
//    return new OpenAPI().info(new Info().title(title)
//            .version(version).description(description)
//            .license(new License().name("API license").url("htt://domain.vn/license")))
//        .servers(List.of(new Server().url(serverUrl).description(serverName)))
//        .components(
//            new Components().addSecuritySchemes(
//                "BearerAuth",createAPIKeyScheme()
//            )
//        ).security(List.of(new SecurityRequirement().addList("bearerAuth")));
//  }

  @Bean
  public OpenAPI openAPI(
      @Value("${openapi.service.title}") String title,
      @Value("${openapi.service.version}") String version,
      @Value("${openapi.service.server}") String serverUrl) {
    return new OpenAPI()
        .servers(List.of(new Server().url(serverUrl)))
        .info(new Info().title(title)
            .description("API documents")
            .version(version)
            .license(new License().name("Apache 2.0").url("https://springdoc.org")));
  }
  /**
   * des: cau hinh ve sau cho microservice
   *
   * @return
   */
  @Bean
  public GroupedOpenApi publicApi(@Value("${openapi.service.api-docs}") String apiDocs) {
    return GroupedOpenApi.builder()
        .group(apiDocs) // /v3/api-docs/api-service
        .packagesToScan("vn.tayjava.controller")
        .build();
  }

}
