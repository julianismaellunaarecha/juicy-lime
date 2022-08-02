package com.flashhammer.juicyfruit.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

import java.util.Comparator;

public class ExpedientesSoloNew implements Comparable<ExpedientesSoloNew> {

    @Id
    int expId;
    String fechaFavorito = "";

    @JsonProperty("expId")
    public int getExpId() {
        return this.expId;
    }

    public void setExpId(int expId) {
        this.expId = expId;
    }

    @JsonProperty("fechaFavorito")
    public String getFechaFavorito() {
        return this.fechaFavorito;
    }

    public void setFechaFavorito(String fechaFavorito) {
        this.fechaFavorito = fechaFavorito;
    }

    @Override
    public int compareTo(ExpedientesSoloNew o) {
        //implement comparison here
        return Comparator.comparing(ExpedientesSoloNew::getExpId).compare(this, o);
    }
}