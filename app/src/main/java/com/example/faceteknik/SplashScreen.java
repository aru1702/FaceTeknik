package com.example.faceteknik;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.faceteknik.Database.Configuration;

public class SplashScreen extends AppCompatActivity {

    private String currentId;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // get Id
        getFromPreference();

        // hold for 2 seconds
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // make sure there is Id or not
                if (currentId != null){
                    startActivity(new Intent(SplashScreen.this, Menu.class));
                    finish();
                } else {
                    startActivity(new Intent(SplashScreen.this, LoginActivity.class));
                    finish();
                }
            }
        }, 2000);
    }

    public void getFromPreference () {

        // call and open the shared preference
        sharedPreferences = getSharedPreferences(Configuration.STATIC_PREFERENCE, Context.MODE_PRIVATE);

        // store value from preference into field
        if (sharedPreferences.contains(Configuration.STATIC_USER_ID)) {
            currentId = sharedPreferences.getString(Configuration.STATIC_USER_ID, "");
        } else {
            // Toast.makeText(getApplicationContext(), "No data is stored.", Toast.LENGTH_SHORT).show();
        }
    }
}