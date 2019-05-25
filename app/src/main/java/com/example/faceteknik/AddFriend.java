package com.example.faceteknik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddFriend extends AppCompatActivity {

    boolean friendFound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_friend);

        final EditText findFriend = (EditText) findViewById(R.id.inputUsernameFriend_activity_add_friend);

        final TextView fullname = (TextView) findViewById(R.id.fullname_activity_add_friend);
        final TextView username = (TextView) findViewById(R.id.username_activity_add_friend);

        final Button addFriend = (Button) findViewById(R.id.addfriendbtn_activity_add_friend);
        final Button home = (Button) findViewById(R.id.homebtn_activity_add_friend);

        fullname.setVisibility(View.INVISIBLE);
        username.setVisibility(View.INVISIBLE);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddFriend.this, Menu.class));
            }
        });

        addFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(friendFound == false){
                    //DATABASE//
                    //if found: friendFound == true;
                    fullname.setVisibility(View.INVISIBLE);
                    username.setVisibility(View.INVISIBLE);
                    Toast.makeText(getApplicationContext(),"Fried Found, Click Again to Add",Toast.LENGTH_LONG).show();

                    //else
                    Toast.makeText(getApplicationContext(),"ID not Found",Toast.LENGTH_LONG).show();

//                    friendFound = true;
                }else{
                    //DATABASE//
                    fullname.setVisibility(View.VISIBLE);
                    username.setVisibility(View.VISIBLE);
                    startActivity(new Intent(AddFriend.this, Menu.class));
                }
            }
        });

    }
}
