package com.example;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javafx.scene.control.TextArea;

public class Controlador {
    
    public void mostrarFichero(File fichero, TextArea contenidoFichero) {
        //File fichero = new File(nombreFichero);
        System.out.println(fichero.getAbsolutePath());
        System.out.println(fichero);
        Scanner sc = null;
        //if (fichero.exists()) {
            try {
                System.out.println("entra");
                sc = new Scanner(fichero);
                String texto = "";
                while(sc.hasNextLine()) {
                    texto = texto + sc.nextLine();
                }
                contenidoFichero.setText(texto);
                
            } catch (IOException ex) {
                System.out.println("Error con el fichero " + ex.getMessage());
            }
        //}
    }
}
