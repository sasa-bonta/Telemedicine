package com.example.telemedicine.view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.telemedicine.R;

public class LoginActivity extends AppCompatActivity {

    private TextView signUp;
    private Button login;
    private EditText emailField, passwordField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        signUp = findViewById(R.id.login_sign_up_button);
        login = findViewById(R.id.login_button);
        emailField = findViewById(R.id.login_email_edit);
        passwordField = findViewById(R.id.login_password_edit);
    }

    @Override
    protected void onResume() {
        super.onResume();
        signUp.setOnClickListener(view -> {
            startActivity(new Intent(this, SignUpActivity.class));
            finish();
        });
    }
}
