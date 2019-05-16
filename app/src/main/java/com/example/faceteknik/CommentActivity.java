package com.example.faceteknik;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.faceteknik.Database.Configuration;
import com.example.faceteknik.Database.RequestHandler;

public class CommentActivity extends AppCompatActivity {

    private ListView listView;
    ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();
    private String JSON_STRING;

    public static String STATIC_ID, STATIC_ID_POST, STATIC_ID_USER, STATIC_COMMENT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        getJSON();
    }


    private void showComment(){
        JSONObject jsonObject = null;

        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(Configuration.TAG_JSON_ARRAY);

            for(int i = 0; i<result.length(); i++){
                JSONObject jo = result.getJSONObject(i);
                String id = jo.getString(Configuration.KEY_ID);
                String fullName = jo.getString(Configuration.KEY_FULLNAME);
                String date = jo.getString(Configuration.KEY_DATE);
                String comment = jo.getString(Configuration.KEY_COMMENT);

                HashMap<String,String> data = new HashMap<>();
                data.put(Configuration.KEY_ID, id);
                data.put(Configuration.KEY_FULLNAME, fullName);
                data.put(Configuration.KEY_DATE, date);
                data.put(Configuration.KEY_COMMENT, comment);
                list.add(data);
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
                loading = ProgressDialog.show(CommentActivity.this,"Mengambil Data","Mohon Tunggu...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                JSON_STRING = s;
                showComment();
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(Configuration.URL_GET_COMMENT);
                return s;
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }

    private void addComment(String idPost, String idUser, String comment){

        STATIC_ID_POST = idPost;
        STATIC_ID_USER = idUser;
        STATIC_COMMENT = comment;

        class AddComment extends AsyncTask<Void,Void,String>{

            private String id = STATIC_ID;
            private String idPost = STATIC_ID_POST;
            private String idUser = STATIC_ID_USER;
            private String comment = STATIC_COMMENT;

            private ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(CommentActivity.this,"Menambahkan Comment...","",false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(CommentActivity.this,s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();
                params.put(Configuration.KEY_ID, id);
                params.put(Configuration.KEY_ID_POST, idPost);
                params.put(Configuration.KEY_ID_USER, idUser);
                params.put(Configuration.KEY_COMMENT, comment);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(Configuration.URL_ADD_COMMENT, params);
                return res;
            }
        }

        AddComment ae = new AddComment();
        ae.execute();
    }
}
