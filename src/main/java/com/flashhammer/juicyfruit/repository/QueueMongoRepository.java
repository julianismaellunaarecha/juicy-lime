package com.flashhammer.juicyfruit.repository;

import com.flashhammer.juicyfruit.model.Queue;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface QueueMongoRepository extends ReactiveMongoRepository<Queue, String> {

}
