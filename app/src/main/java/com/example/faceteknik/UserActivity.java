package com.example.faceteknik;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.faceteknik.Database.Configuration;
import com.example.faceteknik.Database.RequestHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class UserActivity extends AppCompatActivity {

    private ListView listView;

    private String JSON_STRING;
    public static int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        getJSON(id);
    }

    private void showUser(){
        JSONObject jsonObject = null;
        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();
        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(Configuration.TAG_JSON_ARRAY);

            for(int i = 0; i<result.length(); i++){
                JSONObject jo = result.getJSONObject(i);
                String id = jo.getString(Configuration.KEY_ID);
                String fullName = jo.getString(Configuration.KEY_FULLNAME);
                String userName = jo.getString(Configuration.KEY_USERNAME);
                String email = jo.getString(Configuration.KEY_EMAIL);
                String tanggalLahir = jo.getString(Configuration.KEY_TANGGALLAHIR);
                String bio = jo.getString(Configuration.KEY_BIO);

                HashMap<String,String> data = new HashMap<>();
                data.put(Configuration.KEY_ID, id);
                data.put(Configuration.KEY_FULLNAME, fullName);
                data.put(Configuration.KEY_USERNAME, userName);
                data.put(Configuration.KEY_EMAIL, email);
                data.put(Configuration.KEY_TANGGALLAHIR, tanggalLahir);
                data.put(Configuration.KEY_BIO, bio);
                list.add(data);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void getJSON(int id){

        this.id = id;

        class GetJSON extends AsyncTask<Void,Void,String> {

            int id = UserActivity.id;

            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(UserActivity.this,"Mengambil Data","Mohon Tunggu...",false,false);
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
                String s = rh.sendGetRequestParam(Configuration.URL_GET_USER, Integer.toString(id));
                return s;
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }
}
