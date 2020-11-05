package com.example.provalez2;

import java.io.Serializable;

public class Persona implements Serializable {
    private String nome,cognome,data,indirizzo,eta;
    public Persona(){
        this.nome="";
        this.cognome="";
        this.data="";
    }
    public Persona(String nome, String cognome, String data, String indirizzo, String eta){
        this.nome=nome;
        this.cognome=cognome;
        this.data=data;
        this.indirizzo=indirizzo;
        this.eta=eta;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public void setEta(String eta) {
        this.eta = eta;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public String getEta() {
        return eta;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getData() {
        return data;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setData(String data) {
        this.data = data;
    }
}
