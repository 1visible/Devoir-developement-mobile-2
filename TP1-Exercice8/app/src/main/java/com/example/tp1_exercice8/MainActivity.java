package com.example.tp1_exercice8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button search;
    EditText departure, arrival;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        departure = (EditText) findViewById(R.id.departure_city);
        arrival = (EditText) findViewById(R.id.arrival_city);
        search = (Button) findViewById(R.id.search);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(getBaseContext(), ScheduleList.class);
                intent.putExtra("DEPARTURE_CITY", departure.getText().toString());
                intent.putExtra("ARRIVAL_CITY", arrival.getText().toString());
                startActivity(intent);
            }
        });
    }
}