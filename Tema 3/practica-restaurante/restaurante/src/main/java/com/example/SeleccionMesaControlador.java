package com.example;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class SeleccionMesaControlador {
    


    @FXML
    private void clickSiguiente() {

    }

    @FXML
    private void seleccionarMesa(Event e) {
        Button boton = (Button) e.getSource();
        System.out.println(boton.getText());
        System.out.println(boton.getParent().getId());
    }
}
