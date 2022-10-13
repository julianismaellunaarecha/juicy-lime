package com.flashhammer.juicyfruit.service;

import com.flashhammer.juicyfruit.model.Encabezado;
import com.flashhammer.juicyfruit.model.Expediente;
import com.flashhammer.juicyfruit.model.ExpedientesSolo;
import com.flashhammer.juicyfruit.model.ExpedientesSoloNew;
import com.flashhammer.juicyfruit.model.Ficha;
import com.flashhammer.juicyfruit.model.Parte;
import com.flashhammer.juicyfruit.model.UltimaAccion;
import com.flashhammer.juicyfruit.model.UltimaAccionNew;
import com.flashhammer.juicyfruit.repository.EncabezadoMongoRepository;
import com.flashhammer.juicyfruit.repository.ExpedienteCompletoMongoRepository;
import com.flashhammer.juicyfruit.repository.ExpedientesSoloMongoRepository;
import com.flashhammer.juicyfruit.repository.ExpedientesSoloNewMongoRepository;
import com.flashhammer.juicyfruit.repository.FichaMongoRepository;
import com.flashhammer.juicyfruit.repository.ParteMongoRepository;
import com.flashhammer.juicyfruit.repository.UltimaAccionMongoRepository;
import com.flashhammer.juicyfruit.repository.UltimaAccionNewMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class MongoService {

    @Autowired
    ExpedientesSoloMongoRepository expedientesSoloMongoRepository;

    @Autowired
    ExpedientesSoloNewMongoRepository expedientesSoloNewMongoRepository;

    @Autowired
    EncabezadoMongoRepository encabezadoMongoRepository;

    @Autowired
    UltimaAccionMongoRepository ultimaAccionMongoRepository;

    @Autowired
    UltimaAccionNewMongoRepository ultimaAccionNewMongoRepository;

    @Autowired
    FichaMongoRepository fichaMongoRepository;

    @Autowired
    ParteMongoRepository parteMongoRepository;

    @Autowired
    ExpedienteCompletoMongoRepository expedienteCompletoMongoRepository;

    // Expedientes
    public Mono<ExpedientesSolo> getExpedientesSoloById(Integer id) {
        return expedientesSoloMongoRepository.findById(id);
    }

    public Mono<Boolean> getExpedientesPresente(Integer id) {
        return expedientesSoloMongoRepository.existsById(id);
    }

    public Mono<ExpedientesSolo> putExpedientesSoloByValue(ExpedientesSolo expedientesSolo) {
        return expedientesSoloMongoRepository.insert(expedientesSolo);
    }

    public Mono<ExpedientesSoloNew> putExpedientesSoloNewByValue(ExpedientesSoloNew expedientesSoloNew) {
        return expedientesSoloNewMongoRepository.insert(expedientesSoloNew);
    }

    public Flux<ExpedientesSolo> putExpedientesSoloByValues(List<ExpedientesSolo> expedientesSolos) {
        return expedientesSoloMongoRepository.saveAll(expedientesSolos);
    }

    public Mono<Void> deleteExpedientesSoloById(Integer id) {
        return expedientesSoloMongoRepository.deleteById(id);
    }

    public Mono<Void> deleteExpedientesSoloByValue(ExpedientesSolo expedientesSolo) {
        return expedientesSoloMongoRepository.delete(expedientesSolo);
    }

    public Flux<ExpedientesSolo> getExpedientesSoloAll() {
        return expedientesSoloMongoRepository.findAll();
    }

    // Encabezados
    public Flux<Encabezado> getEncabezadoAll() {
        return encabezadoMongoRepository.findAll();
    }

    public Mono<Encabezado> getEncabezadoById(Integer id) {
        return encabezadoMongoRepository.findById(id);
    }

    public Mono<Boolean> getEncabezadoPresente(Integer id) {
        return encabezadoMongoRepository.existsById(id);
    }

    public Mono<Encabezado> putEncabezadoByValue(Encabezado encabezado) {
        return encabezadoMongoRepository.insert(encabezado);
    }

    public Mono<Encabezado> updateEncabezadoByValue(Encabezado encabezado) {
        return encabezadoMongoRepository.save(encabezado);
    }

    // UltimaAccion

    public Flux<UltimaAccion> getUltimaAccionAll() {
        return ultimaAccionMongoRepository.findAll();
    }

    public Mono<UltimaAccion> getUltimaAccionById(Integer id) {
        return ultimaAccionMongoRepository.findById(id);
    }

    public Mono<Boolean> getUltimaAccionPresente(Integer id) {
        return ultimaAccionMongoRepository.existsById(id);
    }

    public Mono<UltimaAccion> putUltimaAccionByValue(UltimaAccion ultimaAccion) {
        return ultimaAccionMongoRepository.insert(ultimaAccion);
    }

    public Mono<UltimaAccion> updateUltimaAccionByValue(UltimaAccion ultimaAccion) {
        return ultimaAccionMongoRepository.save(ultimaAccion);
    }

    // UltimaAccionNew

    public Flux<UltimaAccionNew> getUltimaAccionNewAll() {
        return ultimaAccionNewMongoRepository.findAll();
    }

    public Mono<UltimaAccionNew> getUltimaAccionNewById(Integer id) {
        return ultimaAccionNewMongoRepository.findById(id);
    }

    public Mono<Boolean> getUltimaAccionNewPresente(Integer id) {
        return ultimaAccionNewMongoRepository.existsById(id);
    }

    public Mono<UltimaAccionNew> putUltimaAccionNewByValue(UltimaAccionNew ultimaAccionNew) {
        return ultimaAccionNewMongoRepository.insert(ultimaAccionNew);
    }

    public Mono<UltimaAccionNew> updateUltimaAccionNewByValue(UltimaAccionNew ultimaAccionNew) {
        return ultimaAccionNewMongoRepository.save(ultimaAccionNew);
    }

    // Ficha

    public Flux<Ficha> getFichaAll() {
        return fichaMongoRepository.findAll();
    }

    public Mono<Ficha> getFichaById(Integer id) {
        return fichaMongoRepository.findById(id);
    }

    public Mono<Boolean> getFichaPresente(Integer id) {
        return fichaMongoRepository.existsById(id);
    }

    public Mono<Ficha> putFichaByValue(Ficha ficha) {
        return fichaMongoRepository.insert(ficha);
    }

    public Mono<Ficha> updateFichaByValue(Ficha ficha) {
        return fichaMongoRepository.save(ficha);
    }

    // Parte

    public Flux<Parte> getParteAll() {
        return parteMongoRepository.findAll();
    }

    public Mono<Parte> getParteById(Integer id) {
        return parteMongoRepository.findById(id);
    }

    public Mono<Boolean> getPartePresente(Integer id) {
        return parteMongoRepository.existsById(id);
    }

    public Mono<Parte> putParteByValue(Parte parte) {
        return parteMongoRepository.insert(parte);
    }

    public Mono<Parte> updateParteByValue(Parte parte) {
        return parteMongoRepository.save(parte);
    }

    // Expediente Completo

    public Flux<Expediente> getExpedienteCompletoAll() {
        return expedienteCompletoMongoRepository.findAll();
    }

    public Mono<Expediente> getExpedienteCompletoById(Integer id) {
        return expedienteCompletoMongoRepository.findById(id);
    }

    public Mono<Expediente> updateExpedienteCompletoByValue(Expediente expedienteCompleto) {
        return expedienteCompletoMongoRepository.save(expedienteCompleto);
    }

    public Mono<Expediente> putExpedienteCompletoByValue(Expediente expedienteCompleto) {
        return expedienteCompletoMongoRepository.insert(expedienteCompleto);
    }

    public Mono<Boolean> getExpedienteCompletoPresente(Integer id) {
        return expedienteCompletoMongoRepository.existsById(id);
    }

}
