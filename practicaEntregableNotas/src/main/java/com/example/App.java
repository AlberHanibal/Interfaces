package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class App extends Application {


    @Override
    public void start(Stage pantalla) throws Exception {

        BorderPane borderPane = new BorderPane();
        Nota nota = new Nota("Una prueba", "Clase", "lorem ipsumlorem ipsumlorem ipsum");
        //System.out.println(nota.toString());
        //nota.guardarNota(nota);
        System.out.println(nota.formatearFecha());
        System.out.println(nota.desFormatearFecha("191023144115"));
        Scene escena = new Scene (borderPane);
        pantalla.setScene(escena);
        pantalla.setTitle("Notas");
        pantalla.show();
    }


    public static void main(String[] args) {
        launch();
    }

}