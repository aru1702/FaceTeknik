package com.example.faceteknik;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.faceteknik.API.Friends;
import com.example.faceteknik.Database.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FriendActivity extends Activity {
    private ListView listFriend;
    private FriendListAdapter adapter;
    private ArrayList<Friends> mFriendList;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_tab3);
        listView = (ListView) findViewById(R.id.listViewFriend);

        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();

        HashMap<String,String> data = new HashMap<>();
        data.put(Configuration.KEY_USERNAME, "a");
        data.put(Configuration.KEY_BIO, "aaa");
        list.add(data);

        for(int i = 0; i < 100; i++){
            HashMap<String,String> data1 = new HashMap<>();
            data1.put(Configuration.KEY_USERNAME, "b");
            data1.put(Configuration.KEY_BIO, "bbb");
            list.add(data1);
        }

        mFriendList = new ArrayList<>();

        ListAdapter adapter = new SimpleAdapter(
                FriendActivity.this, list, R.layout.layout_listview_friendlist,
                new String[]{Configuration.KEY_USERNAME,Configuration.KEY_BIO},
                new int[]{R.id.usernameFriend, R.id.bioFriend});

        listView.setAdapter(adapter);

        //contoh data dummy, mestinya dari db
//        mFriendList.add(new Friends(1, "a", "aaa"));
//        mFriendList.add(new Friends(2, "b", "bbb"));
//        mFriendList.add(new Friends(3, "c", "ccc"));
//
//        adapter = new FriendListAdapter(this, mFriendList);
//        listFriend = (ListView) findViewById(R.id.listViewFriend);
//        listFriend.setAdapter(adapter);

//        //Untuk memilih teman
//        listFriend.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getApplicationContext(),
//                        "Clicked fried id: " + view.getTag(), Toast.LENGTH_LONG).show();
//            }
//        });
    }
}
