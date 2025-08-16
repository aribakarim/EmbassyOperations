package org.example.embassyoperations.Visitor;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ApplyVisaControllerController
{
    @javafx.fxml.FXML
    private Label visaPurposeLabel;
    @javafx.fxml.FXML
    private Button submitButton;
    @javafx.fxml.FXML
    private ComboBox visaTypeBox;
    @javafx.fxml.FXML
    private TextField nameField;
    @javafx.fxml.FXML
    private Label durationLabel;
    @javafx.fxml.FXML
    private AnchorPane visaApplicationText;
    @javafx.fxml.FXML
    private TextField passportNoField;
    @javafx.fxml.FXML
    private Button clearButton;
    @javafx.fxml.FXML
    private TextField purposeOfVisaField;
    @javafx.fxml.FXML
    private Label visaApplicationLabel;
    @javafx.fxml.FXML
    private Label passportNumberField;
    @javafx.fxml.FXML
    private TextField durationField;
    @javafx.fxml.FXML
    private Label visaTypeLabel;
    @javafx.fxml.FXML
    private TextField nationalityField;
    @javafx.fxml.FXML
    private Label fullNameLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void CancelOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void submitOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    private void goBackToDashboard(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getclass().getsource("VisitorDashboard.fxml"));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}