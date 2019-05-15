package com.example.faceteknik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        
        final TextView fullname = (TextView) findViewById(R.id.fullname);
        final TextView username = (TextView) findViewById(R.id.username);
        final TextView tanggalLahir = (TextView) findViewById(R.id.tanggallahir);
        final TextView email = (TextView) findViewById(R.id.email);
        final TextView bio = (TextView) findViewById(R.id.bio);
        
        final Button mainMenu = (Button) findViewById(R.id.mainMenu);

        mainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainMenuIntent = new Intent(ProfileActivity.this, MainMenuActivity.class);
                startActivity(mainMenuIntent);
            }
        });
    }
}
