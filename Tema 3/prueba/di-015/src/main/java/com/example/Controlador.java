package com.example;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controlador{

    @FXML
    private TextField cajaTexto;

    public void initialize() {
        String texto = App.getPrueba().getCositas();
        if (!texto.equals("")) {
            cajaTexto.setText(texto);
        }
    }
    
    @FXML
    private void manejadorEvento() throws IOException {
        App.getPrueba().setCositas(cajaTexto.getText());
        App.getScene().setRoot(App.cargarEscena("secundaria.fxml"));
        
    }
}
