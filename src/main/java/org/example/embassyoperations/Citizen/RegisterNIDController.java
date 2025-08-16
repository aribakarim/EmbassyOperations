package org.example.embassyoperations.Citizen;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterNIDController {

    @javafx.fxml.FXML
    private TextField currentAddressField;
    @javafx.fxml.FXML
    private Button submitButton;
    @javafx.fxml.FXML
    private Button cancelButton;
    @javafx.fxml.FXML
    private TextField contactNOField;
    @javafx.fxml.FXML
    private DatePicker birthdatePicker;
    @javafx.fxml.FXML
    private TextField nameField;
    @javafx.fxml.FXML
    private AnchorPane uploadDocButton;
    @javafx.fxml.FXML
    private TextField nationalityField;

    @javafx.fxml.FXML
    public void initialize() {

        @javafx.fxml.FXML
        private void handleBack(ActionEvent event) throws IOException {
            Parent root = FXMLLoader.load(getclass().getsource("CitizenDashboard.fxml"));
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        }
    }
}