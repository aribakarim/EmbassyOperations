package org.example.embassyoperations.Citizen;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class EmergencyTravelDocumentController
{
    @javafx.fxml.FXML
    private Button submitButton;
    @javafx.fxml.FXML
    private ComboBox emargencyTypeBox;
    @javafx.fxml.FXML
    private TextField emailField;
    @javafx.fxml.FXML
    private TextField phoneField;
    @javafx.fxml.FXML
    private DatePicker TravelDatePicker;
    @javafx.fxml.FXML
    private Button uploadIDButton;
    @javafx.fxml.FXML
    private TextField passportNoField;
    @javafx.fxml.FXML
    private TextField fullNameField;
    @javafx.fxml.FXML
    private TextField idNumberField;
    @javafx.fxml.FXML
    private TextArea reasonArea;
    @javafx.fxml.FXML
    private Label idFileLabel;
    @javafx.fxml.FXML
    private Button uploadPoliceButton;
    @javafx.fxml.FXML
    private TextArea addressArea;
    @javafx.fxml.FXML
    private Label policeReportLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void submitOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    private void handleBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getclass().getsource("CitizenDashboard.fxml"));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}