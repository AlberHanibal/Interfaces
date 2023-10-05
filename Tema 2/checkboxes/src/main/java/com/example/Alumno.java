package com.example;

public class Alumno {

    private String nombre;
    private int nota;
    private boolean seleccionado;

    public Alumno(String nombre, int nota) {
        this.nombre = nombre;
        this.seleccionado = false;
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNota() {
        return this.nota;
    }

    public boolean getSeleccionado() {
        return this.seleccionado;
    }

    public void setSeleccionado(boolean s) {
        seleccionado = s;
    }

    public String toString() {
        if (seleccionado) {
            return nombre + " !!";
        } else {
            return nombre;
        }
    }
}
