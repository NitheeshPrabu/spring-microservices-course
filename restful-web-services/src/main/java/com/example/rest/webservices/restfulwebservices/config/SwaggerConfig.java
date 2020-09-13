package com.example.rest.webservices.restfulwebservices.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.*;

// See http://localhost:8080/swagger-ui/index.html
@Configuration
public class SwaggerConfig {

    public static final Contact DEFAULT_CONTACT = new Contact(
            "Nitheesh", "http://localhost", "test@gmail.com");

    public static final ApiInfo DEFAULT_API_INFO = new ApiInfo(
            "User API", "User REST Web Service", "1.0",
            "urn:tos", DEFAULT_CONTACT,
            "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", Arrays.asList());

    private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES =
            new HashSet<String>(Arrays.asList("application/json",
                    "application/xml"));

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(DEFAULT_API_INFO)
                .produces(DEFAULT_PRODUCES_AND_CONSUMES)
                .consumes(DEFAULT_PRODUCES_AND_CONSUMES);
    }
}
