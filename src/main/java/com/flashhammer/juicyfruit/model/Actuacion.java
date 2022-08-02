package com.flashhammer.juicyfruit.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Actuacion {
    int esCedula;
    String codigo;
    int numero;
    Object fechaFirma;
    String firmantes;
    int actId;
    String titulo;
    int anio;
    String actuacionesNotificadas;
    long fechaNotificacion;
    int poseeAdjunto;
    String cuij;

    @JsonProperty("esCedula")
    public int getEsCedula() {
        return this.esCedula;
    }

    public void setEsCedula(int esCedula) {
        this.esCedula = esCedula;
    }

    @JsonProperty("codigo")
    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @JsonProperty("numero")
    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @JsonProperty("fechaFirma")
    public Object getFechaFirma() {
        return this.fechaFirma;
    }

    public void setFechaFirma(Object fechaFirma) {
        this.fechaFirma = fechaFirma;
    }

    @JsonProperty("firmantes")
    public String getFirmantes() {
        return this.firmantes;
    }

    public void setFirmantes(String firmantes) {
        this.firmantes = firmantes;
    }

    @JsonProperty("actId")
    public int getActId() {
        return this.actId;
    }

    public void setActId(int actId) {
        this.actId = actId;
    }

    @JsonProperty("titulo")
    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @JsonProperty("anio")
    public int getAnio() {
        return this.anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    @JsonProperty("actuacionesNotificadas")
    public String getActuacionesNotificadas() {
        return this.actuacionesNotificadas;
    }

    public void setActuacionesNotificadas(String actuacionesNotificadas) {
        this.actuacionesNotificadas = actuacionesNotificadas;
    }

    @JsonProperty("fechaNotificacion")
    public long getFechaNotificacion() {
        return this.fechaNotificacion;
    }

    public void setFechaNotificacion(long fechaNotificacion) {
        this.fechaNotificacion = fechaNotificacion;
    }

    @JsonProperty("poseeAdjunto")
    public int getPoseeAdjunto() {
        return this.poseeAdjunto;
    }

    public void setPoseeAdjunto(int poseeAdjunto) {
        this.poseeAdjunto = poseeAdjunto;
    }

    @JsonProperty("cuij")
    public String getCuij() {
        return this.cuij;
    }

    public void setCuij(String cuij) {
        this.cuij = cuij;
    }
}
