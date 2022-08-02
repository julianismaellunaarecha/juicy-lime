package com.flashhammer.juicyfruit.repository;

import com.flashhammer.juicyfruit.model.Encabezado;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EncabezadoMongoRepository extends ReactiveMongoRepository<Encabezado, Integer> {
}
