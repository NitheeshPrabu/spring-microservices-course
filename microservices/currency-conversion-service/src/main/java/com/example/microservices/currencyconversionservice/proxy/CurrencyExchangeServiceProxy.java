package com.example.microservices.currencyconversionservice.proxy;

import com.example.microservices.currencyconversionservice.bean.CurrencyConversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "currency-exchange-service", url = "localhost:8000")
public interface CurrencyExchangeServiceProxy {
    @GetMapping(path = "/currency-exchange")
    public CurrencyConversion getExchangeValue(@RequestParam String from, @RequestParam String to);
}
