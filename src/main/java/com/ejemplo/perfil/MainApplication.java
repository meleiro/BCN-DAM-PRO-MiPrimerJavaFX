package com.ejemplo.perfil;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(
                MainApplication.class.getResource("perfil-view.fxml")
        );

        Scene scene = new Scene(loader.load(), 500, 500);

        scene.getStylesheets().add(
                MainApplication.class.getResource("styles.css").toExternalForm()
        );

        stage.setTitle("Gestor de Perfil - JavaFX");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
