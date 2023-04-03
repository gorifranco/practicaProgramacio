package com.tyu;

import java.util.ArrayList;

public class Proveidor {
    private String nom;
    private String telefono;
    private String eMail;
    private String direccio;
    private LlistaJuguetes cataleg;

    public Proveidor(String nom, String telefono, String eMail, String direccio) {
        this.nom = nom;
        this.telefono = telefono;
        this.eMail = eMail;
        this.direccio = direccio;
    }


    public ArrayList<JuguetaPreuQuantitat> getCataleg() {
        return cataleg.getJuguetes();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getDireccio() {
        return direccio;
    }

    public void setDireccio(String direccio) {
        this.direccio = direccio;
    }

    public boolean teJugueta(String nomJugueta) {
        for (int i = 0; i < cataleg.getJuguetes().size(); i++) {
            if (cataleg.getJuguetes().get(i).getJugueta().getNom().equals(nomJugueta)) {
                return true;
            }
        }
        return false;
    }

    public double getPreuJugueta(String nomJugueta) {
        for (int i = 0; i < cataleg.getJuguetes().size(); i++) {
            if (cataleg.getJuguetes().get(i).getJugueta().getNom().equals(nomJugueta)) {
                return cataleg.getJuguetes().get(i).getPreu();
            }
        }
        return -1;
    }

    public String proveidorJugueta(String nomJugueta) {
        return this.nom + ": " + getPreuJugueta(nomJugueta);
    }
}

