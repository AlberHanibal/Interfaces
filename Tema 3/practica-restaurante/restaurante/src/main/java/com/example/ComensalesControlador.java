package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class ComensalesControlador{

    @FXML
    private Button botonSiguiente;

    @FXML
    private Button botonCancelar;

    @FXML
    private Label textoMesa;

    @FXML
    private ListView listaComensales;

    @FXML
    private void clickSiguiente() {
    }

    @FXML
    private void clickCancelar() {
        App.getScene().setRoot(App.cargarEscena("seleccion_mesa.fxml"));
    }

    public void initialize() {
        textoMesa.setText(App.getComanda().getMesa());
        // por aqui
    }
}
