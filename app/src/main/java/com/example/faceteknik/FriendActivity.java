package com.example.faceteknik;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.app.ProgressDialog;
import android.os.AsyncTask;

import com.example.faceteknik.Database.Configuration;
import com.example.faceteknik.Database.RequestHandler;

import com.example.faceteknik.API.Friends;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class FriendActivity extends Activity {
    private ListView listFriend;
    private Tab4Adapter adapter;
    private ArrayList<Friends> mFriendList;
    private ListView listView;

    private String JSON_STRING;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_tab4_friend);
        listView = (ListView) findViewById(R.id.listView4);

        getJSON(1);


    }

    private void showFriend(){
        JSONObject jsonObject = null;
        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();
        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(Configuration.TAG_JSON_ARRAY);

            for(int i = 0; i<result.length(); i++){
                JSONObject jo = result.getJSONObject(i);
                String idUser = jo.getString(Configuration.KEY_IMAGE);
                String userName = jo.getString(Configuration.KEY_FULLNAME);
                String text = jo.getString(Configuration.KEY_TEXT);
                String date = jo.getString(Configuration.KEY_DATE);

                HashMap<String,String> data = new HashMap<>();
                data.put(Configuration.KEY_IMAGE, idUser);
                data.put(Configuration.KEY_FULLNAME, userName);
                data.put(Configuration.KEY_TEXT, text);
                data.put(Configuration.KEY_DATE, date);
                list.add(data);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        ListAdapter adapter = new SimpleAdapter(
                FriendActivity.this, list, R.layout.layout_listview_friendlist,
                new String[]{Configuration.KEY_IMAGE,Configuration.KEY_FULLNAME,Configuration.KEY_TEXT,Configuration.KEY_DATE},
                new int[]{R.id.postImage, R.id.postFullName, R.id.postText, R.id.postDate});

        listView.setAdapter(adapter);
    }

    private void getJSON(final int id){
        class GetJSON extends AsyncTask<Void,Void,String>{

            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(FriendActivity.this,"Mengambil Data","Mohon Tunggu...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                JSON_STRING = s;
                showFriend();
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(Configuration.URL_GET_FRIEND, Integer.toString(id));
                return s;
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }
}
