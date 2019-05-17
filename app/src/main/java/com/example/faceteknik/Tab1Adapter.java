package com.example.faceteknik;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.faceteknik.API.Notification;

import java.util.ArrayList;
import java.util.List;

public class Tab1Adapter extends ArrayAdapter {

    private Context mContext;
    private ArrayList<Notification> mNotificationList;

    public Tab1Adapter(Context mContext, ArrayList<Notification> mNotificationList) {
        super(mContext, 0, mNotificationList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Notification notification = (Notification) getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).
                    inflate(R.layout.tab1_list, parent, false);
        }

        TextView tvUsername = (TextView)convertView.findViewById(R.id.username);
        TextView tvDate = (TextView)convertView.findViewById(R.id.date);
        TextView tvStatus = (TextView)convertView.findViewById(R.id.status);

        tvUsername.setText(notification.getUserPost());
        tvDate.setText(notification.getDate());

        if(notification.isAlreadyRead())
            tvStatus.setText("Already Read");
        else
            tvStatus.setText("New Post!1!1!1!");

        convertView.setTag(notification.getId());

        return convertView;
    }
}
