package com.example;

import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class ComensalesControlador {

    @FXML
    private Button botonSiguiente;

    @FXML
    private Button botonCancelar;

    @FXML
    private Label textoMesa;

    @FXML
    private ListView<String> listaComensales;

    @FXML
    private void clickSiguiente() {
        String comensal = listaComensales.getSelectionModel().getSelectedItem().toString();
        if (!comensal.equals("")) {
            int comensalActual = Integer.parseInt(comensal.split(" ")[1]);
            App.setComensalActual(comensalActual);
            App.getScene().setRoot(App.cargarEscena("comanda.fxml"));
        }
    }

    @FXML
    private void clickCancelar() {
        reiniciarComensales();
        App.getScene().setRoot(App.cargarEscena("seleccion_mesa.fxml"));
    }

    public void initialize() {
        textoMesa.setText(App.getComanda().getMesa());
        List<Comensal> comensales = App.getComanda().getComensales();
        for (int i = 0; i < comensales.size(); i++) {
            // si le hemos tomado nota ya no sale
            if (comensales.get(i).getPrimerPlato().equals("")) {
                listaComensales.getItems().add(String.format("Comensal %d", i + 1));
            }
        }
    }

    private void reiniciarComensales() {
        ArrayList<Comensal> nuevosComensales = new ArrayList<Comensal>();
        for (int i = 0; i < 4; i++) {
            nuevosComensales.add(new Comensal());
        }
        App.getComanda().setComensales(nuevosComensales);
    }
}
