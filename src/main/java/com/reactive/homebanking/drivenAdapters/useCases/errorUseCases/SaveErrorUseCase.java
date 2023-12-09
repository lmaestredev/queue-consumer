package com.reactive.homebanking.drivenAdapters.useCases.errorUseCases;

import com.reactive.homebanking.drivenAdapters.repositories.ErrorRepository;
import com.reactive.homebanking.models.ErrorRabbit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class SaveErrorUseCase {

    private final ErrorRepository errorRepository;

    @Autowired
    public SaveErrorUseCase(ErrorRepository errorRepository) {
        this.errorRepository = errorRepository;
    }

    public Mono<ErrorRabbit> saveError(ErrorRabbit error) {
        return errorRepository.save(error).map( errorSaved -> {
            return errorSaved;
        });
    }
}
