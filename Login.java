package com.example.instaclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.shashank.sony.fancytoastlib.FancyToast;

public class Login extends AppCompatActivity {

    private EditText etUsernameLogin, etPasswordLogin;
    private Button btnLogin;
    private TextView txtGoSignUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Login");

        etUsernameLogin = findViewById(R.id.etUsernameLogin);
        etPasswordLogin = findViewById(R.id.etPasswordLogin);
        btnLogin = findViewById(R.id.btnLogin);
        txtGoSignUp = findViewById(R.id.txtGoSignUp);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ParseUser.logInInBackground(etUsernameLogin.getText().toString(), etPasswordLogin.getText().toString()
                        , new LogInCallback() {
                            @Override
                            public void done(ParseUser user, ParseException e) {
                                if (user!= null && e == null){
                                    FancyToast.makeText(Login.this, user.get("username") +
                                            " login successfully", FancyToast.LENGTH_LONG,FancyToast.SUCCESS,
                                            true).show();
                                } else {
                                    FancyToast.makeText(Login.this,e.getMessage(),
                                            FancyToast.LENGTH_LONG,FancyToast.ERROR,true);
                                }
                            }
                        });
            }
        });

        txtGoSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}