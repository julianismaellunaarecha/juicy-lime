package com.flashhammer.juicyfruit.service;

import com.flashhammer.juicyfruit.model.Message;
import com.flashhammer.juicyfruit.repository.MessagesMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MongoService {

    @Autowired
    MessagesMongoRepository messagesSoloMongoRepository;

    public Flux<Message> getMessages() {
        return messagesSoloMongoRepository.findAll();
    }

    public Mono<Message> getMessageById(String id) {
        return messagesSoloMongoRepository.findById(id);
    }

    public Mono<Message> updateMessageByValue(Message message) {
        return messagesSoloMongoRepository.save(message);
    }

    public Mono<Message> putMessageByValue(Message message) {
        return messagesSoloMongoRepository.insert(message);
    }

    public Mono<Boolean> isMessagePresent(String id) {
        return messagesSoloMongoRepository.existsById(id);
    }

    public Mono<ResponseEntity.BodyBuilder> deleteMessageById(String id) {
        return messagesSoloMongoRepository.deleteById(id).then(Mono.just(ResponseEntity.ok()));
    }

    public Mono<ResponseEntity.BodyBuilder> deleteMessageByValue(Message message) {
        return messagesSoloMongoRepository.delete(message).then(Mono.just(ResponseEntity.ok()));
    }

}
