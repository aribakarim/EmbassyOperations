package org.example.embassyoperations.Citizen;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class EmargencyAssistanceController
{
    @javafx.fxml.FXML
    private Button submitButton;
    @javafx.fxml.FXML
    private Button clearButton;
    @javafx.fxml.FXML
    private TextField nameField;
    @javafx.fxml.FXML
    private TextField passportNumberField;
    @javafx.fxml.FXML
    private ComboBox emargencytypeCombo;
    @javafx.fxml.FXML
    private TextArea emargencyDetailsArea;
    @javafx.fxml.FXML
    private TextField contactNumberField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void clearOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handelEmargencyType(ActionEvent actionEvent) {
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