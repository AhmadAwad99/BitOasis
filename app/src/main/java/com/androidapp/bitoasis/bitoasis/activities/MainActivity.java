package com.androidapp.bitoasis.bitoasis.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;


import com.androidapp.bitoasis.bitoasis.R;
import com.androidapp.bitoasis.bitoasis.fragments.FirstViewFragment;
import com.androidapp.bitoasis.bitoasis.fragments.SecondViewkFragment;


public class MainActivity extends BaseActivity {

    FirstViewFragment firstViewFragment;
    SecondViewkFragment secondViewkFragment;




    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_first_view:
                    setUpFragment(firstViewFragment);
                    return true;
                case R.id.navigation_second_view:
                    setUpFragment(secondViewkFragment);
                    return true;

            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        firstViewFragment = FirstViewFragment.newInstance();
        secondViewkFragment = SecondViewkFragment.newInstance();


            setUpFragment(firstViewFragment);




    }


    private void setUpFragment(Fragment fragment) {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(android.R.anim.slide_in_left,
                android.R.anim.slide_out_right,
                R.anim.ltr_anim,
                R.anim.rtl_anim);
        transaction.replace(R.id.container, fragment);

        transaction.commit();

    }


}
