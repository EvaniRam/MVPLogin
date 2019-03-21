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
            || !userName.equals(getUserName()) || !password.equals(getPassword())) {
            return -1;
        }

        return 0;
    }

    @Override
    public List<String> displayData() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20 ; i++) {
            list.add(" Sample "+i);
        }
        return list;
    }


}
