package com.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    private String formatearFecha() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("ddMMyyHHmmss");
        return this.getFechaCreacion().format(formato);
    }

    private static LocalDateTime desFormatearFecha(String fechaFormateada) {
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

    public static Nota leerNota(String nombreFichero) {
        try {
            File fichero = new File(nombreFichero);
            BufferedReader notaCompleta = new BufferedReader(new FileReader(fichero));
            String lineaTitulo = notaCompleta.readLine();
            String titulo = lineaTitulo.split("título:")[1];
            String lineaCategoria = notaCompleta.readLine();
            String categoria = lineaCategoria.split("categoría:")[1];
            notaCompleta.readLine();
            notaCompleta.readLine();
            String lineaContenido;
            String contenido = "";
            while ((lineaContenido = notaCompleta.readLine()) != null) {
                contenido += lineaContenido + "\n";
            }
            notaCompleta.close();
            String fechaCreacion = nombreFichero.split(".txt")[0];
            return new Nota(titulo, categoria, contenido, desFormatearFecha(fechaCreacion));            
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String toString() {
        return "Nota [titulo=" + titulo + ", categoria=" + categoria + ", contenido=" + contenido + ", fechaCreacion="
                + formatearFecha() + "]";
    }

}
