package com.example.microservices.currencyconversionservice.bean;

import java.math.BigDecimal;

public class CurrencyConversion {
    private Long id;
    private String from;
    private String to;
    private BigDecimal conversionMultiple;
    private BigDecimal amount;
    private BigDecimal convertedAmount;
    private int port;

    public CurrencyConversion() {
    }

    public CurrencyConversion(Long id, String from, String to, BigDecimal conversionMultiple, BigDecimal amount, BigDecimal convertedAmount, int port) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
        this.amount = amount;
        this.convertedAmount = convertedAmount;
        this.port = port;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long inId) {
        this.id = inId;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String inFrom) {
        this.from = inFrom;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String inTo) {
        this.to = inTo;
    }

    public BigDecimal getConversionMultiple() {
        return conversionMultiple;
    }

    public void setConversionMultiple(BigDecimal inConversionMultiple) {
        this.conversionMultiple = inConversionMultiple;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal inAmount) {
        this.amount = inAmount;
    }

    public BigDecimal getConvertedAmount() {
        return convertedAmount;
    }

    public void setConvertedAmount(BigDecimal inConvertedAmount) {
        this.convertedAmount = inConvertedAmount;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int inPort) {
        this.port = inPort;
    }
}
