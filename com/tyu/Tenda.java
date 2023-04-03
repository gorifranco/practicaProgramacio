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

        afegirMarca(new Marca("Lego", "123456789", "Callejón de la Rosa", "lego@gmail.com"));
        afegirMarca(new Marca("Hot Wheels", "123456789", "Calle de la Brisa", "wheels@gmail.com"));
        afegirMarca(new Marca("BayBlade", "98715671", "Avenida del Sol", "blade@gmail.com"));;
        afegirMarca(new Marca("Nerf", "4891935", "Avenida del Sol", "nerf@gmail.com"));;
        afegirMarca(new Marca("HashBro", "22891041", "Callejón del Arco", "hash@gmail.com"));;
        afegirMarca(new Marca("Mattel", "5684658910", "Calle de la Perla.", "mattel@gmail.com"));


        afegirJugueta(new Jugueta("Set de Star Wars Lego", marques.get(0), "Set de Star Wars", "Lego", RangoEdad.QUATRE_A_VUIT), 12.15);
        afegirJugueta(new Jugueta("R34 Skyline", marques.get(1), "R34", "Cotxo", RangoEdad.QUATRE_A_VUIT), 5.15);
        afegirJugueta(new Jugueta("Supreme Spinner", marques.get(2), "Spinner", "Spinner", RangoEdad.NOU_A_DOTZE), 6.65);
        afegirJugueta(new Jugueta("Pistola Nerf", marques.get(3), "Pistola", "Pistola", RangoEdad.TRETZE_A_DEVUIT), 7.85);
        afegirJugueta(new Jugueta("Twister", marques.get(4), "Twistter", "Joc de taula", RangoEdad.TRETZE_A_DEVUIT), 9.99);

        afegirProveidor(new Proveidor("Bandai America", "123456789", "p1@gmail.com", "Callejón de la Rosa"));
        afegirProveidor(new Proveidor("VTech", "123456789", "p2@gmail.com", "Calle de la Brisa"));
        afegirProveidor(new Proveidor("Goliath Games", "98715671", "p3@gmail.com", "Avenida del Sol"));
        afegirProveidor(new Proveidor("Bord Games", "56715671", "p4@gmail.com", "Calle de los Álamos"));
        

        afegirClient(new Client("Julia"));
        afegirClient(new Client("Juana"));
        afegirClient(new Client("Astolfo"));
        afegirClient(new Client("Jose Alberto"));
        afegirClient(new Client("Dionisio Salvador"));

        afegirCompra(new Compra(proveidors.get(0), juguetes.get(0), LocalDate.now(), 50));
        novaVenta(new Venta(juguetes.get(1), clients.get(0), 5, 0, LocalDate.now()));
        //quinProveidorTeLaJugueta(new Jugueta("Marca 1", marques.get(0), "Set de Star Wars", "", RangoEdad.QUATRE_A_VUIT));
    }
}

