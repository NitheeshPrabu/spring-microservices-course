package com.example.microservices.limitsservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "limits-service")
public class LimitsConfig {
    private int maximum;
    private int minimum;

    public int getMaximum() {
        return maximum;
    }

    public void setMaximum(int inMaximum) {
        this.maximum = inMaximum;
    }

    public int getMinimum() {
        return minimum;
    }

    public void setMinimum(int inMinimum) {
        this.minimum = inMinimum;
    }
}
