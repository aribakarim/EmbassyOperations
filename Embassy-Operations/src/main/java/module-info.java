module org.example.embassyoperations {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.embassyoperations to javafx.fxml;
    exports org.example.embassyoperations;
}