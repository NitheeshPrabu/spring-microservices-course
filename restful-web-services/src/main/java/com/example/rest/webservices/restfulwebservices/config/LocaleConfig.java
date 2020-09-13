package com.example.rest.webservices.restfulwebservices.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Locale;

@Configuration
public class LocaleConfig {

// need to get locale as param from request header
//    @Bean
//    public LocaleResolver localeResolver() {
//        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
//        localeResolver.setDefaultLocale(Locale.US);
//        return localeResolver;
//    }

    // no need to get locale as param
    @Bean
    public LocaleResolver localeResolver() {
        AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
        localeResolver.setDefaultLocale(Locale.US);
        return localeResolver;
    }

//    // bean method name must be `messageSource`
//    @Bean(name = "i18nMessageSource")
//    public ResourceBundleMessageSource messageSource() {
//        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//        return messageSource;
//    }
}
