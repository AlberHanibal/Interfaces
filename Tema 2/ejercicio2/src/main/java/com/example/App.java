package com.example;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primera) throws Exception {

        HBox root = new HBox();
        TextField cajaTexto = new TextField();
        Button boton = new Button("Mayúscula");

        EventHandler<ActionEvent> manejador = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                Button boton = (Button) e.getSource();
                if (boton.getText().equals("Mayúscula")) {
                    cajaTexto.setText(cajaTexto.getText().toUpperCase());
                    boton.setText("Minúscula");
                } else {
                    cajaTexto.setText(cajaTexto.getText().toLowerCase());
                    boton.setText("Mayúscula");
                }
            }
        };
        boton.setOnAction(manejador);

        root.getChildren().add(cajaTexto);
        root.getChildren().add(boton);
        Scene scene = new Scene(root, 500, 150);

        primera.setScene(scene);
        primera.setTitle("Ejercicio 2, Tema 2");
        primera.show();
    }

    public static void main(String[] args) {
        launch();
    }

}