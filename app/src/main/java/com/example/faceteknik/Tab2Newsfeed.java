package com.example.faceteknik;


import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.faceteknik.API.Post;
import com.example.faceteknik.API.TextPost;
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
public class Tab2Newsfeed extends Fragment {

    private ListView lvPost;
    private Tab2Adapter adapter;
    private ArrayList<TextPost> mPostList;
    private String JSON_STRING;

    public Tab2Newsfeed() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab2_newsfeed, container, false);

        mPostList = new ArrayList<>();

        mPostList.add(new TextPost(1, "a", "aaa", "isisisisisisisi", "bbb"));
        mPostList.add(new TextPost(2, "a", "aaa", "isisisisisisisi", "bbb"));
        mPostList.add(new TextPost(3, "a", "aaa", "isisisisisisisi", "bbb"));
        mPostList.add(new TextPost(4, "a", "aaa", "isisisisisisisi", "bbb"));
        mPostList.add(new TextPost(5, "a", "aaa", "isisisisisisisi", "bbb"));
        mPostList.add(new TextPost(6, "a", "aaa", "isisisisisisisi", "bbb"));

//        getJSON(1);

        ListView lv = (ListView)view.findViewById(R.id.listView2);
        Tab2Adapter adapter = new Tab2Adapter(getActivity(), mPostList);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "Clicked =" + view.getTag(), Toast.LENGTH_LONG).show();
            }
        });

        final SwipeRefreshLayout mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.fragment_tab2_newsfeed);

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

    private void showPost(){
        JSONObject jsonObject = null;
        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();
        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(Configuration.TAG_JSON_ARRAY);

            for(int i = 0; i<result.length(); i++){
                JSONObject jo = result.getJSONObject(i);
                String id = jo.getString(Configuration.KEY_ID);
                String fullName = jo.getString(Configuration.KEY_FULLNAME);
                String date = jo.getString(Configuration.KEY_DATE);
                String image = jo.getString(Configuration.KEY_IMAGE);
                String text = jo.getString(Configuration.KEY_TEXT);

                HashMap<String,String> data = new HashMap<>();
                data.put(Configuration.KEY_ID, id);
                data.put(Configuration.KEY_FULLNAME, fullName);
                data.put(Configuration.KEY_DATE, date);
                data.put(Configuration.KEY_IMAGE, image);
                data.put(Configuration.KEY_TEXT, text);
                list.add(data);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        ListAdapter adapter = new SimpleAdapter(
                getContext(), list, R.layout.post_template,
                new String[]{Configuration.KEY_ID,Configuration.KEY_FULLNAME},
                new int[]{R.id.id, R.id.name});

//        listView.setAdapter(adapter);
    }

    private void getJSON(){
        class GetJSON extends AsyncTask<Void,Void,String> {

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
                showPost();
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(Configuration.URL_GET_POST_ALL);
                return s;
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }

}
