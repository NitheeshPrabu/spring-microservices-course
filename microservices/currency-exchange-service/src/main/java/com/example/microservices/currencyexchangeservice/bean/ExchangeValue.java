package com.example.microservices.currencyexchangeservice.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class ExchangeValue {

    @Id
    private Long id;

    @Column(name = "currency_from")
    private String from;

    @Column(name = "currency_to")
    private String to;

    private BigDecimal conversionMultiple;

    // just to identify which service instance is being used, not recommended in prod
    private int port;

    public ExchangeValue() {
    }

    public ExchangeValue(Long id, String from, String to, BigDecimal conversionMultiple) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
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

    public int getPort() {
        return port;
    }

    public void setPort(int inPort) {
        this.port = inPort;
    }
}
