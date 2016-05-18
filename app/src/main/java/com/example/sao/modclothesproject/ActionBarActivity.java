package com.example.sao.modclothesproject;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.RelativeLayout;
@SuppressLint("NewApi")
public class ActionBarActivity extends AppCompatActivity implements ActionBar.TabListener {
    RelativeLayout rl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar);
        try {
            rl = (RelativeLayout) findViewById(R.id.mainLayout);
            fragMentTra = getFragmentManager().beginTransaction();
            ActionBar bar = getActionBar();
            bar.addTab(bar.newTab().setText("Listing").setTabListener(this));
            bar.addTab(bar.newTab().setText("Image").setTabListener(this));
            bar.addTab(bar.newTab().setText("Details").setTabListener(this));

            bar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM
                    | ActionBar.DISPLAY_USE_LOGO);
            bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
            bar.setDisplayShowHomeEnabled(true);
            bar.setDisplayShowTitleEnabled(false);
            bar.show();

        } catch (Exception e) {
            e.getMessage();
        }
        /**
         * Hiding Action Bar
         */
    }

    FragMent1 fram1;
    FragmentTransaction fragMentTra = null;
    FragMent2 fram2;
    FragMent3 fram3;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {

        if (tab.getText().equals("Listing")) {
            try {
                rl.removeAllViews();
            } catch (Exception e) {
            }
            fram1 = new FragMent1();
            fragMentTra.addToBackStack(null);
            fragMentTra = getFragmentManager().beginTransaction();
            fragMentTra.add(rl.getId(), fram1);
            fragMentTra.commit();
        } else if (tab.getText().equals("Image")) {
            try {
                rl.removeAllViews();
            } catch (Exception e) {
            }
            fram2 = new FragMent2();
            fragMentTra.addToBackStack(null);
            fragMentTra = getFragmentManager().beginTransaction();
            fragMentTra.add(rl.getId(), fram2);
            fragMentTra.commit();
        } else if (tab.getText().equals("Details")) {
            try {
                rl.removeAllViews();
            } catch (Exception e) {
            }
            fram3 = new FragMent3();
            fragMentTra.addToBackStack(null);
            fragMentTra = getFragmentManager().beginTransaction();
            fragMentTra.add(rl.getId(), fram3);
            fragMentTra.commit();
        }

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

}
