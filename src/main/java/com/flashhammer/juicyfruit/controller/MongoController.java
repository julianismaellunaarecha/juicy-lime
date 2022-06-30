package com.flashhammer.juicyfruit.controller;

import com.flashhammer.juicyfruit.model.Queue;
import com.flashhammer.juicyfruit.service.MongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("mongocontroller")
public class MongoController {

    @Autowired
    MongoService mongoService;

    @GetMapping
    public Flux<Queue> getQueue() {
        return mongoService.getQueueAll();
    }
    @GetMapping("/{id}")
    public Mono<Queue> getQueueId(@PathVariable String id ) {
        return mongoService.getQueueById(id);
    }

    @PostMapping
    public Mono<Queue> putQueueByValue(Queue queue) {
        return mongoService.putQueueByValue(queue);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteQueueById( @PathVariable String id ) {
        return mongoService.deleteQueueById(id);
    }

    @DeleteMapping
    public Mono<Void> deleteQueueByValue( Queue queue) {
        return mongoService.deleteQueueByValue(queue);
    }
}
