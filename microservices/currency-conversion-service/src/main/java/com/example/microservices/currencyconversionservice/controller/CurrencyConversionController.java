package com.example.microservices.currencyconversionservice.controller;

import com.example.microservices.currencyconversionservice.bean.CurrencyConversion;
import com.example.microservices.currencyconversionservice.proxy.CurrencyExchangeServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyConversionController {

    private CurrencyExchangeServiceProxy currencyExchangeServiceProxy;

    @Autowired
    public CurrencyConversionController(CurrencyExchangeServiceProxy inCurrencyExchangeServiceProxy) {
        this.currencyExchangeServiceProxy = inCurrencyExchangeServiceProxy;
    }

    //    @GetMapping(path = "/currency-converter")
//    public CurrencyConversion convertCurrency(@RequestParam String from ,
//                                              @RequestParam String to, @RequestParam BigDecimal amount) {
//        Map<String, String> uriVariables = new HashMap<>();
//        uriVariables.put("from", from);
//        uriVariables.put("to", to);
//
//        ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate()
//                .getForEntity("http://localhost:8000/currency-exchange?from={from}&to={to}",
//                        CurrencyConversion.class, uriVariables);
//        CurrencyConversion response = responseEntity.getBody();
//        return new CurrencyConversion(response.getId(), from, to, response.getConversionMultiple(), amount,
//                amount.multiply(response.getConversionMultiple()), response.getPort());
//    }

    @GetMapping(path = "/currency-converter")
    public CurrencyConversion convertCurrency(@RequestParam String from ,
                                              @RequestParam String to, @RequestParam BigDecimal amount) {
        CurrencyConversion response = currencyExchangeServiceProxy.getExchangeValue(from, to);
        return new CurrencyConversion(response.getId(), from, to, response.getConversionMultiple(), amount,
                amount.multiply(response.getConversionMultiple()), response.getPort());
    }
}
