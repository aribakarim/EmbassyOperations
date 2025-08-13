package org.example.embassyoperations.ConsularOfficer;

import org.example.embassyoperations.AppendableObjectOutputStream;

import java.io.*;
import java.time.LocalDate;
import java.util.Random;

public class LeaveRequest implements Serializable{
    private String requestId, employeeId,designation,reason,status;
    private LocalDate startDate, endDate;

    public LeaveRequest(String employeeId, String designation, String reason, LocalDate startDate, LocalDate endDate) {
        this.requestId = generateID();
        this.employeeId = employeeId;
        this.designation = designation;
        this.reason = reason;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = "Pending";
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

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "LeaveRequest{" +
                "requestId='" + requestId + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", designation='" + designation + '\'' +
                ", reason='" + reason + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }

    private String generateID(){
        Random r = new Random();
        int num = r.nextInt(100000, 999999);
        String str = Integer.toString(num);
        return str;
    }

    static void writeLeaveRequest(LeaveRequest request){
        File f = new File("LeaveRequestInfo.bin");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(request);
            oos.close();
        }catch(Exception e){
            //
        }
    }
}
