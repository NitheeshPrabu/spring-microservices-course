package com.example.microservices.currencyconversionservice.controller;

import com.example.microservices.currencyconversionservice.bean.CurrencyConversion;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionController {

    @GetMapping(path = "/currency-converter")
    public CurrencyConversion convertCurrency(@RequestParam String from ,
                                              @RequestParam String to, @RequestParam BigDecimal amount) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);

        ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate()
                .getForEntity("http://localhost:8000/currency-exchange?from={from}&to={to}",
                        CurrencyConversion.class, uriVariables);
        CurrencyConversion response = responseEntity.getBody();
        return new CurrencyConversion(response.getId(), from, to, response.getConversionMultiple(), amount,
                amount.multiply(response.getConversionMultiple()), response.getPort());
    }
}
