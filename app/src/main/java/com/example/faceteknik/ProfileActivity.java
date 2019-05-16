package com.example.faceteknik;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.faceteknik.API.User;
import com.example.faceteknik.Database.Configuration;
import com.example.faceteknik.Database.RequestHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class ProfileActivity extends AppCompatActivity {

    private ListView listView;
    ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();
    private String JSON_STRING;
    private User myUser;

    public ProfileActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_tab4);
        
        final TextView fullname = (TextView) findViewById(R.id.fullname);
        final TextView username = (TextView) findViewById(R.id.username);
        final TextView tanggalLahir = (TextView) findViewById(R.id.tanggallahir);
        final TextView email = (TextView) findViewById(R.id.email);
        final TextView bio = (TextView) findViewById(R.id.bio);

        // call getJson to get user identity
        getJSON();

        // display identity in activity
        fullname.setText(myUser.getFullname());
        username.setText(myUser.getUsername());
        tanggalLahir.setText(myUser.getTanggalLahir());
        email.setText(myUser.getEmail());
        bio.setText(myUser.getBio());
    }

    private void showUser(){
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(Configuration.TAG_JSON_ARRAY);

            for(int i = 0; i<result.length(); i++){
                JSONObject jo = result.getJSONObject(i);
                String myId = jo.getString(Configuration.KEY_ID);

//                if (myId == id yang ada di lokal) {
//                    String id = jo.getString(Configuration.KEY_ID);
//                    String fullName = jo.getString(Configuration.KEY_FULLNAME);
//                    String userName = jo.getString(Configuration.KEY_USERNAME);
//                    String email = jo.getString(Configuration.KEY_EMAIL);
//                    String tanggalLahir = jo.getString(Configuration.KEY_TANGGALLAHIR);
//                    String bio = jo.getString(Configuration.KEY_BIO);
//
//                    myUser = new User(Integer.valueOf(id), userName, fullName, "", email, tanggalLahir, bio);
//                }

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void getJSON(){
        class GetJSON extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(ProfileActivity.this,"Mengambil Data","Mohon Tunggu...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                JSON_STRING = s;
                showUser();
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(Configuration.URL_GET_USER);
                return s;
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }
}
