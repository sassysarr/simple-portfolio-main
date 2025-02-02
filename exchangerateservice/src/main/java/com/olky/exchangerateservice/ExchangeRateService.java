package com.olky.exchangerateservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ExchangeRateService {

    @Autowired
    private ExchangeRateRepository exchangeRateRepository;


    public ExchangeRateService(ExchangeRateRepository exchangeRateRepository) {
        this.exchangeRateRepository = exchangeRateRepository;
    }

    public Optional<ExchangeRate> getExchangeRate(String symbol, String base) {
        return exchangeRateRepository.findAll()
                .stream()
                .filter(rate -> rate.getSymbol().equalsIgnoreCase(symbol) && rate.getBase().equalsIgnoreCase(base))
                .findFirst();
    }
}
