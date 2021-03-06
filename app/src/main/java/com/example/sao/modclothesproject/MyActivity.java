package com.example.sao.modclothesproject;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.android.datetimepicker.date.DatePickerDialog;
import com.android.datetimepicker.time.RadialPickerLayout;
import com.android.datetimepicker.time.TimePickerDialog;
import com.roomorama.caldroid.CaldroidFragment;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Calendar;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import singleton.SingleObject;

public class MyActivity extends AppCompatActivity
        implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener,
        View.OnClickListener,
        AdapterView.OnItemClickListener {
    EditText etPersonName;
    Button btnAddPerson;
    ListView list;

    MyDbHelper dbHelper;
    SQLiteDatabase db;
    Cursor cursor;
    SimpleCursorAdapter adapter1;

    private NotificationManager myNotificationManager;
    private int notificationIdOne = 111;
    private int numMessagesOne = 0;
    private static final String TIME_PATTERN = "HH:mm";

    private TextView lblDate;
    private TextView lblTime;
    private java.util.Calendar calendar;
    private DateFormat dateFormat;
    private SimpleDateFormat timeFormat;

    AlarmManager alarmManager;
    private PendingIntent pendingIntent;
    private TimePicker alarmTimePicker;
    private static MyActivity inst;
    private TextView alarmTextView;
    AlarmReceiver a;

    public static MyActivity instance() {
        return inst;
    }

    @Override
    public void onStart() {
        super.onStart();
        inst = this;
    }

    private boolean undo = false;
    private CaldroidFragment caldroidFragment;
    private CaldroidFragment dialogCaldroidFragment;

    private void setCustomResourceForDates() {
        Calendar cal = Calendar.getInstance();

        cal.add(Calendar.DATE, 0);
        Date oneDate = cal.getTime();

        cal.add(Calendar.DATE, -2);
        Date twoDate = cal.getTime();

        // Min date is last 7 days
        cal.add(Calendar.DATE, -7);
        Date blueDate = cal.getTime();

        // Max date is next 7 days
        cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 7);
        Date greenDate = cal.getTime();

        if (caldroidFragment != null) {
            caldroidFragment.setBackgroundDrawableForDate(getResources().getDrawable(R.mipmap.dress),oneDate);
            caldroidFragment.setBackgroundDrawableForDate(getResources().getDrawable(R.mipmap.dress),twoDate);
            caldroidFragment.setTextColorForDate(R.color.twhite, blueDate);
            caldroidFragment.setTextColorForDate(R.color.twhite, greenDate);
        }
    }

    public void w() {
        String p= lblDate.toString();

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        etPersonName = (EditText) findViewById(R.id.person_name);
        list = (ListView) findViewById(R.id.list);
        list.setOnItemClickListener(this);

        dbHelper = new MyDbHelper(this);


    calendar = java.util.Calendar.getInstance();
        dateFormat = DateFormat.getDateInstance(DateFormat.LONG, Locale.getDefault());
        timeFormat = new SimpleDateFormat(TIME_PATTERN, Locale.getDefault());

        lblDate = (TextView) findViewById(R.id.lblDate);
        lblTime = (TextView) findViewById(R.id.lblTime);


        update();

        alarmTimePicker = (TimePicker) findViewById(R.id.alarmTimePicker);
        alarmTextView = (TextView) findViewById(R.id.alarmText);
        final ToggleButton alarmToggle = (ToggleButton) findViewById(R.id.alarmToggle);
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

    }

    public void onToggleClicked(View view) {
        if (((ToggleButton) view).isChecked()) {
            Log.d("MyActivity", "Alarm On");
            calendar.get(java.util.Calendar.DAY_OF_MONTH);
            calendar.get(java.util.Calendar.MONTH);
            calendar.get(java.util.Calendar.YEAR);
            calendar.get(java.util.Calendar.HOUR_OF_DAY);
            calendar.get(java.util.Calendar.MINUTE);
            Intent myIntent = new Intent(MyActivity.this, AlarmReceiver.class);
            pendingIntent = PendingIntent.getBroadcast(MyActivity.this, 0, myIntent, 0);
            alarmManager.set(AlarmManager.RTC, calendar.getTimeInMillis(), pendingIntent);
            ContentValues cv = new ContentValues();
            cv.put(MyDbHelper.COL_NAME, "Description : "+etPersonName.getText().toString()+"\nTimes : "+lblDate.getText().toString()+" "+lblTime.getText().toString());

            SimpleDateFormat dateFormat = new SimpleDateFormat(
                    "yyyy-MM-dd HH:mm:ss");
            cv.put(MyDbHelper.COL_DATE, dateFormat.format(new Date()));

            db.insert(MyDbHelper.TABLE_NAME, null, cv);
            cursor.requery();
            adapter1.notifyDataSetChanged();
            etPersonName.setText(null);

        } else {
            alarmManager.cancel(pendingIntent);
            setAlarmText("");
            Log.d("MyActivity", "Alarm Off");

        }
    }

    public void setAlarmText(String alarmText) {
        alarmTextView.setText(alarmText);
    }


    private void update() {
        lblDate.setText(dateFormat.format(calendar.getTime()));
        lblTime.setText(timeFormat.format(calendar.getTime()));

        SingleObject.getInstance().setText(lblDate.getText().toString());
    }

    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnDatePicker:
                DatePickerDialog.newInstance(this, calendar.get(java.util.Calendar.YEAR), calendar.get(java.util.Calendar.MONTH), calendar.get(java.util.Calendar.DAY_OF_MONTH)).show(getFragmentManager(), "datePicker");
                break;
            case R.id.btnTimePicker:
                TimePickerDialog.newInstance(this, calendar.get(java.util.Calendar.HOUR_OF_DAY), calendar.get(java.util.Calendar.MINUTE), true).show(getFragmentManager(), "timePicker");
                break;
        }
    }


    @Override
    public void onDateSet(DatePickerDialog dialog, int year, int monthOfYear, int dayOfMonth) {
        calendar.set(year, monthOfYear, dayOfMonth);
        update();
    }

    @Override
    public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute) {
        calendar.set(java.util.Calendar.HOUR_OF_DAY, hourOfDay);
        calendar.set(Calendar.MINUTE, minute);
        update();
    }
/*
    protected void displayNotificationOne() {

        // Invoking the default notification service
        NotificationCompat.Builder  mBuilder = new NotificationCompat.Builder(this);

        mBuilder.setContentTitle("New Message from MOD Clothes");
        mBuilder.setContentText("New message from javacodegeeks received");
        mBuilder.setTicker("Explicit: New Message Received!");
        mBuilder.setSmallIcon(R.mipmap.ic_launcher);

        // Increase notification number every time a new notification arrives
        mBuilder.setNumber(++numMessagesOne);

        // Creates an explicit intent for an Activity in your app
        Intent resultIntent = new Intent(this, MainActivity.class);
        resultIntent.putExtra("notificationId", notificationIdOne);

        //This ensures that navigating backward from the Activity leads out of the app to Home page
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);

        // Adds the back stack for the Intent
        stackBuilder.addParentStack(MainActivity.class);

        // Adds the Intent that starts the Activity to the top of the stack
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_ONE_SHOT //can only be used once
                );
        // start the activity when the user clicks the notification text
        mBuilder.setContentIntent(resultPendingIntent);

        myNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // pass the Notification object to the system
        myNotificationManager.notify(notificationIdOne, mBuilder.build());
    }*/
@Override
public void onResume() {
    super.onResume();
    db = dbHelper.getWritableDatabase();
    String[] queryColumns = new String[] { "_id", MyDbHelper.COL_NAME,
            MyDbHelper.COL_DATE };
    cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, null, null,
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
    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
        cursor.moveToPosition(position);
        String rowId = cursor.getString(0);
        db.delete(MyDbHelper.TABLE_NAME, "_id = ?", new String[] { rowId });
        cursor.requery();
        adapter1.notifyDataSetChanged();
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        // or call onBackPressed()
        return true;
    }
}
