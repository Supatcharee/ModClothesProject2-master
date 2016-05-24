package com.example.sao.modclothesproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PareShapeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pare_shape);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onSupportNavigateUp(){
        Intent i = new Intent(PareShapeActivity.this, WomanStyleActivity.class);
        startActivity(i);
        // or call onBackPressed()
        return true;
    }
}
