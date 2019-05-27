package com.sarnobatvipul0211.profileapp;

/**
 * Created by sarno on 28-05-2019.
 */

public class Data {

    private String name,mobileno,emailid;

    public Data(String name, String mobileno, String emailid) {
        this.setName(name);
        this.setMobileno(mobileno);
        this.setEmailid(emailid);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }
}
