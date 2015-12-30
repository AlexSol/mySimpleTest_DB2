package com.company;

public class MyUser {
    public MyUser(){}
    public MyUser(String name, String pass){
        this.name = name;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    private String name = " ";
    private String pass = " ";
}
