package org.example.embassyoperations;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


import java.time.LocalDate;

public class VarifyVisaApplicationController
{
    @javafx.fxml.FXML
    private ComboBox<String> VisaType;
    @javafx.fxml.FXML
    private TextField PassportNumber;
    @javafx.fxml.FXML
    private DatePicker Date;
    @javafx.fxml.FXML
    private ComboBox<String> Nationality;
    @javafx.fxml.FXML
    private TextField Reason;
    @javafx.fxml.FXML
    private TextField Name;

    @javafx.fxml.FXML
    public void initialize() {
        Nationality.getItems().addAll("Bangladeshi","Indian","Nepali");
        VisaType.getItems().addAll("Student","Worker","Tourist");
    }

    @javafx.fxml.FXML
    public void Add(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void ExportPdf(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void Back(ActionEvent actionEvent) {
    }
}