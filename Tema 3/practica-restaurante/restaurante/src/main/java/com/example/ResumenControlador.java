package com.example;

import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ResumenControlador {

    @FXML
    private Button botonProcesar;

    @FXML
    private Button botonCancelar;

    @FXML
    private Button botonAñadirComensal;

    @FXML
    private Label textoCamarero;

    @FXML
    private Label textoComanda;

    @FXML
    private void clickProcesar() {
        App.getScene().setRoot(App.cargarEscena("seleccion_mesa.fxml"));
        comandaConCamarero();
    }

    @FXML
    private void clickCancelar() {
        App.getScene().setRoot(App.cargarEscena("seleccion_mesa.fxml"));
        comandaConCamarero();
    }

    @FXML
    private void clickAñadirComensal() {
        App.getScene().setRoot(App.cargarEscena("comensales.fxml"));
    }

    public void initialize() {
        textoCamarero.setText("Procesado por Camarero: " + App.getComanda().getCamarero());
        textoComanda.setText(App.getComanda().toString());
        if (mesaLlena()) {
            botonAñadirComensal.setDisable(true);
        }
    }

    private boolean mesaLlena() {
        ArrayList<Comensal> listaComensales = App.getComanda().getComensales();
        for (Comensal comensal : listaComensales) {
            if (comensal.getPrimerPlato().equals("")) {
                return false;
            }
        }
        return true;
    }

    // crea una nueva comanda con el camarero antiguo
    private void comandaConCamarero() {
        Comanda nuevaComanda = new Comanda();
        nuevaComanda.setCamarero(App.getComanda().getCamarero());
        App.setComanda(nuevaComanda);
    }
}
