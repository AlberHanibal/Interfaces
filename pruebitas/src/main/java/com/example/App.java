package com.example;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class App extends Application {

    TextArea contenidoCentral = null;

    @Override
    public void start(Stage primera) throws Exception {
        
        Nota nota = new Nota("El Camino de los Reyes", "Sanderson", "Muchísimo texto");
        LineaNota linea = new LineaNota(nota);
        /*
        titulo.setOnMouseClicked(new EventHandler<Event>() {
            public void handle(Event e) {
                Text pulsado = (Text) e.getSource();
                Nota nota = (Nota) pulsado.getUserData();
                contenidoCentral.setText(nota.volcarNotaAString());
            }
        });
        */
        TextArea contenidoCentral = new TextArea();
        BorderPane borderPane = new BorderPane();
        borderPane.setLeft(linea);
        borderPane.setCenter(contenidoCentral);


        Scene scene = new Scene(borderPane);
        primera.setScene(scene);
        primera.setTitle("Plantilla de app para JavaFX");
        primera.show();
    }


    public static void main(String[] args) {
        launch();
    }

}