package com.hackgtone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout ll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //create button dynamically
        LinearLayout ll = (LinearLayout)findViewById(R.id.buttonlayout);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        String[] trips = {"home", "first", "second"}; //TODO: Change to trip objects
        for (String trip: trips) {
            Button myButton = new Button(this);
            myButton.setText(trip); //myButton.setText(trip.getName());
            Main.setCurrentTrip(trip);
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
        Intent goToNextActivity = new Intent(getApplicationContext(), ItineraryActvity.class);
        startActivity(goToNextActivity);
    }
}
