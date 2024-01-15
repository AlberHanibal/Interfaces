package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;

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
    private ToggleGroup primerPlato;

    @FXML
    private ToggleGroup bebida;

    @FXML
    private CheckBox checkDescuento;

    @FXML
    private CheckBox checkTarjeta;

    @FXML
    private TextArea cajaComentarios;

    @FXML
    private void clickSiguiente() {
        RadioButton opcionPlato = (RadioButton) primerPlato.getSelectedToggle();
        RadioButton opcionBebida = (RadioButton) bebida.getSelectedToggle();        
        if (opcionPlato != null && opcionBebida != null) {
            Comensal comensal = new Comensal(opcionPlato.getText(), opcionBebida.getText(), 
            cajaComentarios.getText(), checkDescuento.isSelected(), checkTarjeta.isSelected());
            App.getComanda().getComensales().set(App.getComensalActual() - 1, comensal);
            App.getScene().setRoot(App.cargarEscena("resumen.fxml"));
        }
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
