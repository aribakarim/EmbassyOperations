package org.example.embassyoperations.HRManager;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class CalendarCreateEventViewController
{
    @javafx.fxml.FXML
    private ComboBox<String> eventTimeComboBox;
    @javafx.fxml.FXML
    private DatePicker eventDateDatePicker;
    @javafx.fxml.FXML
    private TextField eventTextField;

    @javafx.fxml.FXML
    public void initialize() {
        eventTimeComboBox.getItems().addAll("10AM","11AM","12PM","1PM","2PM","3PM","4PM","5PM","6PM","7PM","8PM","N/A");
    }

    @javafx.fxml.FXML
    public void createEventButtonOnAction(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        if(eventTextField.getText().isEmpty()){
            alert.setTitle("Invalid Event");
            alert.setContentText("Please enter event");
            alert.showAndWait();
            return;
        }
        if(eventTimeComboBox.getValue()==null){
            alert.setTitle("Invalid Event Time");
            alert.setContentText("Please select event time");
            alert.showAndWait();
            return;
        }
        if(eventDateDatePicker.getValue()==null){
            alert.setTitle("Invalid Event Date");
            alert.setContentText("Please select event date");
            alert.showAndWait();
            return;
        }
        Calendar c = new Calendar(eventTextField.getText(),eventTimeComboBox.getValue(),eventDateDatePicker.getValue());
        Calendar.writeCalendarInfo(c);
        Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
        alert2.setTitle("Confirmation");
        alert2.setTitle("Event created successfully");
        alert2.showAndWait();
        eventDateDatePicker.setValue(null);
        eventTextField.clear();
        eventTimeComboBox.setValue("");
    }
}