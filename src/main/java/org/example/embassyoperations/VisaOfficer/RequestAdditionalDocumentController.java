package org.example.embassyoperations;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class RequestAdditionalDocumentController
{
    @javafx.fxml.FXML
    private DatePicker RequestDate;
    @javafx.fxml.FXML
    private ComboBox<String> VisaType;
    @javafx.fxml.FXML
    private TextField ApplicantName;
    @javafx.fxml.FXML
    private TextField PassportNumber;
    @javafx.fxml.FXML
    private ComboBox<String> Nationality;

    @javafx.fxml.FXML
    public void initialize() {
        VisaType.getItems().addAll("Student","Worker","Tourist");
        Nationality.getItems().addAll("Bangladeshi","Indian","Nepali");
    }

    @javafx.fxml.FXML
    public void AddDocument(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void Back(ActionEvent actionEvent) {
    }
}