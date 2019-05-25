package com.example.faceteknik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.faceteknik.Database.Configuration;
import com.example.faceteknik.Database.RequestHandler;

import java.util.HashMap;

public class PostingActivity extends AppCompatActivity {

    public static String idUser;
    public static String image;
    public static String text;

    String stickerSelect = "Sticker1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posting);

        final TextView textPosting = (TextView) findViewById(R.id.textPosting);
        final Button buttonPosting = (Button) findViewById(R.id.buttonPosting);
        final Button gotoHome = (Button) findViewById(R.id.gotoHomePosting);

        final Button sticker1 = (Button) findViewById(R.id.stiker1);
        final Button sticker2 = (Button) findViewById(R.id.stiker2);
        final Button sticker3 = (Button) findViewById(R.id.stiker3);
        final Button sticker4 = (Button) findViewById(R.id.stiker4);

        sticker1.setBackgroundResource(R.drawable.splashscreen);
        sticker2.setBackgroundResource(R.drawable.splashscreen);
        sticker3.setBackgroundResource(R.drawable.splashscreen);
        sticker4.setBackgroundResource(R.drawable.splashscreen);

        //PILIH STIKER//

        sticker1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stickerSelect = "Sticker1";

                sticker1.setBackgroundResource(R.drawable.splashscreen);
                sticker2.setBackgroundResource(R.drawable.logo);
                sticker3.setBackgroundResource(R.drawable.logo);
                sticker4.setBackgroundResource(R.drawable.logo);
            }
        });

        sticker2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stickerSelect = "Sticker1";

                sticker1.setBackgroundResource(R.drawable.logo);
                sticker2.setBackgroundResource(R.drawable.splashscreen);
                sticker3.setBackgroundResource(R.drawable.logo);
                sticker4.setBackgroundResource(R.drawable.logo);
            }
        });

        sticker3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stickerSelect = "Sticker1";

                sticker1.setBackgroundResource(R.drawable.logo);
                sticker2.setBackgroundResource(R.drawable.logo);
                sticker3.setBackgroundResource(R.drawable.splashscreen);
                sticker4.setBackgroundResource(R.drawable.logo);
            }
        });


        sticker4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stickerSelect = "Sticker1";

                sticker1.setBackgroundResource(R.drawable.logo);
                sticker2.setBackgroundResource(R.drawable.logo);
                sticker3.setBackgroundResource(R.drawable.logo);
                sticker4.setBackgroundResource(R.drawable.splashscreen);
            }
        });
        //END PILIH STIKER//

        buttonPosting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String post = textPosting.getText().toString();

                //DATABASE//

                Intent mainMenuIntent = new Intent(PostingActivity.this , Menu.class);
                startActivity(mainMenuIntent);
            }
        });

        gotoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainMenuIntent = new Intent(PostingActivity.this , Menu.class);
                startActivity(mainMenuIntent);
            }
        });
    }

    private void addPost(int idUser, String image, String text){

        this.idUser = Integer.toString(idUser);
        this.image = image;
        this.text = text;


        class AddPost extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;
            String idUser = PostingActivity.idUser;
            String image = PostingActivity.image;
            String text = PostingActivity.text;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(PostingActivity.this,"Menambahkan Post...","Mohon Tunggu...",false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(PostingActivity.this,s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();
                params.put(Configuration.KEY_ID_USER, idUser);
                params.put(Configuration.KEY_IMAGE, image);
                params.put(Configuration.KEY_TEXT, text);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(Configuration.URL_ADD_POST, params);
                return res;
            }
        }

        AddPost ae = new AddPost();
        ae.execute();
    }
}
