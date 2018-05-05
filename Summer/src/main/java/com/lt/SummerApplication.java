package com.lt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = {"com.lt.controllers", "com.lt.services", "com.lt.dao"})
@EnableSwagger2
public class SummerApplication {
	public static void main(String[] args) {
		SpringApplication.run(SummerApplication.class, args);
	}
	@Bean
	public Docket studentAPI() {
		return new Docket(DocumentationType.SWAGGER_2)
			.select()
			.apis(RequestHandlerSelectors.basePackage("com.lt.controller"))
			.paths(PathSelectors.regex("/api.*"))
			.build();
	}
}
