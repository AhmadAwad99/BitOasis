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
     * General function to show  snack bar
     *
     * @param message message to be showing in the snack bar
     */
    public void showSnackMessage(int containerID, String message) {

        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }


}
