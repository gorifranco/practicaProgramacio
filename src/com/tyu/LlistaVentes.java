package com.tyu;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;

public class LlistaVentes {
    private ArrayList<Venta> ventes;

    public LlistaVentes() {
        this.ventes = new ArrayList<>();
    }

    public void novaVenta(JuguetaPreuQuantitat jugueta, Client client, int quantitat, double descompte) {
        if (jugueta.bastenExistencies(quantitat) && descompte < 1) {
            ventes.add(new Venta(ventes.size() + 1, jugueta, client, quantitat, descompte));
            jugueta.llevarExistencies(quantitat);

        }
    }

    public Venta getVenta(int idVenta) {
        if(existeixVenta(idVenta)){
            return ventes.get(idVenta - 1);
        }
        return null;
    }
    private boolean existeixVenta(int idVenta){
        return idVenta <= ventes.size();
    }

    public ArrayList<Venta> ventesClientData(Client client, Year year) {
        ArrayList<Venta> temp = new ArrayList<>();
        for (int i = 0; i < ventes.size(); i++) {
            if (ventes.get(i).getClient().equals(client) && ventes.get(i).getData().getYear() == year.getValue()) {
                temp.add(ventes.get(i));
            }
        }
        return temp;
    }

    public int ventesJuguetaData(Jugueta jugueta, Year any) {
        int numeroVentes = 0;
        for (int i = 0; i < ventes.size(); i++) {
            if (ventes.get(i).getJugueta().getJugueta().equals(jugueta) && ventes.get(i).getData().getYear() == any.getValue()) {
                numeroVentes += ventes.get(i).getQuantitat();
            }
        }
        return numeroVentes;
    }
    public int ventesJuguetaData(Jugueta jugueta, Year any, Month mes) {
        int numeroVentes = 0;
        for (int i = 0; i < ventes.size(); i++) {
            if (ventes.get(i).getJugueta().getJugueta().equals(jugueta) && ventes.get(i).getData().getYear() == any.getValue() && ventes.get(i).getData().getMonth().equals(mes)) {
                numeroVentes += ventes.get(i).getQuantitat();
            }
        }
        return numeroVentes;
    }
    public int ventesJuguetaData(Jugueta jugueta, Year any, Month mes, int dia) {
        int numeroVentes = 0;
        for (int i = 0; i < ventes.size(); i++) {
            if (ventes.get(i).getJugueta().getJugueta().equals(jugueta) && ventes.get(i).getData().getYear() == any.getValue() && ventes.get(i).getData().getMonth().equals(mes)
            && ventes.get(i).getData().getDayOfMonth() == dia) {
                numeroVentes += ventes.get(i).getQuantitat();
            }
        }
        return numeroVentes;
    }


    public double facturacioJuguetaMesAnterior(Jugueta jugueta) {

        double resultat = 0;
        int mesAnterior;
        if (LocalDate.now().getMonth().getValue() == 1) {
            mesAnterior = 12;
        } else {
            mesAnterior = LocalDate.now().getMonth().getValue() - 1;
        }

        for (int i = 0; i < ventes.size(); i++) {
            resultat = 0;
            if (ventes.get(i).getData().getMonth().getValue() == mesAnterior && ventes.get(i).getJugueta().getJugueta().equals(jugueta)) {
                resultat += ventes.get(i).getImport();
            }
        }
        return resultat;
    }

    public double facturacioClient(Client client) {
        if(client != null) {
            double resultat = 0;
            for (int i = 0; i < ventes.size(); i++) {
                if (ventes.get(i).getClient().equals(client) && ventes.get(i).getData().getMonth().equals(LocalDate.now().getMonth()) &&
                        ventes.get(i).getData().getYear() == LocalDate.now().getYear()) {
                    resultat += ventes.get(i).getImport();
                }
            }
            return resultat;
        }
        return -1;
    }
}
