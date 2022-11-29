package com.msag.securityinfo.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class GatewayConfiguration {
    @Value("${com.msag.securityInfo.gateway.userName}")
    private String userName;

    @Value("${com.msag.securityInfo.gateway.pwd}")
    private String userPassword;

    @Bean
    public RestTemplate restClientWithBasicAuthentication(final RestTemplateBuilder restTemplateBuilder){
        return restTemplateBuilder
                .basicAuthentication(userName, userPassword)
                .build();
    }
}
