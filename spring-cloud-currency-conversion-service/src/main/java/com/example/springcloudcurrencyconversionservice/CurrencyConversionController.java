package com.example.springcloudcurrencyconversionservice;

import com.example.springcloudcurrencyconversionservice.bean.CurrencyConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionController {

    @Autowired
    private CurrencyExchangeServiceProxy proxy;


    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion convertCurrency(@PathVariable String from,
                                              @PathVariable String to,
                                              @PathVariable BigDecimal quantity){

        Map<String, String> valueMap = new HashMap<>();
        valueMap.put("from", from);
        valueMap.put("to", to);
        ResponseEntity<CurrencyConversion> conversionResponseEntity = new RestTemplate().getForEntity(
            "http://localhost:8000/currency-exchange/from/{from}/to/{to}",
            CurrencyConversion.class,
            valueMap);

        CurrencyConversion currencyConversion = conversionResponseEntity.getBody();

        return new CurrencyConversion(currencyConversion.getId(),
            from,
            to,
            currencyConversion.getExchangeRate(),
            quantity,
            quantity.multiply(currencyConversion.getExchangeRate()),
            currencyConversion.getPort());
    }

    @GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion convertCurrencyFeign(@PathVariable String from,
                                              @PathVariable String to,
                                              @PathVariable BigDecimal quantity){

        CurrencyConversion currencyConversion = proxy.retrieveExchangeValue(from, to);

        System.out.println(currencyConversion);
        return new CurrencyConversion(currencyConversion.getId(),
            from,
            to,
            currencyConversion.getExchangeRate(),
            quantity,
            quantity.multiply(currencyConversion.getExchangeRate()),
            currencyConversion.getPort());
    }
}
