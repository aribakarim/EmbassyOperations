package org.example.embassyoperations;

import java.time.LocalDate;

public class MannuallyUpdateApplication {
    private String Name,PassportNumber,ApplicationStatus;
    private LocalDate Date;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "MannuallyUpdateApplication{" +
                "Name='" + Name + '\'' +
                ", PassportNumber='" + PassportNumber + '\'' +
                ", ApplicationStatus='" + ApplicationStatus + '\'' +
                ", Date=" + Date +
                '}';
    }

    public String getPassportNumber() {
        return PassportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        PassportNumber = passportNumber;
    }

    public String getApplicationStatus() {
        return ApplicationStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        ApplicationStatus = applicationStatus;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        Date = date;
    }

    public MannuallyUpdateApplication(String name, String passportNumber, String applicationStatus, LocalDate date) {
        Name = name;
        PassportNumber = passportNumber;
        ApplicationStatus = applicationStatus;
        Date = date;
    }
}
