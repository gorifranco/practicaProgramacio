package com.tyu;

import java.time.LocalDate;

public class Compra {
    private Proveidor proveidor;
    private JuguetaPreu jugueta_preu;
    private LocalDate data;
    private int quantitat;

    public Compra(Proveidor proveidor, JuguetaPreu jugueta_preu, LocalDate data, int quantitat) {
        this.proveidor = proveidor;
        this.jugueta_preu = jugueta_preu;
        this.data = data;
        this.quantitat = quantitat;
    }

    public Proveidor getProveidor() {
        return proveidor;
    }

    public void setProveidor(Proveidor proveidor) {
        this.proveidor = proveidor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getQuantitat() {
        return quantitat;
    }

    public void setQuantitat(int quantitat) {
        this.quantitat = quantitat;
    }

    public JuguetaPreu getJugueta_preu() {
        return jugueta_preu;
    }

    public void setJugueta_preu(JuguetaPreu jugueta_preu) {
        this.jugueta_preu = jugueta_preu;
    }

    public double getImport() {
        return quantitat * jugueta_preu.getPreu();
    }
}
