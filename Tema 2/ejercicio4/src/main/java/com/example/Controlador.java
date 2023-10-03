package com.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Controlador {
    
    public String leerFichero(File fichero) {
        String texto = "";
        try {
            texto = Files.readString(Path.of(fichero.getAbsolutePath()));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return texto;
    }

    public void escribirFichero(File fichero, String texto) {
        try {
            fichero.createNewFile();
            Path filepath = Path.of(fichero.getAbsolutePath());
            Files.writeString(filepath, texto, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
