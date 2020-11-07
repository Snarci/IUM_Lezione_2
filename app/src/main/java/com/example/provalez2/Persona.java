package com.example.provalez2;

import java.io.Serializable;
import java.util.Calendar;

public class Persona implements Serializable {
    private String nome,cognome,indirizzo;



    Calendar dataDiNascita;
    public Persona(){
        this.nome="";
        this.cognome="";

    }

    public void setDataDiNascita(Calendar dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }
    public Calendar getDataDiNascita() {
        return dataDiNascita;
    }
    public Persona(String nome, String cognome, String data, String indirizzo, Calendar eta){
        this.nome=nome;
        this.cognome=cognome;
        this.indirizzo=indirizzo;
        this.dataDiNascita=eta;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }



    public String getIndirizzo() {
        return indirizzo;
    }


    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }


}
