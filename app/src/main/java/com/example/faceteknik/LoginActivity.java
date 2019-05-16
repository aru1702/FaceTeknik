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
        final EditText usernameInput = (EditText) findViewById(R.id.username);
        final EditText passwordInput = (EditText) findViewById(R.id.password);
        final Button loginButton = (Button) findViewById(R.id.login);
        final Button registerButton = (Button) findViewById(R.id.register);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email = usernameInput.getText().toString();
                final String password = passwordInput.getText().toString();

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
