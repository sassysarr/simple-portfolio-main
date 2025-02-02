package com.olky.portfolioservice;


import jakarta.persistence.*;


@Entity
@Table(name = "holding")
public class Holding {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identifiant unique de la détention

    private String symbol; // Symbole de la cryptomonnaie (ex: BTC, ETH)
    private Double quantity; // Quantité détenue

    @ManyToOne
    @JoinColumn(name = "portfolio_id")
    private Portfolio portfolio; // Référence au portefeuille

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    // Constructeurs
    public Holding() {
    }

    public Holding(String symbol, Double quantity) {
        this.symbol = symbol;
        this.quantity = quantity;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }
}
