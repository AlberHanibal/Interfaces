package com.example;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class App extends Application {

    private Controlador controlador = new Controlador();

    @Override
    public void start(Stage pantalla) throws Exception {

        VBox columnaNotas = new VBox();

        HBox lineaFiltrado = new HBox();
        Label filtro = new Label("Filtro");
        TextField cajaFiltro = new TextField();
        lineaFiltrado.getChildren().addAll(filtro, cajaFiltro);
        columnaNotas.getChildren().add(lineaFiltrado);

        TextArea contenidoCentral = new TextArea();
        
        BorderPane borderPane = new BorderPane();
        borderPane.setLeft(columnaNotas);
        borderPane.setCenter(contenidoCentral);

        EventHandler<KeyEvent> manejadorFiltro = arg0 -> controlador.filtrarNotas(columnaNotas, cajaFiltro);
        cajaFiltro.setOnKeyTyped(manejadorFiltro);
        controlador.crearColumnaNotas(columnaNotas, contenidoCentral);

        Scene escena = new Scene (borderPane);
        pantalla.setScene(escena);
        pantalla.setTitle("Notas");
        pantalla.show();
    }

    public static void main(String[] args) {
        launch();
    }

}