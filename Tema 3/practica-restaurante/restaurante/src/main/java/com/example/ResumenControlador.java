package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ResumenControlador{

    @FXML
    private Button botonSiguiente;

    @FXML
    private Button botonCancelar;

    @FXML
    private Label textoCamarero;

    @FXML
    private Label textoComanda;

    @FXML
    private void clickSiguiente() {
        
    }

    @FXML
    private void clickCancelar() {
        
    }

    public void initialize() {
        // deshabilitar el boton añadir comensal si ya hay 4
        textoCamarero.setText("Procesado por Camarero: " + App.getComanda().getCamarero());
        textoComanda.setText(App.getComanda().toString());
    }
}
