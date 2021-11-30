package com.example.pfotenfreunde.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pfotenfreunde.R;
import com.example.pfotenfreunde.ui.ladingpage.LadingPageActivity;
import com.example.pfotenfreunde.ui.signup.SignUpActivity;

public class LoginActivity extends AppCompatActivity implements View.OnFocusChangeListener, View.OnClickListener {

    public EditText textUsername;
    public EditText textPassword;
    public Button loginButton;
    public Button signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        textUsername = findViewById(R.id.textUsername);
        textPassword = findViewById(R.id.textPassword);
        loginButton = findViewById(R.id.loginButton);
        signUpButton = findViewById(R.id.signUpButton);
        loginButton.setOnClickListener(this);
        signUpButton.setOnClickListener(this);
        textUsername.setOnFocusChangeListener(this);
        textPassword.setOnFocusChangeListener(this);
    }


    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (v == textPassword) {
            if (hasFocus) {
                textPassword.setText(R.string.empty);
                textPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                textPassword.setTextColor(getResources().getColor(R.color.black));

            }
        }
        if (v == textUsername) {
            if (hasFocus) {
                textUsername.setText(R.string.empty);
                textUsername.setTextColor(getResources().getColor(R.color.black));
            }
        }
    }

    @Override
    public void onClick(View v) {
        if(v == signUpButton){
            Intent next = new Intent(this,SignUpActivity.class);
            startActivity(next);
        }
        if(v == loginButton){
            if(textUsername.getText().length() > 5){
                if (textPassword.getText().length() > 5){
                    Intent next = new Intent(this, LadingPageActivity.class);
                    startActivity(next);
                }
            }
        }
    }
}