package com.flashhammer.juicyfruit.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

public class Expediente {

    @Id
    int expId;
    ExpedientesSolo expedientesSolo;
    Encabezado encabezado;
    UltimaAccion ultimaAccion;
    List<Parte> partes;
    Ficha ficha;
    List<Actuacion> actuaciones;
    AccesosExpediente accesosExpediente;

    public int getExpId() {
        return expId;
    }

    public void setExpId(int expId) {
        this.expId = expId;
    }

    public ExpedientesSolo getExpedientesSolo() {
        return expedientesSolo;
    }

    public void setExpedientesSolo(ExpedientesSolo expedientesSolo) {
        this.expedientesSolo = expedientesSolo;
    }

    public Encabezado getEncabezado() {
        return encabezado;
    }

    public void setEncabezado(Encabezado encabezado) {
        this.encabezado = encabezado;
    }

    public UltimaAccion getUltimaAccion() {
        return ultimaAccion;
    }

    public void setUltimaAccion(UltimaAccion ultimaAccion) {
        this.ultimaAccion = ultimaAccion;
    }

    public List<Parte> getPartes() {
        return partes;
    }

    public void setPartes(List<Parte> partes) {
        this.partes = partes;
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

    public List<Actuacion> getActuaciones() {
        return actuaciones;
    }

    public void setActuaciones(List<Actuacion> actuaciones) {
        this.actuaciones = actuaciones;
    }

    public AccesosExpediente getAccesosExpediente() {
        return accesosExpediente;
    }

    public void setAccesosExpediente(AccesosExpediente accesosExpediente) {
        this.accesosExpediente = accesosExpediente;
    }
}
