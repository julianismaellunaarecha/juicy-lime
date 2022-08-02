package com.flashhammer.juicyfruit.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Ubicacion {
    String organismo;
    String dependencia;

    @JsonProperty("organismo")
    public String getOrganismo() {
        return this.organismo;
    }

    public void setOrganismo(String organismo) {
        this.organismo = organismo;
    }

    @JsonProperty("dependencia")
    public String getDependencia() {
        return this.dependencia;
    }

    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }
}
