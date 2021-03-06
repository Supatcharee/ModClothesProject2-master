package com.example.sao.modclothesproject;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Sao on 5/16/2016.
 */
public class GAdapter extends BaseAdapter {

    // Declare variables
    private Activity activity;
    private String[] filepath;
    private String[] filename;
    private int[] a1;

    private static LayoutInflater inflater = null;

    public GAdapter(Activity a, String[] fpath, String[] fname) {
        activity = a;
        filepath = fpath;
        filename = fname;
        inflater = (LayoutInflater) activity
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount() {
        return filepath.length;

    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;

        if (convertView == null)
            vi = inflater.inflate(R.layout.griditem, null);
        // Locate the TextView in gridview_item.xml
        //TextView text = (TextView) vi.findViewById(R.id.text);
        // Locate the ImageView in gridview_item.xml
        ImageView image = (ImageView) vi.findViewById(R.id.image);

        // Set file name to the TextView followed by the position
        //text.setText(filename[position]);

        // Decode the filepath with BitmapFactory followed by the position
        Bitmap bmp = BitmapFactory.decodeFile(filepath[position]);

        //Bitmap resizedbitmap = Bitmap.createScaledBitmap(bmp, 230, 230, true);
        bmp = Bitmap.createScaledBitmap(bmp,80,80,false);

        // Set the decoded bitmap into ImageView
        image.setImageBitmap(bmp);
        return vi;
    }
}

