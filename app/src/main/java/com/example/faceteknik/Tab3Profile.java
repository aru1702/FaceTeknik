package com.example.faceteknik;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.TextView;

import com.example.faceteknik.API.User;
import com.example.faceteknik.Database.Configuration;
import com.example.faceteknik.Database.RequestHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 */
public class Tab3Profile extends Fragment {

    private User myUser;
    private String JSON_STRING;

    TextView username;
    TextView fullname;
    TextView email;
    TextView birthdate;
    TextView bio;

    private int userID;

    public Tab3Profile() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab3_profile, container, false);

        userID = getActivity().getIntent().getIntExtra("userID", 0);

        username = (TextView) view.findViewById(R.id.username_profile);
        fullname = (TextView) view.findViewById(R.id.fullname_profile);
        email = (TextView) view.findViewById(R.id.email_profile);
        birthdate = (TextView) view.findViewById(R.id.birthdate_profile);
        bio = (TextView) view.findViewById(R.id.bio_profile);

        // call getJson to get user identity
//        getJSON(1);



        return view;
    }

    private void showUser(){
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(Configuration.TAG_JSON_ARRAY);
            if(result != null)
            {
                for(int i = 0; i<result.length(); i++){
                    JSONObject jo = result.getJSONObject(i);
                    int id = jo.getInt(Configuration.KEY_ID);
                    String userName = jo.getString(Configuration.KEY_USERNAME);
                    String fullName = jo.getString(Configuration.KEY_FULLNAME);
                    String emailData = jo.getString(Configuration.KEY_EMAIL);
                    String tanggalLahir = jo.getString(Configuration.KEY_TANGGALLAHIR);
                    String bioData = jo.getString(Configuration.KEY_BIO);

                    if(id == 1)
                    {
                        // display identity in activity
                        fullname.setText(fullName);
                        username.setText(userName);
                        email.setText(emailData);
                        birthdate.setText(tanggalLahir);
                        bio.setText(bioData);
                    }
                }
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private void getJSON(final int id){
        class GetJSON extends AsyncTask<Void,Void,String>{

            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(getContext(),"Mengambil Data","Mohon Tunggu...",false,false);
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
