package com.flashhammer.juicyfruit.service;

import com.flashhammer.juicyfruit.model.Queue;
import com.flashhammer.juicyfruit.repository.QueueMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MongoService {

    @Autowired
    QueueMongoRepository queueMongoRepository;

    public Mono<Queue> getQueueById(String id ) {
        return queueMongoRepository.findById(id);
    }

    public Mono<Queue> putQueueByValue(Queue queue) {
        return queueMongoRepository.insert(queue);
    }

    public Mono<Void> deleteQueueById( String id ) {
        return queueMongoRepository.deleteById(id);
    }

    public Mono<Void> deleteQueueByValue( Queue queue) {
        return queueMongoRepository.delete(queue);
    }

    public Flux<Queue> getQueueAll() {
        return queueMongoRepository.findAll();
    }
}
