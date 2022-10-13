package com.flashhammer.juicyfruit.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

public class UltimaAccionNew {

    @Id
    int expId;
    String descripcion;
    long fecha;
    String tipo;

    @JsonProperty("expId")
    public int getExpId() {
        return expId;
    }

    public void setExpId(int expId) {
        this.expId = expId;
    }

    @JsonProperty("descripcion")
    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @JsonProperty("fecha")
    public long getFecha() {
        return this.fecha;
    }

    public void setFecha(long fecha) {
        this.fecha = fecha;
    }

    @JsonProperty("tipo")
    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
