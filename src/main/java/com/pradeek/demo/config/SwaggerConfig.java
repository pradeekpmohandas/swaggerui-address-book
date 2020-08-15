package com.pradeek.demo.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/api/*"))
				.apis(RequestHandlerSelectors.basePackage("com.pradeek.demo.controller"))
				.build()
				.apiInfo(apiInfo());

	}
	private ApiInfo apiInfo() {
		return	new ApiInfo(
                        " Microservice API Documentation",
                        "List  Microservice APIs  Documentation",
                        "1.0.0", "https://developer.arabbank.com/api-catalogue",
                        new Contact("Arab-Bank", "http://www.website", "your-email"),
                        "Arab-Bank API license 1.0",
                        "https://developer.arabbank.com/Application-catalogue", Collections.emptyList());
	}
}
