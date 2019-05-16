package com.example.faceteknik;

import android.content.Context;
import android.os.TestLooperManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.faceteknik.API.Friends;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

class FriendListAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<Friends> mFriendList;

    public FriendListAdapter(Context mContext, ArrayList<Friends> mFriendList) {
        this.mContext = mContext;
        this.mFriendList = mFriendList;
    }

    @Override
    public int getCount() {
        return mFriendList.size();
    }

    @Override
    public Object getItem(int position) {
        return mFriendList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).
                    inflate(R.layout.layout_listview_friendlist, parent, false);
        }

        // get current item to be displayed
        Friends currentItem = (Friends) getItem(position);

        TextView tvUsername = (TextView)convertView.findViewById(R.id.usernameFriend);
        TextView tvBio = (TextView)convertView.findViewById(R.id.bioFriend);

        tvUsername.setText("Text");
        tvBio.setText("Bio");

//        v.setTag(mFriendList.get(position).getId());

        return convertView;
    }
}
