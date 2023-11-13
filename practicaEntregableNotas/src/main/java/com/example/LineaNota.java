package com.example;

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
        botonBorrar.setVisible(true);
        botonModificar.setVisible(true);
        
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
