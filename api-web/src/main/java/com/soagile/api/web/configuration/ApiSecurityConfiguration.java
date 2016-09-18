package com.soagile.api.web.configuration;

import com.soagile.api.web.security.ApiUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by soagile-pc on 16/09/2016.
 */
@Configuration
@ComponentScan ("com.soagile.api.web.security")
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class ApiSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private ApiUserDetailsService userDetailsService;

    @Autowired
    public void configureGlobal (final AuthenticationManagerBuilder authenticationManagerBuilder)  throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.
                authorizeRequests().anyRequest().authenticated().and().
                httpBasic().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().
                csrf().disable();
    }
}
