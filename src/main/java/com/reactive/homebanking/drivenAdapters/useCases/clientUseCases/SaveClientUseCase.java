package com.reactive.homebanking.drivenAdapters.useCases.clientUseCases;

import com.reactive.homebanking.drivenAdapters.repositories.ClientRepository;
import com.reactive.homebanking.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class SaveClientUseCase {

    private final ClientRepository clientRepository;

    @Autowired
    public SaveClientUseCase(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Mono<Client> saveClient(Client client) {
        return clientRepository.save(client).map( clientSaved -> {
            return clientSaved;
        });
    }
}
