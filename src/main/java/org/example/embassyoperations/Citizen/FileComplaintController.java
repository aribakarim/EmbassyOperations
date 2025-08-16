package org.example.embassyoperations.Citizen;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FileComplaintController
{
    @javafx.fxml.FXML
    private Button cancelButton;
    @javafx.fxml.FXML
    private Button submitButton;
    @javafx.fxml.FXML
    private TextArea descriptionArea;
    @javafx.fxml.FXML
    private AnchorPane chooseFileButton;
    @javafx.fxml.FXML
    private ComboBox complaintTypeCombo;
    @javafx.fxml.FXML
    private TextField subjectField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void complainttypeOnAction(ActionEvent actionEvent) {
    }


    @javafx.fxml.FXML
    private void handleBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getclass().getsource("CitizenDashboard.fxml"));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}