package com.tyu;

import java.time.LocalDate;

public class Venta {
    private int idVenta;
    private JuguetaPreuQuantitat jugueta;
    private Client client;
    private int quantitat;
    private double descompte;
    private LocalDate data;

    public Venta(int idVenta, JuguetaPreuQuantitat jugueta, Client client, int quantitat, double descompte) {
        this.idVenta = idVenta;
        this.jugueta = jugueta;
        this.client = client;
        this.quantitat = quantitat;
        this.descompte = descompte;
        this.data = LocalDate.now();
    }

    public JuguetaPreuQuantitat getJugueta() {
        return jugueta;
    }


    public Client getClient() {
        return client;
    }

    public int getQuantitat() {
        return quantitat;
    }

    public void setQuantitat(int quantitat) {
        this.quantitat = quantitat;
    }

    public LocalDate getData() {
        return data;
    }


    public double getDescompte() {
        return descompte;
    }

    public double getImport() {
        return quantitat * jugueta.getPreu() * (1 - descompte);
    }
}
