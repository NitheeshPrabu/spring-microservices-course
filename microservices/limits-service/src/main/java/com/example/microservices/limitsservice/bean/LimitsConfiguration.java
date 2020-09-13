package com.example.microservices.limitsservice.bean;

public class LimitsConfiguration {
    private int maximum;
    private int minimum;

    public LimitsConfiguration() {
    }

    public LimitsConfiguration(int maximum, int minimum) {
        this.maximum = maximum;
        this.minimum = minimum;
    }

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
