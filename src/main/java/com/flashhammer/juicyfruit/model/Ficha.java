package com.flashhammer.juicyfruit.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;

public class Ficha {

    @Id
    int expId;
    Radicaciones radicaciones;
    int numero;
    int anio;
    int sufijo;
    ArrayList<ObjetosJuicio> objetosJuicio;
    Ubicacion ubicacion;
    long fechaInicio;
    long ultimoMovimiento;
    int tieneSentencia;
    Object expedienteOtraJurisdiccion;
    int esPrivado;
    Object expedienteUACF;
    String tipoExpediente;
    String cuij;
    String caratula;
    Object codigoDGR;
    Object numeroAdjudicacion;
    double monto;
    Object etiquetas;

    @JsonProperty("expId")
    public int getExpId() {
        return expId;
    }

    public void setExpId(int expId) {
        this.expId = expId;
    }

    @JsonProperty("radicaciones")
    public Radicaciones getRadicaciones() {
        return this.radicaciones;
    }

    public void setRadicaciones(Radicaciones radicaciones) {
        this.radicaciones = radicaciones;
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

    @JsonProperty("sufijo")
    public int getSufijo() {
        return this.sufijo;
    }

    public void setSufijo(int sufijo) {
        this.sufijo = sufijo;
    }

    @JsonProperty("objetosJuicio")
    public ArrayList<ObjetosJuicio> getObjetosJuicio() {
        return this.objetosJuicio;
    }

    public void setObjetosJuicio(ArrayList<ObjetosJuicio> objetosJuicio) {
        this.objetosJuicio = objetosJuicio;
    }

    @JsonProperty("ubicacion")
    public Ubicacion getUbicacion() {
        return this.ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    @JsonProperty("fechaInicio")
    public long getFechaInicio() {
        return this.fechaInicio;
    }

    public void setFechaInicio(long fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @JsonProperty("ultimoMovimiento")
    public long getUltimoMovimiento() {
        return this.ultimoMovimiento;
    }

    public void setUltimoMovimiento(long ultimoMovimiento) {
        this.ultimoMovimiento = ultimoMovimiento;
    }

    @JsonProperty("tieneSentencia")
    public int getTieneSentencia() {
        return this.tieneSentencia;
    }

    public void setTieneSentencia(int tieneSentencia) {
        this.tieneSentencia = tieneSentencia;
    }

    @JsonProperty("expedienteOtraJurisdiccion")
    public Object getExpedienteOtraJurisdiccion() {
        return this.expedienteOtraJurisdiccion;
    }

    public void setExpedienteOtraJurisdiccion(Object expedienteOtraJurisdiccion) {
        this.expedienteOtraJurisdiccion = expedienteOtraJurisdiccion;
    }

    @JsonProperty("esPrivado")
    public int getEsPrivado() {
        return this.esPrivado;
    }

    public void setEsPrivado(int esPrivado) {
        this.esPrivado = esPrivado;
    }

    @JsonProperty("expedienteUACF")
    public Object getExpedienteUACF() {
        return this.expedienteUACF;
    }

    public void setExpedienteUACF(Object expedienteUACF) {
        this.expedienteUACF = expedienteUACF;
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

    @JsonProperty("caratula")
    public String getCaratula() {
        return this.caratula;
    }

    public void setCaratula(String caratula) {
        this.caratula = caratula;
    }

    @JsonProperty("codigoDGR")
    public Object getCodigoDGR() {
        return this.codigoDGR;
    }

    public void setCodigoDGR(Object codigoDGR) {
        this.codigoDGR = codigoDGR;
    }

    @JsonProperty("numeroAdjudicacion")
    public Object getNumeroAdjudicacion() {
        return this.numeroAdjudicacion;
    }

    public void setNumeroAdjudicacion(Object numeroAdjudicacion) {
        this.numeroAdjudicacion = numeroAdjudicacion;
    }

    @JsonProperty("monto")
    public double getMonto() {
        return this.monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @JsonProperty("etiquetas")
    public Object getEtiquetas() {
        return this.etiquetas;
    }

    public void setEtiquetas(Object etiquetas) {
        this.etiquetas = etiquetas;
    }
}



