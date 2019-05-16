package com.example.faceteknik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText fullnameRegister =(EditText)findViewById(R.id.fullname);
        final EditText usernameRegister = (EditText) findViewById(R.id.username);
        final EditText emailRegister = (EditText) findViewById(R.id.email);
        final EditText passwordRegister = (EditText) findViewById(R.id.password);
//        final EditText lahirRegister = (EditText) findViewById(R.id.lahir);
//        final EditText bioRegister = (EditText) findViewById(R.id.bio);

        final Button buttonRegister = (Button) findViewById(R.id.signup);
        final Button buttonHome = (Button) findViewById(R.id.login);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String fullname = fullnameRegister.getText().toString();
                final String username = usernameRegister.getText().toString();
                final String email = emailRegister.getText().toString();
                final String password = passwordRegister.getText().toString();
//                final String lahir = lahirRegister.getText().toString();
//                final String bio = bioRegister.getText().toString();

//                RegisterRequest temp = new RegisterRequest(fullname, username, email, password, lahir, bio);

                Intent mainMenuIntent = new Intent(RegisterActivity.this, MainMenuActivity.class);
                startActivity(mainMenuIntent);
            }
        });

        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainMenuIntent = new Intent(RegisterActivity.this, MainMenuActivity.class);
                startActivity(mainMenuIntent);
            }
        });

    }
}
