package com.example;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class LineaNota extends HBox {
    
    private Text titulo;
    private Button botonBorrar;
    private Button botonModificar;

    public LineaNota(Nota nota) {

        titulo = new Text(nota.getTitulo());
        botonBorrar = new Button("B");
        botonModificar = new Button("M");

        titulo.setUserData(nota);

        botonBorrar.setVisible(true);
        botonBorrar.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                System.out.println("He pulsado boton borrar");
            }
        });

        botonModificar.setVisible(true);
        botonModificar.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                System.out.println("He pulsado boton modificar");
            }
        });
        
        this.getChildren().addAll(titulo, botonBorrar, botonModificar);
    }

}
