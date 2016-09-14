package com.example.daniel.cmput_301_assignment_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

public class NewHabitScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_habit_screen);

        Intent intent = getIntent();
        TextView textView = new TextView(this);
        textView.setTextSize(40);

        ViewGroup layout = (ViewGroup) findViewById(R.id.new_habit_button);
    }
}
