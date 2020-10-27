package com.neet.qb.config;

import com.monitorjbl.json.JsonViewSupportFactoryBean;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import com.neet.qb.resolver.ProjectKeyResolver;

/**
 * 
 * @author Phaninder
 * 
 */
@Configuration
public class ContextConfig extends WebMvcConfigurerAdapter {

  @Bean
  public JsonViewSupportFactoryBean views() {
    return new JsonViewSupportFactoryBean();
  }

  @Override
  public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
    argumentResolvers.add(new ProjectKeyResolver());
  }

}
