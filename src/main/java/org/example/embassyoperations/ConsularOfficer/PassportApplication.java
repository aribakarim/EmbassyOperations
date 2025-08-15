package org.example.embassyoperations.ConsularOfficer;

import org.example.embassyoperations.AppendableObjectOutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Random;

public class PassportApplication implements Serializable {
    private String applicationId, name, nid, oldPPNo,status,applicantId,nationality,processedById;
    private LocalDate dateOfApplication;

    public PassportApplication(String name, String nid, String oldPPNo, String applicantId, String nationality) {
        this.applicationId = generateId();
        this.name = name;
        this.nid = nid;
        this.oldPPNo = oldPPNo;
        this.status = "Pending";
        this.applicantId = applicantId;
        this.nationality = nationality;
        this.dateOfApplication = LocalDate.now();
        this.processedById = "N/A";
    }

    public String getProcessedById() {
        return processedById;
    }

    public void setProcessedById(String processedById) {
        this.processedById = processedById;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getOldPPNo() {
        return oldPPNo;
    }

    public void setOldPPNo(String oldPPNo) {
        this.oldPPNo = oldPPNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(String applicantId) {
        this.applicantId = applicantId;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public LocalDate getDateOfApplication() {
        return dateOfApplication;
    }

    public void setDateOfApplication(LocalDate dateOfApplication) {
        this.dateOfApplication = dateOfApplication;
    }

    @Override
    public String toString() {
        return "Application Id: " + applicationId + '\n' +
                "Applicant Name: " + name + '\n' +
                "Applicant Id: " + applicantId + '\n' +
                "Nationality: " + nationality + '\n' +
                "Applicant Nid: " + nid + '\n' +
                "Old Passport No: " + oldPPNo + '\n' +
                "Status: " + status + '\n' +
                "Date Of Application: " + dateOfApplication ;
    }

    private String generateId(){
        Random r = new Random();
        int id = r.nextInt(100000, 999999);
        String str = Integer.toString(id);
        return str;
    }

    static void writePassportApplicationInfo(PassportApplication p){
        File f = new File("PassportApplicationInfo.bin");
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
