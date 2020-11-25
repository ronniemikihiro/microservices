package com.example.rest.product.swagger;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    
    private static final String AUTH_SERVER = "http://localhost:8080/auth";
    private static final String SECURITY_SCHEME_NAME = "spring_oauth";
    private static final String CLIENT_ID = "esales";
    private static final String CLIENT_SECRET = "@123";
    
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.rest.product.controller"))
                .build()
                .apiInfo(apiInfo())
                .securitySchemes(Lists.newArrayList(securityScheme()))
                .securityContexts(Lists.newArrayList(securityContext()));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot Microservices")
                .description("Example Microservices")
                .version("1.0")
                .contact(new Contact("Ronnie Mikihiro Sato Lopes", "https://esales.com.br/", "ronnie.lopes@esales.com.br"))
                .license("Private for esales")
                .licenseUrl("https://esales.com.br/")
                .build();
    }
    
    @Bean
    public SecurityConfiguration securityInfo() {
        return new SecurityConfiguration(CLIENT_ID, CLIENT_SECRET, "", "", "", ApiKeyVehicle.HEADER, "", " ");
    }


    private SecurityScheme securityScheme() {
        return new OAuthBuilder().name(SECURITY_SCHEME_NAME)
                .grantTypes(Lists.newArrayList(new ResourceOwnerPasswordCredentialsGrant(AUTH_SERVER + "/oauth/token")))
                .scopes(Lists.newArrayList(scopes()))
                .build();
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(Lists.newArrayList(new SecurityReference(SECURITY_SCHEME_NAME, scopes())))
                .build();
    }

    private AuthorizationScope[] scopes() {
        return new AuthorizationScope[] {
            new AuthorizationScope("read", "ler todos"),
            new AuthorizationScope("write", "acesso total")
        };
    }
}
