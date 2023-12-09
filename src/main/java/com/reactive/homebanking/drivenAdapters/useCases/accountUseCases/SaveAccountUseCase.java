package com.reactive.homebanking.drivenAdapters.useCases.accountUseCases;

import com.reactive.homebanking.drivenAdapters.repositories.AccountRepository;
import com.reactive.homebanking.models.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class SaveAccountUseCase {

    private final AccountRepository accountRepository;

    @Autowired
    public SaveAccountUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Mono<Account> saveAccount(Account account) {
        return accountRepository.save(account).map( accountSaved -> {
                return accountSaved;
        });
    }
}
