package com.example;

import java.io.File;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
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
        File imagen = new File("assets/editar.png");
        ImageView editar = new ImageView(imagen.toURI().toString());
        botonModificar = new Button("", editar);
        imagen = new File("assets/basura.png");
        ImageView borrar = new ImageView(imagen.toURI().toString());
        botonBorrar = new Button("", borrar);
        seleccionado = false;
        Region espacioVacio = new Region();
        this.setHgrow(espacioVacio, Priority.ALWAYS);
        this.setSpacing(10);

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

    public boolean isSeleccionado() {
        return seleccionado;
    }

}
