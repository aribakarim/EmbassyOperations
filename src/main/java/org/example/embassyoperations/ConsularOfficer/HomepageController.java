package org.example.embassyoperations.ConsularOfficer;

import javafx.scene.control.Label;

public class HomepageController
{
    @javafx.fxml.FXML
    private Label outputLabel;


    @javafx.fxml.FXML
    public void initialize() {
    }

    public void labelTitle(ConsularOfficer consularOfficer){
        outputLabel.setText("Welcome "+consularOfficer.getName()+"!");
    }
}