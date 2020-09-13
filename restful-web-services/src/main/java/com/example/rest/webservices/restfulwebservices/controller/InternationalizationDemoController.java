package com.example.rest.webservices.restfulwebservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;


@RestController
@RequestMapping(path = "/api")
public class InternationalizationDemoController {
    private MessageSource messageSource;

    @Autowired
    public InternationalizationDemoController(@Qualifier(value = "messageSource") MessageSource inMessageSource) {
        this.messageSource = inMessageSource;
    }

//    @GetMapping(path = "/localeGreeting")
//    public String getGreetingForLocale(@RequestHeader(value = "Accept-Language", required = false) Locale locale) {
//        // Add Accept-Language header as fr to test
//        return messageSource.getMessage("good.morning.message", null, locale);
//    }

    @GetMapping(path = "/localeGreeting")
    public String getGreetingForLocale() {
        // no need to get locale from header as param manually now, when using AcceptHeaderLocaleResolver
        return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
    }
}
