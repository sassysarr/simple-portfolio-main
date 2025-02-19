package com.olky.portfolioservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class PortfolioVariationDTO {
    private BigDecimal variationAbsolute;  // Variation absolue du portefeuille
    private BigDecimal variationPercentage; // Variation en pourcentage
    private String currency; // Devise utilisée pour les calculs

    public PortfolioVariationDTO(BigDecimal variationAbsolute, BigDecimal variationPercentage, String currency) {
    }

    public String getCurrency() {
        return "";
    }

    public BigDecimal getVariationAbsolute() {
        return null;
    }

    public BigDecimal getVariationPercentage() {
        return null;
    }
}
