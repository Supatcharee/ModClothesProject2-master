package com.example.sao.modclothesproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AppleShapeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apple_shape);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onSupportNavigateUp(){
        Intent i = new Intent(AppleShapeActivity.this, WomanStyleActivity.class);
        startActivity(i);
        // or call onBackPressed()
        return true;
    }
}
