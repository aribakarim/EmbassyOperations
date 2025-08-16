package org.example.embassyoperations.Citizen;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DocumentAttestationController
{
    @javafx.fxml.FXML
    private Button uploadIDProofButton;
    @javafx.fxml.FXML
    private Button submitButton;
    @javafx.fxml.FXML
    private TextField passportNoField;
    @javafx.fxml.FXML
    private ComboBox docTypeComboBox;
    @javafx.fxml.FXML
    private TextField nameField;
    @javafx.fxml.FXML
    private Label idFileLabel;
    @javafx.fxml.FXML
    private Button uploadDocButton;
    @javafx.fxml.FXML
    private Label docFileLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void uploadIDproofOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void docTypeOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void uploadDocOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handlesubmit(ActionEvent actionEvent) {
    }
    @javafx.fxml.FXML
    private void handleBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getclass().getsource("CitizenDashboard.fxml"));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}