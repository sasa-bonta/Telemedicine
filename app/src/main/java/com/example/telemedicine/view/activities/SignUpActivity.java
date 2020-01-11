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
import com.example.telemedicine.model.ServerResponse;
import com.example.telemedicine.model.UnregisteredUser;
import com.example.telemedicine.viewModel.RegisterViewModel;

import java.util.Arrays;
import java.util.Base64;

public class SignUpActivity extends AppCompatActivity {

    private EditText fullName, birthday, email, phone, address, username, password;
    private Toolbar toolbar;
    private TextView toolbarTitle;
    private Button registerUser;
    private RegisterViewModel registerViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setSupportActionBar(toolbar);
        referenceViews();

        toolbarTitle.setText(R.string.sign_up);
        registerViewModel = ViewModelProviders.of(this).get(RegisterViewModel.class);
        FrameLayout back = findViewById(R.id.sign_up_action_bar_back);
        back.setOnClickListener(view -> finish());
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerUser.setOnClickListener(view -> registerNewUser());
        LiveData<ServerResponse> userLiveData = registerViewModel.getUnregisteredUserLiveData();
        userLiveData.observe(this, response -> {
            Log.d("LiveData", "onResume: "
                    + response.getResponseStatus() + "\n" + response.getResponseToken());
        });
    }

    @SuppressLint("NewApi")
    private void registerNewUser() {
        String userFullName = fullName.getText().toString();
        String userBirthday = birthday.getText().toString();
        String userEmail = email.getText().toString();
        String userPhone = phone.getText().toString();
        String userAddress = address.getText().toString();
        String userName = username.getText().toString();
        String userPassword = password.getText().toString();
        registerViewModel.makeRegisterRequest(new UnregisteredUser(
                "Andrew Long",
                "1994/12/12",
                "and.long@gmail.com",
                "373798551426",
                "str.Burebista",
                "and.long",
                "longlongAndTest123",
                "L3NkY2FyZC9Eb3dubG9hZC9Ed2F5bmVfSm9obnNvbl8yLF8yMDEzLmpwZw=="));
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
