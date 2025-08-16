package org.example.embassyoperations.Visitor;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CancelVisaApplicationController {
    @javafx.fxml.FXML
    private DatePicker cancellationDatePicker;
    @javafx.fxml.FXML
    private Button cancelButton;
    @javafx.fxml.FXML
    private TextField applicationidField;
    @javafx.fxml.FXML
    private Button backButton;
    @javafx.fxml.FXML
    private TextArea reasonArea;

    @javafx.fxml.FXML
    public void initialize() {

    }

    @javafx.fxml.FXML
    private void goBackToDashboard(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getclass().getsource("VisitorDashboard.fxml"));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }


}