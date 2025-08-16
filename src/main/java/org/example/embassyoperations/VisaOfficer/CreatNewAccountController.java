package org.example.embassyoperations;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;



public class CreatNewAccountController
{
    @javafx.fxml.FXML
    private TextField Email;
    @javafx.fxml.FXML
    private TextField PhoneNumber;
    @javafx.fxml.FXML
    private ComboBox<String> Nationality;
    @javafx.fxml.FXML
    private TextField Name;
    @javafx.fxml.FXML
    private TextField Password;

    @javafx.fxml.FXML
    public void initialize() {
        Nationality.getItems().addAll("Bangladeshi","Indian","Nepali");
    }

    @javafx.fxml.FXML
    public void Back(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void Creat(ActionEvent actionEvent) {
    }
}