package org.example.embassyoperations.HRManager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.embassyoperations.ConsularOfficer.ConsularOfficer;
import org.example.embassyoperations.Employee;
import org.example.embassyoperations.User;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class HRManager extends Employee implements Serializable {

    public HRManager(String name, String nid, String email, String address, String password, String usertype, String phoneNo, LocalDate dob) {
        super(name, nid, email, address, password, usertype, phoneNo, dob);
    }

    @Override
    public String toString() {
        return "HRManager " + "\n"+ super.toString();
    }

    //id is 5 digit
     private String generateId(){
        Random r = new Random();
        int id = r.nextInt(10000, 99999);
        String str = Integer.toString(id);
        return str;
    }

    public HRManager login(String id, String password){
        if(Objects.equals(id, this.getId()) && Objects.equals(password, this.getPassword())){
            return this;
        }
        return null;
    }

    void submitMaintenanceRequest(MaintenanceRequest maintenanceRequest){
        MaintenanceRequest.writeMaintenanceRequestInfo(maintenanceRequest);
    }

    void assignTask(Task task){
        Task.writeTaskInfo(task);
    }

    void sendAnnouncementToAllEmployees(Announcement announcement){
        Announcement.writeAnnouncementInfo(announcement);
    }

    String viewEmployeeDirectory(User user){
        return user.toString();
    }

}
