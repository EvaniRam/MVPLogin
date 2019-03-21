package com.evani.techmtest.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.evani.techmtest.R;
import com.evani.techmtest.presenters.ILoginPresenter;
import com.evani.techmtest.presenters.LoginPresenter;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity implements ILoginView , View.OnClickListener {

    private EditText userName;
    private EditText password;
    private Button btnLogin;

    //presenter reference
    private ILoginPresenter loginPresenter;

    List<String> data = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //finding views
        userName = (EditText) findViewById(R.id.userName);
        password = (EditText) findViewById(R.id.password);
        btnLogin = (Button) findViewById(R.id.button);

        //register listerner
        btnLogin.setOnClickListener(this);

        //initialising Presenter
        loginPresenter = new LoginPresenter(this);

        data = new ArrayList<>();

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button :
                loginPresenter.login(userName.getText().toString(),password.getText().toString());
                break;
        }
    }

    @Override
    public void onLoginResult(Boolean result, int code) {
        btnLogin.setEnabled(true);
        if (result){
            Toast.makeText(this,"Login Success", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this,MyRecyclerListActivity.class);
            startActivity(intent);

        }
        else
            Toast.makeText(this,"Login Fail, code = " + code,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
