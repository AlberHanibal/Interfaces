package com.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

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

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    private String formatearFecha() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("ddMMyyHHmmss");
        return this.getFechaCreacion().format(formato);
    }

    private static LocalDateTime desFormatearFecha(String fechaFormateada) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("ddMMyyHHmmss");
        LocalDateTime fechaSinFormato = LocalDateTime.parse(fechaFormateada, formato);
        return fechaSinFormato;
    }

    public static void guardarNota(Nota nota) {
        PrintWriter notaCompleta = null;
        File carpeta = new File("Notas");
        if (!carpeta.exists()) {
            carpeta.mkdir();
        }
        File ficheroNota = new File("Notas/" + nota.formatearFecha() + ".txt");
        try {
            notaCompleta = new PrintWriter(ficheroNota);
            notaCompleta.format("titulo: %s%n" 
            + "categoria: %s%n"
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
            File fichero = new File("Notas/" + nombreFichero);
            BufferedReader notaCompleta = new BufferedReader(new FileReader(fichero));
            String lineaTitulo = notaCompleta.readLine();
            String titulo = lineaTitulo.split("titulo:")[1];
            String lineaCategoria = notaCompleta.readLine();
            String categoria = lineaCategoria.split("categoria:")[1];
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

    public static ArrayList <Nota> crearListaFicheros() {
        File carpeta = new File("Notas");
        String [] nombreFicheros = carpeta.list();
        if ((nombreFicheros == null) || nombreFicheros.length == 0) {
            System.err.println("No existe la carpeta Notas o no hay notas");
            return null;
        } else {
            ArrayList <Nota> lista = new ArrayList<>();
            for (String nombre : nombreFicheros) {
                lista.add(leerNota(nombre));
            }
            return lista;
        }
    }

    // pasarle la nota o los parámetros (?)
    public void modificarNota(Nota nuevaNota) {
        this.setTitulo(nuevaNota.getTitulo());
        this.setCategoria(nuevaNota.getCategoria());
        this.setContenido(nuevaNota.getContenido());
    }

	public String volcarNotaAString() {
        return String.format("titulo: %s%ncategoria: %s%n---%n%n%s", this.getTitulo(), this.getCategoria(), this.getContenido());
    }
    @Override
    public String toString() {
        return "Nota [titulo=" + titulo + ", categoria=" + categoria + ", contenido=" + contenido + ", fechaCreacion="
                + formatearFecha() + "]";
    }

}
