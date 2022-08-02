package com.flashhammer.juicyfruit.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Comparator;

public class Parte implements Comparable<Parte> {

    int expId;
    boolean esNotificableFisicamente;
    ArrayList<Representante> representantes;
    int perId;
    int tieneDelito;
    String nombreApellido;
    int esDetenido;
    String vinculo;
    ArrayList<Domicilio> domicilios;
    int esCondenado;

    @JsonProperty("expId")
    public int getExpId() {
        return expId;
    }

    public void setExpId(int expId) {
        this.expId = expId;
    }

    @JsonProperty("esNotificableFisicamente")
    public boolean getEsNotificableFisicamente() {
        return this.esNotificableFisicamente;
    }

    public void setEsNotificableFisicamente(boolean esNotificableFisicamente) {
        this.esNotificableFisicamente = esNotificableFisicamente;
    }

    @JsonProperty("representantes")
    public ArrayList<Representante> getRepresentantes() {
        return this.representantes;
    }

    public void setRepresentantes(ArrayList<Representante> representantes) {
        this.representantes = representantes;
    }

    @JsonProperty("perId")
    public int getPerId() {
        return this.perId;
    }

    public void setPerId(int perId) {
        this.perId = perId;
    }

    @JsonProperty("tieneDelito")
    public int getTieneDelito() {
        return this.tieneDelito;
    }

    public void setTieneDelito(int tieneDelito) {
        this.tieneDelito = tieneDelito;
    }

    @JsonProperty("nombreApellido")
    public String getNombreApellido() {
        return this.nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    @JsonProperty("esDetenido")
    public int getEsDetenido() {
        return this.esDetenido;
    }

    public void setEsDetenido(int esDetenido) {
        this.esDetenido = esDetenido;
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

    @JsonProperty("esCondenado")
    public int getEsCondenado() {
        return this.esCondenado;
    }

    public void setEsCondenado(int esCondenado) {
        this.esCondenado = esCondenado;
    }

    @Override
    public int compareTo(Parte o) {
        //implement comparison here
        return Comparator.comparing(Parte::getVinculo).thenComparing(Parte::getPerId).thenComparing(Parte::getExpId).compare(this, o);
    }
}




