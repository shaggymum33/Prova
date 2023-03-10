module com.example.progetto_uni {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires java.management;
    requires java.desktop;
    requires javafx.swing;

    opens com.example.progetto_uni to javafx.fxml;
    exports com.example.progetto_uni;
}