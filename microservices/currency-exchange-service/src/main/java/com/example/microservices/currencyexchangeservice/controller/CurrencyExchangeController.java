package com.example.microservices.currencyexchangeservice.controller;

import com.example.microservices.currencyexchangeservice.bean.ExchangeValue;
import com.example.microservices.currencyexchangeservice.repository.ExchangeValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    private Environment environment;
    private ExchangeValueRepository exchangeValueRepository;

    @Autowired
    public CurrencyExchangeController(Environment inEnvironment, ExchangeValueRepository inExchangeValueRepository) {
        this.environment = inEnvironment;
        this.exchangeValueRepository = inExchangeValueRepository;
    }

    @GetMapping(path = "/currency-exchange")
    public ExchangeValue getExchangeValue(@RequestParam String from, @RequestParam String to) {
        ExchangeValue exchangeValue = exchangeValueRepository.findByFromAndTo(from, to);
        exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        return exchangeValue;
    }
}
