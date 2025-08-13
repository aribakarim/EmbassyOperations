package org.example.embassyoperations.HRManager;

import javafx.scene.control.Label;
import org.example.embassyoperations.ConsularOfficer.ConsularOfficer;

public class HomepageHRController
{
    @javafx.fxml.FXML
    private Label outputLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    public void labelTitle(HRManager hrManager){
        outputLabel.setText("Welcome "+hrManager.getName()+"!");
    }
}