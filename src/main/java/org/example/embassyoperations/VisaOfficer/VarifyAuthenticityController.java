package org.example.embassyoperations;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


public class VarifyAuthenticityController
{
    @javafx.fxml.FXML
    private ComboBox<String> DocumentStatus;
    @javafx.fxml.FXML
    private TextField PassportNumber;
    @javafx.fxml.FXML
    private TextField Name;

    @javafx.fxml.FXML
    public void initialize() {
        DocumentStatus.getItems().addAll("Pending","Approved");
    }

    @javafx.fxml.FXML
    public void Back(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void Save(ActionEvent actionEvent) {
    }
}