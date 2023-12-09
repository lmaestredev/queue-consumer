package com.reactive.homebanking.drivenAdapters.useCases.transactionUseCases;

import com.reactive.homebanking.drivenAdapters.repositories.TransactionRepository;
import com.reactive.homebanking.models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class SaveTransactionUseCase {

    private final TransactionRepository transactionRepository;

    @Autowired
    public SaveTransactionUseCase(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Mono<Transaction> saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction).map( transactionSaved -> {
            return transactionSaved;
        });
    }
}
