package com.msag.securityinfo.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

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

}
