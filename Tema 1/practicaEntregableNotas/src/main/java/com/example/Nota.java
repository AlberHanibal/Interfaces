package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

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

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
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

    // Crea una lista de notas a partir de los ficheros del directorio Notas
    public static ArrayList<Nota> crearListaFicheros() {
        File carpeta = new File("Notas");
        if (!carpeta.exists()) {
            carpeta.mkdir();
        }
        ArrayList<Nota> lista = new ArrayList<>();
        String[] nombreFicheros = carpeta.list();
        if ((nombreFicheros == null) || nombreFicheros.length == 0) {
            return lista;
        } else {
            for (String nombre : nombreFicheros) {
                lista.add(leerNota(nombre));
            }
            return lista;
        }
    }

    public static Nota leerNota(String nombreFichero) {
        try {
            File fichero = new File("Notas/" + nombreFichero);
            Scanner notaCompleta = new Scanner(fichero);
            Nota nota = Nota.leerString(notaCompleta);
            String fechaCreacion = nombreFichero.split(".txt")[0];
            nota.setFechaCreacion(desFormatearFecha(fechaCreacion));
            return nota;
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return null;
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
            notaCompleta.format("titulo:%s%n"
                    + "categoria:%s%n"
                    + "---%n"
                    + "%n%s%n", nota.getTitulo(), nota.getCategoria(), nota.getContenido().trim());
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            notaCompleta.close();
        }
    }

    // se usa tanto para leer un fichero como un string que contenga la nota
    private static Nota leerString(Scanner stringCompleto) {
        String lineaTitulo = stringCompleto.nextLine();
        String titulo = lineaTitulo.split("titulo:")[1];
        String lineaCategoria = stringCompleto.nextLine();
        String categoria = lineaCategoria.split("categoria:")[1];
        stringCompleto.nextLine();
        String lineaContenido;
        String contenido = "";
        while (stringCompleto.hasNextLine()) {
            lineaContenido = stringCompleto.nextLine();
            contenido += lineaContenido + "\n";
        }
        stringCompleto.close();
        return new Nota(titulo, categoria, contenido);
    }

    public void modificarNota(Nota nuevaNota) {
        this.setTitulo(nuevaNota.getTitulo());
        this.setCategoria(nuevaNota.getCategoria());
        this.setContenido(nuevaNota.getContenido());
    }

    public void borrarNota() {
        File notaABorrar = new File("Notas/" + this.formatearFecha() + ".txt");
        notaABorrar.delete();
    }

    public static Nota stringToNota(String stringNota) {
        Scanner notaCompleta = new Scanner(stringNota);
        Nota nota = Nota.leerString(notaCompleta);
        return nota;
    }

    public String volcarNotaAString() {
        return String.format("titulo:%s%ncategoria:%s%n---%n%n%s", this.getTitulo(), this.getCategoria(),
                this.getContenido().trim());
    }

    public static String esqueletoNota() {
        return String.format("titulo:%n"
                + "categoria:%n"
                + "---%n%n");
    }

    public static boolean notaBienFormada(String stringNota) {
        String[] stringLineas = stringNota.split("\\n");
        if (stringLineas.length >= 3) {
            String titulo = stringLineas[0];
            if (!titulo.matches("titulo:.+"))
                return false;
            String categoria = stringLineas[1];
            if (!categoria.matches("categoria:.+"))
                return false;
            String rayas = stringLineas[2];
            if (!rayas.matches("---"))
                return false;
        } else
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Nota [titulo=" + titulo + ", categoria=" + categoria + ", contenido=" + contenido + ", fechaCreacion="
                + formatearFecha() + "]";
    }

}
