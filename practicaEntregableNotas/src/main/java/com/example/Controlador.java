package com.example;

import java.util.ArrayList;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Controlador {

    private LineaNota notaSeleccionada;
    private VBox columnaNotas;
    private VBox contenidoPrincipal;

    public Controlador(VBox columnaNotas, VBox contenidoPrincipal) {
        this.notaSeleccionada = null;
        this.columnaNotas = columnaNotas;
        this.contenidoPrincipal = contenidoPrincipal;
    }

    public void crearColumnaNotas() {
        TextArea contenidoCentral = (TextArea) this.contenidoPrincipal.getChildren().get(0);
        HBox lineaBotones = (HBox) this.contenidoPrincipal.getChildren().get(1);
        ArrayList<Nota> lista = Nota.crearListaFicheros();
        VBox listaNotas = (VBox) this.columnaNotas.getChildren().get(2);
        if (!lista.isEmpty()) {
            for (Nota nota : lista) {
            LineaNota linea = new LineaNota(nota);
            linea.setOnMouseClicked(new EventHandler<Event>() {
                public void handle(Event e) {
                    LineaNota pulsado = (LineaNota) e.getSource();
                    seleccionarNota(pulsado);
                    contenidoCentral.setText(nota.volcarNotaAString());
                    contenidoCentral.setEditable(false);
                    lineaBotones.setVisible(false);
                    lineaBotones.setManaged(false);
                }
            });
            linea.getBotonBorrar().setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    borrarNota();
                }
            });
            linea.getBotonModificar().setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    añadirNota(e);
                }
            });
            listaNotas.getChildren().add(linea);
        }
        }
        
    }

    public void filtrarNotas(TextField cajaFiltro) {
        ObservableList<Node> listaNotas = ((VBox) this.columnaNotas.getChildren().get(2)).getChildren();
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

    public void añadirNota(ActionEvent e) {
        TextArea contenidoCentral = (TextArea) this.contenidoPrincipal.getChildren().get(0);
        contenidoCentral.setEditable(true);
        this.contenidoPrincipal.getChildren().get(1).setVisible(true);
        this.contenidoPrincipal.getChildren().get(1).setManaged(true);
        // ver si viene de un boton modificar o del nueva nota
        Button boton = (Button) e.getSource();
        if (boton.getText().equals("Nueva Nota")) {
            deseleccionarNota();
            contenidoCentral.setText(Nota.esqueletoNota());
        } else {
            contenidoCentral.setText(notaSeleccionada.getNota().volcarNotaAString());
        }
    }

    public void guardarNota() {
        TextArea contenidoCentral = (TextArea) contenidoPrincipal.getChildren().get(0);
        if (Nota.notaBienFormada(contenidoCentral.getText())) {
            if (notaSeleccionada == null) { // nota nueva
                Nota nuevaNota = Nota.stringToNota(contenidoCentral.getText());
                Nota.guardarNota(nuevaNota);
            } else { // nota modificada
                Nota modNota = Nota.stringToNota(contenidoCentral.getText());
                notaSeleccionada.getNota().modificarNota(modNota);
                Nota.guardarNota(notaSeleccionada.getNota());
            }
            resetInterfaz();
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

    public void borrarNota() {
        Alert alert = new Alert(AlertType.CONFIRMATION, "¿Seguro que quieres borrar la nota?",
                new ButtonType("Borrar", ButtonData.YES), new ButtonType("Cancelar", ButtonData.CANCEL_CLOSE));
        alert.setTitle("Borrar nota");
        alert.setHeaderText("Borrando...");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get().getText().equals("Borrar")) {
            Nota notaABorrar = notaSeleccionada.getNota();
            notaABorrar.borrarNota();
            deseleccionarNota();
            resetInterfaz();
            TextArea contenidoCentral = (TextArea) contenidoPrincipal.getChildren().get(0);
            contenidoCentral.setText("Borrado con éxito");
        }
    }

    public void cancelar() {
        TextArea contenidoCentral = (TextArea) contenidoPrincipal.getChildren().get(0);
        contenidoCentral.setText("");
        contenidoCentral.setEditable(false);
        HBox lineaBotones = (HBox) this.contenidoPrincipal.getChildren().get(1);
        lineaBotones.setVisible(false);
        lineaBotones.setManaged(false);
        deseleccionarNota();
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

    private void resetInterfaz() {
        HBox lineaBotones = (HBox) this.contenidoPrincipal.getChildren().get(1);
        lineaBotones.setVisible(false);
        lineaBotones.setManaged(false);
        VBox listaNotas = (VBox) this.columnaNotas.getChildren().get(2);
        listaNotas.getChildren().clear();
        this.crearColumnaNotas();
        TextArea contenidoCentral = (TextArea) this.contenidoPrincipal.getChildren().get(0);
        contenidoCentral.setEditable(false);
        HBox lineaFiltrado = (HBox) this.columnaNotas.getChildren().get(1);
        TextField filtro = (TextField) lineaFiltrado.getChildren().get(1);
        filtro.setText("");
    }

}
