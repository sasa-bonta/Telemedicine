package com.example.telemedicine.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.telemedicine.R;

public class SignUpActivity extends AppCompatActivity {

    private EditText fullName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Toolbar toolbar = findViewById(R.id.sign_up_toolbar);
        setSupportActionBar(toolbar);
        TextView toolbarTitle = findViewById(R.id.sign_up_action_bar_title);
        toolbarTitle.setText(R.string.sign_up);

        fullName = findViewById(R.id.sign_up_full_name_edit);
        FrameLayout back = findViewById(R.id.sign_up_action_bar_back);
        back.setOnClickListener(view -> finish());
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
