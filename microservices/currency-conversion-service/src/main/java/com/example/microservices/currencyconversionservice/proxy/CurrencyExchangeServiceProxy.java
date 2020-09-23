package com.example.microservices.currencyconversionservice.proxy;

import com.example.microservices.currencyconversionservice.bean.CurrencyConversion;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@FeignClient(name = "currency-exchange-service", url = "localhost:8000")
//@FeignClient(name = "currency-exchange-service") // no need to add url with ribbon - client side load balancer
@FeignClient(name = "netflix-zuul-api-gateway-server")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy {
//    @GetMapping(path = "/currency-exchange")
    @GetMapping(path = "/currency-exchange-service/currency-exchange") // forward requests through zuul
    public CurrencyConversion getExchangeValue(@RequestParam String from, @RequestParam String to);
}
