package com.flashhammer.juicyfruit.repository;

import com.flashhammer.juicyfruit.model.UltimaAccion;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UltimaAccionMongoRepository extends ReactiveMongoRepository<UltimaAccion, Integer> {
}
