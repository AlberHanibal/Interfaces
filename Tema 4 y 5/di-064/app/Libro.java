package app;

import java.util.Vector;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class Libro {

    public String titulo;
    public String autor;
    public String[] etiquetas;
    public String genero;


    public Libro(String titulo, String autor, String genero){
        this.titulo=titulo;
        this.autor=autor;
        this.genero=genero;
    }   

    public String getTitulo(){
        return this.titulo;
    }

    public String getAutor(){
        return this.autor;
    }

    public String getGenero(){
        return this.genero;
    }

    public Vector<String> getFields(){
        Vector<String> l = new Vector<String>();
        l.add(this.titulo);
        l.add(this.autor);
        l.add(this.genero);
        return l;
    }

    public void setEtiquetas(String tags){
        this.etiquetas=tags.split(",");
    }


    public String toString(){
        return this.titulo+":"+this.autor+":"+this.genero+":"+String.join(", ",this.etiquetas)+"\n";
    }


    public void guarda() throws IOException{
        Path filename = Path.of("datos.txt");
        File file = new File(filename.toString());
        file.createNewFile();
        Files.writeString(filename, this.toString(), StandardOpenOption.APPEND);
    }


    public static ArrayList<Libro> getAll(){
        ArrayList<Libro> biblioteca =new ArrayList<Libro>();
        try {
            Path filename = Path.of("datos.txt");
            List<String> lineas = Files.readAllLines(filename);
            for (String linea : lineas) {
                String[] parts = linea.split(":");
                Libro nuevo = new Libro(parts[0], parts[1], parts[2]);
                biblioteca.add(nuevo);
            }
        } catch (Exception e) {}
        return biblioteca;
    }
}
