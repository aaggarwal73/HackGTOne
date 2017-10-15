package com.hackgtone.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.hackgtone.R;
import com.hackgtone.model.Trip;

public class MainActivity extends AppCompatActivity {

    Facade facade = Facade.getInstance();
    private LinearLayout ll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // create button dynamically
        LinearLayout ll = (LinearLayout)findViewById(R.id.buttonlayout);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        for (Trip trip: Facade.getCurrentUser().getTrips()) {
            Button myButton = new Button(this);
            myButton.setText(trip.getName());
            Facade.setCurrentTrip(trip);
            ll.addView(myButton, lp);
            myButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    nextScreen();
                }
            });
        }
    }

    public void nextScreen() {
        Intent goToNextActivity = new Intent(getApplicationContext(), ItineraryActivity.class);
        startActivity(goToNextActivity);
    }
}
