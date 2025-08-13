package org.example.embassyoperations;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

import java.time.LocalDate;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
//        User u = new User("Ariba","2311","11a","r@gmail.com","abc","pa123", "user","01236", LocalDate.of(2002,7,7),LocalDate.now());
//        Alert alert = new Alert(Alert.AlertType.ERROR);
//        if(u.validateNID(u.getNid())){
//            alert.setContentText("Invalid NID");
//            alert.showAndWait();
//        }
    }
}