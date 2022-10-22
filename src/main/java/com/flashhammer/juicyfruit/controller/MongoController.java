package com.flashhammer.juicyfruit.controller;

import com.flashhammer.juicyfruit.model.Message;
import com.flashhammer.juicyfruit.service.MongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RestController
@RequestMapping(path ="/mongocontroller")
public class MongoController {

    @Autowired
    private MongoService mongoService;

    @GetMapping(value="/messages",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<Message> getMessages() {
        return mongoService.getMessages();
    }

    @GetMapping(value="/message/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Message> getMessageById(@PathVariable String id) {
        return mongoService.getMessageById(id);
    }

    @GetMapping(value="/messagepresent/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Boolean> isMessagePresent(@PathVariable String id) {
        return mongoService.isMessagePresent(id);
    }

    @PutMapping(value="/message",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Message> updateMessageByValue(@RequestBody Message message) {
        return mongoService.updateMessageByValue(message);
    }

    @CrossOrigin(origins = "https://akshu.ar")
    @PostMapping(value="/message",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Message> putMessageByValue(@RequestBody Message message) {
        return mongoService.putMessageByValue(message);
    }

    @DeleteMapping(value="/message/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity.BodyBuilder> deleteMessageById(@PathVariable String id) {
        return mongoService.deleteMessageById(id);
    }

    @DeleteMapping(value="/message",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity.BodyBuilder> deleteMessageByValue(@RequestBody Message message) {
        return mongoService.deleteMessageByValue(message);
    }

}
