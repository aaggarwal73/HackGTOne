package com.hackgtone.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.hackgtone.R;
import com.hackgtone.model.Trip;

public class MainActivity extends AppCompatActivity {
    Main singleton = Main.getInstance();

    private LinearLayout ll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //create button dynamically
        LinearLayout ll = (LinearLayout)findViewById(R.id.buttonlayout);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        Trip[] trips = Main.getTrips();
        for (final Trip trip: trips) {
            Button myButton = new Button(this);
            myButton.setText(trip.getName()); //myButton.setText(trip.getName());
            ll.addView(myButton, lp);
            myButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    singleton.setCurrentTrip(trip);
                    nextScreen();
                }
            });
        }
    }

    public void nextScreen() {
        Intent goToNextActivity = new Intent(getApplicationContext(), ItineraryActvity.class);
        startActivity(goToNextActivity);
    }
}
