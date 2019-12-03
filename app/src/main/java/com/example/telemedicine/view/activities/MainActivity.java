package com.example.telemedicine.view.activities;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.telemedicine.R;
import com.example.telemedicine.view.fragments.HomeFragment;
import com.example.telemedicine.view.fragments.NotificationsFragment;
import com.example.telemedicine.view.fragments.ProfileFragment;
import com.example.telemedicine.view.fragments.ScheduleFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.util.ArrayDeque;

public class MainActivity extends AppCompatActivity {

    private ArrayDeque<Integer> backStack = new ArrayDeque<>();
    private int selectedId = R.id.navigation_home;

    private static final String MENU_KEY = "selected";

    private BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationView = findViewById(R.id.navigation_view);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(MENU_KEY, selectedId);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            selectedId = menuItem.getItemId();
            //setFragment(menuItem.getItemId());
            backStack.remove(menuItem.getItemId());
            backStack.push(menuItem.getItemId());
            setActionBarTitle(menuItem.getItemId());
            return true;
        }
    };

    private Fragment createNewFragment(Integer itemId) {

        switch (itemId) {
            case R.id.navigation_home:
                return HomeFragment.newInstance();
            case R.id.navigation_notifications:
                return NotificationsFragment.newInstance();
            case R.id.navigation_schedule:
                return ScheduleFragment.newInstance();
            case R.id.navigation_profile:
                return ProfileFragment.newInstance();
        }
        return HomeFragment.newInstance();
    }

    private void setActionBarTitle(Integer itemId) {/*
        switch (itemId) {
            case R.id.navigation_home:
                fragmentTitleTextView.setText(getString(R.string.title_home));
                break;
            case R.id.navigation_popular:
                fragmentTitleTextView.setText(getString(R.string.title_notifications));
                if (billingManager.isPurchased()) {
                    premiumIcon.setVisibility(View.GONE);
                } else premiumIcon.setVisibility(View.VISIBLE);
                break;
            case R.id.navigation_art:
                fragmentTitleTextView.setText(getString(R.string.title_art));
                if (billingManager.isPurchased()) {
                    premiumIcon.setVisibility(View.GONE);
                } else premiumIcon.setVisibility(View.VISIBLE);
                break;
            case R.id.navigation_settings:
                fragmentTitleTextView.setText(getString(R.string.title_settings));
                premiumIcon.setVisibility(View.INVISIBLE);
                break;
        }
    */}
}
