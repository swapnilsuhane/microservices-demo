package com.example.springcloudcurrencyconversionservice.bean;

import java.math.BigDecimal;

public class CurrencyConversion {
    private Long id;
    private String fromCurrency;
    private String toCurrency;
    private BigDecimal exchangeRate;
    private BigDecimal quantity;
    private BigDecimal currencyAmount;
    private int port;

    public CurrencyConversion() {
    }

    public CurrencyConversion(Long id, String fromCurrency, String toCurrency, BigDecimal exchangeRate,
                              BigDecimal quantity, BigDecimal currencyAmount, int port) {
        this.id = id;
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.exchangeRate = exchangeRate;
        this.quantity = quantity;
        this.currencyAmount = currencyAmount;
        this.port = port;
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

    public BigDecimal getQuantity() {
        return quantity;
    }

    public BigDecimal getCurrencyAmount() {
        return currencyAmount;
    }

    public int getPort() {
        return port;
    }
}
