package com.example;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;

public class LineaNota extends HBox {
    
    private Text titulo;
    private Button botonBorrar;
    private Button botonModificar;
    private boolean seleccionado;

    public LineaNota(Nota nota) {

        titulo = new Text(nota.getTitulo());
        botonModificar = new Button("M");
        botonBorrar = new Button("B");
        seleccionado = false;
        Region espacioVacio = new Region();
        this.setHgrow(espacioVacio, Priority.ALWAYS);

        titulo.setUserData(nota);
        botonBorrar.setVisible(false);
        botonModificar.setVisible(false);
        
        this.getChildren().addAll(titulo, espacioVacio, botonModificar, botonBorrar);
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

    public Nota getNota() {
        return (Nota) this.titulo.getUserData();
    }

    public void seleccionarLinea() {
        this.seleccionado = true;
        botonBorrar.setVisible(true);
        botonModificar.setVisible(true);
    }

    public void deseleccionarLinea() {
        this.seleccionado = false;
        botonBorrar.setVisible(false);
        botonModificar.setVisible(false);
    }

    public boolean isSeleccionado() {
        return seleccionado;
    }

}
