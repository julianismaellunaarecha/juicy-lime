package com.flashhammer.juicyfruit.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Domicilio {
    int domId;
    String descripcion;
    String tipoDomicilio;
    boolean esNotificableFisicamente;
    boolean esNotificableElectronicamente;
    String domicilioNotificable;

    @JsonProperty("domId")
    public int getDomId() {
        return this.domId;
    }

    public void setDomId(int domId) {
        this.domId = domId;
    }

    @JsonProperty("descripcion")
    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @JsonProperty("tipoDomicilio")
    public String getTipoDomicilio() {
        return this.tipoDomicilio;
    }

    public void setTipoDomicilio(String tipoDomicilio) {
        this.tipoDomicilio = tipoDomicilio;
    }

    @JsonProperty("esNotificableFisicamente")
    public boolean getEsNotificableFisicamente() {
        return this.esNotificableFisicamente;
    }

    public void setEsNotificableFisicamente(boolean esNotificableFisicamente) {
        this.esNotificableFisicamente = esNotificableFisicamente;
    }

    @JsonProperty("esNotificableElectronicamente")
    public boolean getEsNotificableElectronicamente() {
        return this.esNotificableElectronicamente;
    }

    public void setEsNotificableElectronicamente(boolean esNotificableElectronicamente) {
        this.esNotificableElectronicamente = esNotificableElectronicamente;
    }

    @JsonProperty("domicilioNotificable")
    public String getDomicilioNotificable() {
        return this.domicilioNotificable;
    }

    public void setDomicilioNotificable(String domicilioNotificable) {
        this.domicilioNotificable = domicilioNotificable;
    }
}
