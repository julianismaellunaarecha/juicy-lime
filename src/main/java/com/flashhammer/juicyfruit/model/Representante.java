package com.flashhammer.juicyfruit.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Representante {
    String nombreApellido;
    String vinculo;
    ArrayList<Domicilio> domicilios;

    @JsonProperty("nombreApellido")
    public String getNombreApellido() {
        return this.nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    @JsonProperty("vinculo")
    public String getVinculo() {
        return this.vinculo;
    }

    public void setVinculo(String vinculo) {
        this.vinculo = vinculo;
    }

    @JsonProperty("domicilios")
    public ArrayList<Domicilio> getDomicilios() {
        return this.domicilios;
    }

    public void setDomicilios(ArrayList<Domicilio> domicilios) {
        this.domicilios = domicilios;
    }
}
