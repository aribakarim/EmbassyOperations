package org.example.embassyoperations.Visitor;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class UrgentProcessing
{
    @javafx.fxml.FXML
    private ComboBox priorityComboBox;
    @javafx.fxml.FXML
    private Button cancelButton;
    @javafx.fxml.FXML
    private Button submitButton;
    @javafx.fxml.FXML
    private Label uploadDocLabel;
    @javafx.fxml.FXML
    private TextField applicationNumberField;
    @javafx.fxml.FXML
    private TextArea reasonArea;
    @javafx.fxml.FXML
    private Button uploadDocButton;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void submitOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void cancelOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    private void goBackToDashboard(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getclass().getsource("VisitorDashboard.fxml"));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}