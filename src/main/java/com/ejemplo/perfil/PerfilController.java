package com.ejemplo.perfil;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
public class PerfilController {

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtEmail;

    @FXML
    private CheckBox checkJava;

    @FXML
    private CheckBox checkJavaFX;

    @FXML
    private Label lblResultado;

    @FXML
    private void guardarPerfil() {

        String nombre = txtNombre.getText();
        String email = txtEmail.getText();

        if (nombre.isBlank() || email.isBlank()) {

            lblResultado.setText(
                    "Debes introducir nombre y correo electrónico."
            );

            return;
        }

        String preferencias = "";

        if (checkJava.isSelected()) {
            preferencias += "Java ";
        }

        if (checkJavaFX.isSelected()) {
            preferencias += "JavaFX";
        }

        abrirVentanaResumen(
                nombre,
                email,
                preferencias
        );
    }

    @FXML
    private void limpiarFormulario() {
        txtNombre.clear();
        txtEmail.clear();
        checkJava.setSelected(false);
        checkJavaFX.setSelected(false);
        lblResultado.setText("");
    }

    private void abrirVentanaResumen(
            String nombre,
            String email,
            String preferencias) {

        try {

            FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource(
                                    "resumen-view.fxml"
                            )
                    );

            Scene scene =
                    new Scene(loader.load());

            // Obtenemos el controlador
            // de la segunda pantalla
            ResumenController controller =
                    loader.getController();

            // Le pasamos los datos
            controller.cargarDatos(
                    nombre,
                    email,
                    preferencias
            );

            // Creamos una nueva ventana
            Stage stage = new Stage();

            stage.setTitle(
                    "Resumen del perfil"
            );

            stage.setScene(scene);

            stage.show();

        } catch (IOException e) {

            e.printStackTrace();

        }
    }
}
