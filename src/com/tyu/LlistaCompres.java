package com.tyu;

import java.time.LocalDate;
import java.util.ArrayList;

public class LlistaCompres {
    private ArrayList<Compra> compres;

    public LlistaCompres() {
        this.compres = new ArrayList<>();
    }

    public void comprarJuguetaExistent(Proveidor proveidor, JuguetaPreuQuantitat jugueta, int quantitat, double preuCompra) {
        compres.add(new Compra(proveidor, jugueta.getJugueta(), quantitat, preuCompra));
        jugueta.afegirExistencies(quantitat);
    }

    public JuguetaPreuQuantitat comprarNovaJugueta(Proveidor proveidor, String nomJugueta, Marca marcaJugueta, String descripcioJugueta,
                                                   String tipusJugueta, RangoEdad rangoEdad, double preuCompra, int quantitat, double preuVenta) {

        Jugueta jugueta = new Jugueta(nomJugueta, marcaJugueta, descripcioJugueta, tipusJugueta, rangoEdad);
        compres.add(new Compra(proveidor, jugueta, quantitat, preuCompra));
        return new JuguetaPreuQuantitat(jugueta, preuVenta, quantitat);
    }

    public ArrayList<Compra> getCompres() {
        return compres;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < compres.size() ; i++) {
            sb.append(compres.get(i).toString()).append("\n");
        }
        return sb.toString();
    }
}
