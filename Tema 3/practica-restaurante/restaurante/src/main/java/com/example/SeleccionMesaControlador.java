package com.example;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class SeleccionMesaControlador {

    @FXML
    private void clickSiguiente() {
        if (!App.getComanda().getMesa().equals("")) {
            App.getScene().setRoot(App.cargarEscena("comensales.fxml"));
        }
    }

    @FXML
    private void seleccionarMesa(Event e) {
        Button boton = (Button) e.getSource();
        App.getComanda().setMesa(boton.getParent().getId() + ": " + boton.getText());
    }
}
