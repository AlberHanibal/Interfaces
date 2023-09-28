package com.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.stage.Stage;


public class App extends Application {


    @Override
    public void start(Stage primera) throws Exception {

        HBox root = new HBox(20);
        root.setPadding(new Insets(20));

        Button boton1 = new Button("B1");
        Button boton2 = new Button("B2");
        Button boton3 = new Button("B3");
        Region spacer = new Region();
        TextArea texto = new TextArea();
        spacer.setPrefHeight(20);
        boton1.setMinSize(89, 50);

        root.getChildren().add(boton1);
        root.getChildren().add(boton2);
        //root.getChildren().add(spacer);
        root.getChildren().add(texto);
        root.getChildren().add(boton3);
        HBox.setHgrow(texto,Priority.ALWAYS);

        Scene scene = new Scene(root, 600, 200);

        primera.setScene(scene);
        primera.setTitle("Cositas");
        primera.show();
    }


    public static void main(String[] args) {
        launch();
    }

}