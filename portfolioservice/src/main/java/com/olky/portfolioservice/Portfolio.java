package com.olky.portfolioservice;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "portfolio")
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identifiant unique du portefeuille

    private String userId; // Identifiant de l'utilisateur

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "portfolio")
    private List<Holding> holdings; // Liste des détentions de cryptomonnaies

    // Constructeurs
    public Portfolio() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Holding> getHoldings() {
        return holdings;
    }

    public void setHoldings(List<Holding> holdings) {
        this.holdings = holdings;
    }

    public Portfolio(String userId) {
        this.userId = userId;
    }
}