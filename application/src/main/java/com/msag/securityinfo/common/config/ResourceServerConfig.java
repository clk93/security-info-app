package com.msag.securityinfo.common.config;


import org.assertj.core.util.Lists;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.Collections;

@Configuration
@Profile("!test")
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResourceServerConfig extends WebSecurityConfigurerAdapter
{
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .httpBasic().disable()
                .authorizeRequests().antMatchers("/actuator/**").permitAll().and()
                .authorizeRequests().antMatchers("/v3/api-docs/**").permitAll().and()
                .authorizeRequests().antMatchers("/swagger-ui/index.html/**").permitAll().and()
                .authorizeRequests().antMatchers("/swagger-ui/**").permitAll().and()
                .authorizeRequests().antMatchers("/webjars/**").permitAll().and()
                .authorizeRequests().antMatchers("/api/v1/**").permitAll().and()
                .authorizeRequests().antMatchers(org.springframework.http.HttpMethod.OPTIONS).permitAll().and()
                .authorizeRequests().anyRequest().authenticated();
    }

    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter()
    {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(Boolean.TRUE);
        config.setAllowedHeaders(Collections.singletonList(CorsConfiguration.ALL));
        config.setAllowedMethods(Lists.newArrayList(HttpMethod.OPTIONS.name(), HttpMethod.POST.name(), HttpMethod.GET.name(), HttpMethod.PUT.name(), HttpMethod.PATCH.name(), HttpMethod.DELETE.name()));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        FilterRegistrationBean<CorsFilter> corsFilter = new FilterRegistrationBean<>(new CorsFilter(source));
        corsFilter.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return corsFilter;
    }

}
