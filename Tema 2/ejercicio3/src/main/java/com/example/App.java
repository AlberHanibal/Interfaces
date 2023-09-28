package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;


public class App extends Application {

    private Controlador c;

    @Override
    public void start(Stage primera) throws Exception {

        c = new Controlador();
        BorderPane borderPane = new BorderPane();
        HBox top = new HBox();
        TextField palabra = new TextField();
        TextArea texto = new TextArea();
        Button botonBuscar = new Button("Buscar");
        Label textoInformativo = new Label("Pon un texto y una palabra para buscarla.");
        Label numVecesTexto = new Label();

        EventHandler<ActionEvent> manejador = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                if ((texto.getText().isEmpty()) && (palabra.getText().isEmpty())) {
                    numVecesTexto.setText("Añade un texto y una palabra a buscar.");
                } else {
                    int numVeces = c.buscarPalabra(texto.getText(), palabra.getText());
                    numVecesTexto.setText(String.format("La palabra \"%s\" sale %d veces.%n", palabra.getText(), numVeces));
                }
            }
        };
        botonBuscar.setOnAction(manejador);

        top.getChildren().add(palabra);
        top.getChildren().add(botonBuscar);
        top.getChildren().add(textoInformativo);
        borderPane.setTop(top);

        borderPane.setCenter(texto);
        borderPane.setBottom(numVecesTexto);
        Scene scene = new Scene(borderPane, 500, 300);

        primera.setScene(scene);
        primera.setTitle("Ejercicio 3, Tema 2");
        primera.show();
    }


    public static void main(String[] args) {
        launch();
    }

}