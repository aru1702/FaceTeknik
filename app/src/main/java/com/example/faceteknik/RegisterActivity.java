package com.example.faceteknik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.faceteknik.Database.Configuration;
import com.example.faceteknik.Database.RequestHandler;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {

    public static String fullName;
    public static String userName;
    public static String email;
    public static String password;
    public static String tanggalLahir;
    public static String bio;

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

                Intent mainMenuIntent = new Intent(RegisterActivity.this, Menu.class);
                startActivity(mainMenuIntent);
            }
        });

        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainMenuIntent = new Intent(RegisterActivity.this, Menu.class);
                startActivity(mainMenuIntent);
            }
        });

    }

    private void addUser(String fullName, String userName, String email, String password, String tanggalLahir, String bio){

        this.fullName = fullName;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.tanggalLahir = tanggalLahir;
        this.bio = bio;

        class AddUser extends AsyncTask<Void,Void,String>{

            String fullName = RegisterActivity.fullName;
            String userName = RegisterActivity.userName;
            String email = RegisterActivity.email;
            String password = RegisterActivity.password;
            String tanggalLahir = RegisterActivity.tanggalLahir;
            String bio = RegisterActivity.bio;

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(RegisterActivity.this,"Menambahkan Friend...","",false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(RegisterActivity.this,s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();
                params.put(Configuration.KEY_FULLNAME, fullName);
                params.put(Configuration.KEY_USERNAME, userName);
                params.put(Configuration.KEY_EMAIL, email);
                params.put(Configuration.KEY_PASSWORD, password);
                params.put(Configuration.KEY_TANGGALLAHIR, tanggalLahir);
                params.put(Configuration.KEY_BIO, bio);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(Configuration.URL_ADD_USER, params);
                return res;
            }
        }

        AddUser ae = new AddUser();
        ae.execute();
    }
}
