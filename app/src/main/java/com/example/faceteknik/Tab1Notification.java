package com.example.faceteknik;


import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.media.Image;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.faceteknik.API.Notification;
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
public class Tab1Notification extends Fragment {

    private ListView listView;
    private Tab1Adapter adapter;
    private ArrayList<Notification> mNotificationList;
    private String JSON_STRING;

    public Tab1Notification() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab1_notification, container, false);

//        getJSON();

        mNotificationList = new ArrayList<>();

        mNotificationList.add(new Notification(1, "a", "aaa", true));
        mNotificationList.add(new Notification(1, "b", "aaa", false));
        mNotificationList.add(new Notification(1, "c", "aaa", false));
        mNotificationList.add(new Notification(1, "d", "aaa", false));
        mNotificationList.add(new Notification(1, "e", "aaa", false));
        mNotificationList.add(new Notification(1, "f", "aaa", false));
        mNotificationList.add(new Notification(1, "g", "aaa", false));
        mNotificationList.add(new Notification(1, "a", "aaa", false));
        mNotificationList.add(new Notification(1, "b", "aaa", false));
        mNotificationList.add(new Notification(1, "c", "aaa", true));
        mNotificationList.add(new Notification(1, "d", "aaa", true));
        mNotificationList.add(new Notification(1, "e", "aaa", true));
        mNotificationList.add(new Notification(1, "g", "aaa", true));
        mNotificationList.add(new Notification(1, "f", "aaa", true));

//        ListView lv = (ListView)view.findViewById(R.id.listView4);
//        Tab1Adapter adapter = new Tab1Adapter(getActivity(), mNotificationList);
//        lv.setAdapter(adapter);

        final SwipeRefreshLayout mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.fragment_tab1_notification);

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

    private void showNotification(){
//        JSONObject jsonObject = null;
//        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();
//        try {
//            jsonObject = new JSONObject(JSON_STRING);
//            JSONArray result = jsonObject.getJSONArray(Configuration.TAG_JSON_ARRAY);
//
//            for(int i = 0; i<result.length(); i++){
//                JSONObject jo = result.getJSONObject(i);
//                String id = jo.getString(Configuration.KEY_ID);
//                String fullName = jo.getString(Configuration.KEY_FULLNAME);
//                String date = jo.getString(Configuration.KEY_DATE);
//                String alreadyRead = jo.getString(Configuration.KEY_ALREADY_READ);
//
//                HashMap<String,String> data = new HashMap<>();
//                data.put(Configuration.KEY_ID, id);
//                data.put(Configuration.KEY_FULLNAME, fullName
//                );
////                data.put(Configuration.KEY_DATE, date);
////                data.put(Configuration.KEY_ALREADY_READ, alreadyRead);
//                list.add(data);
//            }
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//        ListAdapter adapter = new SimpleAdapter(
//                getContext(), list, R.layout.post_template,
//                new String[]{Configuration.KEY_ID,Configuration.KEY_FULLNAME},
//                new int[]{R.id.id, R.id.name});
//
//        listView.setAdapter(adapter);
    }
//    private void getJSON(){
//        class GetJSON extends AsyncTask<Void,Void,String> {
//
////            ProgressDialog loading;
////            @Override
////            protected void onPreExecute() {
////                super.onPreExecute();
////                loading = ProgressDialog.show(getContext(),"Mengambil Data","Mohon Tunggu...",false,false);
////            }
////
////            @Override
////            protected void onPostExecute(String s) {
////                super.onPostExecute(s);
////                loading.dismiss();
////                JSON_STRING = s;
////                showNotification();
////            }
////
////            @Override
////            protected String doInBackground(Void... params) {
////                RequestHandler rh = new RequestHandler();
////                String s = rh.sendGetRequest(Configuration.URL_GET_NOTIFICATION);
////                return s;
////            }
////        }
////        GetJSON gj = new GetJSON();
////        gj.execute();
//    }
}
