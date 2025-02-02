package com.olky.exchangerateservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/exchange-rate")
public class ExchangeRateController {


    @Autowired
    private ExchangeRateService exchangeRateService;

    @GetMapping
    public ResponseEntity<Double> getExchangeRate(@RequestParam String symbol, @RequestParam String base) {
        return exchangeRateService.getExchangeRate(symbol, base)
                .map(exchangeRate -> ResponseEntity.ok(exchangeRate.getRate())) // Retourne uniquement le taux
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}

