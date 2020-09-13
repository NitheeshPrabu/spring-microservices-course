package com.example.microservices.limitsservice.controller;

import com.example.microservices.limitsservice.bean.LimitsConfiguration;
import com.example.microservices.limitsservice.config.LimitsConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {

    private LimitsConfig limitsConfig;

    @Autowired
    public LimitsConfigurationController(LimitsConfig inLimitsConfig) {
        this.limitsConfig = inLimitsConfig;
    }

    @GetMapping(path = "/limits")
    public LimitsConfiguration retrieveLimitsFromConfiguration() {
        return new LimitsConfiguration(limitsConfig.getMaximum(), limitsConfig.getMinimum());
    }
}
