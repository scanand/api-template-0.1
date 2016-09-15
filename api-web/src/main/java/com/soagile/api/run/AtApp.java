package com.soagile.api.run;

import com.soagile.api.run.setup.MyApplicationContextInitializer;
import com.soagile.api.web.configuration.WebappConfiguration;
import com.soagile.api.web.configuration.WebappPersistenceJpaConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.DispatcherServlet;

import java.util.HashMap;
import java.util.Map;

/**
 * An opinionated WebApplicationInitializer to run a SpringApplication from a traditional WAR deployment.
 */
@SpringBootApplication
@Import(value = {MyApplicationContextInitializer.class, WebappPersistenceJpaConfig.class, WebappConfiguration.class})
public class AtApp extends SpringBootServletInitializer {

    @Bean
    public DispatcherServlet dispatcherServlet() {
        return new DispatcherServlet();
    }

    /**
     * Only for Spring-boot
     *
     * This method adds a servlet (with rootcontext specific to this app) to the servlet container
     * ServletContextInitializer uses this bean, its in embedded container.
     * Unlike WebApplicationInitializer, these servlets are not by default added to the Servlet COntainer(context)
     *
     * @return
     */
    @Bean
    public ServletRegistrationBean dispatcherServletRegistration() {
        final ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet(), "/api/*");

        final Map<String, String> params = new HashMap<String, String>();
        params.put("contextClass", "org.springframework.web.context.support.AnnotationConfigWebApplicationContext");
        params.put("contextConfigLocation", "org.spring.sec2.spring");
        params.put("dispatchOptionsRequest", "true");
        registration.setInitParameters(params);
        registration.setLoadOnStartup(1);
        return registration;
    }


    /**
     * This class adds initializers to the application (applied to the ApplicationContext before any bean definitions are loaded
     * By sources(), additional configuration classes and components are added to the application
     *
     * @param builder
     * @return
     */
    @Override
    protected SpringApplicationBuilder configure(final SpringApplicationBuilder builder) {
        return builder.initializers(new MyApplicationContextInitializer()).sources(AtApp.class);
    }


    /***
     *
     * @param args
     */
    public static void main(final String... args) {
        new SpringApplicationBuilder(AtApp.class).initializers(new MyApplicationContextInitializer()).run(args);
    }
}
