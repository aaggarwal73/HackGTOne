package com.hackgtone;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class ItineraryActvity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary);
        //set number of buttons here.
        LinearLayout ll = (LinearLayout)findViewById(R.id.buttonlayout);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        String[] stops = {"LAX", "FL1", "JFK","FL2"}; //TODO: Change to leg objects
        for (String stop: stops) {
            Button myButton = new Button(this);
            myButton.setText(stop); //myButton.setText(trip.getName());

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
        Intent goToNextActivity = new Intent(getApplicationContext(), ServicesActivty.class);
        startActivity(goToNextActivity);
    }

}
