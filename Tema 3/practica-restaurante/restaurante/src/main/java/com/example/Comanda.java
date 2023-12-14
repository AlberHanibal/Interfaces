package com.example;

import java.util.ArrayList;

public class Comanda {
    
    private String camarero;
    private String mesa;
    private ArrayList<Comensal> comensales;

    public Comanda() {
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

    public void setCamarero(String camarero) {
        this.camarero = camarero;
    }

    public void setMesa(String mesa) {
        this.mesa = mesa;
    }
}
