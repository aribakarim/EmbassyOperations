package org.example.embassyoperations.Citizen;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CitizenshipCertificateController
{
    @javafx.fxml.FXML
    private Button submitButton;
    @javafx.fxml.FXML
    private TextField fullNameField;
    @javafx.fxml.FXML
    private DatePicker birthDatePicker;
    @javafx.fxml.FXML
    private TextField passportNumberField;
    @javafx.fxml.FXML
    private TextArea reasonArea;
    @javafx.fxml.FXML
    private ComboBox certificateTypeBox;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handelFullName(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handelBirthDate(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handelPassportNumber(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handelSubmit(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handelCertificate(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    private void handleBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getclass().getsource("CitizenDashboard.fxml"));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}