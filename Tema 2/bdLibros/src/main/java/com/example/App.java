package com.example;

import java.io.File;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.event.ActionEvent;



public class App extends Application {

    private Controlador c;
    private final String [] generos = {"Novela", "Ensayo", "Artículo", "Docencia"};
    private final String [] etiquetas = {"Leído", "Pendiente", "Favorito"};
    @Override
    public void start(Stage primera) throws Exception {
//datos : t´ıtulo, autor, genero y etiquetas
// generos: Novela, Ensayo, Art´ıculo y Docencia
        c = new Controlador();
        VBox formulario = new VBox();

        HBox lineaTitulo = new HBox();
        Label textoTitulo = new Label("Título");
        TextField cajaTitulo = new TextField();
        lineaTitulo.getChildren().addAll(textoTitulo, cajaTitulo);

        HBox lineaAutor = new HBox();
        Label textoAutor = new Label("Autor");
        TextField cajaAutor = new TextField();
        lineaAutor.getChildren().addAll(textoAutor, cajaAutor);

        HBox lineaGenero = new HBox();
        ToggleGroup opcionesGenero = new ToggleGroup();
        for (String genero : generos) {
            RadioButton r = new RadioButton(genero);
            r.setToggleGroup(opcionesGenero);
            lineaGenero.getChildren().add(r);
        }

        HBox lineaEtiquetas = new HBox();
        for (String etiqueta : etiquetas) {
            CheckBox c = new CheckBox(etiqueta);
            lineaEtiquetas.getChildren().add(c);
        }

        Button botonGuardar = new Button("Guardar");
        botonGuardar.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                String textoEtiquetas = "";
                for (Node n : lineaEtiquetas.getChildren()) {
                    CheckBox c = (CheckBox) n;
                    if (c.isSelected()) {
                        textoEtiquetas+= c.getText() + ",";
                    }
                    // quitar el último ,
                    // falla el string del radio
                }
                Libro libro = new Libro(cajaTitulo.getText(), cajaAutor.getText(), opcionesGenero.getSelectedToggle().toString(), textoEtiquetas);
                System.out.println(libro.toString());
                FileChooser fileChooser = new FileChooser();
                File fichero = fileChooser.showOpenDialog(primera);
                if (fichero != null) {
                    c.guardarFichero(fichero, libro);
                }
            };
        });


        formulario.getChildren().addAll(lineaTitulo, lineaAutor, lineaGenero, lineaEtiquetas, botonGuardar);




        Scene scene = new Scene(formulario, 400, 200);
        primera.setScene(scene);
        primera.setTitle("BD Libros");
        primera.show();
    }


    public static void main(String[] args) {
        launch();
    }

}