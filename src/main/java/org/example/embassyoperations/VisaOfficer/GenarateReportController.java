package org.example.embassyoperations;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


import java.time.LocalDate;

public class GenarateReportController
{
    @javafx.fxml.FXML
    private DatePicker StartDate;
    @javafx.fxml.FXML
    private TextField PassportNumber;
    @javafx.fxml.FXML
    private DatePicker EndDate;
    @javafx.fxml.FXML
    private TextField Name;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void Report(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void Back(ActionEvent actionEvent) {
    }
}