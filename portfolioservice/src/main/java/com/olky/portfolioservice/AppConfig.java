
package com.olky.portfolioservice;

import com.olky.exchangerateservice.ExchangeRateService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ExchangeRateService exchangeRateService() {
        return new ExchangeRateService();
    }
}
