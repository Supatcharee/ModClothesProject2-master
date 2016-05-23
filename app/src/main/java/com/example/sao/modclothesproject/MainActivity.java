package com.example.sao.modclothesproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Button btnCloset=(Button)findViewById(R.id.btnCS);
        btnCloset.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(MainActivity.this, ClosetActivity.class);
                startActivity(intent);
            }
        });

        Button btnCollection=(Button)findViewById(R.id.btnCT);
        btnCollection.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(MainActivity.this, CollectionsActivity.class);
                startActivity(intent);
            }
        });

        Button btnWomenStyle=(Button)findViewById(R.id.btnC);
        btnWomenStyle.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(MainActivity.this, WomanStyleActivity.class);
                startActivity(intent);
            }
        });

        ImageButton imageButton1 = (ImageButton)findViewById(R.id.btnWomenStyle);
        imageButton1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(MainActivity.this, WomanStyleActivity.class);
                startActivity(intent);
            }
        });

        Button btnCalendar=(Button)findViewById(R.id.btnWS);
        btnCalendar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(MainActivity.this, CaldroidSampleActivity.class);
                startActivity(intent);
            }
        });
        Button btnAbout = (Button)findViewById(R.id.btnA);
        btnAbout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });

        Button btnCalendar1 = (Button)findViewById(R.id.btnCS1);
        btnCalendar1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(MainActivity.this, CaldroidSampleActivity.class);
                startActivity(intent);
            }
        });

        Button btnCloset1 = (Button)findViewById(R.id.btnWS1);
        btnCloset1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(MainActivity.this, ClosetActivity.class);
                startActivity(intent);
            }
        });

        ImageView about = (ImageView)findViewById(R.id.imageView8);
        about.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });

        about = (ImageView)findViewById(R.id.imageView5);
        about.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(MainActivity.this, WomanStyleActivity.class);
                startActivity(intent);
            }
        });

        about = (ImageView)findViewById(R.id.imageView4);
        about.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(MainActivity.this, CollectionsActivity.class);
                startActivity(intent);
            }
        });

        ImageButton imageButton = (ImageButton)findViewById(R.id.imageButton2);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });
    }
}
