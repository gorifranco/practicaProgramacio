package com.tyu;

import java.time.LocalDate;

public class Compra {
    private Proveidor proveidor;
    private Jugueta jugueta;
    private LocalDate data;
    private int quantitat;
    private double preu;

    public Compra(Proveidor proveidor, Jugueta jugueta, int quantitat, double preu) {
        this.proveidor = proveidor;
        this.jugueta = jugueta;
        this.data = LocalDate.now();
        this.quantitat = quantitat;
        this.preu = preu;
    }

    public Proveidor getProveidor() {
        return proveidor;
    }

    public LocalDate getData() {
        return data;
    }

    public int getQuantitat() {
        return quantitat;
    }

    public Jugueta getJugueta() {
        return jugueta;
    }


    public double getImport() {
        return quantitat * preu;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "proveidor=" + proveidor +
                ", jugueta=" + jugueta +
                ", data=" + data +
                ", quantitat=" + quantitat +
                ", preu=" + preu +
                '}';
    }
}
