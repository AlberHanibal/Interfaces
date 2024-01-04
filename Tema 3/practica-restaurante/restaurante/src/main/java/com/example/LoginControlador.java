package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginControlador{

    @FXML
    private TextField cajaLogin;

    @FXML
    private Button botonSiguiente;

    @FXML
    private void clickSiguiente() {
        if (!cajaLogin.getText().equals("")) {
            App.getComanda().setCamarero(cajaLogin.getText());
            // cambiar de pantalla
            App.getScene().setRoot(App.cargarEscena("seleccion_mesa.fxml"));
        } else {
            // sacar error
        }
    }
}
