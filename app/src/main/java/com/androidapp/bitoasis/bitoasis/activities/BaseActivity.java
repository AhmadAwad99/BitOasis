package com.androidapp.bitoasis.bitoasis.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Ahmad  awad on 05/11/2018.
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    /**
     * Setup tool bar in base activity
     *
     * @param toolBar  toolbar
     * @param title    title of toolbar
     * @param subtitle subtitle of the toolbar
     */
    protected void setUpToolBar(Toolbar toolBar, String title, String subtitle) {

        toolBar.setTitle(title);

        toolBar.setSubtitle(subtitle);

        toolBar.setNavigationIcon(null);

    }



    /**
     * Setup tool bar in base activity
     *
     * @param toolBar toolbar
     * @param title   title of toolbar
     */
    protected void setUpToolBar(Toolbar toolBar, String title) {

        setUpToolBar(toolBar, title, null);
    }


    /**
     * visibility of tool bar in base activity
     *
     * @param toolbar toolbar
     * @param hide    visibility of toolbar
     */
    protected void hideToolbar(Toolbar toolbar, boolean hide) {
        toolbar.setVisibility(hide ? View.GONE : View.VISIBLE);
    }

    /**
     * General function to show  snack bar
     *
     * @param message message to be showing in the snack bar
     */
    public void showSnackMessage(String message) {

        showSnackMessage(android.R.id.content, message);

    }

    /**
     * General function to show  snack bar
     *
     * @param message message to be showing in the snack bar
     */
    public void showSnackMessage(int containerID, String message) {

        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }


}
