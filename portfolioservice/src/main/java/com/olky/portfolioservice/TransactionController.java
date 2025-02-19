package com.olky.portfolioservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(
            @RequestParam Long portfolioId,
            @RequestParam String crypto,
            @RequestParam BigDecimal amount,
            @RequestParam String type) {

        Transaction transaction = transactionService.processTransaction(portfolioId, crypto, amount, type);
        return ResponseEntity.ok(transaction);
    }
}

