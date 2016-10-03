package com.example.daniel.cmput_301_assignment_1;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class HabitCompletionsScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completions_habit);
        Intent intent = getIntent();
        Habit passedHabit = (Habit) intent.getSerializableExtra("com.example.daniel.cmput_301_assignment_1.data");
        final ListView listOfCompletions = (ListView) findViewById(R.id.habit_completion_list);
        ArrayList<Habit> oldHabitList = HabitListController.getHabitList().getHabits();
        final Habit receivedHabit = getHabit(oldHabitList, passedHabit.getHabitName());
        final ArrayAdapter<String> habitCompletionAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, receivedHabit.viewCompletions());

        listOfCompletions.setAdapter(habitCompletionAdapter);

        listOfCompletions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id)
            {
                final String deleteHabitCompletion = receivedHabit.viewCompletions().get(pos);
                HabitListController.getHabitList().removeHabitCompletion(receivedHabit, deleteHabitCompletion);
                habitCompletionAdapter.notifyDataSetChanged();
                HabitListController.getHabitList().notifyListeners();
                listOfCompletions.invalidate();
            }
        });
    }

    public Habit getHabit(ArrayList<Habit> hl, String habitName)
    {
        for (Habit h : hl)
        {
            if (h.getHabitName().equals(habitName))
            {
                return h;
            }
        }
        return null;
    }
}
