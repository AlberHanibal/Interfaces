package com.example;

import java.util.ArrayList;

public class Comanda {
    
    private String camarero;
    private String mesa;
    private ArrayList<Comensal> comensales;

    public Comanda() {
        camarero = "";
        mesa = "";
        comensales = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            comensales.add(new Comensal());
        }
    }

    public String getCamarero() {
        return camarero;
    }

    public String getMesa() {
        return mesa;
    }

    public ArrayList<Comensal> getComensales() {
        return comensales;
    }

    public void setComensales(ArrayList<Comensal> nuevosComensales) {
        comensales = nuevosComensales;
    }

    public void setCamarero(String camarero) {
        this.camarero = camarero;
    }

    public void setMesa(String mesa) {
        this.mesa = mesa;
    }

    @Override
    public String toString() {
        String ticket = "";
        for (int i = 0; i < comensales.size(); i++) {
            if (!comensales.get(i).getPrimerPlato().equals("")) {
                ticket += String.format("- Comensal %d:%n", i + 1) + comensales.get(i);
            }
        }
        return ticket;
    }
}
