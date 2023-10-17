package com.example;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class App extends Application {


    @Override
    public void start(Stage primera) throws Exception {

        HBox raiz = new HBox(20);
        VBox col1 = new VBox();
        Label textoSonido1 = new Label("Sonido1");
        Label valorSonido1 = new Label("0");
        Slider sonido1 = new Slider(0, 100, 0);
        sonido1.setOrientation(Orientation.VERTICAL);
        valorSonido1.textProperty().bind(Bindings.format("%.2f", sonido1.valueProperty()));
        col1.getChildren().addAll(textoSonido1, sonido1, valorSonido1);

        VBox col2 = new VBox();
        Label textoSonido2 = new Label("Sonido2");
        Label valorSonido2 = new Label("0");
        Slider sonido2 = new Slider(0, 100, 0);
        sonido2.setOrientation(Orientation.VERTICAL);
        valorSonido2.textProperty().bind(Bindings.format("%.2f", sonido2.valueProperty()));
        col2.getChildren().addAll(textoSonido2, sonido2, valorSonido2);

        VBox col3 = new VBox();
        Label textoSonido3 = new Label("Sonido3");
        Label valorSonido3 = new Label("0");
        Slider sonido3 = new Slider(0, 100, 0);
        sonido3.setOrientation(Orientation.VERTICAL);
        valorSonido3.textProperty().bind(Bindings.format("%.2f", sonido3.valueProperty()));
        col3.getChildren().addAll(textoSonido3, sonido3, valorSonido3);
        
        VBox colMaestra = new VBox();
        Label textoSonidoMaestro = new Label("Maestro");
        Label valorSonidoMaestro = new Label("100");
        Slider sonidoMaestro = new Slider(0, 100, 100);
        sonidoMaestro.setOrientation(Orientation.VERTICAL);
        valorSonidoMaestro.textProperty().bind(Bindings.format("%.2f", sonidoMaestro.valueProperty()));
        colMaestra.getChildren().addAll(textoSonidoMaestro, sonidoMaestro, valorSonidoMaestro);
        sonido1.maxProperty().bind(sonidoMaestro.valueProperty());
        sonido2.maxProperty().bind(sonidoMaestro.valueProperty());
        sonido3.maxProperty().bind(sonidoMaestro.valueProperty());

        
        raiz.getChildren().addAll(colMaestra, col1, col2, col3);

        Scene scene = new Scene(raiz, 300, 300);
        primera.setScene(scene);
        primera.setTitle("Sonidos");
        primera.show();
    }


    public static void main(String[] args) {
        launch();
    }

}