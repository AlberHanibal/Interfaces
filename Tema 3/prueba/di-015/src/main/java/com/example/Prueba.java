package com.example;

public class Prueba {
    
    private int annos;
    private String cositas;

    public Prueba() {
        annos = 0;
        cositas = "";
    }

    public int getAnnos() {
        return annos;
    }

    public void setAnnos(int annos) {
        this.annos = annos;
    }

    public String getCositas() {
        return cositas;
    }

    public void setCositas(String cositas) {
        this.cositas = cositas;
    }

    @Override
    public String toString() {
        return "Prueba [annos=" + annos + ", cositas=" + cositas + "]";
    }

}
