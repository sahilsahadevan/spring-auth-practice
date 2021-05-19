package com.example.sahil.auth.basic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class BasicAuthConfig extends WebSecurityConfigurerAdapter {

    @Override //this overload method configures Authorization
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin**").hasRole("ADMIN")
                .antMatchers("/user**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/").permitAll()
                .and().formLogin();

    }

    @Override  //this overload method configures Authentication
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("ADMIN")
                .and()
                .withUser("user")
                .password(passwordEncoder().encode("user"))
                .roles("USER");

    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}