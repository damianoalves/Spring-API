package com.restful.api.config;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;

/**
 * @author Damiano Alves on 22/02/19
 * damiano.alves@gmail.com
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.restful.api"))
                .paths(regex("/.*"))
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {

        ApiInfo apiInfo = new ApiInfo(
                "SPRING API REST",
                "API REST de Complexos Eólicos.",
                "1.0",
                "Terms of Service",
                new Contact("Damiano Alves", "https://github.com/DamianoAlves/Spring-api",
                        "damiano.alves@gmail.com"),
                "MIT",
                "https://opensource.org/licenses/MIT", new ArrayList<VendorExtension>()
        );

        return apiInfo;
    }

}