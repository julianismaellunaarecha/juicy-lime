package com.flashhammer.juicyfruit.repository;

import com.flashhammer.juicyfruit.model.Parte;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ParteMongoRepository extends ReactiveMongoRepository<Parte, Integer> {
}
