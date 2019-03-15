package com.example.springcloudcurrencyexchangeservice.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class CurrencyExchange {

    @Id
    private Long id;
    private String fromCurrency;
    private String toCurrency;
    private BigDecimal exchangeRate;
    private int port;

    public CurrencyExchange() {
    }

    public CurrencyExchange(Long id, String fromCurrency, String toCurrency, BigDecimal exchangeRate) {
        this.id = id;
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.exchangeRate = exchangeRate;
    }

    public Long getId() {
        return id;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
