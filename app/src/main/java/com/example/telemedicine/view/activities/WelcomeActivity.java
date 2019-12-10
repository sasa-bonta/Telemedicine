package com.example.telemedicine.view.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.telemedicine.R;

public class WelcomeActivity extends AppCompatActivity {

    private Button signUpButton;
    private RelativeLayout loginButton;
    private TextView urgentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

    }

    @Override
    protected void onResume() {
        super.onResume();
        signUpButton = findViewById(R.id.welcome_button_sign_up);
        loginButton = findViewById(R.id.welcome_button_login);
        urgentButton = findViewById(R.id.welcome_button_urgent);

        signUpButton.setOnClickListener(view ->
                startActivity(new Intent(this, SignUpActivity.class)));
        urgentButton.setOnClickListener(view -> {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        });
        loginButton.setOnClickListener(view ->
                startActivity(new Intent(this, LoginActivity.class)));
    }

}
