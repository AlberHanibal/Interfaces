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
        botonModificar = new Button("M");
        botonBorrar = new Button("B");

        titulo.setUserData(nota);


        // esto tendría que estar al crear la LineaNota en la vista (?)
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
        
        this.getChildren().addAll(titulo, botonModificar, botonBorrar);
    }

    public Text getTitulo() {
        return titulo;
    }

    public Button getBotonBorrar() {
        return botonBorrar;
    }

    public Button getBotonModificar() {
        return botonModificar;
    }

    public void setTitulo(Text titulo) {
        this.titulo = titulo;
    }

}
