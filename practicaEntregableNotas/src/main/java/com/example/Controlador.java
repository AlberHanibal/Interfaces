package com.example;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class Controlador {
    
    public void crearColumnaNotas(VBox columna, TextArea contenidoCentral) {
        ArrayList<Nota> lista = Nota.crearListaFicheros();
        for (Nota nota : lista) {
            LineaNota linea = new LineaNota(nota);
            linea.setOnMouseClicked(new EventHandler<Event>() {
                public void handle(Event e) {
                    LineaNota pulsado = (LineaNota) e.getSource();
                    Nota nota = (Nota) pulsado.getTitulo().getUserData();
                    if (!pulsado.isSeleccionado()) {
                        deseleccionarColumna(columna);
                        pulsado.seleccionarLinea();
                    }
                    contenidoCentral.setText(nota.volcarNotaAString());
                }
            });
            linea.getBotonBorrar().setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    System.out.println("He pulsado boton borrar");
                }
            });
            linea.getBotonModificar().setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    System.out.println("He pulsado boton modificar");
                }
            });
            columna.getChildren().add(linea);
        }
    }

    public void filtrarNotas(VBox columna, TextField cajaFiltro) {
        ObservableList<Node> listaNotas = columna.getChildren();
        LineaNota linea = null;
        Nota nota = null;
        Pattern pattern = Pattern.compile(cajaFiltro.getText());
        Matcher matcher = null;
        String notaCompleta;
        for (Node node : listaNotas) {
            if (node.getClass().getSimpleName().equals("LineaNota")) {
                linea = (LineaNota) node;
                nota = linea.getNota();
                notaCompleta = nota.volcarNotaAString();
                matcher = pattern.matcher(notaCompleta);
                if (matcher.find()) {
                    linea.setVisible(true);
                    linea.setManaged(true);
                } else {
                    linea.setVisible(false);
                    linea.setManaged(false);
                }
            }
        }
    }

    private void deseleccionarColumna(VBox columna) {
        ObservableList<Node> listaNotas = columna.getChildren();
        LineaNota linea = null;
        for (Node node : listaNotas) {
            if (node.getClass().getSimpleName().equals("LineaNota")) {
                linea = (LineaNota) node;
                if (linea.isSeleccionado()) {
                    linea.deseleccionarLinea();
                }
            }
        }
    }
}
