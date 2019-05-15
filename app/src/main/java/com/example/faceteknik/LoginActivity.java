package com.example.faceteknik;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.faceteknik.API.NewsFeed;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final EditText emailInput = (EditText) findViewById(R.id.emailInput);
        final EditText passInput = (EditText) findViewById(R.id.passInput);
        final Button loginButton = (Button) findViewById(R.id.loginButton);
        final Button registerButton = (Button) findViewById(R.id.registerButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email = emailInput.getText().toString();
                final String password = passInput.getText().toString();



                // Ketika berhasil login bakal pindah ke newsfeed
             Intent newsfeedIntent = new Intent(LoginActivity.this , NewsFeed.class);
             startActivity(newsfeedIntent);
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent regisIntent = new Intent(LoginActivity.this , RegisterActivity.class);
                startActivity(regisIntent);
            }
        });
    }
}
