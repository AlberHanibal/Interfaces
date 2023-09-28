package com.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controlador {
    
    public int buscarPalabra(String texto, String palabra) {
        String[] textoSplit = texto.split(" ");
        Pattern patron = Pattern.compile(palabra, Pattern.CASE_INSENSITIVE);
        Matcher matcher = null;
        int numVeces = 0;
        for (String p : textoSplit) {
            matcher = patron.matcher(p);
            if (matcher.find()) {
                numVeces++;
            }
        }
        return numVeces;
    }
}
