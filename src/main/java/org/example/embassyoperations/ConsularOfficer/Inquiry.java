package org.example.embassyoperations.ConsularOfficer;

import org.example.embassyoperations.AppendableObjectOutputStream;
import org.example.embassyoperations.HRManager.Announcement;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Random;

public class Inquiry implements Serializable {
    private String inquiryID, applicantID, inquiryDetails, status,response;
    private LocalDate inquiryDate;

    public Inquiry(String applicantID,String inquiryDetails) {
        this.inquiryID = generateID();
        this.applicantID = applicantID;
        this.inquiryDate = LocalDate.now();
        this.inquiryDetails = inquiryDetails;
        this.status = "Pending";
        this.response = "N/A";
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInquiryID() {
        return inquiryID;
    }

    public void setInquiryID(String inquiryID) {
        this.inquiryID = inquiryID;
    }

    public String getApplicantID() {
        return applicantID;
    }

    public void setApplicantID(String applicantID) {
        this.applicantID = applicantID;
    }

    public String getInquiryDetails() {
        return inquiryDetails;
    }

    public void setInquiryDetails(String inquiryDetails) {
        this.inquiryDetails = inquiryDetails;
    }

    public LocalDate getInquiryDate() {
        return inquiryDate;
    }

    public void setInquiryDate(LocalDate inquiryDate) {
        this.inquiryDate = inquiryDate;
    }

    @Override
    public String toString() {
        return "Inquiry Detail" + '\n' +
                "Inquiry ID : " + inquiryID + '\n' +
                "Applicant ID : " + applicantID + '\n' +
                "Inquiry Status : " + status + '\n' +
                "Inquiry Details : " + inquiryDetails + '\n' +
                "Inquiry Submission Date : " + inquiryDate ;
    }

    private String generateID(){
        Random r = new Random();
        int num = r.nextInt(10000,999999);
        String str = Integer.toString(num);
        return str;
    }

     static void writeInquiryInfo(Inquiry inquiry){
        File f = new File("InquiryInfo.bin");
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
            oos.writeObject(inquiry);
            oos.close();
        }catch(Exception e){
            //
        }
    }
}
