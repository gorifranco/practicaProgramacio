package com.tyu;

import java.time.LocalDate;

public class Venta {
    private JuguetaPreu jugueta;
    private Client client;
    private int quantitat;
    private double descompte;
    private LocalDate data;

    public Venta(JuguetaPreu jugueta, Client client, int quantitat, double descompte, LocalDate data) {
        this.jugueta = jugueta;
        this.client = client;
        this.quantitat = quantitat;
        this.descompte = descompte;
        this.data = data;
    }

    public JuguetaPreu getJugueta() {
        return jugueta;
    }

    public void setJugueta(JuguetaPreu jugueta) {
        this.jugueta = jugueta;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getDescompte() {
        return descompte;
    }

    public double getImport() {
        return quantitat * jugueta.getPreu();
    }
}
