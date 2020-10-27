package com.example.rest.auth.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    public void configure(final HttpSecurity http) throws Exception {
        http.csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
                .authorizeRequests()
                .antMatchers("/auth/**").permitAll()
                .antMatchers("/**/swagger-ui.html").permitAll()
                .antMatchers(HttpMethod.GET, "/**/swagger-resources/**", "/**/webjars/springfox-swagger-ui/**", "/**/v2/api-docs/**").permitAll()
                .anyRequest().authenticated();
    }
}
