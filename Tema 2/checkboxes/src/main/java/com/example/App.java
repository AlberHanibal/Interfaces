package com.example;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.event.*;
import java.util.ArrayList;

public class App extends Application {

    ArrayList<Alumno> alumnos;
    double notaMedia = 0;
    int numeroAlumnos = 0;

    @Override
    public void start(Stage primera) throws Exception {
        
        alumnos=new ArrayList<Alumno>();
        alumnos.add(new Alumno("Marta", 6));
        alumnos.add(new Alumno("Sergio", 9));
        alumnos.add(new Alumno("Pedro", 4));
        alumnos.add(new Alumno("Alberto", 10));
        alumnos.add(new Alumno("Ermenegilda", 2));
        alumnos.add(new Alumno("Eustaquio", 5));
        

        VBox raiz = new VBox();
        Label texto = new Label();
        texto.setText(String.format("La nota media de los seleccionados es de %.2f%n", notaMedia));
        Scene escena = new Scene(raiz,200,200);


        EventHandler<ActionEvent> eventoCheck = new EventHandler<ActionEvent>(){
                public void handle(ActionEvent e){
                    CheckBox c = (CheckBox)e.getSource(); // obtengo el checkbox que ha sido pulsado
                    Alumno activo = (Alumno) c.getUserData(); // obtengo el alumno vinculado al check pulsado
                    double notaTotal = notaMedia * numeroAlumnos;
                    if (!activo.getSeleccionado()) {
                        numeroAlumnos++;
                        notaMedia = (notaTotal + activo.getNota()) / numeroAlumnos;
                    } else {
                        numeroAlumnos--;
                        if (numeroAlumnos != 0) {
                            notaMedia = (notaTotal - activo.getNota()) / numeroAlumnos;
                        } else {
                            notaMedia = 0;
                        }
                        
                    }
                    
                    texto.setText(String.format("La nota media es de %.2f%n", notaMedia));
                    activo.setSeleccionado(c.isSelected()); // actualizo el estado del objeto Alumno del modelo
                }
            };

        
        for (Alumno a:alumnos){
            CheckBox c =new CheckBox(a.getNombre());
            raiz.getChildren().add(c);
            c.setOnAction(eventoCheck);
            c.setUserData(a);  // vinculo el alumno con este check
        }
        raiz.getChildren().add(texto);

        primera.setScene(escena);
        primera.setTitle("Checkboxes");
        primera.show();
    }


    public static void main(String[] args) {
        launch();
    }

}
