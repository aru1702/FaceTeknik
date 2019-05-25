package com.example.faceteknik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.faceteknik.API.Comment;

import java.util.ArrayList;

public class PostActivity extends AppCompatActivity implements ListView.OnItemClickListener{

    private ArrayList<Comment> mCommentList;

    private int userID;
    private int postID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        userID = getIntent().getIntExtra("userID", 0);
        postID = getIntent().getIntExtra("postID", 0);

        //DATABASE NOTIFICATION STATUS ALREADY READ//

        final ImageView stickerPost = (ImageView) findViewById(R.id.stickerPost);
        final TextView postisi = (TextView) findViewById(R.id.postIsi);
        final TextView usernamePost = (TextView) findViewById(R.id.usernamePost);
        final TextView commentPost= (TextView) findViewById(R.id.comment);
        final ListView commentList = (ListView) findViewById(R.id.commentList);

        mCommentList = new ArrayList<>();

        mCommentList.add(new Comment(1, "aaa", "AAA", "AaAaAaAaAaAa"));
        mCommentList.add(new Comment(1, "aaa", "AAA", "AaAaAaAaAaAa"));
        mCommentList.add(new Comment(1, "aaa", "AAA", "AaAaAaAaAaAa"));
        mCommentList.add(new Comment(1, "aaa", "AAA", "AaAaAaAaAaAa"));
        mCommentList.add(new Comment(1, "aaa", "AAA", "AaAaAaAaAaAa"));
        mCommentList.add(new Comment(1, "aaa", "AAA", "AaAaAaAaAaAa"));
        mCommentList.add(new Comment(1, "aaa", "AAA", "AaAaAaAaAaAa"));
        mCommentList.add(new Comment(1, "aaa", "AAA", "AaAaAaAaAaAa"));
        mCommentList.add(new Comment(1, "aaa", "AAA", "AaAaAaAaAaAa"));
        mCommentList.add(new Comment(1, "aaa", "AAA", "AaAaAaAaAaAa"));
        mCommentList.add(new Comment(1, "aaa", "AAA", "AaAaAaAaAaAa"));
        mCommentList.add(new Comment(1, "aaa", "AAA", "AaAaAaAaAaAa"));
        mCommentList.add(new Comment(1, "aaa", "AAA", "AaAaAaAaAaAa"));
        mCommentList.add(new Comment(1, "aaa", "AAA", "AaAaAaAaAaAa"));
        mCommentList.add(new Comment(1, "aaa", "AAA", "AaAaAaAaAaAa"));
        mCommentList.add(new Comment(1, "aaa", "AAA", "AaAaAaAaAaAa"));
        mCommentList.add(new Comment(1, "aaa", "AAA", "AaAaAaAaAaAa"));
        mCommentList.add(new Comment(1, "aaa", "AAA", "AaAaAaAaAaAa"));



//        getJSON();

        postisi.setText("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaa bbbbbbbbbbbbbbbbbbbbbb ahahahhahahahhahahahahahahhahaha" + postID);
        usernamePost.setText("bbbbbbbbb");

        final String stickerSelect = "Sticker1";
        if(stickerSelect.equals("Sticker1"))
            stickerPost.setBackgroundResource(R.drawable.splashscreen);
        else if(stickerSelect.equals("Sticker2"))
            stickerPost.setBackgroundResource(R.drawable.logo);
        else if(stickerSelect.equals("Sticker3"))
            stickerPost.setBackgroundResource(R.drawable.common_full_open_on_phone);
        else
            stickerPost.setBackgroundResource(R.drawable.contohfotonewsfeed);

        ListView lv = (ListView) findViewById(R.id.commentList);
        PostAdapter adapter = new PostAdapter(PostActivity.this, mCommentList);
        lv.setAdapter(adapter);

        commentPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent commentIntent = new Intent(PostActivity.this , AddComment.class);
                commentIntent.putExtra("userID", userID);
                commentIntent.putExtra("postID", postID);
                startActivity(commentIntent);
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        Intent intent = new Intent(this, PostActivity.class);
//        HashMap<String,String> map =(HashMap)parent.getItemAtPosition(position);
//        String empId = map.get(Configuration.KEY_ID).toString();
//        intent.putExtra(Configuration.KEY_ID,empId);
//        startActivity(intent);
    }
}
