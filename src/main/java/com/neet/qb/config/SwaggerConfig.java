package com.neet.qb.config;

import com.google.common.base.Predicates;
import com.neet.qb.key.ProjectKey;

import java.util.HashSet;
import java.util.Set;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author Phaninder
 * 
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Bean
  public Docket projectApi() {
    return new Docket(DocumentationType.SWAGGER_2).ignoredParameterTypes(ignoreParamClasses())
        .groupName("rest-api").apiInfo(apiInfo()).select()
        .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework")))
        .build();
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder().title("Srichaitanya")
        .description(" Neet QB")
        .termsOfServiceUrl("https://github.com/phaninder")
        .contact(new Contact("Phaninder Sangineni",
            "https://github.com/phaninder",
            "phaninder.sangineni@gmail.com")).build();
  }

  /**
   * Hide classes which are used as Keys for security checks.
   */
  private Class[] ignoreParamClasses() {
    Set<Class<? extends Object>> ignoredClasses = new HashSet<>();
    ignoredClasses.add(ProjectKey.class);
    return ignoredClasses.toArray(new Class[ignoredClasses.size()]);
  }
}
