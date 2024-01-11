package com.masud.task.ui;

import android.Manifest;
import android.app.FragmentManager;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.masud.task.R;
import com.masud.task.fragments.CompletedTaskFragment;
import com.masud.task.fragments.HomeFragment;
import com.masud.task.fragments.ProfileFragment;

import hotchemi.android.rate.AppRate;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);
        bottomNav.setOnNavigationItemSelectedListener(navListener);


        takeNotificationPermission();

        //show rate app prompt
        AppRate.with(this)
                .setInstallDays(1)
                .setLaunchTimes(3)
                .setRemindInterval(2)
                .monitor();

        AppRate.showRateDialogIfMeetsConditions(this);

        //this checks to see if there's any savedInstance,if null, then it replaces the fragment container
        // with home fragment.
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainer,
                    new HomeFragment()).commit();
        }

    }

    private void takeNotificationPermission() {

            if (Build.VERSION.SDK_INT >= 32) {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.POST_NOTIFICATIONS},
                        112);
            }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 112) {// If request is cancelled, the result arrays are empty.
            if (grantResults.length > 0 &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // allow

            } else {
                //deny
            }
            return;
        }

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            menuItem -> {
                Fragment selectedfragment = null;

                if (menuItem.getItemId() == R.id.home) {
                    selectedfragment = new HomeFragment();
                }
                if (menuItem.getItemId() == R.id.completed) {
                    selectedfragment = new CompletedTaskFragment();
                }
                if (menuItem.getItemId() == R.id.profile) {
                    selectedfragment = new ProfileFragment();
                }

                if (selectedfragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainer,
                            selectedfragment).commit();
                }

                return true;
            };

    @Override
    public void onBackPressed() {
        FragmentManager fm = getFragmentManager();
        if (fm.getBackStackEntryCount() > 0) {
            fm.popBackStack();
        } else {
            super.onBackPressed();
        }
    }
    // handles on hard ware backpressed..


}


