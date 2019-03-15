package com.example.springcloudcurrencyexchangeservice;

import com.example.springcloudcurrencyexchangeservice.bean.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {
    CurrencyExchange findByFromCurrencyAndToCurrency(String from, String to);
}
