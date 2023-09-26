package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;


public class App extends Application {


    @Override
    public void start(Stage primera) throws Exception {

        HBox root = new HBox();
        TextField palabra = new TextField();
        TextArea texto = new TextArea();
        Button botonBuscar = new Button("Buscar");
        Label numVecesTexto = new Label();

        EventHandler<ActionEvent> manejador = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                if ((!texto.getText().isEmpty()) && (!palabra.getText().isEmpty())) {
                    numVecesTexto.setText("Añade un texto y una palabra a buscar");
                } else {
                    int numVeces = texto.getText().co
                }
            }
        };
        botonBuscar.setOnAction(manejador);

        root.getChildren().add(palabra);
        root.getChildren().add(texto);
        root.getChildren().add(botonBuscar);
        root.getChildren().add(numVeces);
        Scene scene = new Scene(root, 500, 300);

        primera.setScene(scene);
        primera.setTitle("Ejercicio 3, Tema 2");
        primera.show();
    }


    public static void main(String[] args) {
        launch();
    }

}