package com.soagile.api.web.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "com.soagile.api.service" })
public class ApiServiceConfig {

    public ApiServiceConfig() {
        super();
    }

    // beans

}
