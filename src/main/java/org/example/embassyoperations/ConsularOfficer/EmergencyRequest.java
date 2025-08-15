package org.example.embassyoperations.ConsularOfficer;

import org.example.embassyoperations.AppendableObjectOutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Random;

public class EmergencyRequest implements Serializable {
    private String requestId, applicantId, emergencyType, details,status,ppNo;
    private LocalDate dateOfRequest;

    public EmergencyRequest(String applicantId, String emergencyType, String details,String ppNo) {
        this.requestId = generateId();
        this.applicantId = applicantId;
        this.emergencyType = emergencyType;
        this.details = details;
        this.status = "Pending";
        this.dateOfRequest = LocalDate.now();
        this.ppNo = ppNo;
    }

    public String getPpNo() {
        return ppNo;
    }

    public void setPpNo(String ppNo) {
        this.ppNo = ppNo;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(String applicantId) {
        this.applicantId = applicantId;
    }

    public String getEmergencyType() {
        return emergencyType;
    }

    public void setEmergencyType(String emergencyType) {
        this.emergencyType = emergencyType;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDateOfRequest() {
        return dateOfRequest;
    }

    public void setDateOfRequest(LocalDate dateOfRequest) {
        this.dateOfRequest = dateOfRequest;
    }

    @Override
    public String toString() {
        return "Request Id: " + requestId + '\n' +
                "Applicant Id: " + applicantId + '\n' +
                "Passport No: " + ppNo + '\n' +
                "Emergency Type: " + emergencyType + '\n' +
                "Details: " + details + '\n' +
                "Status: " + status + '\n' +
                "Date Of Request: " + dateOfRequest ;
    }

    private String generateId(){
        Random r = new Random();
        int id = r.nextInt(100000, 999999);
        String str = Integer.toString(id);
        return str;
    }

    static void writeEmergencyRequest(EmergencyRequest p){
        File f = new File("EmergencyRequestInfo.bin");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            if(f.exists()){
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(p);
            oos.close();
        }catch(Exception e){
            //
        }
    }
}
