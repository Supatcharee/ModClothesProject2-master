package com.example.sao.modclothesproject;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

public class TodayActivity extends Activity implements View.OnClickListener,
        AdapterView.OnItemClickListener {

    EditText etPersonName;
    Button btnAddPerson;
    ListView list;

    MyDbHelper dbHelper;
    SQLiteDatabase db;
    Cursor cursor;
    SimpleCursorAdapter adapter;

    private String[] FilePathStrings;
    private String[] FileNameStrings;
    private File[] listFile;
    GridView grid;
    GAdapter adapter1;
    File file;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today);


        list = (ListView) findViewById(R.id.list);
        list.setOnItemClickListener(this);

        dbHelper = new MyDbHelper(this);

        /*if (!Environment.getExternalStorageState().equals(
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
        }


        // Locate the GridView in gridview_main.xml
        grid = (GridView) findViewById(R.id.gridView);
        // Pass String arrays to LazyAdapter Class
        adapter1 = new GAdapter(this, FilePathStrings, FileNameStrings);
        // Set the LazyAdapter to the GridView
        grid.setAdapter(adapter1);*/
    }

    @Override
    public void onResume() {
        super.onResume();
        db = dbHelper.getWritableDatabase();
        String[] queryColumns = new String[] { "_id", MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        cursor = db.query(MyDbHelper.TABLE_NAME, queryColumns, MyDbHelper.COL_NAME  + " LIKE '%May 23, 2016%'", null,
                null, null, null);


        String[] showColumns = new String[] { MyDbHelper.COL_NAME,
                MyDbHelper.COL_DATE };
        int[] views = new int[] { android.R.id.text1, android.R.id.text2 };

        adapter = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item, cursor, showColumns, views);
        list.setAdapter(adapter);
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
    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
       /* cursor.moveToPosition(position);
        String rowId = cursor.getString(0);
        db.delete(MyDbHelper.TABLE_NAME, "_id = ?", new String[] { rowId });
        cursor.requery();
        adapter.notifyDataSetChanged();*/
    }

}