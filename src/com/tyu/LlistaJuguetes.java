package com.tyu;

import java.util.ArrayList;

public class LlistaJuguetes {
    private ArrayList<JuguetaPreuQuantitat> juguetes;

    public LlistaJuguetes() {
        this.juguetes = new ArrayList<>();
    }

    public void afegirJugueta(String nom, Marca marca, String descripcio, String tipusJugueta, RangoEdad rangEdat, double preu, int quantitat) {
        juguetes.add(new JuguetaPreuQuantitat(new Jugueta(nom, marca, descripcio, tipusJugueta, rangEdat), preu, quantitat, juguetes.size() + 1));
    }

    public void afegirJugueta(JuguetaPreuQuantitat jugueta) {
        juguetes.add(jugueta);
    }

    public void llevarJugueta(int idJugueta) {
        if (existeixJugueta(idJugueta)) {
            juguetes.remove(idJugueta - 1);
        }
    }

    private boolean existeixJugueta(int idJugueta) {
        return idJugueta <= juguetes.size();
    }

    public JuguetaPreuQuantitat getJugueta(int idJugueta) {
        if (existeixJugueta(idJugueta)) {
            return juguetes.get(idJugueta - 1);
        }
        return null;
    }


    public ArrayList<JuguetaPreuQuantitat> getJuguetes() {
        return juguetes;
    }

    public ArrayList<JuguetaPreuQuantitat> juguetesPerMarca(String nomMarca) {
        ArrayList<JuguetaPreuQuantitat> temp = new ArrayList<>();
        for (int i = 0; i < juguetes.size(); i++) {
            if (juguetes.get(i).getJugueta().getMarca().getNom().equals(nomMarca)) {
                temp.add(juguetes.get(i));
            }
        }
        return temp;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < juguetes.size() ; i++) {
            sb.append(juguetes.get(i).toString()).append("\n");
        }
        return sb.toString();
    }
}
