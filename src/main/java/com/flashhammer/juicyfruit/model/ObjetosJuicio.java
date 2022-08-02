package com.flashhammer.juicyfruit.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ObjetosJuicio {
    String objetoJuicio;
    String categoria;
    int esPrincipal;
    String materia;

    @JsonProperty("objetoJuicio")
    public String getObjetoJuicio() {
        return this.objetoJuicio;
    }

    public void setObjetoJuicio(String objetoJuicio) {
        this.objetoJuicio = objetoJuicio;
    }

    @JsonProperty("categoria")
    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @JsonProperty("esPrincipal")
    public int getEsPrincipal() {
        return this.esPrincipal;
    }

    public void setEsPrincipal(int esPrincipal) {
        this.esPrincipal = esPrincipal;
    }

    @JsonProperty("materia")
    public String getMateria() {
        return this.materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }
}
