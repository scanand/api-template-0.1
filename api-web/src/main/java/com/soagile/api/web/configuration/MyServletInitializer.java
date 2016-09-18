package com.soagile.api.web.configuration;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.soagile.api.run.setup"})
public class MyServletInitializer extends SpringBootServletInitializer {

    //

    @Override
    protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
        return application.sources(ApiContextConfig.class, WebappPersistenceJpaConfig.class, ApiServiceConfig.class, WebappConfiguration.class, ApiServletConfig.class, ApiSecurityConfiguration.class);
    }

}
