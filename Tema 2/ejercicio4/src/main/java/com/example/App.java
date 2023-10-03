package com.example;

import java.io.File;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class App extends Application {

    private Controlador c;

    @Override
    public void start(Stage primera) throws Exception {

        c = new Controlador();
        BorderPane borderPane = new BorderPane();
        HBox top = new HBox();
        Button abrirFichero = new Button("Abrir");
        Button guardarFichero = new Button("Guardar");
        TextArea contenidoFichero = new TextArea();
        

        EventHandler<ActionEvent> leerFichero = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                FileChooser fileChooser = new FileChooser();
                    File fichero = fileChooser.showOpenDialog(primera);
                    if (fichero != null) {
                        String datos = c.leerFichero(fichero);
                        contenidoFichero.setText(datos);
                    }
            }
        };
        abrirFichero.setOnAction(leerFichero);

        EventHandler<ActionEvent> escribirFichero = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                FileChooser fileChooser = new FileChooser();
                File fichero = fileChooser.showOpenDialog(primera);
                if (fichero != null) {
                    String datos = contenidoFichero.getText();
                    c.escribirFichero(fichero, datos);
                }
            }
        };
        guardarFichero.setOnAction(escribirFichero);

        top.getChildren().addAll(abrirFichero, guardarFichero);
        borderPane.setTop(top);
        borderPane.setCenter(contenidoFichero);
        Scene scene = new Scene(borderPane, 500, 300);

        primera.setScene(scene);
        primera.setTitle("Notepad--");
        primera.show();
    }

    public static void main(String[] args) {
        launch();
    }

}