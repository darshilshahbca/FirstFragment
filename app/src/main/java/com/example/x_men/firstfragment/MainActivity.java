package com.example.x_men.firstfragment;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

//    private SimpleFragment fragment;
    public static final String FRAGMENT_TAG = "fragment_tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

//        fragment = new SimpleFragment ();

    }

    public void clickHandler(View view) {


        SimpleFragment fragment = SimpleFragment.newInstance ("Passed to factory method");
        getSupportFragmentManager ()
                .beginTransaction ()
                .addToBackStack (null) //To Remove using Back Button
                .add(R.id.fragment_container, fragment, FRAGMENT_TAG)
                .commit ();
    }

    public void removeClickHandler(View view) {

//        android.support.v4.app.Fragment fragment = getSupportFragmentManager ().findFragmentById (R.id.fragment_container);
        android.support.v4.app.Fragment fragment = getSupportFragmentManager ().findFragmentByTag (FRAGMENT_TAG);
        if (fragment != null) {
            getSupportFragmentManager ()
                    .beginTransaction ()
                    .remove (fragment)
                    .commit ();
        }
    }
}
