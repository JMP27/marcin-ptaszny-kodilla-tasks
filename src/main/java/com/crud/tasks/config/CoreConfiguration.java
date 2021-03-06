package com.crud.tasks.config;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@EnableScheduling
@EnableSwagger2
@Configuration
public class CoreConfiguration implements WebMvcConfigurer {
  @Bean
  public RestTemplate restTemplate(){
      return new RestTemplate();
  }

    private static final String NO_ERROR_REGEX = "(?!.*error).*$";
    private static final String NO_TRELLO_REGEX = "(?!.*trello).*$";

  @Bean
  public Docket api(){
      return new Docket(DocumentationType.SWAGGER_2)
              .select()
              .apis(RequestHandlerSelectors.any()).paths(paths()).paths(pathsTrello())
              //.paths(PathSelectors.any())
              .build();
  }

    private Predicate<String> paths() {
      return regex(NO_ERROR_REGEX);
    }

    private Predicate<String> pathsTrello() {
        return regex(NO_TRELLO_REGEX);
    }

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        // Required by Swagger UI configuration
        registry.addResourceHandler("/lib/**").addResourceLocations("/lib/").setCachePeriod(0);
        registry.addResourceHandler("/images/**").addResourceLocations("/images/").setCachePeriod(0);
        registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(0);
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
