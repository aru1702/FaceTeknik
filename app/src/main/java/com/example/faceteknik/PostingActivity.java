package com.example.faceteknik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.faceteknik.API.NewsFeed;

public class PostingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posting);

        final TextView textPosting = (TextView) findViewById(R.id.textPosting);
        final Button buttonPosting = (Button) findViewById(R.id.buttonPosting);
        final Button gotoHome = (Button) findViewById(R.id.gotoHomePosting);

        buttonPosting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String post = textPosting.getText().toString();

                // Ketika berhasil login bakal pindah ke newsfeed
                Intent mainMenuIntent = new Intent(PostingActivity.this , MainMenuActivity.class);
                startActivity(mainMenuIntent);
            }
        });

        gotoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainMenuIntent = new Intent(PostingActivity.this , MainMenuActivity.class);
                startActivity(mainMenuIntent);
            }
        });
    }
}
