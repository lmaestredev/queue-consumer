package com.reactive.homebanking.drivenAdapters.repositories;

import com.reactive.homebanking.models.ErrorRabbit;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ErrorRepository  extends ReactiveMongoRepository<ErrorRabbit, String> {

}
