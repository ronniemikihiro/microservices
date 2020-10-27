package com.example.rest.gateway.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    public void configure(final ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenStore(this.tokenStore());
    }

    public void configure(final HttpSecurity http) throws Exception {
        http.csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
                .authorizeRequests().antMatchers("/**/auth/oauth/token").permitAll()
                .antMatchers("/**/swagger-ui.html").permitAll()
                .antMatchers(HttpMethod.GET, "/**/swagger-resources/**", "/**/webjars/springfox-swagger-ui/**", "/**/v2/api-docs/**").permitAll()
                .anyRequest().authenticated()
            .and()
                .exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
    }

    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(this.accessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        final JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
        tokenConverter.setSigningKey("esales.com.br");
        return tokenConverter;
    }

}
