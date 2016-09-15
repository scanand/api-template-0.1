package com.soagile.api.run.setup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * Created by soagile-pc on 10/08/2016.
 */
public class MyApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    //TODO: 10/08/2016 - implement the logger, check logger guidelines, "why Slf4j better" - Max time 30 mins

    private final Logger LOG =  LoggerFactory.getLogger(getClass());

    public void initialize(final ConfigurableApplicationContext applicationContext) {
        final ConfigurableEnvironment environment = applicationContext.getEnvironment();
        final String property = environment.getProperty("spring.profiles.active");

        LOG.info("The active profiles are :{}" , property);

        environment.setActiveProfiles(property.split(","));
    }
}
