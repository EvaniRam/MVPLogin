package com.evani.techmtest.presenters;

import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;

import com.evani.techmtest.model.ILogin;
import com.evani.techmtest.model.LoginModel;
import com.evani.techmtest.view.ILoginView;



public class LoginPresenter implements ILoginPresenter {
    ILoginView iLoginView;
    ILogin model;
    Handler handler;

    public LoginPresenter(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
        handler = new Handler(Looper.getMainLooper());
        initModel();
    }


    @Override
    public void login(String userName, String password) {
        Boolean isLoginSuccess = true;
        final int code = model.checkValidity(userName,password);
        if (code!=0) isLoginSuccess = false;
        final Boolean result = isLoginSuccess;

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                iLoginView.onLoginResult(result, code);
            }
        }, 2000);
    }

    private void initModel(){
        model = new LoginModel("test","test");
    }
}
