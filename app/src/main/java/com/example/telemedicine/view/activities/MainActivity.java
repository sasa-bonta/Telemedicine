package com.example.telemedicine.view.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.telemedicine.R;
import com.example.telemedicine.view.fragments.HomeFragment;
import com.example.telemedicine.view.fragments.NotificationsFragment;
import com.example.telemedicine.view.fragments.ProfileFragment;
import com.example.telemedicine.view.fragments.ScheduleFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayDeque;

public class MainActivity extends AppCompatActivity {

    private ArrayDeque<Integer> backStack = new ArrayDeque<>();
    private int selectedId = R.id.navigation_home;

    private static final String MENU_KEY = "selected";
    private TextView fragmentTitleTextView;

    private BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState !=null){
            selectedId = savedInstanceState.getInt(MENU_KEY);
        }

        fragmentTitleTextView = findViewById(R.id.action_bar_title);
        navigationView = findViewById(R.id.navigation_view);
        navigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        navigationView.setSelectedItemId(selectedId);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(MENU_KEY, selectedId);
    }

    @Override
    public void onBackPressed() {
        if (backStack.size() <= 1)
            finish();
        else {
            backStack.pop();
            if (backStack.peek() != null)
                navigationView.setSelectedItemId(backStack.peek());
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            selectedId = menuItem.getItemId();
            setFragment(menuItem.getItemId());
            backStack.remove(menuItem.getItemId());
            backStack.push(menuItem.getItemId());
            setActionBarTitle(menuItem.getItemId());
            return true;
        }
    };

    private void setFragment(Integer itemId) {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(itemId.toString());
        if (fragment == null) {
            replaceFragment(R.id.content_container, createNewFragment(itemId), itemId.toString());
        } else {
            if (fragment != getSupportFragmentManager().findFragmentById(R.id.content_container)) {
                replaceFragment(R.id.content_container, fragment, null);
            }
        }
    }

    private Fragment createNewFragment(Integer itemId) {
        Menu item = navigationView.getMenu();
        MenuItem add = item.findItem(R.id.navigation_add);
        add.setEnabled(false);
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

    public void replaceFragment(int fragmentId, Fragment fragment, String tag) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_container, fragment, tag);
        if (tag != null) {
            fragmentTransaction.addToBackStack(tag);
        }
        fragmentTransaction.commit();

    }

    private void setActionBarTitle(Integer itemId) {
        switch (itemId) {
            case R.id.navigation_home:
                fragmentTitleTextView.setText(getString(R.string.title_home));
                break;
            case R.id.navigation_notifications:
                fragmentTitleTextView.setText(getString(R.string.title_notifications));
                break;
            case R.id.navigation_schedule:
                fragmentTitleTextView.setText(getString(R.string.title_schedule));
                break;
            case R.id.navigation_profile:
                fragmentTitleTextView.setText(getString(R.string.title_profile));
                break;
        }
    }
}
