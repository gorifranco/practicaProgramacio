package com.tyu;

import java.util.ArrayList;

public class LlistaMarques {
    private ArrayList<Marca> marques;

    public LlistaMarques() {
        this.marques = new ArrayList<>();
    }

    public void afegirMarca(String nom, String telefon, String direccio, String email) {
        marques.add(new Marca(nom, telefon, direccio, email));
    }
    public void eliminarMarca(String nomMarca){
        if(existeixMarca(nomMarca)){
            marques.remove(trobarMarca(nomMarca));
        }
    }

    public boolean existeixMarca(String nomMarca) {
        for (int i = 0; i < marques.size(); i++) {
            if (marques.get(i).getNom().equals(nomMarca)) {
                return true;
            }
        }
        return false;
    }

    private int trobarMarca(String nomMarca) {
        for (int i = 0; i < marques.size(); i++) {
            if (marques.get(i).getNom().equals(nomMarca)) {
                return i;
            }
        }
        return -1;
    }

    public Marca getMarca(String nomMarca) {
        if (existeixMarca(nomMarca)) {
            return marques.get(trobarMarca(nomMarca));
        }
        return null;
    }
}
