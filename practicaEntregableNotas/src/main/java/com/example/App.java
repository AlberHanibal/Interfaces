package com.example;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    private VBox columnaNotas;
    private VBox contenidoPrincipal;
    private Controlador controlador;

    @Override
    public void start(Stage pantalla) throws Exception {

        // Inicialización controlador
        columnaNotas = new VBox(10);
        contenidoPrincipal = new VBox();
        controlador = new Controlador(columnaNotas, contenidoPrincipal);

        // Línea del botón añadir nota
        HBox lineaAñadir = new HBox();
        Region spacer = new Region();
        Button botonAñadir = new Button("Nueva Nota");
        lineaAñadir.getChildren().addAll(spacer, botonAñadir);
        HBox.setHgrow(spacer, Priority.ALWAYS);
        EventHandler<ActionEvent> manejadorAñadirNota = arg0 -> controlador.añadirNota(arg0);
        botonAñadir.setOnAction(manejadorAñadirNota);

        // Línea del filtro
        HBox lineaFiltrado = new HBox(20);
        Label filtro = new Label("Filtro");
        TextField cajaFiltro = new TextField();
        lineaFiltrado.getChildren().addAll(filtro, cajaFiltro);
        EventHandler<KeyEvent> manejadorFiltro = arg0 -> controlador.filtrarNotas(cajaFiltro);
        cajaFiltro.setOnKeyTyped(manejadorFiltro);

        // Lista notas
        VBox listaNotas = new VBox(5);
        columnaNotas.getChildren().addAll(lineaAñadir, lineaFiltrado, listaNotas);

        // Contenido central
        TextArea contenidoCentral = new TextArea();
        contenidoCentral.setStyle("-fx-font-size: 1.3em");
        contenidoCentral.setEditable(false);
        HBox lineaBotones = new HBox(10);
        lineaBotones.setVisible(false);
        lineaBotones.setManaged(false);
        Button botonCancelar = new Button("Cancelar");
        EventHandler<ActionEvent> manejadorCancelar = arg0 -> controlador.cancelar();
        botonCancelar.setOnAction(manejadorCancelar);
        Button botonGuardar = new Button("Guardar");
        EventHandler<ActionEvent> manejadorGuardarNota = arg0 -> controlador.guardarNota();
        botonGuardar.setOnAction(manejadorGuardarNota);
        lineaBotones.getChildren().addAll(botonGuardar, botonCancelar);
        contenidoPrincipal.getChildren().addAll(contenidoCentral, lineaBotones);
        VBox.setVgrow(contenidoCentral, Priority.ALWAYS);

        BorderPane borderPane = new BorderPane();
        borderPane.setLeft(columnaNotas);
        borderPane.setCenter(contenidoPrincipal);
        borderPane.setStyle("-fx-font-size: 14px");

        controlador.crearColumnaNotas();

        Scene escena = new Scene(borderPane, 1000, 500);
        pantalla.setScene(escena);
        pantalla.setTitle("Notas");
        pantalla.show();
    }

    public static void main(String[] args) {
        launch();
    }

}