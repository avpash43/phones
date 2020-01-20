package ru.phones.book.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                .antMatchers("/")
                .permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/h2/**")
                .permitAll();

        httpSecurity
                .csrf()
                .disable();

        httpSecurity
                .headers()
                .frameOptions()
                .disable();

        httpSecurity
                .requiresChannel()
                .anyRequest()
                .requiresSecure();
    }
}
