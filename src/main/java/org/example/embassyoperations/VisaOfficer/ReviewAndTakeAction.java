package org.example.embassyoperations;

import java.time.LocalDate;

public class ReviewAndTakeAction {
    private String Name,PassportNumber,VisaType,Reason;
    private LocalDate DateOfFlagged;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "ReviewAndTakeAction{" +
                "Name='" + Name + '\'' +
                ", PassportNumber='" + PassportNumber + '\'' +
                ", VisaType='" + VisaType + '\'' +
                ", Reason='" + Reason + '\'' +
                ", DateOfFlagged=" + DateOfFlagged +
                '}';
    }

    public String getPassportNumber() {
        return PassportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        PassportNumber = passportNumber;
    }

    public String getVisaType() {
        return VisaType;
    }

    public void setVisaType(String visaType) {
        VisaType = visaType;
    }

    public String getReason() {
        return Reason;
    }

    public void setReason(String reason) {
        Reason = reason;
    }

    public LocalDate getDateOfFlagged() {
        return DateOfFlagged;
    }

    public void setDateOfFlagged(LocalDate dateOfFlagged) {
        DateOfFlagged = dateOfFlagged;
    }

    public ReviewAndTakeAction(String name, String passportNumber, String visaType, String reason, LocalDate dateOfFlagged) {
        Name = name;
        PassportNumber = passportNumber;
        VisaType = visaType;
        Reason = reason;
        DateOfFlagged = dateOfFlagged;
    }
}
