package com.example.sao.modclothesproject;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.roomorama.caldroid.CaldroidFragment;
import com.roomorama.caldroid.CaldroidListener;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;



@SuppressLint("SimpleDateFormat")
public class CaldroidSampleActivity extends AppCompatActivity implements View.OnClickListener,
        AdapterView.OnItemClickListener{
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

    private void setCustomResourceForDates() {
        Calendar cal = Calendar.getInstance();

        cal.add(Calendar.DATE, 0);
        Date today = cal.getTime();

        cal.add(Calendar.DATE, -1);
        Date oneDate = cal.getTime();

        cal.add(Calendar.DATE, 1);
        Date blueDate = cal.getTime();

        cal.add(Calendar.DATE, 2);
        Date twoDate = cal.getTime();

        cal.add(Calendar.DATE, 3);
        Date threeDate = cal.getTime();

        /*// Min date is last 7 days
        cal.add(Calendar.DATE, -7);
        Date blueDate = cal.getTime();

        // Max date is next 7 days
        cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 7);
        Date greenDate = cal.getTime();*/

        if (caldroidFragment != null) {
            int c = listFile.length-1;
            int b = listFile.length-2;
            int a = listFile.length-3;
            String ab = listFile[a].getAbsolutePath().toString();
            String ab1 = listFile[b].getAbsolutePath().toString();
            String ab2 = listFile[c].getAbsolutePath().toString();
            //caldroidFragment.setTextColorForDate(R.color.black, greenDate);
            Drawable dd = Drawable.createFromPath(ab);
            caldroidFragment.setBackgroundDrawableForDate(dd,twoDate);
            Drawable end = Drawable.createFromPath(ab1);
            Drawable ac = Drawable.createFromPath(ab2);
            //caldroidFragment.setBackgroundDrawableForDate(end,greenDate);
           // caldroidFragment.setBackgroundDrawableForDate(getResources().getDrawable(R.mipmap.aaa),oneDate);
            caldroidFragment.setBackgroundDrawableForDate(ac,blueDate);
            caldroidFragment.setBackgroundDrawableForDate(end,twoDate);
            caldroidFragment.setBackgroundDrawableForDate(dd,oneDate);
            caldroidFragment.setTextColorForDate(R.color.black, blueDate);

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caldroid_sample);
        list = (ListView) findViewById(R.id.list);
        list.setOnItemClickListener(this);

        dbHelper = new MyDbHelper(this);
        if (!Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            Toast.makeText(this, "Error! No SDCARD Found!", Toast.LENGTH_LONG)
                    .show();
        } else {
            // Locate the image folder in your SD Card
            file = new File(Environment.getExternalStorageDirectory()
                    + File.separator + "Collections");
            // Create a new folder if no folder named SDImageTutorial exist
            if(!file.exists()) {
                file.mkdirs();
            }
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
            }
            int i = 1;
            int a = 2;
            int b = 3;
            int c = listFile.length-1;
            /*Toast.makeText(getApplicationContext(), listFile[i].getAbsolutePath(),
                    Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplicationContext(), listFile[a].getAbsolutePath(),
                    Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplicationContext(), listFile[b].getAbsolutePath(),
                    Toast.LENGTH_SHORT).show();*/
            String abc = listFile[c].getAbsolutePath().toString();

            Toast.makeText(getApplicationContext(), listFile[c].getAbsolutePath(),
                    Toast.LENGTH_SHORT).show();
        }





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
        }

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

        //final Button customizeButton = (Button) findViewById(R.id.customize_button);

        // Customize the calendar
        /*customizeButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (undo) {
                    customizeButton.setText(getString(R.string.customize));
                    textView.setText("");

                    // Reset calendar
                    caldroidFragment.clearDisableDates();
                    caldroidFragment.clearSelectedDates();
                    caldroidFragment.setMinDate(null);
                    caldroidFragment.setMaxDate(null);
                    caldroidFragment.setShowNavigationArrows(true);
                    caldroidFragment.setEnableSwipe(true);
                    caldroidFragment.refreshView();
                    undo = false;
                    return;
                }*/

                // Else
                /*undo = true;
                customizeButton.setText(getString(R.string.undo));
                Calendar cal = Calendar.getInstance();

                // Min date is last 7 days
                cal.add(Calendar.DATE, -7);
                Date minDate = cal.getTime();

                // Max date is next 7 days
                cal = Calendar.getInstance();
                cal.add(Calendar.DATE, 14);
                Date maxDate = cal.getTime();

                // Set selected dates
                // From Date
                *//*cal = Calendar.getInstance();
                cal.add(Calendar.DATE, 2);
                Date fromDate = cal.getTime();

                // To Date
                cal = Calendar.getInstance();
                cal.add(Calendar.DATE, 3);
                Date toDate = cal.getTime();
*//*
                // Set disabled dates
                ArrayList<Date> disabledDates = new ArrayList<Date>();
                for (int i = 5; i < 8; i++) {
                    cal = Calendar.getInstance();
                    cal.add(Calendar.DATE, i);
                    disabledDates.add(cal.getTime());
                }

                // Customize
                caldroidFragment.setMinDate(minDate);
                caldroidFragment.setMaxDate(maxDate);
                caldroidFragment.setDisableDates(disabledDates);
                //caldroidFragment.setSelectedDates(fromDate, toDate);
                caldroidFragment.setShowNavigationArrows(false);
                caldroidFragment.setEnableSwipe(false);

                caldroidFragment.refreshView();

                // Move to date
                // cal = Calendar.getInstance();
                // cal.add(Calendar.MONTH, 12);
                // caldroidFragment.moveToDate(cal.getTime());

                *//*String text = "Today: " + formatter.format(new Date()) + "\n";
                text += "Min Date: " + formatter.format(minDate) + "\n";
                text += "Max Date: " + formatter.format(maxDate) + "\n";
                //text += "Select From Date: " + formatter.format(fromDate)
                //        + "\n";
                //text += "Select To Date: " + formatter.format(toDate) + "\n";
                for (Date date : disabledDates) {
                    text += "Disabled Date: " + formatter.format(date) + "\n";
                }

                textView.setText(text);*//*
            }
        });*/

        //Button showDialogButton = (Button) findViewById(R.id.show_dialog_button);

        final Bundle state = savedInstanceState;
        /*showDialogButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // Setup caldroid to use as dialog
                dialogCaldroidFragment = new CaldroidFragment();
                dialogCaldroidFragment.setCaldroidListener(listener);

                // If activity is recovered from rotation
                final String dialogTag = "CALDROID_DIALOG_FRAGMENT";
                if (state != null) {
                    dialogCaldroidFragment.restoreDialogStatesFromKey(
                            getSupportFragmentManager(), state,
                            "DIALOG_CALDROID_SAVED_STATE", dialogTag);
                    Bundle args = dialogCaldroidFragment.getArguments();
                    if (args == null) {
                        args = new Bundle();
                        dialogCaldroidFragment.setArguments(args);
                    }
                } else {
                    // Setup arguments
                    Bundle bundle = new Bundle();
                    // Setup dialogTitle
                    dialogCaldroidFragment.setArguments(bundle);
                }

                dialogCaldroidFragment.show(getSupportFragmentManager(),
                        dialogTag);
            }
        });*/
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
        cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, MyDbHelper.COL_NAME + " LIKE '%May 24, 2016%'", null,
                null, null, null);

        String[] showColumns = new String[] { MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        int[] views = new int[] { android.R.id.text1, android.R.id.text2 };

        adapter1 = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item, cursor, showColumns, views);
        list.setAdapter(adapter1);
    }
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


    @Override
    public void onPause() {
        super.onPause();
        cursor.close();
        db.close();
    }

    @Override
    public void onClick(View v) {
        ContentValues cv = new ContentValues();
        //cv.put(MyDbHelper.COL_NAME, etPersonName.getText().toString());

        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        cv.put(MyDbHelper.COL_DATE, dateFormat.format(new Date()));

        db.insert(MyDbHelper.TABLE_NAME, null, cv);
        cursor.requery();
        adapter.notifyDataSetChanged();
        //etPersonName.setText(null);
    }
    public void open(View view){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Are you sure,You wanted to make decision");

        alertDialogBuilder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(CaldroidSampleActivity.this,"You clicked yes button",Toast.LENGTH_LONG).show();

            }
        });

        alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

       cursor.moveToPosition(position);
        String rowId = cursor.getString(0);
        db.delete(MyDbHelper.TABLE_NAME, "_id = ?", new String[] { rowId });
        cursor.requery();
        adapter.notifyDataSetChanged();
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
