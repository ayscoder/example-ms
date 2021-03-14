package com.ays.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

/**
 * @author ayush agrahari created on 14/03/2021
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final String example = "example";
    public static final String packageName = "com.ays.example";

    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
                .apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage(packageName))
                .build();
        //                .paths(postPaths()).build();
    }


    //    private Predicate<String> postPaths() {
    //        return or(regex("/api/posts.*"), regex("/api/javainuse.*"));
    //    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title(example.toUpperCase() + " API")
                .description(example.toUpperCase() + " API reference for developers")
                .termsOfServiceUrl("http://" + example + ".com")
                .contact(example + "@gmail.com").license(example.toUpperCase() + " License")
                .licenseUrl(example + "@gmail.com").version("1.0").build();
    }

}
