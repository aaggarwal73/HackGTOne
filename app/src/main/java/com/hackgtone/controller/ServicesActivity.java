package com.hackgtone.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.hackgtone.R;
import com.hackgtone.model.Service;

public class ServicesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Facade.setCurrentService(new Service("", "", "", Facade.getCurrentUser()));
                nextScreen();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        LinearLayout ll = (LinearLayout)findViewById(R.id.buttonlayout);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        if (ll.getChildCount() > 0) {
            ll.removeAllViews();
        }
        if (!Facade.getCurrentServiceCenter().getServices().isEmpty()) {
            for (final Service s : Facade.getCurrentServiceCenter().getServices()) {
                Button myButton = new Button(this);
                myButton.setText(String.format("%s -> %s", s.getTimeframe(), s.getItem()));
                ll.addView(myButton, lp);
                myButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Facade.setCurrentService(s);
                        nextScreen();
                    }
                });
            }
        } else {
            Snackbar.make(ll, "No Service Requests! Add one with the + button.", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
    }

    public void nextScreen() {
        Intent goToNextActivity = new Intent(getApplicationContext(), ServiceInfoActivity.class);
        startActivity(goToNextActivity);
    }
}
