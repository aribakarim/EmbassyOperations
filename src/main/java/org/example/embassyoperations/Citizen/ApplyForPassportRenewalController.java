package org.example.embassyoperations.Citizen;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.IOException;

public class ApplyForPassportRenewalController
{
    @javafx.fxml.FXML
    private Text fullNameText;
    @javafx.fxml.FXML
    private Button submitButton;
    @javafx.fxml.FXML
    private Label passportRenewalLabel;
    @javafx.fxml.FXML
    private Button uploadPhotoButton;
    @javafx.fxml.FXML
    private TextField fullNameTextField;
    @javafx.fxml.FXML
    private Text expiryDateTextField;
    @javafx.fxml.FXML
    private Button uploadDocsButton;
    @javafx.fxml.FXML
    private DatePicker expiryDateDatePicker;
    @javafx.fxml.FXML
    private Text passportNOTextField;

    @javafx.fxml.FXML
    public void initialize() {
        System.out.println("ApplyForPassportRenewalController initialize.");
    }

    @javafx.fxml.FXML
    public void handelExpiryDate(ActionEvent actionEvent) {
        if(expiryDateDatePicker.getValue() !=null){
            System.out.println("Expiry Date selected:"+expiryDateDatePicker.getValue());
        }
    }

    @javafx.fxml.FXML
    public void handelfullName(ActionEvent actionEvent) {
        String name = fullNameTextField.getText();
        System.out.println("Full name entered : "+name);
    }

    @javafx.fxml.FXML
    public void handelUploadPhoto(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        uploadPhoto = fileChooser.showOpenDialog(new Stage());

        if(uploadPhoto != null){
            System.out.println("Photo upload :"+ uploadPhoto.getAbsolutePath());
        }
    }

    @javafx.fxml.FXML
    public void handelUploadDocuments(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        uploadedDocuments = fileChooser. showOpenDialog(new Stage());

        if(uploadedDocuments !=null){
            System.out.println("Documents uploaded :"+ uploadedDocuments.getAbsolutPath());
        }
    }

    @javafx.fxml.FXML
    public void handelSubmitApplication(ActionEvent actionEvent) {
        String name = fullNameTextField.getText();
        String expiryDate = (expiryDateDatePicker.getValue( !=null)) ? expiryDateDatePicker.getValue().toString(): "Not Selected";

        System.out.println("=== Passport Renewal Application Submitted ===");
        System.out.println("Full Name:" +name);
        System.out.println("Expiry Date:"+ expiryDate);
        System.out.println("Photo:"+(uploadedPhoto !=null ? uploadedPhoto.getName(): "Not Uploaded"));
    }

    @javafx.fxml.FXML
    private void handleBack(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getclass().getsource("CitizenDashboard.fxml"));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

}