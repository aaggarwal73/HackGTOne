
package com.hackgtone.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.hackgtone.R;
import com.hackgtone.model.Flight;
import com.hackgtone.model.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ServiceInfoActivity extends AppCompatActivity {
    private final String[] times = {"6:00-6:15", "6:15-6:30", "6:30-6:45", "6:45-7:00", "8:15-8:30"};
    private final String[] flightTimes = {"Halfway"};

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
        String item = Facade.getCurrentService().getItem();
        if (!item.equals("")) {
            for (int i = 0; i < itemList.size(); i++) {
                if (itemList.get(i).equals(item)) {
                    itemSpinner.setSelection(i);
                }
            }
        }

        final Spinner timeSpinner = (Spinner) findViewById(R.id.time_spinner);
        List<String> timeList = new ArrayList<>(Arrays.asList(times));
        if(Facade.getCurrentServiceCenter() instanceof Flight) {
            timeList.addAll(Arrays.asList(flightTimes));
        }

        final ArrayAdapter<String> timeAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, timeList);
        timeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        timeSpinner.setAdapter(timeAdapter);
        String time = Facade.getCurrentService().getTimeframe();
        if (!time.equals("")) {
            for (int i = 0; i < timeList.size(); i++) {
                if (timeList.get(i).equals(time)) {
                    timeSpinner.setSelection(i);
                }
            }
        }

        final EditText comment = (EditText)findViewById(R.id.comment);
        comment.setText(Facade.getCurrentService().getComment(), TextView.BufferType.EDITABLE);

        Button submit = (Button) findViewById(R.id.button);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Service s = Facade.getCurrentService();
                if (s.getItem().equals("")) {
                    Facade.getCurrentServiceCenter().addService(s);
                }

                s.setItem(String.valueOf(itemSpinner.getSelectedItem()));
                s.setTimeframe(String.valueOf(timeSpinner.getSelectedItem()));
                s.setComment(comment.getText().toString());

                nextScreen();
            }
        });

        Button delete = (Button) findViewById(R.id.button2);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Service s = Facade.getCurrentService();
                Facade.getCurrentServiceCenter().removeService(s);
                nextScreen();
            }
        });
    }

    public void nextScreen() {
        this.finish();
    }
}
