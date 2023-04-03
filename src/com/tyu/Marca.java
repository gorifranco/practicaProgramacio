package com.tyu;

import java.util.Date;

public class Marca {
    private String nom;
    private String telefon;
    private String direccio;
    private String eMail;

    public Marca(String nom, String telefon, String direccio, String eMail) {
        this.nom = nom;
        this.telefon = telefon;
        this.direccio = direccio;
        this.eMail = eMail;
    }

    public void enviarMailMarca() {
    }

    public void ponerRecordatorioLlamar(Date fecha) {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getDireccio() {
        return direccio;
    }

    public void setDireccio(String direccio) {
        this.direccio = direccio;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
}
