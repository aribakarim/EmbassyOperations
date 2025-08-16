package org.example.embassyoperations;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.lang.model.element.Name;

import java.time.LocalDate;

public class MannuallyUpdateApplicationController
{
    @javafx.fxml.FXML
    private ComboBox<String> ApplicationStatus;
    @javafx.fxml.FXML
    private TextField PassportNumber;
    @javafx.fxml.FXML
    private DatePicker Date;
    @javafx.fxml.FXML
    private TextField Name;

    @javafx.fxml.FXML
    public void initialize() {
        ApplicationStatus.getItems().addAll("Pending","Approved","Rejected");
    }

    @javafx.fxml.FXML
    public void SaveUpdate(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void Back(ActionEvent actionEvent) {
    }
}