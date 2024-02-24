package app;

import java.util.ArrayList;

public class Controlador {
    
    public static Libro buscaLibro(ArrayList<Libro> biblioteca,String titulo){
        for(Libro l:biblioteca){
            if (l.titulo.equals(titulo)){
                return l;
            }
        }
        return null;
    }

    public static Libro creaLibro(String titulo,String autor,String genero,String etiquetas) {

        // guardo info en un fichero de texto
        Libro nuevo = new Libro(titulo, autor, genero);
        nuevo.setEtiquetas(etiquetas);
        try {
            nuevo.guarda();
            return nuevo;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

}
