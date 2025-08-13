package org.example.embassyoperations.HRManager;

import org.example.embassyoperations.AppendableObjectOutputStream;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class MaintenanceRequest implements Serializable{
    private String requestId, employeeId, issueDescription, status;
    private LocalDate requestDate;

    public MaintenanceRequest(String employeeId, String issueDescription) {
        this.requestId = generateId();
        this.employeeId = employeeId;
        this.issueDescription = issueDescription;
        this.status = "Pending";
        this.requestDate = LocalDate.now();
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    @Override
    public String toString() {
        return "MaintenanceRequest{" +
                "requestId='" + requestId + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", issueDescription='" + issueDescription + '\'' +
                ", status='" + status + '\'' +
                ", requestDate=" + requestDate +
                '}';
    }

    private String generateId(){
        Random r = new Random();
        int id = r.nextInt(100000, 999999);
        String str = Integer.toString(id);
        return str;
    }

    public static void writeMaintenanceRequestInfo(MaintenanceRequest maintenanceRequest){
        File f = new File("MaintenanceRequestInfo.bin");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);
                System.out.println("Existing file");
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
                System.out.println("New file");
            }
            oos.writeObject(maintenanceRequest);
            oos.close();
        }catch(Exception e){
            //
        }

    }

}
