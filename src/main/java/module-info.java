module com.ejemplo.perfil {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.ejemplo.perfil to javafx.fxml;
    exports com.ejemplo.perfil;
}
