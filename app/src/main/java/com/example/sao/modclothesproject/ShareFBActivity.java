package com.example.sao.modclothesproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import com.facebook.UiLifecycleHelper;
import com.facebook.widget.FacebookDialog;

public class ShareFBActivity extends AppCompatActivity {
    private UiLifecycleHelper uiHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_fb);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        uiHelper = new UiLifecycleHelper(this, null);
        uiHelper.onCreate(savedInstanceState);
    }

    // When Post Status Update button is clicked
    public void postStatusUpdate(View v){
        // Pass null as parameter for setLink method to post status update
        FacebookDialog shareDialog = new FacebookDialog.ShareDialogBuilder(this)
                .setLink(null)
                .build();
        uiHelper.trackPendingDialogCall(shareDialog.present());
    }

    // When Share this tutorial on FB button is clicked
    public void shareTutorialonFB(View v){
        FacebookDialog shareDialog = new FacebookDialog.ShareDialogBuilder(this)
                .setLink("http://www.facebook.com/modclothesapp")
                .build();
        uiHelper.trackPendingDialogCall(shareDialog.present());
    }

    // After Facebook Dialog is closed
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        uiHelper.onActivityResult(requestCode, resultCode, data,
                new FacebookDialog.Callback() {

                    @Override
                    public void onError(FacebookDialog.PendingCall pendingCall,
                                        Exception error, Bundle data) {
                        Toast.makeText(getApplicationContext(), "Error Occured\nMost Common Errors:\n1. Device not connected to Internet\n2.Faceboook APP Id is not changed in Strings.xml", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onComplete(
                            FacebookDialog.PendingCall pendingCall, Bundle data) {
                        Toast.makeText(getApplicationContext(),"Done!!",Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    protected void onResume() {
        super.onResume();
        uiHelper.onResume();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        uiHelper.onSaveInstanceState(outState);
    }

    @Override
    public void onPause() {
        super.onPause();
        uiHelper.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        uiHelper.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        if (id == R.id.home) {
            Intent i = new Intent(ShareFBActivity.this, MainActivity.class);
            startActivity(i);

        }

        return super.onOptionsItemSelected(item);

    }
    @Override
    public boolean onSupportNavigateUp(){
        Intent i = new Intent(ShareFBActivity.this, AboutActivity.class);
        startActivity(i);
        // or call onBackPressed()
        return true;
    }

}