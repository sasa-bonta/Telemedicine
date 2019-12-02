package com.example.telemedicine.view.activities;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.telemedicine.R;
import com.example.telemedicine.view.fragments.HomeFragment;
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

    /*private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            selectedId = menuItem.getItemId();
            setFragment(menuItem.getItemId());
            backStack.remove(menuItem.getItemId());
            backStack.push(menuItem.getItemId());
            setActionBarTitle(menuItem.getItemId());
            return true;
        }
    };*/

    /*private Fragment createNewFragment(Integer itemId) {

        switch (itemId) {
            case R.id.navigation_home:
                return HomeFragment.newInstance();
            case R.id.navigation_popular:
                return PopularFragment.newInstance();
            case R.id.navigation_art:
                return ArtFragment.newInstance();
            case R.id.navigation_settings:
                return SettingsFragment.newInstance();
        }
        return HomeFragment.newInstance();
    }*/
}
