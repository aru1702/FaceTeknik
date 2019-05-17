package com.example.faceteknik;


import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.faceteknik.API.Friends;
import com.example.faceteknik.Database.Configuration;
import com.example.faceteknik.Database.RequestHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 */
public class Tab4Friend extends Fragment {

    private ListView lvFriend;
    private Tab4Adapter adapter;
    private ArrayList<Friends> mFriendList;
    private String JSON_STRING;

    public Tab4Friend() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab4_friend, container, false);

        mFriendList = new ArrayList<>();

        mFriendList.add(new Friends(1, "a", "aaa"));

        getJSON(1);

        ListView lv = (ListView)view.findViewById(R.id.listView4);
        lvFriend = lv;

        final SwipeRefreshLayout mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.fragment_tab4_friend);

        mSwipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        ((Menu) getActivity()).refreshNow();
                        Toast.makeText(getContext(), "Refresh Layout working", Toast.LENGTH_LONG).show();
                    }
                }
        );

        return view;
    }

    private void showFriend(int id){
        JSONObject jsonObject = null;
        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();
        try {
            System.out.println("Hasil JSON String: "+JSON_STRING);
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(Configuration.TAG_JSON_ARRAY);

            for(int i = 0; i<result.length(); i++){
                JSONObject jo = result.getJSONObject(i);
                int idUser = jo.getInt(Configuration.KEY_ID_USER);
                int idFriend = jo.getInt(Configuration.KEY_ID_FRIEND);
                String userName = jo.getString(Configuration.KEY_USERNAME);
                String bio = jo.getString(Configuration.KEY_BIO);

                // HashMap<String,String> data = new HashMap<>();
                // data.put(Configuration.KEY_ID_USER, idUser);
                // data.put(Configuration.KEY_USERNAME, userName);
                // data.put(Configuration.KEY_BIO, bio);
                // list.add(data);
                if(id == idUser)
                {
                    mFriendList.add(new Friends(idFriend, userName, bio));
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        Tab4Adapter adapter = new Tab4Adapter(getActivity(), mFriendList);
        lvFriend.setAdapter(adapter);
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
                showFriend(id);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(Configuration.URL_GET_FRIEND);
                return s;
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }
}