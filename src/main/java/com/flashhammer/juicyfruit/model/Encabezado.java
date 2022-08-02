package com.flashhammer.juicyfruit.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

public class Encabezado {

    @Id
    int expId;
    String tipoExpediente;
    String cuij;
    int numero;
    int anio;
    String caratula;
    Object nivelAcceso;
    String estadoAdministrativo;
    int esPrivado;
    long fechaInicio;
    int sufijo;
    String ubicacion_organismo;

    @JsonProperty("expId")
    public int getExpId() {
        return expId;
    }

    public void setExpId(int expId) {
        this.expId = expId;
    }

    @JsonProperty("tipoExpediente")
    public String getTipoExpediente() {
        return this.tipoExpediente;
    }

    public void setTipoExpediente(String tipoExpediente) {
        this.tipoExpediente = tipoExpediente;
    }

    @JsonProperty("cuij")
    public String getCuij() {
        return this.cuij;
    }

    public void setCuij(String cuij) {
        this.cuij = cuij;
    }

    @JsonProperty("numero")
    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @JsonProperty("anio")
    public int getAnio() {
        return this.anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    @JsonProperty("caratula")
    public String getCaratula() {
        return this.caratula;
    }

    public void setCaratula(String caratula) {
        this.caratula = caratula;
    }

    @JsonProperty("nivelAcceso")
    public Object getNivelAcceso() {
        return this.nivelAcceso;
    }

    public void setNivelAcceso(Object nivelAcceso) {
        this.nivelAcceso = nivelAcceso;
    }

    @JsonProperty("estadoAdministrativo")
    public String getEstadoAdministrativo() {
        return this.estadoAdministrativo;
    }

    public void setEstadoAdministrativo(String estadoAdministrativo) {
        this.estadoAdministrativo = estadoAdministrativo;
    }

    @JsonProperty("esPrivado")
    public int getEsPrivado() {
        return this.esPrivado;
    }

    public void setEsPrivado(int esPrivado) {
        this.esPrivado = esPrivado;
    }

    @JsonProperty("fechaInicio")
    public long getFechaInicio() {
        return this.fechaInicio;
    }

    public void setFechaInicio(long fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @JsonProperty("sufijo")
    public int getSufijo() {
        return this.sufijo;
    }

    public void setSufijo(int sufijo) {
        this.sufijo = sufijo;
    }

    @JsonProperty("ubicacion_organismo")
    public String getUbicacion_organismo() {
        return this.ubicacion_organismo;
    }

    public void setUbicacion_organismo(String ubicacion_organismo) {
        this.ubicacion_organismo = ubicacion_organismo;
    }
}
