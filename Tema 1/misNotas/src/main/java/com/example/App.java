package com.example;

import javafx.application.Application;
import javafx.stage.Stage;


public class App extends Application {


    @Override
    public void start(Stage primera) throws Exception {

        Bloque unidad1 = new Bloque("JavaFX", 0.35, 0.5, 0.5);
        unidad1.setNotaExamen(7.3);
        unidad1.setNotaProyecto(9);
        System.out.println("que tal");
        System.out.println(unidad1.toString());
        primera.setTitle("Mis notas");
        primera.show();
    }


    public static void main(String[] args) {
        launch();
    }

}