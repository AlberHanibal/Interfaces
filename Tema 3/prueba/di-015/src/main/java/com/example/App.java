package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Plantilla de FXML y SceneBuilder
 */
public class App extends Application {

    private static Scene scene;
    private static Prueba prueba;

    @Override
    public void start(Stage stage) throws IOException {

        prueba = new Prueba();
        prueba.setAnnos(12);
        Parent root = cargarEscena("principal.fxml");

        scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static Scene getScene() {
        return scene;
    }

    public static Prueba getPrueba() {
        return prueba;
    }

    public static Parent cargarEscena(String fichero) {
        FXMLLoader loader = new FXMLLoader(App.class.getResource(fichero));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return root;
    }
}
