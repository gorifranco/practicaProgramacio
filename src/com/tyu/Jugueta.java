package com.tyu;


public class Jugueta {

    private String nom;
    private Marca marca;
    private String descripcio;
    private String tipusJugueta;
    private RangoEdad rangoEdad;

    public Jugueta(String nom, Marca marca, String descripcio, String tipusJugueta, RangoEdad rangoEdad) {
        this.nom = nom;
        this.marca = marca;
        this.descripcio = descripcio;
        this.tipusJugueta = tipusJugueta;
        this.rangoEdad = rangoEdad;
    }

    public String getNom() {
        return nom;
    }

    public Marca getMarca() {
        return marca;
    }


    public String getDescripcio() {
        return descripcio;
    }

    public String getTipusJugueta() {
        return tipusJugueta;
    }

    public RangoEdad getRangoEdad() {
        return rangoEdad;
    }

    @Override
    public String toString() {
        return "Jugueta{" +
                "nom='" + nom + '\'' +
                ", marca=" + marca +
                ", descripcio='" + descripcio + '\'' +
                ", tipusJugueta='" + tipusJugueta + '\'' +
                ", rangoEdad=" + rangoEdad +
                '}';
    }
}
