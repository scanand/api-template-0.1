package com.soagile.api.web.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
//@ImportResource("classpath*:umContextConfig.xml")
@EnableAspectJAutoProxy(proxyTargetClass = true)
@PropertySource({ "classpath:env-${envTarget:dev}.properties", "classpath:web-${webTarget:local}.properties" })
public class ApiContextConfig {

    public ApiContextConfig() {
        super();
    }

    // beans

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        final PropertySourcesPlaceholderConfigurer pspc = new PropertySourcesPlaceholderConfigurer();
        return pspc;
    }

}
