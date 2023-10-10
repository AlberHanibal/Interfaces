package com.example;

public class Bloque {
    
    private String nombre;
    // pesos ya con 0.x
    private double pesoNota;
    private double pesoExamen;
    private double pesoProyecto;
    private double notaFinal = 0;
    private double notaExamen = 0;
    private double notaProyecto = 0;

    public Bloque(String nombre, double pesoNota, double pesoExamen, double pesoProyecto) {
        this.nombre = nombre;
        this.pesoNota = pesoNota;
        this.pesoExamen = pesoExamen;
        this.pesoProyecto = pesoProyecto;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPesoNota() {
        return pesoNota;
    }

    public double getPesoExamen() {
        return pesoExamen;
    }

    public double getPesoProyecto() {
        return pesoProyecto;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public double getNotaExamen() {
        return notaExamen;
    }

    public void setNotaExamen(double notaExamen) {
        this.notaExamen = notaExamen;
        if (this.getNotaProyecto() != 0) {
            this.calculoNotaFinal();
        }
    }

    public double getNotaProyecto() {
        return notaProyecto;
    }

    public void setNotaProyecto(double notaProyecto) {
        this.notaProyecto = notaProyecto;
        if (this.getNotaExamen() != 0) {
            this.calculoNotaFinal();
        }
    }

    // @Override
    // public String toString() {
    //     return String.format("%s: %n"
    //     + "Examen: vale %d%, sacaste un %f.2%n"
    //     + "Proyecto: vale %d%, sacaste un %f.2%n"
    //     + "Final: vale %d%, sacaste un %f.2%n"
    //     , this.getNombre(), this.getPesoExamen() * 100, this.getNotaExamen(),this.getPesoProyecto() * 100, this.getNotaProyecto(), this.getPesoNota(), this.getNotaFinal());
    // }

    private void calculoNotaFinal() {
        if ((this.notaExamen != 0) && (this.notaProyecto != 0)) {
            notaFinal = (this.getNotaExamen() * this.getPesoExamen()) + (this.getNotaProyecto() * this.getPesoProyecto());
        }
    }

    @Override
    public String toString() {
        return "Bloque [nombre=" + nombre + ", pesoNota=" + pesoNota + ", pesoExamen=" + pesoExamen + ", pesoProyecto="
                + pesoProyecto + ", notaFinal=" + notaFinal + ", notaExamen=" + notaExamen + ", notaProyecto="
                + notaProyecto + "]";
    }

}
