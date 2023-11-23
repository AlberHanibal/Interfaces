package com.example;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Controlador {
    
    LineaNota notaSeleccionada = null;

    public void crearColumnaNotas(VBox columna, VBox contenidoPrincipal) {
        TextArea contenidoCentral = (TextArea) contenidoPrincipal.getChildren().get(0);
        ArrayList<Nota> lista = Nota.crearListaFicheros();
        VBox listaNotas = (VBox) columna.getChildren().get(2);

        for (Nota nota : lista) {
            LineaNota linea = new LineaNota(nota);
            linea.setOnMouseClicked(new EventHandler<Event>() {
                public void handle(Event e) {
                    LineaNota pulsado = (LineaNota) e.getSource();
                    seleccionarNota(pulsado);
                    contenidoCentral.setText(nota.volcarNotaAString());
                    // falta vbox quitar los botones de guardar y cancelar
                }
            });
            linea.getBotonBorrar().setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    System.out.println("He pulsado boton borrar");
                }
            });
            linea.getBotonModificar().setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    añadirNota(contenidoPrincipal, e);
                }
            });
            listaNotas.getChildren().add(linea);
        }
    }

    public void filtrarNotas(VBox columna, TextField cajaFiltro) {
        ObservableList<Node> listaNotas = ((VBox) columna.getChildren().get(2)).getChildren();
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

    private void deseleccionarNota() {
        if (notaSeleccionada != null) {
            notaSeleccionada.deseleccionarLinea();
            notaSeleccionada = null;
        }
    }

    private void seleccionarNota(LineaNota linea) {
        if (notaSeleccionada != null) {
            deseleccionarNota();
        }
        notaSeleccionada = linea;
        linea.seleccionarLinea();
    }

    public void añadirNota(VBox contenidoPrincipal, ActionEvent e) {
        TextArea contenidoCentral = (TextArea) contenidoPrincipal.getChildren().get(0);
        contenidoPrincipal.getChildren().get(1).setVisible(true);
        contenidoPrincipal.getChildren().get(1).setManaged(true);
        // ver si viene de un boton modificar o del nueva nota
        Button boton = (Button) e.getSource();
        if (boton.getText().equals("Nueva Nota")) {
            deseleccionarNota();
            contenidoCentral.setText(Nota.esqueletoNota());
        } else {
            contenidoCentral.setText(notaSeleccionada.getNota().volcarNotaAString());
        }
        
        
    }

    public void guardarNota(VBox columnaNotas, VBox contenidoPrincipal) {
        TextArea contenidoCentral = (TextArea) contenidoPrincipal.getChildren().get(0);
        if (Nota.notaBienFormada(contenidoCentral.getText())) {
            // nota nueva
            if (notaSeleccionada == null) {
                Nota nuevaNota = Nota.stringToNota(contenidoCentral.getText());
                Nota.guardarNota(nuevaNota);
            } else { // nota modificada
                Nota modNota = Nota.stringToNota(contenidoCentral.getText());
                notaSeleccionada.getNota().modificarNota(modNota);
            }
            HBox lineaBotones = (HBox) contenidoPrincipal.getChildren().get(1);
            lineaBotones.setVisible(false);
            lineaBotones.setManaged(false);
            VBox listaNotas = (VBox) columnaNotas.getChildren().get(2);
            listaNotas.getChildren().clear();
            this.crearColumnaNotas(columnaNotas, contenidoPrincipal);
            // seleccionar la nota creada (?)
        } else {
            // no sé como tratar el error
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error en la aplicación");
            alert.setHeaderText("Cabecera del cuadro de dialogo");
            alert.setContentText("Texto completo del cuadro de diálogo ... ");
            alert.showAndWait();

        }
        
    }

    public void cancelar() {

    }
}
