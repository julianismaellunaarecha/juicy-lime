package com.flashhammer.juicyfruit.repository;

import com.flashhammer.juicyfruit.model.Ficha;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface FichaMongoRepository extends ReactiveMongoRepository<Ficha, Integer> {
}
