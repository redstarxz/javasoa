package com.you.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.fasterxml.classmate.TypeResolver;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableWebMvc
@ComponentScan(basePackages = { "com.you.webapp.controller" })
public class SwaggerConfig {

    @Bean
    public Docket customDocket() {
        //
                return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
        				.apis(RequestHandlerSelectors.basePackage("com.you.webapp.controller")).paths(PathSelectors.any())
        				.build().useDefaultResponseMessages(false).enable(true);
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("test", "sdfsfds", "xxx");
        return new ApiInfo("API",
                "API",
                "0.0.1",
                "www",
                contact,
                "Note",
                "https://"
        );
    }
}
