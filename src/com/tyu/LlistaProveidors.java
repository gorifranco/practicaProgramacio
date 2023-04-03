package com.tyu;

import java.util.ArrayList;

public class LlistaProveidors {
    private ArrayList<Proveidor> proveidors;

    public LlistaProveidors() {
        this.proveidors = new ArrayList<>();
    }

    public void afegirProveidor(String nom, String telefon, String eMail, String direccio) {
        proveidors.add(new Proveidor(nom, telefon, eMail, direccio));
    }

    public void eliminarProveidor(String nomProveidor) {
        if (existeixProveidor(nomProveidor)) {
            proveidors.remove(trobarProveidor(nomProveidor));
        }
    }

    public Proveidor getProveidor(String nomProveidor) {
        if (existeixProveidor(nomProveidor)) {
            return proveidors.get(trobarProveidor(nomProveidor));
        }
        return null;
    }

    private boolean existeixProveidor(String nomProveidor) {
        for (int i = 0; i < proveidors.size(); i++) {
            if (proveidors.get(i).getNom().equals(nomProveidor)) {
                return true;
            }
        }
        return false;
    }

    private int trobarProveidor(String nomProveidor) {
        for (int i = 0; i < proveidors.size(); i++) {
            if (proveidors.get(i).getNom().equals(nomProveidor)) {
                return i;
            }
        }
        return -1;
    }

    public ArrayList<String> quinProveidorTeLaJugueta(String nomJugueta) {
        ArrayList<String> temp = new ArrayList<>();
        for (int i = 0; i < proveidors.size(); i++) {
            if (proveidors.get(i).teJugueta(nomJugueta)) {
                temp.add(proveidors.get(i).proveidorJugueta(nomJugueta));
            }
        }
        return temp;
    }

    public ArrayList<Proveidor> getProveidors() {
        return proveidors;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < proveidors.size() ; i++) {
            sb.append(proveidors.get(i).toString()).append("\n");
        }
        return sb.toString();
    }
}
