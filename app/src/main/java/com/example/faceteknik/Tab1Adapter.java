package com.example.faceteknik;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.faceteknik.API.Notification;

import java.util.ArrayList;
import java.util.List;

public class Tab1Adapter extends ArrayAdapter {

    private Context mContext;
    private ArrayList<Notification> mFriendList;

    public Tab1Adapter(Context mContext, ArrayList<Notification> mFriendList) {
        super(mContext, 0, mFriendList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Notification friends = (Notification) getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).
                    inflate(R.layout.tab4_list, parent, false);
        }

//        TextView tvUsername = (TextView)convertView.findViewById(R.id.username);
//        TextView tvBio = (TextView)convertView.findViewById(R.id.bio);
//
//        tvUsername.setText(friends.getUsername());
//        tvBio.setText(friends.getBiodata());

        convertView.setTag(friends.getId());

        return convertView;
    }
}
