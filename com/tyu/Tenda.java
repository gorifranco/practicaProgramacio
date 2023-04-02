package com.tyu;

import java.time.LocalDate;
import java.util.ArrayList;

public class Tenda {
    private ArrayList<JuguetaPreu> juguetes;
    private ArrayList<Venta> ventes;
    private ArrayList<Client> clients;
    private ArrayList<Marca> marques;
    private ArrayList<Proveidor> proveidors;
    private ArrayList<Compra> compres;

    public Tenda() {
        inicialitzacio();
    }

    public void afegirJugueta(Jugueta jugueta, double preu) {
        this.juguetes.add(new JuguetaPreu(jugueta, preu));
    }

    public void afegirCompra(Compra compra) {
        this.compres.add(compra);
    }

    public void novaVenta(Venta venta) {
        this.ventes.add(venta);
    }

    public void afegirClient(Client client) {
        this.clients.add(client);
    }

    public void afegirProveidor(Proveidor proveidor) {
        this.proveidors.add(proveidor);
    }

    public void afegirMarca(Marca marca) {
        this.marques.add(marca);
    }

    public ArrayList<JuguetaPreu> getJuguetes() {
        return juguetes;
    }

    public ArrayList<Venta> getVentes() {
        return ventes;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public ArrayList<Marca> getMarques() {
        return marques;
    }

    public ArrayList<Proveidor> getProveidors() {
        return proveidors;
    }

    public ArrayList<Compra> getCompres() {
        return compres;
    }

    public void eliminarJugueta(Jugueta jugueta) {
        for (int i = 0; i < juguetes.size(); i++) {
            if (juguetes.get(i).getJugueta().equals(jugueta)) {
                juguetes.remove(i);
                break;
            }
        }
    }

    public void eliminarClient(Client client) {
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).equals(client)) {
                clients.remove(i);
                break;
            }
        }
    }

    public void eliminarProveidor(Proveidor proveidor) {
        for (int i = 0; i < proveidors.size(); i++) {
            if (proveidors.get(i).equals(proveidor)) {
                proveidors.remove(i);
                break;
            }
        }
    }


    public ArrayList<Venta> ventesClientData(Client client, LocalDate data) {
        ArrayList<Venta> resultat = new ArrayList<>();
        for (int i = 0; i < ventes.size(); i++) {
            if (ventes.get(i).getClient().equals(client) && ventes.get(i).getData().isBefore(data)) {
                resultat.add(ventes.get(i));
            }
        }
        return resultat;
    }

    public double facturacioClient(Client client) {
        double resultat = 0;
        for (int i = 0; i < ventes.size(); i++) {
            if (ventes.get(i).getClient().equals(client) && ventes.get(i).getData().getMonth().equals(LocalDate.now().getMonth()) &&
                    ventes.get(i).getData().getYear() == LocalDate.now().getYear()) {
                resultat += ventes.get(i).getImport();
            }
        }
        return resultat;
    }

    public int compresJuguetaData(Jugueta jugueta, LocalDate data) {
        int numeroVentes = 0;
        for (int i = 0; i < ventes.size(); i++) {
            if (ventes.get(i).getJugueta().getJugueta().equals(jugueta) && ventes.get(i).getData().isBefore(data)) {
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

    public ArrayList<JuguetaPreu> quinProveidorTeLaJugueta(Jugueta jugueta) {
        ArrayList<JuguetaPreu> temp = new ArrayList<>();
        for (int i = 0; i < proveidors.size(); i++) {
            if (proveidors.get(i).teJugueta(jugueta)) {
                temp.add(proveidors.get(i).getJugueta(jugueta));
            }
        }
        return temp;
    }

    public ArrayList<Jugueta> juguetaPerMarca(Marca marca) {
        ArrayList<Jugueta> temp = new ArrayList<>();
        for (int i = 0; i < juguetes.size(); i++) {
            if (juguetes.get(i).getJugueta().getMarca().equals(marca)) {
                temp.add(juguetes.get(i).getJugueta());
            }
        }
        return temp;
    }

    private void inicialitzacio() {

        this.juguetes = new ArrayList<>();
        this.ventes = new ArrayList<>();
        this.clients = new ArrayList<>();
        this.marques = new ArrayList<>();
        this.proveidors = new ArrayList<>();
        this.compres = new ArrayList<>();

        afegirMarca(new Marca("marca1", "123456789", "dir", "mail"));
        afegirMarca(new Marca("marca2", "123456789", "dir", "mail"));

        afegirJugueta(new Jugueta("jugueta1", marques.get(0), "desc", "tipo1", RangoEdad.CERO_A_TRES), 2.15);
        afegirJugueta(new Jugueta("jugueta2", marques.get(1), "desc", "tipo1", RangoEdad.QUATRE_A_VUIT), 5.15);

        afegirProveidor(new Proveidor("proveidor1", "123456789", "p1@gmail.com", "dir1"));
        afegirProveidor(new Proveidor("proveidor2", "123456789", "p2@gmail.com", "dir2"));

        afegirClient(new Client("client1"));
        afegirClient(new Client("client2"));

        afegirCompra(new Compra(proveidors.get(0), juguetes.get(0), LocalDate.now(), 50));
        novaVenta(new Venta(juguetes.get(1), clients.get(0), 5, 0, LocalDate.now()));

    }
}

