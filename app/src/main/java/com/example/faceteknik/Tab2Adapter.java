package com.example.faceteknik;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.faceteknik.API.Post;
import com.example.faceteknik.API.TextPost;

import java.util.ArrayList;

public class Tab2Adapter extends ArrayAdapter {

    private Context mContext;
    private ArrayList<TextPost> mPostList;

    public Tab2Adapter(Context mContext, ArrayList<TextPost> mPostList) {
        super(mContext, 0, mPostList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TextPost post = (TextPost) getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).
                    inflate(R.layout.tab2_list, parent, false);
        }

        TextView tvUsername = (TextView)convertView.findViewById(R.id.postUsername);
        TextView tvDate = (TextView)convertView.findViewById(R.id.postDate);
        TextView tvText = (TextView)convertView.findViewById(R.id.postText);
        ImageView tvImage = (ImageView) convertView.findViewById(R.id.postImage);

        tvUsername.setText(post.getUsername());
        tvDate.setText(post.getDate());
        tvText.setText(post.getTextContent());
        tvImage.setImageResource(R.drawable.logo);

        convertView.setTag(post.getId());

        return convertView;
    }
}
