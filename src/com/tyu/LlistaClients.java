package com.tyu;

import java.util.ArrayList;

public class LlistaClients {
    private ArrayList<Client> clients;

    public LlistaClients() {
        clients = new ArrayList<>();
    }

    public void afegirClient(String nom) {
        this.clients.add(new Client(nom));
    }

    public void eliminarClient(String nom) {
        if (clientHiEs(nom)) {
            clients.remove(trobarClient(nom));
        }
    }

    public Client getClient(int idClient) {
        if (clientHiEs(idClient)) {
            return clients.get(idClient - 1);
        }
        return null;
    }

    private int trobarClient(String nom) {
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getNom().equals(nom)) {
                return i;
            }
        }
        return -1;
    }

    private boolean clientHiEs(String nom) {
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getNom().equals(nom)) {
                return true;
            }
        }
        return false;
    }

    private boolean clientHiEs(int idClient) {
        return idClient <= clients.size();
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    @Override
    public String toString() {
StringBuilder sb = new StringBuilder();
        for (int i = 0; i < clients.size() ; i++) {
            sb.append(clients.get(i).toString()).append("\n");
        }
        return sb.toString();
    }
}
