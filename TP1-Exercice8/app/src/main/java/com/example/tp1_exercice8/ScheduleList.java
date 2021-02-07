package com.example.tp1_exercice8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ScheduleList extends AppCompatActivity {

    LinearLayout layout;
    List<Schedule> schedules;
    String departure, arrival;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_list);

        layout = (LinearLayout) findViewById(R.id.schedule_list);

        schedules = new ArrayList<Schedule>();
        schedules.add(new Schedule("Paris", "Marseille", "08/02 13:05", "T6", "1h35"));
        schedules.add(new Schedule("Paris", "Lyon", "08/02 09:35", "T2", "1h10"));
        schedules.add(new Schedule("Lilles", "Marseille", "09/02 10:15", "T1", "1h45"));
        schedules.add(new Schedule("Paris", "Montpellier", "10/02 17:50", "T5", "2h30"));
        schedules.add(new Schedule("Marseille", "Montpellier", "08/02 12:45", "T4", "1h55"));
        schedules.add(new Schedule("Paris", "Marseille", "09/02 07:15", "T3", "2h05"));
        schedules.add(new Schedule("Marseille", "Montpellier", "10/02 20:30", "T7", "1h15"));

        departure = getIntent().getStringExtra("DEPARTURE_CITY");
        arrival = getIntent().getStringExtra("ARRIVAL_CITY");

        // Un RecyclerView (ou ListView) aurait été plus pertinent, mais pour des raisons de simplifications,
        // j'ai utilisé des TextView dans un LinearLayout vertical.
        for(Schedule schedule : schedules) {
            Log.i("TRAINS", schedule.toString() + schedule.match(departure, arrival));
            if(schedule.match(departure, arrival)) {
                TextView tv = new TextView(this);
                tv.setText(schedule.toString());
                layout.addView(tv);
            }
        }

    }
}