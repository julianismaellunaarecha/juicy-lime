package com.flashhammer.juicyfruit.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccesosExpediente {


    boolean tieneAccesoPublico;
    boolean tieneAccesoEstricto;
    boolean tieneAccesoPorAutorizacion;
    boolean tieneAccesoLogueado;
    boolean tieneAccesoRadicado;

    @JsonProperty("tieneAccesoPublico")
    public boolean getTieneAccesoPublico() {
        return this.tieneAccesoPublico;
    }

    public void setTieneAccesoPublico(boolean tieneAccesoPublico) {
        this.tieneAccesoPublico = tieneAccesoPublico;
    }

    @JsonProperty("tieneAccesoEstricto")
    public boolean getTieneAccesoEstricto() {
        return this.tieneAccesoEstricto;
    }

    public void setTieneAccesoEstricto(boolean tieneAccesoEstricto) {
        this.tieneAccesoEstricto = tieneAccesoEstricto;
    }

    @JsonProperty("tieneAccesoPorAutorizacion")
    public boolean getTieneAccesoPorAutorizacion() {
        return this.tieneAccesoPorAutorizacion;
    }

    public void setTieneAccesoPorAutorizacion(boolean tieneAccesoPorAutorizacion) {
        this.tieneAccesoPorAutorizacion = tieneAccesoPorAutorizacion;
    }

    @JsonProperty("tieneAccesoLogueado")
    public boolean getTieneAccesoLogueado() {
        return this.tieneAccesoLogueado;
    }

    public void setTieneAccesoLogueado(boolean tieneAccesoLogueado) {
        this.tieneAccesoLogueado = tieneAccesoLogueado;
    }

    @JsonProperty("tieneAccesoRadicado")
    public boolean getTieneAccesoRadicado() {
        return this.tieneAccesoRadicado;
    }

    public void setTieneAccesoRadicado(boolean tieneAccesoRadicado) {
        this.tieneAccesoRadicado = tieneAccesoRadicado;
    }
}
