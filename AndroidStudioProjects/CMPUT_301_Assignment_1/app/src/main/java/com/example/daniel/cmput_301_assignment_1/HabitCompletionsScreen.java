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
        final Habit receivedHabit = (Habit) intent.getSerializableExtra("com.example.daniel.cmput_301_assignment_1.data");
        ListView listOfCompletions = (ListView) findViewById(R.id.habit_completion_list);

        final ArrayAdapter<String> habitCompletionAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, receivedHabit.viewCompletions());

        listOfCompletions.setAdapter(habitCompletionAdapter);

        listOfCompletions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id)
            {
                final String deleteHabitCompletion = receivedHabit.viewCompletions().get(pos);
                createCompletionDeleteDialog(receivedHabit, deleteHabitCompletion);
                habitCompletionAdapter.notifyDataSetChanged();
            }
        });
    }

    public void createCompletionDeleteDialog(Habit habit, String delHabitCompletion)
    {
        final Habit habitToRemove = habit;
        final String completionToRemove = delHabitCompletion;
        AlertDialog.Builder deleteDialog = new AlertDialog.Builder(HabitCompletionsScreen.this);
        deleteDialog.setMessage("Delete " + completionToRemove + "?");
        deleteDialog.setCancelable(true);
        deleteDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        deleteDialog.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                HabitListController.getHabitList().removeHabitCompletion(habitToRemove, completionToRemove);
                Toast.makeText(HabitCompletionsScreen.this, "Completion Deleted", Toast.LENGTH_SHORT).show();
            }
        });

        deleteDialog.show();
    }

}
