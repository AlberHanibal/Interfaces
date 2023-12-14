package com.example;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ControladorSec {

    private String textoUsuario;

    @FXML
    private Label textoBienvenida;

    public void initialize() { 
        textoUsuario = App.getPrueba().getCositas();
        textoBienvenida.setText("Bienvenido " + textoUsuario);
    }

    @FXML
    private void manejadorVolver() throws IOException {
        App.getScene().setRoot(App.cargarEscena("principal.fxml"));
        
    }
    
}
