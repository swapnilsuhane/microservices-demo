package com.example.springcloudcurrencyexchangeservice;

import com.example.springcloudcurrencyexchangeservice.bean.CurrencyExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    @Autowired
    Environment environment;

    @Autowired
    CurrencyExchangeRepository currencyExchangeRepository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to){
        int port  = Integer.valueOf(environment.getProperty("local.server.port"));
        CurrencyExchange currencyExchange  = currencyExchangeRepository.findByFromCurrencyAndToCurrency(from, to);

        //CurrencyExchange currencyExchange = new CurrencyExchange(1000L, from, to,
        //     new BigDecimal("70"));
         currencyExchange.setPort(port);

        System.out.println(currencyExchange);
         return currencyExchange;
    }
}
