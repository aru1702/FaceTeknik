package com.example.faceteknik;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.faceteknik.API.Friends;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Tab4Friend extends Fragment {

    private ListView lvFriend;
    private Tab4Adapter adapter;
    private ArrayList<Friends> mFriendList;


    public Tab4Friend() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab4_friend, container, false);

        mFriendList = new ArrayList<>();

        mFriendList.add(new Friends(1, "a", "aaa"));
        mFriendList.add(new Friends(1, "b", "aaa"));
        mFriendList.add(new Friends(1, "c", "aaa"));
        mFriendList.add(new Friends(1, "d", "aaa"));
        mFriendList.add(new Friends(1, "e", "aaa"));
        mFriendList.add(new Friends(1, "f", "aaa"));
        mFriendList.add(new Friends(1, "g", "aaa"));
        mFriendList.add(new Friends(1, "a", "aaa"));
        mFriendList.add(new Friends(1, "b", "aaa"));
        mFriendList.add(new Friends(1, "c", "aaa"));
        mFriendList.add(new Friends(1, "d", "aaa"));
        mFriendList.add(new Friends(1, "e", "aaa"));
        mFriendList.add(new Friends(1, "g", "aaa"));
        mFriendList.add(new Friends(1, "f", "aaa"));

        ListView lv = (ListView)view.findViewById(R.id.listView4);
        Tab4Adapter adapter = new Tab4Adapter(getActivity(), mFriendList);
        lv.setAdapter(adapter);

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

}
