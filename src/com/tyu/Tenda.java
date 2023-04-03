package com.tyu;

import java.time.Month;
import java.time.Year;
import java.util.ArrayList;

public class Tenda {
    private LlistaJuguetes cataleg;
    private LlistaVentes ventes;
    private LlistaClients clients;
    private LlistaMarques marques;
    private LlistaProveidors proveidors;
    private LlistaCompres compres;

    public Tenda() {
        inicialitzacio();
    }


    private void inicialitzacio() {

        this.cataleg = new LlistaJuguetes();
        this.ventes = new LlistaVentes();
        this.clients = new LlistaClients();
        this.marques = new LlistaMarques();
        this.proveidors = new LlistaProveidors();
        this.compres = new LlistaCompres();

        proveidors.afegirProveidor("Bandai America", "123456789", "p1@gmail.com", "Callejón de la Rosa");
        proveidors.afegirProveidor("VTech", "123456789", "p2@gmail.com", "Calle de la Brisa");
        proveidors.afegirProveidor("Goliath Games", "98715671", "p3@gmail.com", "Avenida del Sol");
        proveidors.afegirProveidor("Bord Games", "56715671", "p4@gmail.com", "Calle de los Álamos");

        marques.afegirMarca("Lego", "123456789", "Callejón de la Rosa", "lego@gmail.com");
        marques.afegirMarca("Hot Wheels", "123456789", "Calle de la Brisa", "wheels@gmail.com");
        marques.afegirMarca("BayBlade", "98715671", "Avenida del Sol", "blade@gmail.com");
        marques.afegirMarca("Nerf", "4891935", "Avenida del Sol", "nerf@gmail.com");
        marques.afegirMarca("HashBro", "22891041", "Callejón del Arco", "hash@gmail.com");
        marques.afegirMarca("Mattel", "5684658910", "Calle de la Perla.", "mattel@gmail.com");


        cataleg.afegirJugueta(compres.comprarNovaJugueta(proveidors.getProveidor("VTech"), "R34 Skyline",
                marques.getMarca("Lego"), "R34", "Cotxo", RangoEdad.NOU_A_DOTZE,
                1.02, 500, 45));
        cataleg.afegirJugueta(compres.comprarNovaJugueta(proveidors.getProveidor("Goliath Games"), "Supreme Spinner",
                marques.getMarca("Hot Wheels"), "Spinner", "Spinner", RangoEdad.QUATRE_A_VUIT,
                5.15, 300, 99.99));
        cataleg.afegirJugueta(compres.comprarNovaJugueta(proveidors.getProveidor("Goliath Games"), "Supreme Spinner",
                marques.getMarca("Nerf"), "Pistola", "Pistola", RangoEdad.QUATRE_A_VUIT,
                5.00, 150, 32.15));
        cataleg.afegirJugueta(compres.comprarNovaJugueta(proveidors.getProveidor("Bord Games"), "Twister",
                marques.getMarca("HashBro"), "Twistter", "Joc de taula", RangoEdad.TRETZE_A_DEVUIT,
                9.99, 350, 67.12));

        clients.afegirClient("Pepito");
        clients.afegirClient("Julia");
        clients.afegirClient("Juana");
        clients.afegirClient("Astolfo");
        clients.afegirClient("Jose Alberto");
        clients.afegirClient("Dionisio Salvador");

        ventes.novaVenta(cataleg.getJugueta(1), clients.getClient(1), 25, 0);
        ventes.novaVenta(cataleg.getJugueta(2), clients.getClient(1), 10, 0);
        ventes.novaVenta(cataleg.getJugueta(1), clients.getClient(2), 50, 0.15);

    }

    public void afegirClient(String nom) {
        this.clients.afegirClient(nom);
    }

    public void eliminarClient(String nom) {
        this.clients.eliminarClient(nom);
    }

    public void afegirProveidor(String nom, String telefon, String eMail, String direccio) {
        proveidors.afegirProveidor(nom, telefon, eMail, direccio);
    }

    public void eliminarProveidor(String nomProveidor) {
        proveidors.eliminarProveidor(nomProveidor);
    }

    public void afegirMarca(String nom, String telefon, String direccio, String email) {
        marques.afegirMarca(nom, telefon, direccio, email);
    }

    public void eliminarMarca(String nomMarca) {
        marques.eliminarMarca(nomMarca);
    }

    public void comprarJuguetaExistent(String nomProveidor, int idJugueta, int quantitat, double preuCompra) {
        compres.comprarJuguetaExistent(proveidors.getProveidor(nomProveidor), cataleg.getJugueta(idJugueta), quantitat, preuCompra);
    }

    public void comprarNovaJugueta(String nomProveidor, String nomJugueta, String marcaJugueta, String descripcioJugueta,
                                   String tipusJugueta, RangoEdad rangoEdad, double preuCompra, int quantitat, double preuVenta) {
        cataleg.afegirJugueta(compres.comprarNovaJugueta(proveidors.getProveidor(nomProveidor), nomJugueta, marques.getMarca(marcaJugueta), descripcioJugueta, tipusJugueta, rangoEdad, preuCompra, quantitat, preuVenta));
    }

    public void vendreJugueta(int idJugueta, int idClient, int quantitat, double descompte) {
        ventes.novaVenta(cataleg.getJugueta(idJugueta), clients.getClient(idClient), quantitat, descompte);
    }
    public void afegirJugueta(String nom, Marca marca, String descripcio, String tipusJugueta, RangoEdad rangEdat, double preu, int quantitat) {
        cataleg.afegirJugueta(nom,marca,descripcio,tipusJugueta,rangEdat,preu,quantitat);
    }
    public void llevarJugueta(int idJugueta) {
cataleg.llevarJugueta(idJugueta);
    }


    //Getters llistes

    public LlistaJuguetes getCataleg() {
        return cataleg;
    }

    public LlistaVentes getVentes() {
        return ventes;
    }

    public LlistaClients getClients() {
        return clients;
    }

    public LlistaMarques getMarques() {
        return marques;
    }

    public LlistaProveidors getProveidors() {
        return proveidors;
    }

    public LlistaCompres getCompres() {
        return compres;
    }


    // Mètodes llistaVentes

    public double facturacioClient(int idClient) {
        return ventes.facturacioClient(clients.getClient(idClient));
    }

    public double facturacioJuguetaMesAnterior(int idJugueta) {
        return ventes.facturacioJuguetaMesAnterior(cataleg.getJugueta(idJugueta).getJugueta());
    }

    public ArrayList<Venta>  ventesJuguetaData(int idJugueta, int any) {
        return ventes.ventesJuguetaData(cataleg.getJugueta(idJugueta).getJugueta(), any);
    }

    public ArrayList<Venta>  ventesJuguetaData(int idJugueta, int any, int mes) {
        return ventes.ventesJuguetaData(cataleg.getJugueta(idJugueta).getJugueta(), any, mes);
    }

    public ArrayList<Venta>  ventesJuguetaData(int idJugueta, int any, int mes, int dia) {
        return ventes.ventesJuguetaData(cataleg.getJugueta(idJugueta).getJugueta(), any, mes, dia);
    }
    public ArrayList<Venta> ventesClientData(int idClient, int year) {
return ventes.ventesClientData(clients.getClient(idClient), year);
    }
    public ArrayList<Venta> ventesClientData(int idClient, int year, int mes) {
        return ventes.ventesClientData(clients.getClient(idClient), year, mes);
    }
    public ArrayList<Venta> ventesClientData(int idClient, int year, int mes, int dia) {
        return ventes.ventesClientData(clients.getClient(idClient), year, mes, dia);
    }
    public ArrayList<String> quinProveidorTeLaJugueta(String nomJugueta) {
return proveidors.quinProveidorTeLaJugueta(nomJugueta);
    }
    public ArrayList<JuguetaPreuQuantitat> juguetesPerMarca(String nomMarca) {
return  cataleg.juguetesPerMarca(nomMarca);
    }
}