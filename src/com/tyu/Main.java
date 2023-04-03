package com.tyu;

public class Main {
    public static void main(String[] args) {
        provesMarca();
        provesCompra();
        provesVenta();
        Client();
        Proveidor();
    }

    private static void provesMarca() {
        System.out.println("\n----------Marques-------------");
        Tenda t1 = new Tenda();
    }

    private static void provesCompra() {
        System.out.println("\n----------Compra-------------");
        Tenda t1 = new Tenda();
        Compra c1 = t1.getCompres().get(0);
        System.out.println("Import de la compra: " + c1.getImport());
        c1.setQuantitat(255);
        System.out.println("Import canviat: " + c1.getImport());
        System.out.println("Preu de la jugueta comprada: " + c1.getJugueta_preu().getPreu());
    }

    private static void provesVenta() {
        System.out.println("\n----------Venta-------------");
        Tenda t1 = new Tenda();
        Venta v1 = t1.getVentes().get(0);
        System.out.println("Import venta 1: " + v1.getImport());
        v1.setQuantitat(25);
        System.out.println("Import canviat: " + v1.getImport());
    }

    private static void Client() {
        System.out.println("\n----------Clients-------------");
        Tenda t1 = new Tenda();
        Client cl1 = t1.getClients().get(0);
        System.out.println("Client 1: " + cl1.getNom());
        Client cl2 = t1.getClients().get(1);
        System.out.println("Client 2: " + cl2.getNom());
        Client cl3 = t1.getClients().get(2);
        System.out.println("Client 3: " + cl3.getNom());
        Client cl4 = t1.getClients().get(3);
        System.out.println("Client 4: " + cl4.getNom());
        Client cl5 = t1.getClients().get(4);
        System.out.println("Client 5: " + cl5.getNom());
    }

    private static void Proveidor() {
        System.out.println("\n----------Proveidors-------------");
        Tenda t1 = new Tenda();
        Proveidor p1 = t1.getProveidors().get(0);
        //System.out.println("Proveidor 1: " + p1.quinProveidorTeLaJugueta());


    }
}
