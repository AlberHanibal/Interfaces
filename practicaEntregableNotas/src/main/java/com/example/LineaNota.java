package com.example;

import java.io.File;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;

// la clase LineaNota es un HBox con la información (userData) de una Nota en el título y 
// dos botones para borrar y modificar las notas
public class LineaNota extends HBox {

    private Text titulo;
    private Button botonBorrar;
    private Button botonModificar;
    private boolean seleccionado;

    public LineaNota(Nota nota) {

        // título
        titulo = new Text(nota.getTitulo());
        titulo.setUserData(nota);

        // botón modificar
        File imagen = new File("assets/editar.png");
        ImageView editar = new ImageView(imagen.toURI().toString());
        botonModificar = new Button("", editar);
        botonModificar.setVisible(false);

        // boton borrar
        imagen = new File("assets/basura.png");
        ImageView borrar = new ImageView(imagen.toURI().toString());
        botonBorrar = new Button("", borrar);
        botonBorrar.setVisible(false);

        seleccionado = false;

        Region espacioVacio = new Region();
        LineaNota.setHgrow(espacioVacio, Priority.ALWAYS);
        this.setSpacing(10);

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

    public boolean isSeleccionado() {
        return seleccionado;
    }

    public void seleccionarLinea() {
        this.seleccionado = true;
        botonBorrar.setVisible(true);
        botonModificar.setVisible(true);
        this.setStyle("-fx-border-style: solid;"
                + "-fx-border-width: 2px;"
                + "-fx-border-color: #81c8e0;");
    }

    public void deseleccionarLinea() {
        this.seleccionado = false;
        botonBorrar.setVisible(false);
        botonModificar.setVisible(false);
        this.setStyle("");
    }

}
