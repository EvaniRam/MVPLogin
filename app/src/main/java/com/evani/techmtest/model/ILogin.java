package com.evani.techmtest.model;

import java.util.List;

public interface ILogin {

    String getUserName();
    String getPassword();

    int checkValidity(String userName,String password);


}
