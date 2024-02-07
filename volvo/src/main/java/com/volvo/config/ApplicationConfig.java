package com.volvo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.Api;
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
public class ApplicationConfig {

    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class)).paths(PathSelectors.any()).build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Volvo Car - congestion-tax-calculator").description(
                        "Volvo Car - congestion-tax-calculator is a API tax calculator service based on the Vehicle types")
                .termsOfServiceUrl("http://taxdepartment.com")
                .contact(new Contact("Chaitralakshmi S", "https://github.com/volvo-cars/congestion-tax-calculator/blob/main/java/CongestionTaxCalculator.java", "chaitrasridhar13@yahoo.com"))
                .license("Volvo Car @2024").licenseUrl("nonexistant@test.com").version("1.0").build();
    }

}
