package com.tyu;

import java.time.LocalDate;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        provesMarca();
        provesCompra();
        provesVenta();
        Client();
        Proveidor();
        Cataleg();
    }

    private static void provesMarca() {
        System.out.println("\n----------Marques-------------");
        Tenda t1 = new Tenda();
        System.out.println("Marques inicials: ");
        System.out.println(t1.getMarques().toString());
        System.out.println("Afegim marcaProva: ");
        t1.afegirMarca("marcaProva", "telProva", "dirProva", "mailProva");
        System.out.println(t1.getMarques().toString());
        System.out.println("Eliminam marcaProva: ");
        t1.eliminarMarca("marcaProva");
        System.out.println(t1.getMarques().toString());

    }

    private static void provesCompra() {
        System.out.println("\n----------Compra-------------");
        Tenda t1 = new Tenda();
        System.out.println("Compres inicials: ");
        System.out.println(t1.getCompres().toString());
        System.out.println("Cataleg inicial: ");
        System.out.println(t1.getCataleg().toString());
        t1.comprarJuguetaExistent("VTech", 1, 1000, 0.5);
        t1.comprarNovaJugueta("VTech", "juguetaProva", "HashBro",
                 "descripcioProva", "tipusProva", RangoEdad.NOU_A_DOTZE, 0.1, 1000, 120.1);
        System.out.println("Compres despres: ");
        System.out.println(t1.getCompres().toString());
        System.out.println("Cataleg despres: ");
        System.out.println(t1.getCataleg().toString());
    }

    private static void provesVenta() {
        System.out.println("\n----------Venta-------------");
        Tenda t1 = new Tenda();
        System.out.println("Ventes inicials: ");
        System.out.println(t1.getVentes().toString());
        System.out.println("Catàleg inicial: ");
        System.out.println(t1.getCataleg().toString());
        t1.vendreJugueta(1, 1, 50,0);
        t1.vendreJugueta(2,2,500000,0);
        System.out.println("Ventes finals: ");
        System.out.println(t1.getVentes());
        System.out.println("Catàleg final: ");
        System.out.println(t1.getCataleg().toString());
        System.out.println("Ventes per client i data: ");
        System.out.println(t1.ventesClientData(1,2023));
        System.out.println("Ventes per jugueta i data: ");
        System.out.println(t1.ventesJuguetaData(1,2023));
        System.out.println("Facturació jugueta més anterior: ");
        System.out.println(t1.facturacioJuguetaMesAnterior(1));




    }

    private static void Client() {
        System.out.println("\n----------Clients-------------");
        Tenda t1 = new Tenda();
        System.out.println("Clients inicials: ");
        System.out.println(t1.getClients());
        System.out.println("Afegim client prova: ");
        t1.afegirClient("ClientProva");
        System.out.println(t1.getClients());
        System.out.println("Eliminam client prova: ");
        t1.eliminarClient("ClientProva");
        System.out.println(t1.getClients());
        System.out.println("Facturacio client: ");
        System.out.println(t1.facturacioClient(1));
    }

    private static void Proveidor() {
        System.out.println("\n----------Proveidors-------------");
        Tenda t1 = new Tenda();
        System.out.println("Proveidors inicials: ");
        System.out.println(t1.getProveidors());
        System.out.println("Afegim nou proveidor: ");
        t1.afegirProveidor("provProva", "123456789", "MailProva", "dirProva");
        System.out.println(t1.getProveidors().toString());
        System.out.println("Eliminam proveidor prova: ");
        t1.eliminarProveidor("provProva");
        System.out.println(t1.getProveidors());

    }
    private static void Cataleg(){
        System.out.println("\n----------Cataleg-------------");
        Tenda t1 = new Tenda();
        System.out.println(t1.getCataleg().toString());
        System.out.println("Juguetes per marca: ");
        System.out.println(t1.juguetesPerMarca("Nerf"));
        t1.llevarJugueta(1);
        System.out.println("\nLlevam una jugueta de l'stock: ");
        System.out.println(t1.getCataleg());
    }
}
