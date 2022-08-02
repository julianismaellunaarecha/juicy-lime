package com.flashhammer.juicyfruit.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Radicaciones {
    String secretariaPrimeraInstancia;
    String organismoSegundaInstancia;
    String secretariaSegundaInstancia;
    String organismoPrimeraInstancia;
    String organismoTerceraInstancia;

    @JsonProperty("secretariaTerceraInstancia")
    public String getSecretariaTerceraInstancia() {
        return secretariaTerceraInstancia;
    }

    public void setSecretariaTerceraInstancia(String secretariaTerceraInstancia) {
        this.secretariaTerceraInstancia = secretariaTerceraInstancia;
    }

    String secretariaTerceraInstancia;

    @JsonProperty("organismoTerceraInstancia")
    public String getOrganismoTerceraInstancia() {
        return organismoTerceraInstancia;
    }

    public void setOrganismoTerceraInstancia(String organismoTerceraInstancia) {
        this.organismoTerceraInstancia = organismoTerceraInstancia;
    }

    @JsonProperty("secretariaPrimeraInstancia")
    public String getSecretariaPrimeraInstancia() {
        return this.secretariaPrimeraInstancia;
    }

    public void setSecretariaPrimeraInstancia(String secretariaPrimeraInstancia) {
        this.secretariaPrimeraInstancia = secretariaPrimeraInstancia;
    }

    @JsonProperty("organismoSegundaInstancia")
    public String getOrganismoSegundaInstancia() {
        return this.organismoSegundaInstancia;
    }

    public void setOrganismoSegundaInstancia(String organismoSegundaInstancia) {
        this.organismoSegundaInstancia = organismoSegundaInstancia;
    }

    @JsonProperty("secretariaSegundaInstancia")
    public String getSecretariaSegundaInstancia() {
        return this.secretariaSegundaInstancia;
    }

    public void setSecretariaSegundaInstancia(String secretariaSegundaInstancia) {
        this.secretariaSegundaInstancia = secretariaSegundaInstancia;
    }

    @JsonProperty("organismoPrimeraInstancia")
    public String getOrganismoPrimeraInstancia() {
        return this.organismoPrimeraInstancia;
    }

    public void setOrganismoPrimeraInstancia(String organismoPrimeraInstancia) {
        this.organismoPrimeraInstancia = organismoPrimeraInstancia;
    }
}
