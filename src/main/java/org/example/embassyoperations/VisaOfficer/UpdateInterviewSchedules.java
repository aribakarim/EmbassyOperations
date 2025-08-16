package org.example.embassyoperations;

import java.time.LocalDate;

public class UpdateInterviewSchedules {
    private String Name,PassportNumber;
    private LocalDate Date;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "UpdateInterviewSchedules{" +
                "Name='" + Name + '\'' +
                ", PassportNumber='" + PassportNumber + '\'' +
                ", Date=" + Date +
                '}';
    }

    public String getPassportNumber() {
        return PassportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        PassportNumber = passportNumber;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        Date = date;
    }

    public UpdateInterviewSchedules(String name, String passportNumber, LocalDate date) {
        Name = name;
        PassportNumber = passportNumber;
        Date = date;
    }
}
