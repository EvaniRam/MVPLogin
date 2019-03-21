package com.evani.techmtest.model;

import java.util.ArrayList;
import java.util.List;

public class LoginModel implements ILogin{

    String userName;
    String password;

    public  LoginModel(String userName , String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public int checkValidity(String userName, String password) {

        if (null != userName || null != password || !userName.isEmpty() ||!password.isEmpty()
            || !userName.equalsIgnoreCase(userName) || !password.equalsIgnoreCase(password)) {
            return 0;
        }

        return -1;
    }



}
