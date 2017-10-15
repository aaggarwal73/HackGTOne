
package com.hackgtone.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.hackgtone.R;
import com.hackgtone.model.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ServiceInfoActivity extends AppCompatActivity {
    private final String[] times = {"6:00-6:15", "6:15-6:30", "6:30-6:45", "6:45-7:00"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        final Spinner itemSpinner = (Spinner) findViewById(R.id.item_spinner);
        List<String> itemList = new ArrayList<>(Facade.getCurrentServiceCenter().getItems());
        final ArrayAdapter<String> itemAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, itemList);
        itemAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        itemSpinner.setAdapter(itemAdapter);

        final Spinner timeSpinner = (Spinner) findViewById(R.id.time_spinner);
        List<String> timeList = new ArrayList<>(Arrays.asList(times));
        final ArrayAdapter<String> timeAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, timeList);
        timeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        timeSpinner.setAdapter(timeAdapter);

        Button submit = (Button) findViewById(R.id.button);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Service s = Facade.getCurrentService();
                s.setItem(String.valueOf(itemSpinner.getSelectedItem()));
                Facade.getCurrentServiceCenter().addService(s);
                nextScreen();
            }
        });
    }

    public void nextScreen() {
        Intent goToNextActivity = new Intent(getApplicationContext(), ServicesActivity.class);
        startActivity(goToNextActivity);
    }
}
