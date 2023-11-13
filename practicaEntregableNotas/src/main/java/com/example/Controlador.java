package com.example;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
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
        // filtrar en todo el contenido de la nota
        System.out.println("hola");
    }

//columnaNotas.getChildren().get(1).setVisible(false);
//columnaNotas.getChildren().get(1).setManaged(false);

}
