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

    private Controlador controlador = new Controlador();

    @Override
    public void start(Stage pantalla) throws Exception {

        VBox columnaNotas = new VBox();

        // Línea del botón añadir nota
        HBox lineaAñadir = new HBox();
        Region spacer = new Region();
        Button botonAñadir = new Button("Nueva Nota");
        lineaAñadir.getChildren().addAll(spacer, botonAñadir);
        lineaAñadir.setHgrow(spacer, Priority.ALWAYS);

        // Línea del filtro
        HBox lineaFiltrado = new HBox();
        Label filtro = new Label("Filtro");
        TextField cajaFiltro = new TextField();
        lineaFiltrado.getChildren().addAll(filtro, cajaFiltro);
        
        // Lista notas
        VBox listaNotas = new VBox();
        columnaNotas.getChildren().addAll(lineaAñadir, lineaFiltrado, listaNotas);

        VBox contenidoPrincipal = new VBox();
        TextArea contenidoCentral = new TextArea();
        HBox lineaBotones = new HBox();
        lineaBotones.setVisible(false);
        lineaBotones.setManaged(false);
        Button botonCancelar = new Button("Cancelar");
        Button botonGuardar = new Button("Guardar");
        lineaBotones.getChildren().addAll(botonGuardar, botonCancelar);
        contenidoPrincipal.getChildren().addAll(contenidoCentral, lineaBotones);
        
        BorderPane borderPane = new BorderPane();
        borderPane.setLeft(columnaNotas);
        borderPane.setCenter(contenidoPrincipal);

        EventHandler<ActionEvent> manejadorAñadirNota = arg0 -> controlador.añadirNota(contenidoPrincipal, arg0);
        botonAñadir.setOnAction(manejadorAñadirNota);
        EventHandler<KeyEvent> manejadorFiltro = arg0 -> controlador.filtrarNotas(columnaNotas, cajaFiltro);
        cajaFiltro.setOnKeyTyped(manejadorFiltro);
        EventHandler<ActionEvent> manejadorGuardarNota = arg0 -> controlador.guardarNota(columnaNotas, contenidoPrincipal);
        botonGuardar.setOnAction(manejadorGuardarNota);
        EventHandler<ActionEvent> manejadorCancelar = arg0 -> controlador.cancelar();
        botonCancelar.setOnAction(manejadorCancelar); 
        controlador.crearColumnaNotas(columnaNotas, contenidoPrincipal);

        Scene escena = new Scene (borderPane);
        pantalla.setScene(escena);
        pantalla.setTitle("Notas");
        pantalla.show();
    }

    public static void main(String[] args) {
        launch();
    }

}