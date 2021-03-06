
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
import com.hackgtone.model.Flight;
import com.hackgtone.model.ServiceCenter;
import com.hackgtone.model.SkyClub;

public class ItineraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //set number of buttons here.
        LinearLayout ll = (LinearLayout)findViewById(R.id.buttonlayout);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);


        for (final ServiceCenter sc : Facade.getCurrentTrip().getServiceCenters()) {
            Button myButton = new Button(this);
            if (sc instanceof SkyClub) {
                myButton.setText(String.format("SkyClub at %s", sc.getSrc()));
            } else {
                Flight f = (Flight) sc;
                myButton.setText(String.format("Flight %d %s to %s at %s",
                        f.getId(), f.getSrc(), f.getDst(), f.getDeparting()));
            }

            Facade.setCurrentServiceCenter(sc);

            ll.addView(myButton, lp);
            myButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Facade.setCurrentServiceCenter(sc);
                    nextScreen();
                }
            });
        }

    }
    public void nextScreen() {
        Intent goToNextActivity = new Intent(getApplicationContext(), ServicesActivity.class);
        startActivity(goToNextActivity);
    }

}
