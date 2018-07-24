package com.chain.volleyapp;

//contains users attributes

public class User {
    private  String password;
    private  String regNo;

    public User() {
    }

    public User(String password, String regNo) {
        this.password = password;
        this.regNo = regNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }
}
