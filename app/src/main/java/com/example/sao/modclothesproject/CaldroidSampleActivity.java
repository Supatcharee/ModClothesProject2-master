package com.example.sao.modclothesproject;

import android.app.Activity;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.roomorama.caldroid.CaldroidFragment;
import com.roomorama.caldroid.CaldroidListener;

import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;



@SuppressLint("SimpleDateFormat")
public class CaldroidSampleActivity extends AppCompatActivity implements View.OnClickListener,
        AdapterView.OnItemClickListener{

    EditText etPersonName;
    Button btnAddPerson;

    private String[] FilePathStrings;
    private String[] FileNameStrings;
    private File[] listFile;
    GridView grid;
    GAdapter adapter;
    File file;

    ListView list;

    MyDbHelper dbHelper;
    SQLiteDatabase db;
    Cursor cursor;
    SimpleCursorAdapter adapter1;

    private boolean undo = false;
    private CaldroidFragment caldroidFragment;
    private CaldroidFragment dialogCaldroidFragment;

    private void cal_05312016(String s) {
        Calendar cal = Calendar.getInstance();

        // Min date is last 7 days
        cal.add(Calendar.DATE, 5);
        Date blueDate = cal.getTime();

        if (caldroidFragment != null) {
            //ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.caldroid_light_red));
            Drawable e= Drawable.createFromPath(s);
            caldroidFragment.setBackgroundDrawableForDate(e, blueDate);
        }
    }
    private void cal_05302016(String s) {
        final SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
       /* if(formatter.format(date).contains("01 May 2016")){
            onResume1();
        }*/
        Calendar cal = Calendar.getInstance();

        // Min date is last 7 days
        cal.add(Calendar.DATE, 4);
        Date blueDate = cal.getTime();

        if (caldroidFragment != null) {
            //ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.caldroid_light_red));
            Drawable e= Drawable.createFromPath(s);
            caldroidFragment.setBackgroundDrawableForDate(e, blueDate);
        }
    }
    private void cal_05292016(String s) {
        Calendar cal = Calendar.getInstance();

        // Min date is last 7 days
        cal.add(Calendar.DATE, 3);
        Date blueDate = cal.getTime();

        if (caldroidFragment != null) {
            //ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.caldroid_light_red));
            Drawable e= Drawable.createFromPath(s);
            caldroidFragment.setBackgroundDrawableForDate(e, blueDate);
        }
    }
    private void cal_05282016(String s) {
        Calendar cal = Calendar.getInstance();

        // Min date is last 7 days
        cal.add(Calendar.DATE, 2);
        Date blueDate = cal.getTime();

        if (caldroidFragment != null) {
            //ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.caldroid_light_red));
            Drawable e= Drawable.createFromPath(s);
            caldroidFragment.setBackgroundDrawableForDate(e, blueDate);
        }
    }
    private void cal_05272016(String s) {
        Calendar cal = Calendar.getInstance();

        // Min date is last 7 days
        cal.add(Calendar.DATE, 1);
        Date blueDate = cal.getTime();

        if (caldroidFragment != null) {
            //ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.caldroid_light_red));
            Drawable e= Drawable.createFromPath(s);
            caldroidFragment.setBackgroundDrawableForDate(e, blueDate);
        }
    }
    private void cal_05262016(String s) {

        Calendar cal = Calendar.getInstance();

        // Min date is last 7 days
        cal.add(Calendar.DATE, 0);
        Date blueDate = cal.getTime();

        if (caldroidFragment != null) {
            //ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.caldroid_light_red));
            Drawable e= Drawable.createFromPath(s);
            caldroidFragment.setBackgroundDrawableForDate(e, blueDate);
        }
    }
    private void cal_05252016(String s) {
        Calendar cal = Calendar.getInstance();

        // Min date is last 7 days
        cal.add(Calendar.DATE, -1);
        Date blueDate = cal.getTime();

        if (caldroidFragment != null) {
            //ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.caldroid_light_red));
            Drawable e= Drawable.createFromPath(s);
            caldroidFragment.setBackgroundDrawableForDate(e, blueDate);
        }
    }
    private void cal_05242016(String s) {
        Calendar cal = Calendar.getInstance();

        // Min date is last 7 days
        cal.add(Calendar.DATE, -2);
        Date blueDate = cal.getTime();

        if (caldroidFragment != null) {
            //ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.caldroid_light_red));
            Drawable e= Drawable.createFromPath(s);
            caldroidFragment.setBackgroundDrawableForDate(e, blueDate);
        }
    }

    private void cal_05232016(String s) {
        Calendar cal = Calendar.getInstance();

        // Min date is last 7 days
        cal.add(Calendar.DATE, -3);
        Date blueDate = cal.getTime();

        if (caldroidFragment != null) {
            //ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.caldroid_light_red));
            Drawable e= Drawable.createFromPath(s);
            caldroidFragment.setBackgroundDrawableForDate(e, blueDate);
        }
    }
    private void cal_05222016(String s) {
        Calendar cal = Calendar.getInstance();

        // Min date is last 7 days
        cal.add(Calendar.DATE, -4);
        Date blueDate = cal.getTime();

        if (caldroidFragment != null) {
            //ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.caldroid_light_red));
            Drawable e= Drawable.createFromPath(s);
            caldroidFragment.setBackgroundDrawableForDate(e, blueDate);
        }
    }
    private void cal_05212016(String s) {
        Calendar cal = Calendar.getInstance();

        // Min date is last 7 days
        cal.add(Calendar.DATE, -5);
        Date blueDate = cal.getTime();

        if (caldroidFragment != null) {
            //ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.caldroid_light_red));
            Drawable e= Drawable.createFromPath(s);
            caldroidFragment.setBackgroundDrawableForDate(e, blueDate);
        }
    }
    private void cal_05202016(String s) {
        Calendar cal = Calendar.getInstance();

        // Min date is last 7 days
        cal.add(Calendar.DATE, -6);
        Date blueDate = cal.getTime();

        if (caldroidFragment != null) {
            //ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.caldroid_light_red));
            Drawable e= Drawable.createFromPath(s);
            caldroidFragment.setBackgroundDrawableForDate(e, blueDate);
        }
    }
    private void cal_05192016(String s) {
        Calendar cal = Calendar.getInstance();

        // Min date is last 7 days
        cal.add(Calendar.DATE, -7);
        Date blueDate = cal.getTime();

        if (caldroidFragment != null) {
            //ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.caldroid_light_red));
            Drawable e= Drawable.createFromPath(s);
            caldroidFragment.setBackgroundDrawableForDate(e, blueDate);
        }
    }
    private void cal_05182016(String s) {
        Calendar cal = Calendar.getInstance();

        // Min date is last 7 days
        cal.add(Calendar.DATE, -8);
        Date blueDate = cal.getTime();

        if (caldroidFragment != null) {
            //ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.caldroid_light_red));
            Drawable e= Drawable.createFromPath(s);
            caldroidFragment.setBackgroundDrawableForDate(e, blueDate);
        }
    }
    private void cal_05172016(String s) {
        Calendar cal = Calendar.getInstance();

        // Min date is last 7 days
        cal.add(Calendar.DATE, -9);
        Date blueDate = cal.getTime();

        if (caldroidFragment != null) {
            //ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.caldroid_light_red));
            Drawable e= Drawable.createFromPath(s);
            caldroidFragment.setBackgroundDrawableForDate(e, blueDate);
        }
    }
    private void cal_05162016(String s) {
        final SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
//        if(onResumeCheck("09 May 2016") > 0){
//            Toast.makeText(getApplicationContext(), ">0", Toast.LENGTH_SHORT).show();
//        }
        Calendar cal = Calendar.getInstance();

        // Min date is last 7 days
        cal.add(Calendar.DATE, -10);
        Date blueDate = cal.getTime();

        if (caldroidFragment != null) {
            //ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.caldroid_light_red));
            Drawable e= Drawable.createFromPath(s);
            caldroidFragment.setBackgroundDrawableForDate(e, blueDate);
        }
    }
    private void cal_05152016(String s) {

        Calendar cal = Calendar.getInstance();

        // Min date is last 7 days
        cal.add(Calendar.DATE, -11);
        Date blueDate = cal.getTime();

        if (caldroidFragment != null) {
            //ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.caldroid_light_red));
            Drawable e= Drawable.createFromPath(s);
            caldroidFragment.setBackgroundDrawableForDate(e, blueDate);
        }
    }
    private void cal_05142016(String s) {

        Calendar cal = Calendar.getInstance();

        // Min date is last 7 days
        cal.add(Calendar.DATE, -12);
        Date blueDate = cal.getTime();

        if (caldroidFragment != null) {
            //ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.caldroid_light_red));
            Drawable e= Drawable.createFromPath(s);
            caldroidFragment.setBackgroundDrawableForDate(e, blueDate);
        }
    }
    private void cal_05132016(String s) {

        Calendar cal = Calendar.getInstance();

        // Min date is last 7 days
        cal.add(Calendar.DATE, -13);
        Date blueDate = cal.getTime();

        if (caldroidFragment != null) {
            //ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.caldroid_light_red));
            Drawable e= Drawable.createFromPath(s);
            caldroidFragment.setBackgroundDrawableForDate(e, blueDate);
        }
    }
    private void cal_05122016(String s) {

        Calendar cal = Calendar.getInstance();

        // Min date is last 7 days
        cal.add(Calendar.DATE, -14);
        Date blueDate = cal.getTime();

        if (caldroidFragment != null) {
            //ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.caldroid_light_red));
            Drawable e= Drawable.createFromPath(s);
            caldroidFragment.setBackgroundDrawableForDate(e, blueDate);
        }
    }
    private void cal_05112016(String s) {

        Calendar cal = Calendar.getInstance();

        // Min date is last 7 days
        cal.add(Calendar.DATE, -15);
        Date blueDate = cal.getTime();

        if (caldroidFragment != null) {
            //ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.caldroid_light_red));
            Drawable e= Drawable.createFromPath(s);
            caldroidFragment.setBackgroundDrawableForDate(e, blueDate);
        }
    }
    private void cal_05102016(String s) {

        Calendar cal = Calendar.getInstance();

        // Min date is last 7 days
        cal.add(Calendar.DATE, -16);
        Date blueDate = cal.getTime();

        if (caldroidFragment != null) {
            //ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.caldroid_light_red));
            Drawable e= Drawable.createFromPath(s);
            caldroidFragment.setBackgroundDrawableForDate(e, blueDate);
        }
    }
    private void cal_05092016(String s) {

        Calendar cal = Calendar.getInstance();

        // Min date is last 7 days
        cal.add(Calendar.DATE, -17);
        Date blueDate = cal.getTime();

        if (caldroidFragment != null) {
            //ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.caldroid_light_red));
            Drawable e= Drawable.createFromPath(s);
            caldroidFragment.setBackgroundDrawableForDate(e, blueDate);
        }
    }
    private void cal_05082016(String s) {

        Calendar cal = Calendar.getInstance();

        // Min date is last 7 days
        cal.add(Calendar.DATE, -18);
        Date blueDate = cal.getTime();

        if (caldroidFragment != null) {
            //ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.caldroid_light_red));
            Drawable e= Drawable.createFromPath(s);
            caldroidFragment.setBackgroundDrawableForDate(e, blueDate);
        }
    }
    private void cal_05072016(String s) {

        Calendar cal = Calendar.getInstance();

        // Min date is last 7 days
        cal.add(Calendar.DATE, -19);
        Date blueDate = cal.getTime();

        if (caldroidFragment != null) {
            //ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.caldroid_light_red));
            Drawable e= Drawable.createFromPath(s);
            caldroidFragment.setBackgroundDrawableForDate(e, blueDate);
        }
    }
    private void cal_05062016(String s) {

        Calendar cal = Calendar.getInstance();

        // Min date is last 7 days
        cal.add(Calendar.DATE, -20);
        Date blueDate = cal.getTime();

        if (caldroidFragment != null) {
            //ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.caldroid_light_red));
            Drawable e= Drawable.createFromPath(s);
            caldroidFragment.setBackgroundDrawableForDate(e, blueDate);
        }
    }
    private void cal_05052016(String s) {

        Calendar cal = Calendar.getInstance();

        // Min date is last 7 days
        cal.add(Calendar.DATE, -21);
        Date blueDate = cal.getTime();

        if (caldroidFragment != null) {
            //ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.caldroid_light_red));
            Drawable e= Drawable.createFromPath(s);
            caldroidFragment.setBackgroundDrawableForDate(e, blueDate);
        }
    }
    private void cal_05042016(String s) {

        Calendar cal = Calendar.getInstance();

        // Min date is last 7 days
        cal.add(Calendar.DATE, -22);
        Date blueDate = cal.getTime();

        if (caldroidFragment != null) {
            //ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.caldroid_light_red));
            Drawable e= Drawable.createFromPath(s);
            caldroidFragment.setBackgroundDrawableForDate(e, blueDate);
        }
    }
    private void cal_05032016(String s) {

        Calendar cal = Calendar.getInstance();

        // Min date is last 7 days
        cal.add(Calendar.DATE, -23);
        Date blueDate = cal.getTime();

        if (caldroidFragment != null) {
            //ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.caldroid_light_red));
            Drawable e= Drawable.createFromPath(s);
            caldroidFragment.setBackgroundDrawableForDate(e, blueDate);
        }
    }
    private void cal_05022016(String s) {

        Calendar cal = Calendar.getInstance();

        // Min date is last 7 days
        cal.add(Calendar.DATE, -24);
        Date blueDate = cal.getTime();

        if (caldroidFragment != null) {
            //ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.caldroid_light_red));
            Drawable e= Drawable.createFromPath(s);
            caldroidFragment.setBackgroundDrawableForDate(e, blueDate);
        }
    }
    private void cal_05012016(String s) {

        Calendar cal = Calendar.getInstance();

        // Min date is last 7 days
        cal.add(Calendar.DATE, -25);
        Date blueDate = cal.getTime();

        if (caldroidFragment != null) {
            //ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.caldroid_light_red));
            Drawable e= Drawable.createFromPath(s);
            caldroidFragment.setBackgroundDrawableForDate(e, blueDate);
        }
    }



    private void cal_06302016(String s) {
        final SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
       /* if(formatter.format(date).contains("01 May 2016")){
            onResume1();
        }*/
        Calendar cal = Calendar.getInstance();

        // Min date is last 7 days
        cal.add(Calendar.DATE, 35);
        Date blueDate = cal.getTime();

        if (caldroidFragment != null) {
            //ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.caldroid_light_red));
            Drawable e= Drawable.createFromPath(s);
            caldroidFragment.setBackgroundDrawableForDate(e, blueDate);
        }
    }
    private void cal_06292016(String s) {
        Calendar cal = Calendar.getInstance();

        // Min date is last 7 days
        cal.add(Calendar.DATE, 34);
        Date blueDate = cal.getTime();

        if (caldroidFragment != null) {
            //ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.caldroid_light_red));
            Drawable e= Drawable.createFromPath(s);
            caldroidFragment.setBackgroundDrawableForDate(e, blueDate);
        }
    }
    private void cal_06282016(String s) {
        Calendar cal = Calendar.getInstance();

        // Min date is last 7 days
        cal.add(Calendar.DATE, 33);
        Date blueDate = cal.getTime();

        if (caldroidFragment != null) {
            //ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.caldroid_light_red));
            Drawable e= Drawable.createFromPath(s);
            caldroidFragment.setBackgroundDrawableForDate(e, blueDate);
        }
    }
    private void cal_06272016(String s) {
        Calendar cal = Calendar.getInstance();

        // Min date is last 7 days
        cal.add(Calendar.DATE, 32);
        Date blueDate = cal.getTime();

        if (caldroidFragment != null) {
            //ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.caldroid_light_red));
            Drawable e= Drawable.createFromPath(s);
            caldroidFragment.setBackgroundDrawableForDate(e, blueDate);
        }
    }
    private void cal_06262016(String s) {

        Calendar cal = Calendar.getInstance();

        // Min date is last 7 days
        cal.add(Calendar.DATE, 31);
        Date blueDate = cal.getTime();

        if (caldroidFragment != null) {
            //ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.caldroid_light_red));
            Drawable e= Drawable.createFromPath(s);
            caldroidFragment.setBackgroundDrawableForDate(e, blueDate);
        }
    }
    private void cal_06252016(String s) {
        Calendar cal = Calendar.getInstance();

        // Min date is last 7 days
        cal.add(Calendar.DATE, 30);
        Date blueDate = cal.getTime();

        if (caldroidFragment != null) {
            //ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.caldroid_light_red));
            Drawable e= Drawable.createFromPath(s);
            caldroidFragment.setBackgroundDrawableForDate(e, blueDate);
        }
    }
    private void cal_06242016(String s) {
        Calendar cal = Calendar.getInstance();

        // Min date is last 7 days
        cal.add(Calendar.DATE, 29);
        Date blueDate = cal.getTime();

        if (caldroidFragment != null) {
            //ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.caldroid_light_red));
            Drawable e= Drawable.createFromPath(s);
            caldroidFragment.setBackgroundDrawableForDate(e, blueDate);
        }
    }

    private void cal_06232016(String s) {
        Calendar cal = Calendar.getInstance();

        // Min date is last 7 days
        cal.add(Calendar.DATE, 28);
        Date blueDate = cal.getTime();

        if (caldroidFragment != null) {
            //ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.caldroid_light_red));
            Drawable e= Drawable.createFromPath(s);
            caldroidFragment.setBackgroundDrawableForDate(e, blueDate);
        }
    }
    private void cal_06222016(String s) {
        Calendar cal = Calendar.getInstance();

        // Min date is last 7 days
        cal.add(Calendar.DATE, 27);
        Date blueDate = cal.getTime();

        if (caldroidFragment != null) {
            //ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.caldroid_light_red));
            Drawable e= Drawable.createFromPath(s);
            caldroidFragment.setBackgroundDrawableForDate(e, blueDate);
        }
    }
    private void cal_06212016(String s) {
        Calendar cal = Calendar.getInstance();

        // Min date is last 7 days
        cal.add(Calendar.DATE, 26);
        Date blueDate = cal.getTime();

        if (caldroidFragment != null) {
            //ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.caldroid_light_red));
            Drawable e= Drawable.createFromPath(s);
            caldroidFragment.setBackgroundDrawableForDate(e, blueDate);
        }
    }
    private void cal_06202016(String s) {
        Calendar cal = Calendar.getInstance();

        // Min date is last 7 days
        cal.add(Calendar.DATE, 25);
        Date blueDate = cal.getTime();

        if (caldroidFragment != null) {
            //ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.caldroid_light_red));
            Drawable e= Drawable.createFromPath(s);
            caldroidFragment.setBackgroundDrawableForDate(e, blueDate);
        }
    }
    private void cal_06192016(String s) {
        Calendar cal = Calendar.getInstance();

        // Min date is last 7 days
        cal.add(Calendar.DATE, 24);
        Date blueDate = cal.getTime();

        if (caldroidFragment != null) {
            //ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.caldroid_light_red));
            Drawable e= Drawable.createFromPath(s);
            caldroidFragment.setBackgroundDrawableForDate(e, blueDate);
        }
    }
    private void cal_06182016(String s) {
        Calendar cal = Calendar.getInstance();

        // Min date is last 7 days
        cal.add(Calendar.DATE, 23);
        Date blueDate = cal.getTime();

        if (caldroidFragment != null) {
            //ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.caldroid_light_red));
            Drawable e= Drawable.createFromPath(s);
            caldroidFragment.setBackgroundDrawableForDate(e, blueDate);
        }
    }
    private void cal_06172016(String s) {
        Calendar cal = Calendar.getInstance();

        // Min date is last 7 days
        cal.add(Calendar.DATE, 22);
        Date blueDate = cal.getTime();

        if (caldroidFragment != null) {
            //ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.caldroid_light_red));
            Drawable e= Drawable.createFromPath(s);
            caldroidFragment.setBackgroundDrawableForDate(e, blueDate);
        }
    }
    private void cal_06162016(String s) {
        final SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
//        if(onResumeCheck("09 May 2016") > 0){
//            Toast.makeText(getApplicationContext(), ">0", Toast.LENGTH_SHORT).show();
//        }
        Calendar cal = Calendar.getInstance();

        // Min date is last 7 days
        cal.add(Calendar.DATE, 21);
        Date blueDate = cal.getTime();

        if (caldroidFragment != null) {
            //ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.caldroid_light_red));
            Drawable e= Drawable.createFromPath(s);
            caldroidFragment.setBackgroundDrawableForDate(e, blueDate);
        }
    }
    private void cal_06152016(String s) {

        Calendar cal = Calendar.getInstance();

        // Min date is last 7 days
        cal.add(Calendar.DATE, 20);
        Date blueDate = cal.getTime();

        if (caldroidFragment != null) {
            //ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.caldroid_light_red));
            Drawable e= Drawable.createFromPath(s);
            caldroidFragment.setBackgroundDrawableForDate(e, blueDate);
        }
    }
    private void cal_06142016(String s) {

        Calendar cal = Calendar.getInstance();

        // Min date is last 7 days
        cal.add(Calendar.DATE, 19);
        Date blueDate = cal.getTime();

        if (caldroidFragment != null) {
            //ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.caldroid_light_red));
            Drawable e= Drawable.createFromPath(s);
            caldroidFragment.setBackgroundDrawableForDate(e, blueDate);
        }
    }
    private void cal_06132016(String s) {

        Calendar cal = Calendar.getInstance();

        // Min date is last 7 days
        cal.add(Calendar.DATE, 18);
        Date blueDate = cal.getTime();

        if (caldroidFragment != null) {
            //ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.caldroid_light_red));
            Drawable e= Drawable.createFromPath(s);
            caldroidFragment.setBackgroundDrawableForDate(e, blueDate);
        }
    }
    private void cal_06122016(String s) {

        Calendar cal = Calendar.getInstance();

        // Min date is last 7 days
        cal.add(Calendar.DATE, 17);
        Date blueDate = cal.getTime();

        if (caldroidFragment != null) {
            //ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.caldroid_light_red));
            Drawable e= Drawable.createFromPath(s);
            caldroidFragment.setBackgroundDrawableForDate(e, blueDate);
        }
    }
    private void cal_06112016(String s) {

        Calendar cal = Calendar.getInstance();

        // Min date is last 7 days
        cal.add(Calendar.DATE, 16);
        Date blueDate = cal.getTime();

        if (caldroidFragment != null) {
            //ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.caldroid_light_red));
            Drawable e= Drawable.createFromPath(s);
            caldroidFragment.setBackgroundDrawableForDate(e, blueDate);
        }
    }
    private void cal_06102016(String s) {

        Calendar cal = Calendar.getInstance();

        // Min date is last 7 days
        cal.add(Calendar.DATE, 15);
        Date blueDate = cal.getTime();

        if (caldroidFragment != null) {
            //ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.caldroid_light_red));
            Drawable e= Drawable.createFromPath(s);
            caldroidFragment.setBackgroundDrawableForDate(e, blueDate);
        }
    }
    private void cal_06092016(String s) {

        Calendar cal = Calendar.getInstance();

        // Min date is last 7 days
        cal.add(Calendar.DATE, 14);
        Date blueDate = cal.getTime();

        if (caldroidFragment != null) {
            //ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.caldroid_light_red));
            Drawable e= Drawable.createFromPath(s);
            caldroidFragment.setBackgroundDrawableForDate(e, blueDate);
        }
    }
    private void cal_06082016(String s) {

        Calendar cal = Calendar.getInstance();

        // Min date is last 7 days
        cal.add(Calendar.DATE, 13);
        Date blueDate = cal.getTime();

        if (caldroidFragment != null) {
            //ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.caldroid_light_red));
            Drawable e= Drawable.createFromPath(s);
            caldroidFragment.setBackgroundDrawableForDate(e, blueDate);
        }
    }
    private void cal_06072016(String s) {

        Calendar cal = Calendar.getInstance();

        // Min date is last 7 days
        cal.add(Calendar.DATE, 12);
        Date blueDate = cal.getTime();

        if (caldroidFragment != null) {
            //ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.caldroid_light_red));
            Drawable e= Drawable.createFromPath(s);
            caldroidFragment.setBackgroundDrawableForDate(e, blueDate);
        }
    }
    private void cal_06062016(String s) {

        Calendar cal = Calendar.getInstance();

        // Min date is last 7 days
        cal.add(Calendar.DATE, 11);
        Date blueDate = cal.getTime();

        if (caldroidFragment != null) {
            //ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.caldroid_light_red));
            Drawable e= Drawable.createFromPath(s);
            caldroidFragment.setBackgroundDrawableForDate(e, blueDate);
        }
    }
    private void cal_06052016(String s) {

        Calendar cal = Calendar.getInstance();

        // Min date is last 7 days
        cal.add(Calendar.DATE, 10);
        Date blueDate = cal.getTime();

        if (caldroidFragment != null) {
            //ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.caldroid_light_red));
            Drawable e= Drawable.createFromPath(s);
            caldroidFragment.setBackgroundDrawableForDate(e, blueDate);
        }
    }
    private void cal_06042016(String s) {

        Calendar cal = Calendar.getInstance();

        // Min date is last 7 days
        cal.add(Calendar.DATE, 9);
        Date blueDate = cal.getTime();

        if (caldroidFragment != null) {
            //ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.caldroid_light_red));
            Drawable e= Drawable.createFromPath(s);
            caldroidFragment.setBackgroundDrawableForDate(e, blueDate);
        }
    }
    private void cal_06032016(String s) {

        Calendar cal = Calendar.getInstance();

        // Min date is last 7 days
        cal.add(Calendar.DATE, 8);
        Date blueDate = cal.getTime();

        if (caldroidFragment != null) {
            //ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.caldroid_light_red));
            Drawable e= Drawable.createFromPath(s);
            caldroidFragment.setBackgroundDrawableForDate(e, blueDate);
        }
    }
    private void cal_06022016(String s) {

        Calendar cal = Calendar.getInstance();

        // Min date is last 7 days
        cal.add(Calendar.DATE, 7);
        Date blueDate = cal.getTime();

        if (caldroidFragment != null) {
            //ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.caldroid_light_red));
            Drawable e= Drawable.createFromPath(s);
            caldroidFragment.setBackgroundDrawableForDate(e, blueDate);
        }
    }
    private void cal_06012016(String s) {

        Calendar cal = Calendar.getInstance();

        // Min date is last 7 days
        cal.add(Calendar.DATE, 6);
        Date blueDate = cal.getTime();

        if (caldroidFragment != null) {
            //ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.caldroid_light_red));
            Drawable e= Drawable.createFromPath(s);
            caldroidFragment.setBackgroundDrawableForDate(e, blueDate);
        }
    }





    private void setCustomResourceForDates() {
        Calendar cal = Calendar.getInstance();

        // Min date is last 7 days
        cal.add(Calendar.DATE, -7);
        Date blueDate = cal.getTime();

        // Max date is next 7 days
        cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 7);
        Date greenDate = cal.getTime();

        if (caldroidFragment != null) {
            caldroidFragment.setTextColorForDate(R.color.white, blueDate);
            caldroidFragment.setTextColorForDate(R.color.white, greenDate);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caldroid_sample);


        final SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");

        // Setup caldroid fragment
        // **** If you want normal CaldroidFragment, use below line ****
        caldroidFragment = new CaldroidFragment();

        // //////////////////////////////////////////////////////////////////////
        // **** This is to show customized fragment. If you want customized
        // version, uncomment below line ****
//		 caldroidFragment = new CaldroidSampleCustomFragment();

        // Setup arguments

        // If Activity is created after rotation
        if (savedInstanceState != null) {
            caldroidFragment.restoreStatesFromKey(savedInstanceState,
                    "CALDROID_SAVED_STATE");
        }
        // If activity is created from fresh
        else {
            Bundle args = new Bundle();
            Calendar cal = Calendar.getInstance();
            args.putInt(CaldroidFragment.MONTH, cal.get(Calendar.MONTH) + 1);
            args.putInt(CaldroidFragment.YEAR, cal.get(Calendar.YEAR));
            args.putBoolean(CaldroidFragment.ENABLE_SWIPE, true);
            args.putBoolean(CaldroidFragment.SIX_WEEKS_IN_CALENDAR, true);

            // Uncomment this to customize startDayOfWeek
            // args.putInt(CaldroidFragment.START_DAY_OF_WEEK,
            // CaldroidFragment.TUESDAY); // Tuesday

            // Uncomment this line to use Caldroid in compact mode
            // args.putBoolean(CaldroidFragment.SQUARE_TEXT_VIEW_CELL, false);

            // Uncomment this line to use dark theme
//            args.putInt(CaldroidFragment.THEME_RESOURCE, com.caldroid.R.style.CaldroidDefaultDark);

            caldroidFragment.setArguments(args);

            // Check for SD Card
            if (!Environment.getExternalStorageState().equals(
                    Environment.MEDIA_MOUNTED)) {
                Toast.makeText(this, "Error! No SDCARD Found!", Toast.LENGTH_LONG)
                        .show();
            } else {
                // Locate the image folder in your SD Card
                file = new File(Environment.getExternalStorageDirectory()
                        + File.separator + "Collections");
                // Create a new folder if no folder named SDImageTutorial exist
                file.mkdirs();
            }

            if (file.isDirectory()) {
                listFile = file.listFiles();
                // Create a String array for FilePathStrings
                FilePathStrings = new String[listFile.length];
                // Create a String array for FileNameStrings
                FileNameStrings = new String[listFile.length];

                for (int i = 0; i < listFile.length; i++) {
                    // Get the path of the image file
                    FilePathStrings[i] = listFile[i].getAbsolutePath();
                    // Get the name image file
                    FileNameStrings[i] = listFile[i].getName();
                    String s = listFile[i].getAbsolutePath().toString();
                    if(listFile[i].getAbsolutePath().toString().contains("05312016")){cal_05312016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("05302016")){cal_05302016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("05292016")){cal_05292016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("05282016")){cal_05282016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("05272016")){cal_05272016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("05262016")){cal_05262016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("05252016")){cal_05252016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("05242016")){cal_05242016(s);}

                    if(listFile[i].getAbsolutePath().toString().contains("05232016")){cal_05232016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("05222016")){cal_05222016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("05212016")){cal_05212016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("05202016")){cal_05202016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("05192016")){cal_05192016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("05182016")){cal_05182016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("05172016")){cal_05172016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("May 31")){cal_05312016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("May 30")){cal_05302016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("May 29")){cal_05292016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("May 28")){cal_05282016(s);}

                    if(listFile[i].getAbsolutePath().toString().contains("May 27")){cal_05272016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("May 26")){cal_05262016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("May 25")){cal_05252016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("May 24")){cal_05242016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("May 23")){cal_05232016(s);}

                    if(listFile[i].getAbsolutePath().toString().contains("May 22")){cal_05222016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("May 21")){cal_05212016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("May 20")){cal_05202016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("May 19")){cal_05192016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("May 18")){cal_05182016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("May 17")){cal_05172016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("May 16")){cal_05162016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("May 15")){cal_05152016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("May 14")){cal_05142016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("May 13")){cal_05132016(s);}

                    if(listFile[i].getAbsolutePath().toString().contains("May 12")){cal_05122016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("May 11")){cal_05112016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("May 10")){cal_05102016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("May 9")){cal_05092016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("May 8")){cal_05082016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("May 7")){cal_05072016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("May 6")){cal_05062016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("May 5")){cal_05052016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("May 4")){cal_05042016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("May 3")){cal_05032016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("May 2")){cal_05022016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("May 1")){cal_05012016(s);}


                    if(listFile[i].getAbsolutePath().toString().contains("June 30")){cal_06302016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("June 29")){cal_06292016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("June 28")){cal_06282016(s);}

                    if(listFile[i].getAbsolutePath().toString().contains("June 27")){cal_06272016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("June 26")){cal_06262016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("June 25")){cal_06252016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("June 24")){cal_06242016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("June 23")){cal_06232016(s);}

                    if(listFile[i].getAbsolutePath().toString().contains("June 22")){cal_06222016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("June 21")){cal_06212016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("June 20")){cal_06202016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("June 19")){cal_06192016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("June 18")){cal_06182016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("June 17")){cal_06172016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("June 16")){cal_06162016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("June 15")){cal_06152016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("June 14")){cal_06142016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("June 13")){cal_06132016(s);}

                    if(listFile[i].getAbsolutePath().toString().contains("June 12")){cal_06122016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("June 11")){cal_06112016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("June 10")){cal_06102016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("June 9")){cal_06092016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("June 8")){cal_06082016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("June 7")){cal_06072016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("June 6")){cal_06062016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("June 5")){cal_06052016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("June 4")){cal_06042016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("June 3")){cal_06032016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("June 2")){cal_06022016(s);}
                    if(listFile[i].getAbsolutePath().toString().contains("June 1")){cal_06012016(s);}

                }
            }
        }
       /* if (!Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            Toast.makeText(this, "Error! No SDCARD Found!", Toast.LENGTH_LONG)
                    .show();
        } else {
            // Locate the image folder in your SD Card
            file = new File(Environment.getExternalStorageDirectory()
                    + File.separator + "Collections");
            // Create a new folder if no folder named SDImageTutorial exist
            file.mkdirs();
        }

        if (file.isDirectory()) {

            listFile = file.listFiles();
            // Create a String array for FilePathStrings
            FilePathStrings = new String[listFile.length];
            // Create a String array for FileNameStrings
            FileNameStrings = new String[listFile.length];
            for (int i = 0; i < listFile.length; i++) {
            String uri = listFile[1].getAbsolutePath().toString();
            a(uri);
            }
        }*/


            /*Toast.makeText(getApplicationContext(), listFile[i].getAbsolutePath(),
                    Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplicationContext(), listFile[a].getAbsolutePath(),
                    Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplicationContext(), listFile[b].getAbsolutePath(),
                    Toast.LENGTH_SHORT).show();*/




        list = (ListView) findViewById(R.id.list);
        list.setOnItemClickListener(this);

        dbHelper = new MyDbHelper(this);



        setCustomResourceForDates();


        // Attach to the activity
        FragmentTransaction t = getSupportFragmentManager().beginTransaction();
        t.replace(R.id.calendar1, caldroidFragment);
        t.commit();

        // Setup listener
        final CaldroidListener listener = new CaldroidListener() {

            @Override
            public void onSelectDate(Date date, View view) {

                Toast.makeText(getApplicationContext(),
                         formatter.format(date),
                        Toast.LENGTH_SHORT).show();
                if(formatter.format(date).contains("01 May 2016")){
                    onResume1();
                }
                if(formatter.format(date).contains("02 May 2016")){
                    onResume2();
                }
                if(formatter.format(date).contains("03 May 2016")){
                    onResume3();
                }
                if(formatter.format(date).contains("04 May 2016")){
                    onResume4();
                }
                if(formatter.format(date).contains("05 May 2016")){
                    onResume5();
                }
                if(formatter.format(date).contains("06 May 2016")){
                    onResume6();
                }
                if(formatter.format(date).contains("07 May 2016")){
                    onResume7();
                }
                if(formatter.format(date).contains("08 May 2016")){
                    onResume8();
                }
                if(formatter.format(date).contains("09 May 2016")){
                    onResume9();
                }
                if(formatter.format(date).contains("10 May 2016")){
                    onResume10();
                }
                if(formatter.format(date).contains("11 May 2016")){
                    onResume11();
                }
                if(formatter.format(date).contains("12 May 2016")){
                    onResume12();
                }
                if(formatter.format(date).contains("13 May 2016")){
                    onResume13();
                }
                if(formatter.format(date).contains("14 May 2016")){
                    onResume14();
                }
                if(formatter.format(date).contains("15 May 2016")){
                    onResume15();
                }
                if(formatter.format(date).contains("16 May 2016")){
                    onResume16();
                }
                if(formatter.format(date).contains("17 May 2016")){
                    onResume17();
                }
                if(formatter.format(date).contains("18 May 2016")){
                    onResume18();
                }
                if(formatter.format(date).contains("19 May 2016")){
                    onResume19();
                }
                if(formatter.format(date).contains("20 May 2016")){
                    onResume20();
                }
                if(formatter.format(date).contains("21 May 2016")){
                    onResume21();
                }
                if(formatter.format(date).contains("22 May 2016")){
                    onResume22();
                }
                if(formatter.format(date).contains("23 May 2016")){
                    onResume23();

                }
                if(formatter.format(date).contains("24 May 2016")){
                    onResume24();

                }
                if(formatter.format(date).contains("25 May 2016")){
                    onResume25();
                }
                if(formatter.format(date).contains("26 May 2016")){
                    onResume26();
                }
                if(formatter.format(date).contains("27 May 2016")){
                    onResume27();

                }
                if(formatter.format(date).contains("28 May 2016")){
                    onResume28();
                }
                if(formatter.format(date).contains("29 May 2016")){
                    onResume29();
                }
                if(formatter.format(date).contains("30 May 2016")){
                    onResume30();
                }
                if(formatter.format(date).contains("31 May 2016")){
                    onResume31();
                }

                if(formatter.format(date).contains("01 June 2016")){
                    onResume61();
                }
                if(formatter.format(date).contains("02 June 2016")){
                    onResume62();
                }
                if(formatter.format(date).contains("03 June 2016")){
                    onResume63();
                }
                if(formatter.format(date).contains("04 June 2016")){
                    onResume64();
                }
                if(formatter.format(date).contains("05 June 2016")){
                    onResume65();
                }
                if(formatter.format(date).contains("06 June 2016")){
                    onResume66();
                }
                if(formatter.format(date).contains("07 June 2016")){
                    onResume67();
                }
                if(formatter.format(date).contains("08 June 2016")){
                    onResume68();
                }
                if(formatter.format(date).contains("09 June 2016")){
                    onResume69();
                }
                if(formatter.format(date).contains("10 June 2016")){
                    onResume610();
                }
                if(formatter.format(date).contains("11 June 2016")){
                    onResume611();
                }
                if(formatter.format(date).contains("12 June 2016")){
                    onResume612();
                }
                if(formatter.format(date).contains("13 June 2016")){
                    onResume613();
                }
                if(formatter.format(date).contains("14 June 2016")){
                    onResume614();
                }
                if(formatter.format(date).contains("15 June 2016")){
                    onResume615();
                }
                if(formatter.format(date).contains("16 June 2016")){
                    onResume616();
                }
                if(formatter.format(date).contains("17 June 2016")){
                    onResume617();
                }
                if(formatter.format(date).contains("18 June 2016")){
                    onResume618();
                }
                if(formatter.format(date).contains("19 June 2016")){
                    onResume619();
                }
                if(formatter.format(date).contains("20 June 2016")){
                    onResume620();
                }
                if(formatter.format(date).contains("21 June 2016")){
                    onResume621();
                }
                if(formatter.format(date).contains("22 June 2016")){
                    onResume622();
                }
                if(formatter.format(date).contains("23 June 2016")){
                    onResume623();

                }
                if(formatter.format(date).contains("24 June 2016")){
                    onResume624();

                }
                if(formatter.format(date).contains("25 June 2016")){
                    onResume625();
                }
                if(formatter.format(date).contains("26 June 2016")){
                    onResume626();
                }
                if(formatter.format(date).contains("27 June 2016")){
                    onResume627();

                }
                if(formatter.format(date).contains("28 June 2016")){
                    onResume628();
                }
                if(formatter.format(date).contains("29 June 2016")){
                    onResume629();
                }
                if(formatter.format(date).contains("30 June 2016")){
                    onResume630();
                }



            }

            @Override
            public void onChangeMonth(int month, int year) {
                String text = "month: " + month + " year: " + year;
                Toast.makeText(getApplicationContext(), text,
                        Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onLongClickDate(Date date, View view) {
                Toast.makeText(getApplicationContext(),
                        "Long click " + formatter.format(date),
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCaldroidViewCreated() {
                if (caldroidFragment.getLeftArrowButton() != null) {
                    Toast.makeText(getApplicationContext(),
                            "Caldroid view is created", Toast.LENGTH_SHORT)
                            .show();

                }
            }

        };

        // Setup Caldroid
        caldroidFragment.setCaldroidListener(listener);


        final TextView textView = (TextView) findViewById(R.id.textview);


        final Bundle state = savedInstanceState;

    }

    /**
     * Save current states of the Caldroid here
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // TODO Auto-generated method stub
        super.onSaveInstanceState(outState);

        if (caldroidFragment != null) {
            caldroidFragment.saveStatesToKey(outState, "CALDROID_SAVED_STATE");
        }

        if (dialogCaldroidFragment != null) {
            dialogCaldroidFragment.saveStatesToKey(outState,
                    "DIALOG_CALDROID_SAVED_STATE");
        }
    }
    @Override
    public void onResume() {
        super.onResume();
        db = dbHelper.getWritableDatabase();

        String[] queryColumns = new String[] { "_id", MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, MyDbHelper.COL_NAME + " LIKE '%May 25, 2016%'", null,
                null, null, null);

        String[] showColumns = new String[] { MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        int[] views = new int[] { android.R.id.text1, android.R.id.text2 };

        adapter1 = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item, cursor, showColumns, views);
        list.setAdapter(adapter1);
    }

    /*public int onResumeCheck(String date) {
        super.onResume();
        db = dbHelper.getWritableDatabase();

        String[] queryColumns = new String[] { "_id", MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, MyDbHelper.COL_NAME  + " LIKE '%May 10, 2016%'", null,
                null, null, null);
        Toast.makeText(getApplicationContext(), cursor.getCount(), Toast.LENGTH_SHORT).show();
        return cursor.getCount();
    }*/

    public void onResume1() {
        super.onResume();
        db = dbHelper.getWritableDatabase();

        String[] queryColumns = new String[] { "_id", MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, MyDbHelper.COL_NAME  + " LIKE '%May 1, 2016%'", null,
                null, null, null);

        String[] showColumns = new String[] { MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        int[] views = new int[] { android.R.id.text1, android.R.id.text2 };

        adapter1 = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item, cursor, showColumns, views);
        list.setAdapter(adapter1);
    }
    public void onResume2() {
        super.onResume();
        db = dbHelper.getWritableDatabase();

        String[] queryColumns = new String[] { "_id", MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, MyDbHelper.COL_NAME  + " LIKE '%May 2, 2016%'", null,
                null, null, null);

        String[] showColumns = new String[] { MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        int[] views = new int[] { android.R.id.text1, android.R.id.text2 };

        adapter1 = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item, cursor, showColumns, views);
        list.setAdapter(adapter1);
    }
    public void onResume3() {
        super.onResume();
        db = dbHelper.getWritableDatabase();

        String[] queryColumns = new String[] { "_id", MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, MyDbHelper.COL_NAME  + " LIKE '%May 3, 2016%'", null,
                null, null, null);

        String[] showColumns = new String[] { MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        int[] views = new int[] { android.R.id.text1, android.R.id.text2 };

        adapter1 = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item, cursor, showColumns, views);
        list.setAdapter(adapter1);
    }
    public void onResume4() {
        super.onResume();
        db = dbHelper.getWritableDatabase();

        String[] queryColumns = new String[] { "_id", MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, MyDbHelper.COL_NAME  + " LIKE '%May 4, 2016%'", null,
                null, null, null);

        String[] showColumns = new String[] { MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        int[] views = new int[] { android.R.id.text1, android.R.id.text2 };

        adapter1 = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item, cursor, showColumns, views);
        list.setAdapter(adapter1);
    }
    public void onResume5() {
        super.onResume();
        db = dbHelper.getWritableDatabase();

        String[] queryColumns = new String[] { "_id", MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, MyDbHelper.COL_NAME  + " LIKE '%May 5, 2016%'", null,
                null, null, null);

        String[] showColumns = new String[] { MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        int[] views = new int[] { android.R.id.text1, android.R.id.text2 };

        adapter1 = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item, cursor, showColumns, views);
        list.setAdapter(adapter1);
    }
    public void onResume6() {
        super.onResume();
        db = dbHelper.getWritableDatabase();

        String[] queryColumns = new String[] { "_id", MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, MyDbHelper.COL_NAME  + " LIKE '%May 6, 2016%'", null,
                null, null, null);

        String[] showColumns = new String[] { MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        int[] views = new int[] { android.R.id.text1, android.R.id.text2 };

        adapter1 = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item, cursor, showColumns, views);
        list.setAdapter(adapter1);
    }
    public void onResume7() {
        super.onResume();
        db = dbHelper.getWritableDatabase();

        String[] queryColumns = new String[] { "_id", MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, MyDbHelper.COL_NAME  + " LIKE '%May 7, 2016%'", null,
                null, null, null);

        String[] showColumns = new String[] { MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        int[] views = new int[] { android.R.id.text1, android.R.id.text2 };

        adapter1 = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item, cursor, showColumns, views);
        list.setAdapter(adapter1);
    }
    public void onResume8() {
        super.onResume();
        db = dbHelper.getWritableDatabase();

        String[] queryColumns = new String[] { "_id", MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, MyDbHelper.COL_NAME  + " LIKE '%May 8, 2016%'", null,
                null, null, null);

        String[] showColumns = new String[] { MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        int[] views = new int[] { android.R.id.text1, android.R.id.text2 };

        adapter1 = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item, cursor, showColumns, views);
        list.setAdapter(adapter1);
    }
    public void onResume9() {
        super.onResume();
        db = dbHelper.getWritableDatabase();

        String[] queryColumns = new String[] { "_id", MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, MyDbHelper.COL_NAME  + " LIKE '%May 9, 2016%'", null,
                null, null, null);

        String[] showColumns = new String[] { MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        int[] views = new int[] { android.R.id.text1, android.R.id.text2 };

        adapter1 = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item, cursor, showColumns, views);
        list.setAdapter(adapter1);
    }
    public void onResume10() {
        super.onResume();
        db = dbHelper.getWritableDatabase();

        String[] queryColumns = new String[] { "_id", MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, MyDbHelper.COL_NAME  + " LIKE '%May 10, 2016%'", null,
                null, null, null);

        String[] showColumns = new String[] { MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        int[] views = new int[] { android.R.id.text1, android.R.id.text2 };

        adapter1 = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item, cursor, showColumns, views);
        list.setAdapter(adapter1);
    }
    public void onResume11() {
        super.onResume();
        db = dbHelper.getWritableDatabase();

        String[] queryColumns = new String[] { "_id", MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, MyDbHelper.COL_NAME  + " LIKE '%May 11, 2016%'", null,
                null, null, null);

        String[] showColumns = new String[] { MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        int[] views = new int[] { android.R.id.text1, android.R.id.text2 };

        adapter1 = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item, cursor, showColumns, views);
        list.setAdapter(adapter1);
    }
    public void onResume12() {
        super.onResume();
        db = dbHelper.getWritableDatabase();

        String[] queryColumns = new String[] { "_id", MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, MyDbHelper.COL_NAME  + " LIKE '%May 12, 2016%'", null,
                null, null, null);

        String[] showColumns = new String[] { MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        int[] views = new int[] { android.R.id.text1, android.R.id.text2 };

        adapter1 = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item, cursor, showColumns, views);
        list.setAdapter(adapter1);
    }
    public void onResume13() {
        super.onResume();
        db = dbHelper.getWritableDatabase();

        String[] queryColumns = new String[] { "_id", MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, MyDbHelper.COL_NAME  + " LIKE '%May 13, 2016%'", null,
                null, null, null);

        String[] showColumns = new String[] { MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        int[] views = new int[] { android.R.id.text1, android.R.id.text2 };

        adapter1 = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item, cursor, showColumns, views);
        list.setAdapter(adapter1);
    }
    public void onResume14() {
        super.onResume();
        db = dbHelper.getWritableDatabase();

        String[] queryColumns = new String[] { "_id", MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, MyDbHelper.COL_NAME  + " LIKE '%May 14, 2016%'", null,
                null, null, null);

        String[] showColumns = new String[] { MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        int[] views = new int[] { android.R.id.text1, android.R.id.text2 };

        adapter1 = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item, cursor, showColumns, views);
        list.setAdapter(adapter1);
    }
    public void onResume15() {
        super.onResume();
        db = dbHelper.getWritableDatabase();

        String[] queryColumns = new String[] { "_id", MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, MyDbHelper.COL_NAME  + " LIKE '%May 15, 2016%'", null,
                null, null, null);

        String[] showColumns = new String[] { MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        int[] views = new int[] { android.R.id.text1, android.R.id.text2 };

        adapter1 = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item, cursor, showColumns, views);
        list.setAdapter(adapter1);
    }
    public void onResume16() {
        super.onResume();
        db = dbHelper.getWritableDatabase();

        String[] queryColumns = new String[] { "_id", MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, MyDbHelper.COL_NAME  + " LIKE '%May 16, 2016%'", null,
                null, null, null);

        String[] showColumns = new String[] { MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        int[] views = new int[] { android.R.id.text1, android.R.id.text2 };

        adapter1 = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item, cursor, showColumns, views);
        list.setAdapter(adapter1);
    }
    public void onResume17() {
        super.onResume();
        db = dbHelper.getWritableDatabase();

        String[] queryColumns = new String[] { "_id", MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, MyDbHelper.COL_NAME  + " LIKE '%May 17, 2016%'", null,
                null, null, null);

        String[] showColumns = new String[] { MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        int[] views = new int[] { android.R.id.text1, android.R.id.text2 };

        adapter1 = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item, cursor, showColumns, views);
        list.setAdapter(adapter1);
    }
    public void onResume18() {
        super.onResume();
        db = dbHelper.getWritableDatabase();

        String[] queryColumns = new String[] { "_id", MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, MyDbHelper.COL_NAME  + " LIKE '%May 18, 2016%'", null,
                null, null, null);

        String[] showColumns = new String[] { MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        int[] views = new int[] { android.R.id.text1, android.R.id.text2 };

        adapter1 = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item, cursor, showColumns, views);
        list.setAdapter(adapter1);
    }
    public void onResume19() {
        super.onResume();
        db = dbHelper.getWritableDatabase();

        String[] queryColumns = new String[] { "_id", MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, MyDbHelper.COL_NAME  + " LIKE '%May 19, 2016%'", null,
                null, null, null);

        String[] showColumns = new String[] { MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        int[] views = new int[] { android.R.id.text1, android.R.id.text2 };

        adapter1 = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item, cursor, showColumns, views);
        list.setAdapter(adapter1);
    }
    public void onResume20() {
        super.onResume();
        db = dbHelper.getWritableDatabase();

        String[] queryColumns = new String[] { "_id", MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, MyDbHelper.COL_NAME  + " LIKE '%May 20, 2016%'", null,
                null, null, null);

        String[] showColumns = new String[] { MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        int[] views = new int[] { android.R.id.text1, android.R.id.text2 };

        adapter1 = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item, cursor, showColumns, views);
        list.setAdapter(adapter1);
    }
    public void onResume21() {
        super.onResume();
        db = dbHelper.getWritableDatabase();

        String[] queryColumns = new String[] { "_id", MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, MyDbHelper.COL_NAME  + " LIKE '%May 21, 2016%'", null,
                null, null, null);

        String[] showColumns = new String[] { MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        int[] views = new int[] { android.R.id.text1, android.R.id.text2 };

        adapter1 = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item, cursor, showColumns, views);
        list.setAdapter(adapter1);
    }
    public void onResume22() {
        super.onResume();
        db = dbHelper.getWritableDatabase();

        String[] queryColumns = new String[] { "_id", MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, MyDbHelper.COL_NAME  + " LIKE '%May 22, 2016%'", null,
                null, null, null);

        String[] showColumns = new String[] { MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        int[] views = new int[] { android.R.id.text1, android.R.id.text2 };

        adapter1 = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item, cursor, showColumns, views);
        list.setAdapter(adapter1);
    }
    public void onResume23() {
        super.onResume();
        db = dbHelper.getWritableDatabase();

        String[] queryColumns = new String[] { "_id", MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, MyDbHelper.COL_NAME  + " LIKE '%May 23, 2016%'", null,
                null, null, null);

        String[] showColumns = new String[] { MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        int[] views = new int[] { android.R.id.text1, android.R.id.text2 };

        adapter1 = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item, cursor, showColumns, views);
        list.setAdapter(adapter1);
    }
    public void onResume24() {
        super.onResume();
        db = dbHelper.getWritableDatabase();

        String[] queryColumns = new String[] { "_id", MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, MyDbHelper.COL_NAME  + " LIKE '%May 24, 2016%'", null,
                null, null, null);

        String[] showColumns = new String[] { MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        int[] views = new int[] { android.R.id.text1, android.R.id.text2 };

        adapter1 = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item, cursor, showColumns, views);
        list.setAdapter(adapter1);
    }
    public void onResume25() {
        super.onResume();
        db = dbHelper.getWritableDatabase();

        String[] queryColumns = new String[] { "_id", MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, MyDbHelper.COL_NAME  + " LIKE '%May 25, 2016%'", null,
                null, null, null);

        String[] showColumns = new String[] { MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        int[] views = new int[] { android.R.id.text1, android.R.id.text2 };

        adapter1 = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item, cursor, showColumns, views);
        list.setAdapter(adapter1);
    }
    public void onResume26() {
        super.onResume();
        db = dbHelper.getWritableDatabase();

        String[] queryColumns = new String[] { "_id", MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, MyDbHelper.COL_NAME  + " LIKE '%May 26, 2016%'", null,
                null, null, null);

        String[] showColumns = new String[] { MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        int[] views = new int[] { android.R.id.text1, android.R.id.text2 };

        adapter1 = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item, cursor, showColumns, views);
        list.setAdapter(adapter1);
    }
    public void onResume27() {
        super.onResume();
        db = dbHelper.getWritableDatabase();

        String[] queryColumns = new String[] { "_id", MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, MyDbHelper.COL_NAME  + " LIKE '%May 27, 2016%'", null,
                null, null, null);

        String[] showColumns = new String[] { MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        int[] views = new int[] { android.R.id.text1, android.R.id.text2 };

        adapter1 = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item, cursor, showColumns, views);
        list.setAdapter(adapter1);
    }
    public void onResume28() {
        super.onResume();
        db = dbHelper.getWritableDatabase();

        String[] queryColumns = new String[] { "_id", MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, MyDbHelper.COL_NAME  + " LIKE '%May 28, 2016%'", null,
                null, null, null);

        String[] showColumns = new String[] { MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        int[] views = new int[] { android.R.id.text1, android.R.id.text2 };

        adapter1 = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item, cursor, showColumns, views);
        list.setAdapter(adapter1);
    }
    public void onResume29() {
        super.onResume();
        db = dbHelper.getWritableDatabase();

        String[] queryColumns = new String[] { "_id", MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, MyDbHelper.COL_NAME  + " LIKE '%May 29, 2016%'", null,
                null, null, null);

        String[] showColumns = new String[] { MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        int[] views = new int[] { android.R.id.text1, android.R.id.text2 };

        adapter1 = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item, cursor, showColumns, views);
        list.setAdapter(adapter1);
    }
    public void onResume30() {
        super.onResume();
        db = dbHelper.getWritableDatabase();

        String[] queryColumns = new String[] { "_id", MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, MyDbHelper.COL_NAME  + " LIKE '%May 30, 2016%'", null,
                null, null, null);

        String[] showColumns = new String[] { MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        int[] views = new int[] { android.R.id.text1, android.R.id.text2 };

        adapter1 = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item, cursor, showColumns, views);
        list.setAdapter(adapter1);
    }
    public void onResume31() {
        super.onResume();
        db = dbHelper.getWritableDatabase();

        String[] queryColumns = new String[] { "_id", MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, MyDbHelper.COL_NAME  + " LIKE '%May 31, 2016%'", null,
                null, null, null);

        String[] showColumns = new String[] { MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        int[] views = new int[] { android.R.id.text1, android.R.id.text2 };

        adapter1 = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item, cursor, showColumns, views);
        list.setAdapter(adapter1);
    }



    public void onResume61() {
        super.onResume();
        db = dbHelper.getWritableDatabase();

        String[] queryColumns = new String[] { "_id", MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, MyDbHelper.COL_NAME  + " LIKE '%June 1, 2016%'", null,
                null, null, null);

        String[] showColumns = new String[] { MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        int[] views = new int[] { android.R.id.text1, android.R.id.text2 };

        adapter1 = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item, cursor, showColumns, views);
        list.setAdapter(adapter1);
    }
    public void onResume62() {
        super.onResume();
        db = dbHelper.getWritableDatabase();

        String[] queryColumns = new String[] { "_id", MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, MyDbHelper.COL_NAME  + " LIKE '%June 2, 2016%'", null,
                null, null, null);

        String[] showColumns = new String[] { MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        int[] views = new int[] { android.R.id.text1, android.R.id.text2 };

        adapter1 = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item, cursor, showColumns, views);
        list.setAdapter(adapter1);
    }
    public void onResume63() {
        super.onResume();
        db = dbHelper.getWritableDatabase();

        String[] queryColumns = new String[] { "_id", MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, MyDbHelper.COL_NAME  + " LIKE '%June 3, 2016%'", null,
                null, null, null);

        String[] showColumns = new String[] { MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        int[] views = new int[] { android.R.id.text1, android.R.id.text2 };

        adapter1 = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item, cursor, showColumns, views);
        list.setAdapter(adapter1);
    }
    public void onResume64() {
        super.onResume();
        db = dbHelper.getWritableDatabase();

        String[] queryColumns = new String[] { "_id", MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, MyDbHelper.COL_NAME  + " LIKE '%June 4, 2016%'", null,
                null, null, null);

        String[] showColumns = new String[] { MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        int[] views = new int[] { android.R.id.text1, android.R.id.text2 };

        adapter1 = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item, cursor, showColumns, views);
        list.setAdapter(adapter1);
    }
    public void onResume65() {
        super.onResume();
        db = dbHelper.getWritableDatabase();

        String[] queryColumns = new String[] { "_id", MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, MyDbHelper.COL_NAME  + " LIKE '%June 5, 2016%'", null,
                null, null, null);

        String[] showColumns = new String[] { MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        int[] views = new int[] { android.R.id.text1, android.R.id.text2 };

        adapter1 = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item, cursor, showColumns, views);
        list.setAdapter(adapter1);
    }
    public void onResume66() {
        super.onResume();
        db = dbHelper.getWritableDatabase();

        String[] queryColumns = new String[] { "_id", MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, MyDbHelper.COL_NAME  + " LIKE '%June 6, 2016%'", null,
                null, null, null);

        String[] showColumns = new String[] { MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        int[] views = new int[] { android.R.id.text1, android.R.id.text2 };

        adapter1 = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item, cursor, showColumns, views);
        list.setAdapter(adapter1);
    }
    public void onResume67() {
        super.onResume();
        db = dbHelper.getWritableDatabase();

        String[] queryColumns = new String[] { "_id", MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, MyDbHelper.COL_NAME  + " LIKE '%June 7, 2016%'", null,
                null, null, null);

        String[] showColumns = new String[] { MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        int[] views = new int[] { android.R.id.text1, android.R.id.text2 };

        adapter1 = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item, cursor, showColumns, views);
        list.setAdapter(adapter1);
    }
    public void onResume68() {
        super.onResume();
        db = dbHelper.getWritableDatabase();

        String[] queryColumns = new String[] { "_id", MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, MyDbHelper.COL_NAME  + " LIKE '%June 8, 2016%'", null,
                null, null, null);

        String[] showColumns = new String[] { MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        int[] views = new int[] { android.R.id.text1, android.R.id.text2 };

        adapter1 = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item, cursor, showColumns, views);
        list.setAdapter(adapter1);
    }
    public void onResume69() {
        super.onResume();
        db = dbHelper.getWritableDatabase();

        String[] queryColumns = new String[] { "_id", MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, MyDbHelper.COL_NAME  + " LIKE '%June 9, 2016%'", null,
                null, null, null);

        String[] showColumns = new String[] { MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        int[] views = new int[] { android.R.id.text1, android.R.id.text2 };

        adapter1 = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item, cursor, showColumns, views);
        list.setAdapter(adapter1);
    }
    public void onResume610() {
        super.onResume();
        db = dbHelper.getWritableDatabase();

        String[] queryColumns = new String[] { "_id", MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, MyDbHelper.COL_NAME  + " LIKE '%June 10, 2016%'", null,
                null, null, null);

        String[] showColumns = new String[] { MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        int[] views = new int[] { android.R.id.text1, android.R.id.text2 };

        adapter1 = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item, cursor, showColumns, views);
        list.setAdapter(adapter1);
    }
    public void onResume611() {
        super.onResume();
        db = dbHelper.getWritableDatabase();

        String[] queryColumns = new String[] { "_id", MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, MyDbHelper.COL_NAME  + " LIKE '%June 11, 2016%'", null,
                null, null, null);

        String[] showColumns = new String[] { MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        int[] views = new int[] { android.R.id.text1, android.R.id.text2 };

        adapter1 = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item, cursor, showColumns, views);
        list.setAdapter(adapter1);
    }
    public void onResume612() {
        super.onResume();
        db = dbHelper.getWritableDatabase();

        String[] queryColumns = new String[] { "_id", MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, MyDbHelper.COL_NAME  + " LIKE '%June 12, 2016%'", null,
                null, null, null);

        String[] showColumns = new String[] { MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        int[] views = new int[] { android.R.id.text1, android.R.id.text2 };

        adapter1 = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item, cursor, showColumns, views);
        list.setAdapter(adapter1);
    }
    public void onResume613() {
        super.onResume();
        db = dbHelper.getWritableDatabase();

        String[] queryColumns = new String[] { "_id", MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, MyDbHelper.COL_NAME  + " LIKE '%June 13, 2016%'", null,
                null, null, null);

        String[] showColumns = new String[] { MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        int[] views = new int[] { android.R.id.text1, android.R.id.text2 };

        adapter1 = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item, cursor, showColumns, views);
        list.setAdapter(adapter1);
    }
    public void onResume614() {
        super.onResume();
        db = dbHelper.getWritableDatabase();

        String[] queryColumns = new String[] { "_id", MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, MyDbHelper.COL_NAME  + " LIKE '%June 14, 2016%'", null,
                null, null, null);

        String[] showColumns = new String[] { MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        int[] views = new int[] { android.R.id.text1, android.R.id.text2 };

        adapter1 = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item, cursor, showColumns, views);
        list.setAdapter(adapter1);
    }
    public void onResume615() {
        super.onResume();
        db = dbHelper.getWritableDatabase();

        String[] queryColumns = new String[] { "_id", MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, MyDbHelper.COL_NAME  + " LIKE '%June 15, 2016%'", null,
                null, null, null);

        String[] showColumns = new String[] { MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        int[] views = new int[] { android.R.id.text1, android.R.id.text2 };

        adapter1 = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item, cursor, showColumns, views);
        list.setAdapter(adapter1);
    }
    public void onResume616() {
        super.onResume();
        db = dbHelper.getWritableDatabase();

        String[] queryColumns = new String[] { "_id", MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, MyDbHelper.COL_NAME  + " LIKE '%June 16, 2016%'", null,
                null, null, null);

        String[] showColumns = new String[] { MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        int[] views = new int[] { android.R.id.text1, android.R.id.text2 };

        adapter1 = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item, cursor, showColumns, views);
        list.setAdapter(adapter1);
    }
    public void onResume617() {
        super.onResume();
        db = dbHelper.getWritableDatabase();

        String[] queryColumns = new String[] { "_id", MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, MyDbHelper.COL_NAME  + " LIKE '%June 17, 2016%'", null,
                null, null, null);

        String[] showColumns = new String[] { MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        int[] views = new int[] { android.R.id.text1, android.R.id.text2 };

        adapter1 = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item, cursor, showColumns, views);
        list.setAdapter(adapter1);
    }
    public void onResume618() {
        super.onResume();
        db = dbHelper.getWritableDatabase();

        String[] queryColumns = new String[] { "_id", MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, MyDbHelper.COL_NAME  + " LIKE '%June 18, 2016%'", null,
                null, null, null);

        String[] showColumns = new String[] { MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        int[] views = new int[] { android.R.id.text1, android.R.id.text2 };

        adapter1 = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item, cursor, showColumns, views);
        list.setAdapter(adapter1);
    }
    public void onResume619() {
        super.onResume();
        db = dbHelper.getWritableDatabase();

        String[] queryColumns = new String[] { "_id", MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, MyDbHelper.COL_NAME  + " LIKE '%June 19, 2016%'", null,
                null, null, null);

        String[] showColumns = new String[] { MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        int[] views = new int[] { android.R.id.text1, android.R.id.text2 };

        adapter1 = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item, cursor, showColumns, views);
        list.setAdapter(adapter1);
    }
    public void onResume620() {
        super.onResume();
        db = dbHelper.getWritableDatabase();

        String[] queryColumns = new String[] { "_id", MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, MyDbHelper.COL_NAME  + " LIKE '%June 20, 2016%'", null,
                null, null, null);

        String[] showColumns = new String[] { MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        int[] views = new int[] { android.R.id.text1, android.R.id.text2 };

        adapter1 = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item, cursor, showColumns, views);
        list.setAdapter(adapter1);
    }
    public void onResume621() {
        super.onResume();
        db = dbHelper.getWritableDatabase();

        String[] queryColumns = new String[] { "_id", MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, MyDbHelper.COL_NAME  + " LIKE '%June 21, 2016%'", null,
                null, null, null);

        String[] showColumns = new String[] { MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        int[] views = new int[] { android.R.id.text1, android.R.id.text2 };

        adapter1 = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item, cursor, showColumns, views);
        list.setAdapter(adapter1);
    }
    public void onResume622() {
        super.onResume();
        db = dbHelper.getWritableDatabase();

        String[] queryColumns = new String[] { "_id", MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, MyDbHelper.COL_NAME  + " LIKE '%June 22, 2016%'", null,
                null, null, null);

        String[] showColumns = new String[] { MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        int[] views = new int[] { android.R.id.text1, android.R.id.text2 };

        adapter1 = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item, cursor, showColumns, views);
        list.setAdapter(adapter1);
    }
    public void onResume623() {
        super.onResume();
        db = dbHelper.getWritableDatabase();

        String[] queryColumns = new String[] { "_id", MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, MyDbHelper.COL_NAME  + " LIKE '%June 23, 2016%'", null,
                null, null, null);

        String[] showColumns = new String[] { MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        int[] views = new int[] { android.R.id.text1, android.R.id.text2 };

        adapter1 = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item, cursor, showColumns, views);
        list.setAdapter(adapter1);
    }
    public void onResume624() {
        super.onResume();
        db = dbHelper.getWritableDatabase();

        String[] queryColumns = new String[] { "_id", MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, MyDbHelper.COL_NAME  + " LIKE '%June 24, 2016%'", null,
                null, null, null);

        String[] showColumns = new String[] { MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        int[] views = new int[] { android.R.id.text1, android.R.id.text2 };

        adapter1 = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item, cursor, showColumns, views);
        list.setAdapter(adapter1);
    }
    public void onResume625() {
        super.onResume();
        db = dbHelper.getWritableDatabase();

        String[] queryColumns = new String[] { "_id", MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, MyDbHelper.COL_NAME  + " LIKE '%June 25, 2016%'", null,
                null, null, null);

        String[] showColumns = new String[] { MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        int[] views = new int[] { android.R.id.text1, android.R.id.text2 };

        adapter1 = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item, cursor, showColumns, views);
        list.setAdapter(adapter1);
    }
    public void onResume626() {
        super.onResume();
        db = dbHelper.getWritableDatabase();

        String[] queryColumns = new String[] { "_id", MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, MyDbHelper.COL_NAME  + " LIKE '%June 26, 2016%'", null,
                null, null, null);

        String[] showColumns = new String[] { MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        int[] views = new int[] { android.R.id.text1, android.R.id.text2 };

        adapter1 = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item, cursor, showColumns, views);
        list.setAdapter(adapter1);
    }
    public void onResume627() {
        super.onResume();
        db = dbHelper.getWritableDatabase();

        String[] queryColumns = new String[] { "_id", MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, MyDbHelper.COL_NAME  + " LIKE '%June 27, 2016%'", null,
                null, null, null);

        String[] showColumns = new String[] { MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        int[] views = new int[] { android.R.id.text1, android.R.id.text2 };

        adapter1 = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item, cursor, showColumns, views);
        list.setAdapter(adapter1);
    }
    public void onResume628() {
        super.onResume();
        db = dbHelper.getWritableDatabase();

        String[] queryColumns = new String[] { "_id", MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, MyDbHelper.COL_NAME  + " LIKE '%June 28, 2016%'", null,
                null, null, null);

        String[] showColumns = new String[] { MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        int[] views = new int[] { android.R.id.text1, android.R.id.text2 };

        adapter1 = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item, cursor, showColumns, views);
        list.setAdapter(adapter1);
    }
    public void onResume629() {
        super.onResume();
        db = dbHelper.getWritableDatabase();

        String[] queryColumns = new String[] { "_id", MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, MyDbHelper.COL_NAME  + " LIKE '%June 29, 2016%'", null,
                null, null, null);

        String[] showColumns = new String[] { MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        int[] views = new int[] { android.R.id.text1, android.R.id.text2 };

        adapter1 = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item, cursor, showColumns, views);
        list.setAdapter(adapter1);
    }
    public void onResume630() {
        super.onResume();
        db = dbHelper.getWritableDatabase();

        String[] queryColumns = new String[] { "_id", MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, MyDbHelper.COL_NAME  + " LIKE '%June 30, 2016%'", null,
                null, null, null);

        String[] showColumns = new String[] { MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        int[] views = new int[] { android.R.id.text1, android.R.id.text2 };

        adapter1 = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item, cursor, showColumns, views);
        list.setAdapter(adapter1);
    }



    @Override
    public void onPause() {
        super.onPause();
        cursor.close();
        db.close();
    }

    @Override
    public void onClick(View v) {
        ContentValues cv = new ContentValues();
        cv.put(MyDbHelper.COL_NAME, etPersonName.getText().toString());

        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        cv.put(MyDbHelper.COL_DATE, dateFormat.format(new Date()));

        db.insert(MyDbHelper.TABLE_NAME, null, cv);
        cursor.requery();
        adapter.notifyDataSetChanged();
        etPersonName.setText(null);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View v, final int positionNok, long id) {

        AlertDialog.Builder builder = new AlertDialog.Builder(CaldroidSampleActivity.this);

        builder.setTitle("This is a dialog.");
        builder.setMessage("Are you sure you want to delete collection?");
        AlertDialog.Builder yes = builder.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int position) {
                        cursor.moveToPosition(positionNok);
                        String rowId = cursor.getString(0);
                        Toast.makeText(getApplicationContext(),rowId,Toast.LENGTH_LONG).show();
                        db.delete(MyDbHelper.TABLE_NAME, "_id = ?", new String[]{rowId});
                        cursor.requery();
                    }
                });
        builder.setNegativeButton("No",
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        builder.show();
        /*cursor.moveToPosition(position);
        String rowId = cursor.getString(0);
        db.delete(MyDbHelper.TABLE_NAME, "_id = ?", new String[] { rowId });
        cursor.requery();*/

        // Showing Alert Message
        /*cursor.moveToPosition(position);
        String rowId = cursor.getString(0);
        db.delete(MyDbHelper.TABLE_NAME, "_id = ?", new String[] { rowId });
        cursor.requery();
        //adapter.notifyDataSetChanged();*/
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
            Intent intent = new Intent(CaldroidSampleActivity.this, MainActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
