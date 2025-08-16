module org.example.embassyoperations {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jdk.compiler;


    opens org.example.embassyoperations to javafx.fxml;

    opens org.example.embassyoperations.ConsularOfficer to javafx.fxml, javafx.base;
    opens org.example.embassyoperations.HRManager to javafx.fxml, javafx.base;
    opens org.example.embassyoperations.Citizen to javafx.fxml, javafx.base;
    opens org.example.embassyoperations.Visitor to javafx.fxml, javafx.base;
    opens org.example.embassyoperations.VisaOfficer to javafx.fxml, javafx.base;
    exports org.example.embassyoperations;
}