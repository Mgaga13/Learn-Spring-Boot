package vn.tayjava.configuration;

import jakarta.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import  org.springframework.util.StringUtils;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@Configurable
public class LocalResolver extends AcceptHeaderLocaleResolver implements WebMvcConfigurer {

  private static  final List<Locale> SUPPORTED_LOCALES = List.of(
      Locale.FRANCE,
      Locale.JAPAN,
      Locale.CANADA,
      Locale.KOREAN,
      new Locale("vi")
  );

  @Override
  public Locale resolveLocale(HttpServletRequest request) {
    String languageHeader = request.getHeader("Accept-Language");

    return StringUtils.hasLength(languageHeader)?Locale.lookup(Locale.LanguageRange.parse(languageHeader),
        SUPPORTED_LOCALES):Locale.getDefault();
  }

  @Bean
  public ResourceBundleMessageSource messageSource() {
    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
    messageSource.setBasename("messages");
    messageSource.setDefaultEncoding("UTF-8");
    messageSource.setCacheSeconds(2000);
    return messageSource;
  }
}
