package org.example.embassyoperations.Visitor;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class VisitorDashboardController{
    @javafx.fxml.FXML
    private Button appointmentBookButton;
    @javafx.fxml.FXML
    private Button applyVisaButton;
    @javafx.fxml.FXML
    private Button downloadApplicationButton;
    @javafx.fxml.FXML
    private Button urgentProcessingButton;
    @javafx.fxml.FXML
    private Button submitDocsButton;
    @javafx.fxml.FXML
    private Button trackApplicationButton;
    @javafx.fxml.FXML
    private Button askQuestionButton;
    @javafx.fxml.FXML
    private Button cancelApplicationButton;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void DownloadApplicationOnAction(ActionEvent actionEvent) throws IOException {
        switchScene(event, "/fxml/DownloadVisaApplication.fxml" );
    }

    @javafx.fxml.FXML
    public void cancelApplicationOnAction(ActionEvent actionEvent) throws IOException{
        switchScene(event, "/fxml/CancelVisaApplication.fxml");
    }

    @javafx.fxml.FXML
    public void applyVisaOnAction(ActionEvent actionEvent) throws IOException{
        switchScene(event, "/fxml/ApplyVisa.fxml");
    }

    @javafx.fxml.FXML
    public void bookAppointmentOnAction(ActionEvent actionEvent) throws IOException{
        switchScene(event, "/fxml/BookAppointment.fxml");
    }

    @javafx.fxml.FXML
    public void askQuestionOnAction(ActionEvent actionEvent) throws IOException {
        switchScene(event,"/fxml/AskQuestion.fxml");
    }

    @javafx.fxml.FXML
    public void urgentProcessingOnAction(ActionEvent actionEvent) throws IOException {
        switchScene(event,"/fxml/UrgentProcessing.fxml");
    }

    @javafx.fxml.FXML
    public void trackApplicationOnAction(ActionEvent actionEvent)throws IOException {
        switchScene(event, "/fxml/TrackVisaApplication.fxml");
    }

    @javafx.fxml.FXML
    public void submitdocsOnAction(ActionEvent actionEvent) throws IOException{
        switchScene(event, "/fxml/SubmitAdditionalDocuments.fxml");
    }
    @javafx.fxml.FXML
    private void switchScene(ActionEvent event, String fxmlFile){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) ((Node)event. getSource()).getScene(). getWindow();
            Stage.setScene(scene);
            stage.show()
        }catch (IOException e){
            e.printStackTrace();
        }


    }
}