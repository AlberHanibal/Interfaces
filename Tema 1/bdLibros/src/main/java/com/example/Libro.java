package com.example;

public class Libro {
    
    private String titulo;
    private String autor;
    private String genero;
    private String etiqutas;

    public Libro(String titulo, String autor, String genero, String etiqutas) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.etiqutas = etiqutas;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getGenero() {
        return genero;
    }

    public String getEtiqutas() {
        return etiqutas;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setEtiqutas(String etiqutas) {
        this.etiqutas = etiqutas;
    }

    @Override
    public String toString() {
        return "Libro [titulo=" + titulo + ", autor=" + autor + ", genero=" + genero + ", etiqutas=" + etiqutas + "]";
    }
    
    
}
