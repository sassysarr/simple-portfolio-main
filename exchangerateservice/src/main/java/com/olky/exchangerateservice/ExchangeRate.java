package com.olky.exchangerateservice;

import jakarta.persistence.*;

@Entity
@Table(name = "exchange_rate")
public class ExchangeRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String symbol; // Symbole de la cryptomonnaie , ex: BTC, ETH
    private String base;   // Devise de base, ex: USD
    private Double rate;   // Taux de change

    // Constructeurs, getters et setters
    public ExchangeRate() {}

    public ExchangeRate(String symbol, String base, Double rate) {
        this.symbol = symbol;
        this.base = base;
        this.rate = rate;
    }

    public Long getId() {
        return id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}
