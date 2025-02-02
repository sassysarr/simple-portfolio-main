package com.olky.portfolioservice;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/portfolios")
public class PortfolioController {

    private final PortfolioService portfolioService;

    public PortfolioController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    @PostMapping
    public Portfolio createPortfolio(@RequestBody Portfolio portfolio) {
        return portfolioService.createPortfolio(portfolio);
    }

    @GetMapping("/{id}")
    public Portfolio getPortfolio(@PathVariable Long id) {
        return portfolioService.getPortfolio(id).orElseThrow();
    }

    @PostMapping("/{id}/holdings")
    public void addHolding(@PathVariable Long id, @RequestBody Holding holding) {
        portfolioService.addHolding(id, holding);
    }

    @DeleteMapping("/{id}/holdings/{symbol}")
    public void removeHolding(@PathVariable Long id, @PathVariable String symbol) {
        portfolioService.removeHolding(id, symbol);
    }

    /*@GetMapping("/{id}/valuation")
    public Double getValuation(@PathVariable Long id, @RequestParam String base) {
        return portfolioService.getValuation(id, base);
    }*/
}