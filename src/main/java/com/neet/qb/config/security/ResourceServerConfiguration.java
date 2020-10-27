package com.neet.qb.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

import com.neet.qb.filter.ApiCorsFilter;
import com.neet.qb.util.APIEndpoints;

import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

  private static final String RESOURCE_ID = "api_design";
  final String[] protectEndpoints = {APIEndpoints.BASE_API_URL_V1 + "/**"};

  @Autowired
  private ApiCorsFilter corsFilter;

  @Override
  public void configure(ResourceServerSecurityConfigurer resources) {
    resources.resourceId(RESOURCE_ID).stateless(false);
  }

  @Override
  public void configure(HttpSecurity http) throws Exception {
    http.csrf().disable().headers().frameOptions().disable().and()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and().authorizeRequests()
        .antMatchers(HttpMethod.OPTIONS).permitAll()
        .antMatchers(HttpMethod.POST, APIEndpoints.BASE_API_URL_V1 + "/user").permitAll()
        .antMatchers(protectEndpoints).authenticated()
        .and().addFilterBefore(corsFilter, AnonymousAuthenticationFilter.class)
        .anonymous();
  }
}
