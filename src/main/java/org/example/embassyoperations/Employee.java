package org.example.embassyoperations;

import java.io.Serializable;
import java.time.LocalDate;


public abstract class Employee extends User implements Serializable {

    public Employee(String name, String nid, String email, String address, String password, String usertype, String phoneNo, LocalDate dob) {
        super(name, nid, email, address, password, usertype, phoneNo, dob);
    }

    @Override
    public String toString() {
        return "Employee " + '\n' +
                super.toString();
    }

    public void applyForLeave(){

    }

}
