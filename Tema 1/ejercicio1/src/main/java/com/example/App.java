package com.example;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application {

    EventHandler<ActionEvent> manejador = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e) {
            System.out.format("Has pulsado el botón %s%n", ((Button) e.getSource()).getText());
        }
    };

    @Override
    public void start(Stage primera) throws Exception {
        Text msg = new Text("Etiqueta con un mensaje");
        VBox root = new VBox();
        Button boton = new Button("hola");
        boton.setOnAction(manejador);
        Button boton2 = new Button("que");
        boton2.setOnAction(manejador);
        Label label = new Label("holaqutal");
        root.getChildren().add(msg);
        root.getChildren().add(boton);
        root.getChildren().add(boton2);
        root.getChildren().add(label);
        Scene scene = new Scene(root, 500, 150);

        primera.setScene(scene);
        primera.setTitle("Ejercicio 1, Tema 2");
        primera.show();
    }

    public static void main(String[] args) {
        launch();
    }

}