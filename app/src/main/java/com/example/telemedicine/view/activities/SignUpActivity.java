package com.example.telemedicine.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.telemedicine.R;
import java.util.Arrays;
import java.util.Base64;

public class SignUpActivity extends AppCompatActivity {

    private EditText fullName, birthday, email, phone, address, username, password;
    private Toolbar toolbar;
    private TextView toolbarTitle;
    private Button registerUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setSupportActionBar(toolbar);
        referenceViews();

        toolbarTitle.setText(R.string.sign_up);

        FrameLayout back = findViewById(R.id.sign_up_action_bar_back);
        back.setOnClickListener(view -> finish());
    }

    private void referenceViews() {
        username = findViewById(R.id.sign_up_username_edit);
        password = findViewById(R.id.sign_up_password_edit);
        toolbar = findViewById(R.id.sign_up_toolbar);
        toolbarTitle = findViewById(R.id.sign_up_action_bar_title);
        registerUser = findViewById(R.id.sign_up_register_user);
        fullName = findViewById(R.id.sign_up_full_name_edit);
        birthday = findViewById(R.id.sign_up_birthday_edit);
        email = findViewById(R.id.sign_up_email_edit);
        phone = findViewById(R.id.sign_up_phone_edit);
        address = findViewById(R.id.sign_up_address_edit);
    }


}
