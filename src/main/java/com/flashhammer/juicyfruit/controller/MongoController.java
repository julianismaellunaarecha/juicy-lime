package com.flashhammer.juicyfruit.controller;

import com.flashhammer.juicyfruit.model.Encabezado;
import com.flashhammer.juicyfruit.model.Expediente;
import com.flashhammer.juicyfruit.model.ExpedientesSolo;
import com.flashhammer.juicyfruit.model.ExpedientesSoloNew;
import com.flashhammer.juicyfruit.model.Ficha;
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

    // Expedientes
    @GetMapping("expedientessolo")
    public Flux<ExpedientesSolo> getExpedientesSolo() {
        return mongoService.getExpedientesSoloAll();
    }

    @GetMapping("expedientessolo/{id}")
    public Mono<ExpedientesSolo> getExpedientesSoloId(@PathVariable Integer id) {
        return mongoService.getExpedientesSoloById(id);
    }

    @GetMapping("expedientespresente/{id}")
    public Mono<Boolean> getExpedientesPresente(Integer id) {
        return mongoService.getExpedientesPresente(id);
    }

    @PostMapping
     public Mono<ExpedientesSolo> putExpedientesSoloByValue(ExpedientesSolo expedientesSolo) {
        return mongoService.putExpedientesSoloByValue(expedientesSolo);
    }

    public Mono<ExpedientesSoloNew> putExpedientesSoloNewByValue(ExpedientesSoloNew expedientesSoloNew) {
        return mongoService.putExpedientesSoloNewByValue(expedientesSoloNew);
    }

    public Flux<ExpedientesSolo> putExpedientesSoloByValues(List<ExpedientesSolo> expedientesSolos) {
        return mongoService.putExpedientesSoloByValues(expedientesSolos);
    }

    @DeleteMapping("expedientessolo/{id}")
    public Mono<Void> deleteExpedientesSoloById(@PathVariable Integer id) {
        return mongoService.deleteExpedientesSoloById(id);
    }

    @DeleteMapping("expedientessolo/{expedientesSolo}")
    public Mono<Void> deleteExpedientesSoloByValue(ExpedientesSolo expedientesSolo) {
        return mongoService.deleteExpedientesSoloByValue(expedientesSolo);
    }

    // Encabezados
    @GetMapping("encabezados")
    public Flux<Encabezado> getEncabezadoAll() {
        return mongoService.getEncabezadoAll();
    }

    @GetMapping("encabezados/{id}")
    public Mono<Encabezado> getEncabezadoById(Integer id) {
        return mongoService.getEncabezadoById(id);
    }

    @GetMapping("encabezadopresente/{id}")
    public Mono<Boolean> getEncabezadoPresente(Integer id) {
        return mongoService.getEncabezadoPresente(id);
    }

    public Mono<Encabezado> putEncabezadoByValue(Encabezado encabezado) {
        return mongoService.putEncabezadoByValue(encabezado);
    }

    public Mono<Encabezado> updateEncabezadoByValue(Encabezado encabezado) {
        return mongoService.updateEncabezadoByValue(encabezado);
    }

    // UltimaAccion

    @GetMapping("ultimasacciones")
    public Flux<UltimaAccion> getUltimaAccionAll() {
        return mongoService.getUltimaAccionAll();
    }

    @GetMapping("ultimaaccion/{id}")
    public Mono<UltimaAccion> getUltimaAccionById(Integer id) {
        return mongoService.getUltimaAccionById(id);
    }

    @GetMapping("ultimaaccionepresente/{id}")
    public Mono<Boolean> getUltimaAccionPresente(Integer id) {
        return mongoService.getUltimaAccionPresente(id);
    }

    public Mono<UltimaAccion> putUltimaAccionByValue(UltimaAccion ultimaAccion) {
        return mongoService.putUltimaAccionByValue(ultimaAccion);
    }

    public Mono<UltimaAccion> updateUltimaAccionByValue(UltimaAccion ultimaAccion) {
        return mongoService.updateUltimaAccionByValue(ultimaAccion);
    }

    // UltimaAccionNew

    @GetMapping("ultimasaccionesnew")
    public Flux<UltimaAccionNew> getUltimaAccionNewAll() {
        return mongoService.getUltimaAccionNewAll();
    }

    @GetMapping("ultimaaccionnew/{id}")
    public Mono<UltimaAccionNew> getUltimaAccionNewById(Integer id) {
        return mongoService.getUltimaAccionNewById(id);
    }

    @GetMapping("ultimaaccionnewpresente/{id}")
    public Mono<Boolean> getUltimaAccionNewPresente(Integer id) {
        return mongoService.getUltimaAccionNewPresente(id);
    }


    public Mono<UltimaAccionNew> putUltimaAccionNewByValue(UltimaAccionNew ultimaAccionNew) {
        return mongoService.putUltimaAccionNewByValue(ultimaAccionNew);
    }

    public Mono<UltimaAccionNew> updateUltimaAccionNewByValue(UltimaAccionNew ultimaAccionNew) {
        return mongoService.updateUltimaAccionNewByValue(ultimaAccionNew);
    }

    // Ficha

    @GetMapping("fichas")
    public Flux<Ficha> getFichaAll() {
        return mongoService.getFichaAll();
    }

    @GetMapping("ficha/{id}")
    public Mono<Ficha> getFichaById(Integer id) {
        return mongoService.getFichaById(id);
    }

    @GetMapping("fichapresente/{id}")
    public Mono<Boolean> getFichaPresente(Integer id) {
        return mongoService.getFichaPresente(id);
    }


    public Mono<Ficha> putFichaByValue(Ficha ficha) {
        return mongoService.putFichaByValue(ficha);
    }

    public Mono<Ficha> updateFichaByValue(Ficha ficha) {
        return mongoService.updateFichaByValue(ficha);
    }

    // Parte

    @GetMapping("partes")
    public Flux<Parte> getParteAll() {
        return mongoService.getParteAll();
    }

    @GetMapping("parte/{id}")
    public Mono<Parte> getParteById(Integer id) {
        return mongoService.getParteById(id);
    }

    @GetMapping("partepresente/{id}")
    public Mono<Boolean> getPartePresente(Integer id) {
        return mongoService.getPartePresente(id);
    }

    public Mono<Parte> putParteByValue(Parte parte) {
        return mongoService.putParteByValue(parte);
    }

    public Mono<Parte> updateParteByValue(Parte parte) {
        return mongoService.updateParteByValue(parte);
    }

    // Expediente completo

    @GetMapping("expedientescompletos")
    public Flux<Expediente> getExpedienteCompletoAll() {
        return mongoService.getExpedienteCompletoAll();
    }

    @GetMapping("expedientecompleto/{id}")
    public Mono<Expediente> getExpedienteCompletoById(Integer id) {
        return mongoService.getExpedienteCompletoById(id);
    }

    @GetMapping("expedientecompletopresente/{id}")
    public Mono<Boolean> getExpedienteCompletoPresente(Integer id) {
        return mongoService.getExpedienteCompletoPresente(id);
    }

    public Mono<Expediente> putExpedienteCompletoByValue(Expediente expediente) {
        return mongoService.putExpedienteCompletoByValue(expediente);
    }

    public Mono<Expediente> updateExpedienteCompletoByValue(Expediente expediente) {
        return mongoService.updateExpedienteCompletoByValue(expediente);
    }

}
