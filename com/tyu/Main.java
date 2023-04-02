package com.tyu;

public class Main {
    public static void main(String[] args) {
        provesMarca();
        provesCompra();
        provesVenta();
    }

    private static void provesMarca() {
        System.out.println("\n----------Proves marca-------------");
        Tenda t1 = new Tenda();
        Marca m1 = t1.getMarques().get(0);
        System.out.println(m1.getDireccio());
        System.out.println(m1.getNom());
        m1.setDireccio("dir2");
        System.out.println(m1.getDireccio());
    }

    private static void provesCompra() {
        System.out.println("\n----------Proves compra-------------");
        Tenda t1 = new Tenda();
        Compra c1 = t1.getCompres().get(0);
        System.out.println("Import de la compra: " + c1.getImport());
        c1.setQuantitat(255);
        System.out.println("Import canviat: " + c1.getImport());
        System.out.println("Preu de la jugueta comprada: " + c1.getJugueta_preu().getPreu());
    }

    private static void provesVenta() {
        System.out.println("\n----------Proves venta-------------");
Tenda t1 = new Tenda();
Venta v1 = t1.getVentes().get(0);
        System.out.println("Import venta 1: " + v1.getImport());
        v1.setQuantitat(25);
        System.out.println("Import canviat: " + v1.getImport());
    }

    private static void provesClient(){
        System.out.println("\n----------Proves c lient-------------");
    }

}
