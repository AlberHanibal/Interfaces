package com.example;


public class Asignatura {
    
    private Bloque[] bloques;
    private double notaFinal;

    public Asignatura(Bloque[] bloques) {
        this.bloques = bloques;
    }

    public Bloque[] getBloques() {
        return bloques;
    }

    public void setBloques(Bloque[] bloques) {
        this.bloques = bloques;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public void calculoNotaFinal() {
        // recorrer los bloques y sumar su nota final
    }

    @Override
    public String toString() {

        return "";
    }
    
}
