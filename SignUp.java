package com.example.instaclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class SignUp extends AppCompatActivity {

    private EditText etEmailSignUp, etUsernameSignUp, etPasswordSignUp;
    private Button btnSignUp;
    private TextView txtGoLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.appbar_name);
        setContentView(R.layout.activity_main);

        etEmailSignUp = findViewById(R.id.etEmailSignUp);
        etUsernameSignUp = findViewById(R.id.etUsernameLogin);
        etPasswordSignUp = findViewById(R.id.etPasswordLogin);
        btnSignUp = findViewById(R.id.btnLogin);
        txtGoLogin = findViewById(R.id.txtGoLogin);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ParseUser appUser = new ParseUser();
                appUser.setEmail(etEmailSignUp.getText().toString());
                appUser.setUsername(etUsernameSignUp.getText().toString());
                appUser.setPassword(etPasswordSignUp.getText().toString());

                appUser.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null){
                            FancyToast.makeText(SignUp.this, appUser.get("username") +
                                            " registered successfully", FancyToast.LENGTH_LONG,FancyToast.SUCCESS,
                                    true).show();
                        } else {
                            FancyToast.makeText(SignUp.this, e.getMessage(), FancyToast.LENGTH_LONG,
                                    FancyToast.ERROR, false).show();
                        }
                    }
                });
            }
        });

        txtGoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp.this, Login.class);
                startActivity(intent);
            }
        });








    }



}