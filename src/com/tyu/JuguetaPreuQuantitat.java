package com.tyu;

public class JuguetaPreuQuantitat {
    private Jugueta jugueta;
    private double preu;
    private int stock;
    private int idJugueta;

    public JuguetaPreuQuantitat(Jugueta jugueta, double preu, int stock, int idJugueta) {
        this.jugueta = jugueta;
        this.preu = preu;
        this.stock = stock;
        this.idJugueta = idJugueta;
    }

    public JuguetaPreuQuantitat(Jugueta jugueta, double preu, int stock) {
        this.jugueta = jugueta;
        this.preu = preu;
        this.stock = stock;
    }

    public Jugueta getJugueta() {
        return jugueta;
    }

    public void setJugueta(Jugueta jugueta) {
        this.jugueta = jugueta;
    }

    public double getPreu() {
        return preu;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void afegirExistencies(int quantitat) {
        stock += quantitat;
    }

    public void llevarExistencies(int quantitat) {
        if (bastenExistencies(quantitat)) {
            stock -= quantitat;
        }
    }

    public boolean bastenExistencies(int quantitat) {
        return quantitat <= stock;
    }

    @Override
    public String toString() {
        return "JuguetaPreuQuantitat{" +
                "jugueta=" + jugueta +
                ", preu=" + preu +
                ", stock=" + stock +
                ", idJugueta=" + idJugueta +
                '}';
    }
}
