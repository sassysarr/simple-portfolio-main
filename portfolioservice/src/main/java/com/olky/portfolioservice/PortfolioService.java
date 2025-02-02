package com.olky.portfolioservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class PortfolioService {

    @Autowired
    private PortfolioRepository portfolioRepository;


    public PortfolioService(PortfolioRepository portfolioRepository) {
        this.portfolioRepository = portfolioRepository;

    }

    public Portfolio createPortfolio(Portfolio portfolio) {
        return portfolioRepository.save(portfolio);
    }

    public Optional<Portfolio> getPortfolio(Long id) {
        return portfolioRepository.findById(id);
    }

    public void addHolding(Long portfolioId, Holding holding) {
        Portfolio portfolio = portfolioRepository.findById(portfolioId).orElseThrow();
        holding.setPortfolio(portfolio);
        portfolio.getHoldings().add(holding);
        portfolioRepository.save(portfolio);
    }

    public void removeHolding(Long portfolioId, String symbol) {
        Portfolio portfolio = portfolioRepository.findById(portfolioId).orElseThrow();
        portfolio.getHoldings().removeIf(h -> h.getSymbol().equals(symbol));
        portfolioRepository.save(portfolio);
    }

    /*public Double getValuation(Long portfolioId, String base) {
        Portfolio portfolio = portfolioRepository.findById(portfolioId).orElseThrow();
        return portfolio.getHoldings().stream()
                .mapToDouble(h -> {
                    String url = "http://localhost:8081/exchange-rate?symbol=" + h.getSymbol() + "&base=" + base;
                    Double rate = restTemplate.getForObject(url, Double.class);
                    return h.getQuantity() * (rate != null ? rate : 0.0);
                })
                .sum();
    }*/
}