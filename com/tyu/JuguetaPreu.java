package com.tyu;

public class JuguetaPreu {
    private Jugueta jugueta;
    private double preu;

    public JuguetaPreu(Jugueta jugueta, double preu) {
        this.jugueta = jugueta;
        this.preu = preu;
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
}
