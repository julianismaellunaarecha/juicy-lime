package com.flashhammer.juicyfruit.repository;

import com.flashhammer.juicyfruit.model.Message;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessagesMongoRepository extends ReactiveMongoRepository<Message, String> {
}
