module org.example.projetcalendrier {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens org.example.projetcalendrier to javafx.fxml;
    exports org.example.projetcalendrier;
    exports vue;
}