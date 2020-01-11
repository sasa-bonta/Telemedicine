package com.example.telemedicine.view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProviders;

import com.example.telemedicine.R;
import com.example.telemedicine.model.RegisteredUser;
import com.example.telemedicine.model.ServerResponse;
import com.example.telemedicine.viewModel.LoginViewModel;

public class LoginActivity extends AppCompatActivity {

    private TextView signUp;
    private Button login;
    private EditText emailField, passwordField;
    private LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        referenceViews();
        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
    }

    @Override
    protected void onResume() {
        super.onResume();
        LiveData<ServerResponse> responseLiveData = loginViewModel.getRegisteredUserLiveData();
        responseLiveData.observe(this, response -> {

        });
        signUp.setOnClickListener(view -> {
            startActivity(new Intent(this, SignUpActivity.class));
            finish();
        });
        login.setOnClickListener(view -> {
            loginUser();
        });
    }

    private void loginUser() {
        String email = emailField.getText().toString();
        String password = passwordField.getText().toString();
        RegisteredUser user = new RegisteredUser(email, password);
        loginViewModel.makeAuthenticationRequest(user);
    }

    private void referenceViews() {
        signUp = findViewById(R.id.login_sign_up_button);
        login = findViewById(R.id.login_button);
        emailField = findViewById(R.id.login_email_edit);
        passwordField = findViewById(R.id.login_password_edit);
    }
}
