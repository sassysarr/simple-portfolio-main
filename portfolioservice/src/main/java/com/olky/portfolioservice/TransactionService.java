package com.olky.portfolioservice;

import com.olky.exchangerateservice.ExchangeRate;
import com.olky.exchangerateservice.ExchangeRateRepository;
import com.olky.exchangerateservice.ExchangeRateService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;



import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TransactionService {
    @Autowired
   private TransactionRepository transactionRepository;

    @Autowired
   private PortfolioRepository portfolioRepository;

    @Autowired
    private  ExchangeRateService exchangeRateService;


//    @Autowired
//    public TransactionService(ExchangeRateService exchangeRateService) {
//        this.exchangeRateService = exchangeRateService;
//    }

    public void performTransaction() {
        double rate = exchangeRateService.getExchangeRate("USD");
        System.out.println("Taux de change utilisé : " + rate);
    }

    public Transaction processTransaction(Long portfolioId, String crypto, BigDecimal amount, String type) {
        return null;
    }

////    @Transactional
////    public Transaction processTransaction(Long portfolioId, String crypto, BigDecimal amount, String type) {
////        Portfolio portfolio = portfolioRepository.findById(portfolioId)
////                .orElseThrow(() -> new RuntimeException("Portfolio not found"));
////
////        Optional<ExchangeRate> price = exchangeRateService.getExchangeRate(crypto, "USD");
////        Optional<Object> totalValue = price.map(ExchangeRate::getPrice);
////
////        if (type.equalsIgnoreCase("SELL")) {
////            if (!portfolio.hasSufficientBalance(crypto, amount)) {
////                throw new RuntimeException("Insufficient balance");
////            }
////            portfolio.decreaseHolding(crypto, amount);
////        } else {
////            portfolio.increaseHolding(crypto, amount);
////        }
////
////        Transaction transaction = new Transaction();
////        transaction.setPortfolio(portfolio);
////        transaction.setCryptoSymbol(crypto);
////        transaction.setAmount(amount);
////        transaction.setPriceAtTransaction(price);
////        transaction.setTimestamp(LocalDateTime.now());
////        transaction.setType(type);
//
//        return transactionRepository.save(transaction);
//    }

}
