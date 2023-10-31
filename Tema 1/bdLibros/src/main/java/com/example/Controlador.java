package com.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Controlador {
    
    //machaca siempre
    public void guardarFichero(File fichero, Libro libro) {
        try {
            fichero.createNewFile();
            Path filepath = Path.of(fichero.getAbsolutePath());
            Files.writeString(filepath, libro.toString(), StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
