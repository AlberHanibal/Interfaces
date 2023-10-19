package com.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Nota {
    
    private String titulo;
    private String categoria;
    private String contenido;
    private LocalDateTime fechaCreacion;

    public Nota(String titulo, String categoria, String contenido) {
        this.titulo = titulo;
        this.categoria = categoria;
        this.contenido = contenido;
        this.fechaCreacion = LocalDateTime.now();
    }

    public Nota(String titulo, String categoria, String contenido, LocalDateTime fechaCreacion) {
        this.titulo = titulo;
        this.categoria = categoria;
        this.contenido = contenido;
        this.fechaCreacion = fechaCreacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getContenido() {
        return contenido;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    //cambiar a privado cuando se pruebe
    public String formatearFecha() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("ddMMyyHHmmss");
        return this.getFechaCreacion().format(formato);
    }

    //cambiar a privado cuando se pruebe, me pone una T
    public LocalDateTime desFormatearFecha(String fechaFormateada) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("ddMMyyHHmmss");
        LocalDateTime fechaSinFormato = LocalDateTime.parse(fechaFormateada, formato);
        System.out.println(fechaSinFormato);
        return fechaSinFormato;
    }

    public void guardarNota(Nota nota) {
        PrintWriter notaCompleta = null;
        File ficheroNota = new File(nota.formatearFecha() + ".txt");
        try {
            notaCompleta = new PrintWriter(ficheroNota);
            notaCompleta.format("título: %s%n" 
            + "categoría: %s%n"
            + "---%n%n"
            + "%s%n", nota.getTitulo(), nota.getCategoria(), nota.getContenido());
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            notaCompleta.close();
        }
    }

    public Nota leerNota(String nombreFichero) {
        try {
            BufferedReader notaCompleta = new BufferedReader(new FileReader(nombreFichero));

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }



        return null;
    }



    @Override
    public String toString() {
        return "Nota [titulo=" + titulo + ", categoria=" + categoria + ", contenido=" + contenido + ", fechaCreacion="
                + formatearFecha() + "]";
    }

    
    
}
