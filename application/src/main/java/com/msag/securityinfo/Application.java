package com.msag.securityinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application
{
    public static void main(final String[] args)
    {
        final SpringApplication app = new SpringApplication(Application.class);
        app.run(args);
    }
}