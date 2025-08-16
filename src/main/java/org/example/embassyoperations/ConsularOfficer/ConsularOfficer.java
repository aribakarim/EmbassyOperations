package org.example.embassyoperations.ConsularOfficer;

import org.example.embassyoperations.Employee;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class ConsularOfficer extends Employee implements Serializable {


    public ConsularOfficer(String name, String nid, String email, String address, String password, String usertype, String phoneNo, LocalDate dob) {
        super(name, nid, email, address, password, usertype, phoneNo, dob);
    }


    @Override
    public String toString() {
        return "Consular Officer" + "\n" +super.toString() ;
    }

    //id is 6 digit
    private String generateId(){
        Random r = new Random();
        int id = r.nextInt(100000, 999999);
        String str = Integer.toString(id);
        return str;
    }

    public ConsularOfficer login(String id, String password){
        if(Objects.equals(id, this.getId()) && Objects.equals(password, this.getPassword())){
            return this;
        }
        return null;
    }
}
