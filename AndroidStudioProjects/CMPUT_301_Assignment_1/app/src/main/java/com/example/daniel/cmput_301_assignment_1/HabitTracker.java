package com.example.daniel.cmput_301_assignment_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;


public class HabitTracker extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list_of_habits();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void deleteHabits(MenuItem menu)
    {
        Toast.makeText(this, "Delete Habits", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(HabitTracker.this, DeleteHabit.class);
        startActivity(intent);
    }

    public void addNewHabit(View v)
    {
        Intent intent = new Intent(HabitTracker.this, NewHabitScreen.class);
        startActivity(intent);
    }

    public void list_of_habits()
    {
        ListView habitList = (ListView) findViewById(R.id.habitTrackerMainListView);

        Collection<Habit> habits = new HabitListController().getHabitList().getHabits();
        ArrayList<Habit> list = new ArrayList<Habit>(habits);
        ArrayAdapter<Habit> habitTrackerAdapter = new ArrayAdapter<Habit>(this, android.R.layout.simple_list_item_1, list);

        habitList.setAdapter(habitTrackerAdapter);
    }
}

