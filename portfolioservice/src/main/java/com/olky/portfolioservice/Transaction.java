package com.olky.portfolioservice;

import com.olky.exchangerateservice.ExchangeRate;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Entity
public class Transaction {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "portfolio_id", nullable = false)
    private Portfolio portfolio;
    private BigDecimal priceAtTransaction; // Prix au moment de la transaction
    private String type; // BUY, SELL

    public Transaction() {
    }

    // Getters & Setters

    public Transaction(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    public Transaction(Long id) {
        this.id = id;
    }

    public Transaction(String cryptoSymbol) {
        // BTC, ETH, etc.
    }

    public Transaction(BigDecimal amount) {
        // Quantité achetée/vendue
    }

    public Transaction(LocalDateTime timestamp) {
    }

    public void setCryptoSymbol(String crypto) {
    }

    public void setAmount(BigDecimal amount) {
    }

    public void setPriceAtTransaction(Optional<ExchangeRate> price) {
    }

    public void setTimestamp(LocalDateTime now) {
    }

    public void setType(String type) {
    }
}

