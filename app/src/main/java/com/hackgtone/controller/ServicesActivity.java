package com.hackgtone.controller;

import android.content.Intent;
import android.os.Bundle;
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

        LinearLayout ll = (LinearLayout)findViewById(R.id.buttonlayout);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        if (!Facade.getCurrentServiceCenter().getServices().isEmpty()) {
            for (Service s : Facade.getCurrentServiceCenter().getServices()) {
                Button myButton = new Button(this);
                myButton.setText(String.format("%s -> %s", s.getTimeframe(), s.getItem()));
                ll.addView(myButton, lp);
                Facade.setCurrentService(s);
                myButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        nextScreen();
                    }
                });
            }
        } else {
            Button myButton = new Button(this);
            myButton.setText("No service requests! Click here to add.");
            ll.addView(myButton, lp);
            Facade.setCurrentService(null);
            myButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    nextScreen();
                }
            });
        }
    }

    public void nextScreen() {
        Intent goToNextActivity = new Intent(getApplicationContext(), ServiceInfoActivity.class);
        startActivity(goToNextActivity);
    }
}
