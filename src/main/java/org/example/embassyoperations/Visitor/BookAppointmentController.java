package org.example.embassyoperations.Visitor;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BookAppointmentController
{
    @javafx.fxml.FXML
    private DatePicker choosedatePicker;
    @javafx.fxml.FXML
    private Button cancelButton;
    @javafx.fxml.FXML
    private Label visaApplicationIDLabel;
    @javafx.fxml.FXML
    private ComboBox centerBox;
    @javafx.fxml.FXML
    private CheckBox slotschooseCheckBox;
    @javafx.fxml.FXML
    private TextField applicationIDField;
    @javafx.fxml.FXML
    private Label choosedateLabel;
    @javafx.fxml.FXML
    private Button confirmButton;
    @javafx.fxml.FXML
    private Button reschduleButton;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handelReschdule(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handelCancel(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handelCenter(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handelConfermation(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    private void goBackToDashboard(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getclass().getsource("VisitorDashboard.fxml"));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}