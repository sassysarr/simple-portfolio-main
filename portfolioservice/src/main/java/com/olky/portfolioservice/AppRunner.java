package com.olky.portfolioservice;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

    private final TransactionService transactionService;

    public AppRunner(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @Override
    public void run(String... args) throws Exception {
        transactionService.performTransaction();
    }
}
