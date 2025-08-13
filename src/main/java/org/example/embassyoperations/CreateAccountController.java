package org.example.embassyoperations;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import org.example.embassyoperations.ConsularOfficer.ConsularOfficer;
import org.example.embassyoperations.HRManager.HRManager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class CreateAccountController
{
    @javafx.fxml.FXML
    private TextField userNameTextField;
    @javafx.fxml.FXML
    private ComboBox<String> userTypeComboBox;
    @javafx.fxml.FXML
    private TextField phoneNoTextField;
    @javafx.fxml.FXML
    private TextField nidTextField;
    @javafx.fxml.FXML
    private TextField emailTextField;
    @javafx.fxml.FXML
    private PasswordField passwordPasswordField;
    @javafx.fxml.FXML
    private TextField passportNoTextField;
    @javafx.fxml.FXML
    private TextArea addressTextArea;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void createAccountButtonOnAction(ActionEvent actionEvent) {
        ConsularOfficer newOfficer1 = new ConsularOfficer("Ariba","12345","r@gmail.com","Dhaka","pass12", "Consular Officer", "017069", LocalDate.of(2003,10,9));
        ConsularOfficer newOfficer2 = new ConsularOfficer("Bushra","6789","b@gmail.com","Dhaka","pass13", "Consular Officer", "017111", LocalDate.of(2003,10,9));
        writeConsularOfficer(newOfficer1);
        writeUser(newOfficer1);
        writeConsularOfficer(newOfficer2);
        writeUser(newOfficer2);
        writeUser2(newOfficer1);
        writeUser2(newOfficer2);

        HRManager Officer1 = new HRManager("Rinvil","55669","s@gmail.com","Dhaka","pass2", "HR Manager", "019069", LocalDate.of(2003,10,9));
        HRManager Officer2 = new HRManager("Faiza","69874","f@gmail.com","Dhaka","pass1", "HR Manager", "019069", LocalDate.of(2003,10,9));
        writeHRManager(Officer1);
        writeUser(Officer1);
        writeHRManager(Officer2);
        writeUser(Officer2);
        writeUser2(Officer1);
        writeUser2(Officer2);

    }

    public void writeUser(User user) {
        File f = null;
        FileWriter fw = null;

        try {
            f = new File("User.txt");
            if (f.exists()) {
                fw = new FileWriter(f, true);
            } else {
                fw = new FileWriter(f);
            }
            fw.write(user.getId() + "," + user.getName() + "," + user.getPassword() + "," + user.getUsertype() + "\n");
        } catch (Exception e) {
            //
        } finally {
            try {
                if (fw != null) {
                    fw.close(); //
                }
            } catch (Exception e) {
            }
        }
    }

    public void writeUser2(User user){
        File f = new File("User.bin");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try{
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(user);
            oos.close();
        }catch(Exception e){
            //
        }
    }

    public void writeConsularOfficer(ConsularOfficer consularOfficer) {
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("ConsularOfficer.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(consularOfficer);
        } catch (Exception e) {
           //
        } finally {
            try {
                if (oos != null) oos.close();
                if (fos != null) fos.close();
            } catch (Exception e) {
                //
            }
        }
    }

    public void writeHRManager(HRManager hrManager) {
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("HRManager.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(hrManager);
        } catch (Exception e) {
            //
        } finally {
            try {
                if (oos != null) oos.close();
                if (fos != null) fos.close();
            } catch (Exception e) {
                //
            }
        }
    }
}