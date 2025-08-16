package org.example.embassyoperations;


import java.io.Serializable;
import java.time.LocalDate;

public abstract class User implements Serializable {
    String name, id, nid, email, address, password, usertype, phoneNo;
    LocalDate dob;


    public User(String name, String nid, String email, String address, String password, String usertype, String phoneNo, LocalDate dob) {
        this.name = name;
        this.id = this.generateId();
        this.nid = nid;
        this.email = email;
        this.address = address;
        this.password = password;
        this.usertype = usertype;
        this.phoneNo = phoneNo;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }



    @Override
    public String toString() {
        return
                "Name = " + name + '\n' +
                "Id = " + id + '\n' +
                "Nid = " + nid + '\n' +
                "Email = " + email + '\n' +
                "Address = " + address + '\n' +
                "Password = " + password + '\n' +
                "Designation = " + usertype + '\n' +
                "PhoneNo = " + phoneNo + '\n' +
                "Date of birth = " + dob ;
    }


    abstract String generateId();

    public abstract User login(String id, String password);

}

