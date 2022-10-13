package com.flashhammer.juicyfruit.repository;

import com.flashhammer.juicyfruit.model.Expediente;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ExpedienteCompletoMongoRepository extends ReactiveMongoRepository<Expediente, Integer> {
}
