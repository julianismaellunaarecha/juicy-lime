package com.flashhammer.juicyfruit.controller;

import com.flashhammer.juicyfruit.model.Encabezado;
import com.flashhammer.juicyfruit.model.Expediente;
import com.flashhammer.juicyfruit.model.ExpedientesSolo;
import com.flashhammer.juicyfruit.model.ExpedientesSoloNew;
import com.flashhammer.juicyfruit.model.Ficha;
import com.flashhammer.juicyfruit.model.Message;
import com.flashhammer.juicyfruit.model.Parte;
import com.flashhammer.juicyfruit.model.UltimaAccion;
import com.flashhammer.juicyfruit.model.UltimaAccionNew;
import com.flashhammer.juicyfruit.service.MongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Controller
@RestController
@RequestMapping("mongocontroller")
public class MongoController {

    @Autowired
    private MongoService mongoService;

    @GetMapping("messages")
    public Flux<Message> getMessages() {
        return mongoService.getMessages();
    }

    @GetMapping("message/{id}")
    public Mono<Message> getMessageById(Integer id) {
        return mongoService.getMessageById(id);
    }

    @GetMapping("message/{id}")
    public Mono<Boolean> isMessagePresent(Integer id) {
        return mongoService.isMessagePresent(id);
    }

    public Mono<Message> putMessageByValue(Message message) {
        return mongoService.putMessageByValue(message);
    }

}
