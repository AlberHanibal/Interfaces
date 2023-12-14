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
    private static Comanda comanda;

    @Override
    public void start(Stage stage) throws IOException {

        Parent root = cargarEscena("login.fxml");
        comanda = new Comanda();

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

    public static Comanda getComanda() {
        return comanda;
    }

    public static Parent cargarEscena(String fichero) {
        FXMLLoader loader = new FXMLLoader(App.class.getResource(fichero));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return root;
    }

}
