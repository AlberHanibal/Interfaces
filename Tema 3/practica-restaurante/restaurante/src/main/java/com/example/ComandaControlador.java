package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ComandaControlador{

    @FXML
    private Button botonSiguiente;

    @FXML
    private Button botonCancelar;

    @FXML
    private Label textoMesa;

    @FXML
    private Label textoComensal;

    @FXML
    private void clickSiguiente() {
        
    }

    @FXML
    private void clickCancelar() {
        App.getScene().setRoot(App.cargarEscena("comensales.fxml"));
    }

    public void initialize() {
        textoMesa.setText(App.getComanda().getMesa());
        textoComensal.setText("Comensal: " + App.getComensalActual());
    }
}
