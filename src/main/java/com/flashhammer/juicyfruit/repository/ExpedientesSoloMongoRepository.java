package com.flashhammer.juicyfruit.repository;

import com.flashhammer.juicyfruit.model.ExpedientesSolo;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpedientesSoloMongoRepository extends ReactiveMongoRepository<ExpedientesSolo, Integer> {

}
