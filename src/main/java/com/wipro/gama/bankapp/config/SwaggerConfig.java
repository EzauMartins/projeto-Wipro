package com.wipro.gama.bankapp.config;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket client() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.wipro.gama.bankapp"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaInfo());
    }


    private ApiInfo metaInfo() {

        ApiInfo apiInfo = new ApiInfo(
                "CARD API",
                "API CARTÕES",
                "1.0",
                "Terms of Service",
                new Contact("Ezau Martins", "https://github.com/EzauMartins/projeto-Wipro",
                        "ezaumateus97@gmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licesen.html", new ArrayList<VendorExtension>()
        );

        return apiInfo;
    }

}
