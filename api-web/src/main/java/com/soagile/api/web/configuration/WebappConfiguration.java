package com.soagile.api.web.configuration;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.soagile.api.run.setup.MyApplicationContextInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;
import java.util.Optional;

/**
 * Created by BMGTS on 24/02/2016.
 */
@Configuration
@ComponentScan(basePackages = {"com.soagile.api.web.*","com.soagile.api.common.web", "com.soagile.api.common.model", "com.soagile.api.service.*"})
@Import(value = {MyApplicationContextInitializer.class})
@EnableWebMvc
public class WebappConfiguration extends WebMvcConfigurerAdapter {

    private Logger LOGGER =  LoggerFactory.getLogger(getClass());

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        final PropertySourcesPlaceholderConfigurer pspc = new PropertySourcesPlaceholderConfigurer();
        return pspc;
    }

    @Override
    public void extendMessageConverters(final List<HttpMessageConverter<?>> converters) {

        final Optional<HttpMessageConverter<?>> jsonConvertorFound = converters.stream().filter(c -> c instanceof MappingJackson2HttpMessageConverter).findFirst();

        LOGGER.debug("jsonConvertorFound.isPresent()"+jsonConvertorFound.isPresent());
        if (jsonConvertorFound.isPresent()) {
                final AbstractJackson2HttpMessageConverter httpMessageConverter = (AbstractJackson2HttpMessageConverter) jsonConvertorFound.get();
                httpMessageConverter.getObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
                httpMessageConverter.getObjectMapper().enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        }

        final Optional<HttpMessageConverter<?>> xmlConverterFound = converters.stream().filter(c -> c instanceof MappingJackson2XmlHttpMessageConverter).findFirst();
        if (xmlConverterFound.isPresent()) {
            final MappingJackson2XmlHttpMessageConverter converter = (MappingJackson2XmlHttpMessageConverter) xmlConverterFound.get();
            converter.getObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
            converter.getObjectMapper().enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        }
    }

    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean() {
        return new LocalValidatorFactoryBean();
    }


}
