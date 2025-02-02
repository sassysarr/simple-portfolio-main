package com.olky.exchangerateservice;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class ExchangeRateServiceTest {

    @Mock
    private ExchangeRateRepository exchangeRateRepository;

    @InjectMocks
    private ExchangeRateService exchangeRateService;

    private List<ExchangeRate> exchangeRates;

    @BeforeEach
    void setUp() {
        exchangeRates = Arrays.asList(
                new ExchangeRate("BTC", "USD", 45000.0),
                new ExchangeRate("ETH", "USD", 3000.0)
        );
    }

    @Test
    void testGetExchangeRate_Found() {
        when(exchangeRateRepository.findAll()).thenReturn(exchangeRates);

        Optional<ExchangeRate> result = exchangeRateService.getExchangeRate("BTC", "USD");

        assertTrue(result.isPresent());
        assertEquals("BTC", result.get().getSymbol());
        assertEquals("USD", result.get().getBase());
        assertEquals(45000.0, result.get().getRate());
    }

    @Test
    void testGetExchangeRate_NotFound() {
        when(exchangeRateRepository.findAll()).thenReturn(exchangeRates);

        Optional<ExchangeRate> result = exchangeRateService.getExchangeRate("XRP", "USD");

        assertFalse(result.isPresent());
    }
}

