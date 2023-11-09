package com.example;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class App extends Application {

    TextArea contenidoCentral = null;

    @Override
    public void start(Stage primera) throws Exception {
        
        VBox columnaNotas = new VBox();
        Nota nota = new Nota("El Camino de los Reyes", "Sanderson", "Muchísimo texto");
        LineaNota linea = new LineaNota(nota);
        Nota nota2 = new Nota("Palabras Radiantes", "Sanderson", "Muchísimo texto más texto");
        LineaNota linea2 = new LineaNota(nota2);
        columnaNotas.getChildren().addAll(linea, linea2);

        contenidoCentral = new TextArea();
        BorderPane borderPane = new BorderPane();
        borderPane.setLeft(columnaNotas);
        borderPane.setCenter(contenidoCentral);


        annadirManejadorLinea(linea);
        annadirManejadorLinea(linea2);
        // investigar
        //linea.setVisible(false);
        //linea.setManged(false);
        Scene scene = new Scene(borderPane);
        primera.setScene(scene);
        primera.setTitle("Plantilla de app para JavaFX");
        primera.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public void annadirManejadorLinea(LineaNota linea) {
        linea.setOnMouseClicked(new EventHandler<Event>() {
            public void handle(Event e) {
                LineaNota pulsado = (LineaNota) e.getSource();
                Nota nota = (Nota) pulsado.getTitulo().getUserData();
                contenidoCentral.setText(nota.volcarNotaAString());
            }
        });
    }

}