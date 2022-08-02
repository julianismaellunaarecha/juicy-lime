package com.flashhammer.juicyfruit.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContenedorUltimaAccion {
    UltimaAccion ultimaAccion;

    @JsonProperty("ultimaAccion")
    public UltimaAccion getUltimaAccion() {
        return this.ultimaAccion;
    }

    public void setUltimaAccion(UltimaAccion ultimaAccion) {
        this.ultimaAccion = ultimaAccion;
    }
}