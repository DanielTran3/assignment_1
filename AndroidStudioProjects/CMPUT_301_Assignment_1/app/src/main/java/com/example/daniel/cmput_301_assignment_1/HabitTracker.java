package com.example.daniel.cmput_301_assignment_1;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class HabitTracker extends AppCompatActivity implements Serializable {

    private static final String FILENAME = "habit_data.sav";
    private ArrayList<Habit> hlist = new HabitListController().getHabitList().getHabits();
    private HabitList list_of_habits;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListView habitList = (ListView) findViewById(R.id.habitTrackerMainListView);
        list_of_habits = HabitListController.getHabitList();
        loadHabits(this.getApplicationContext());
        for(Habit h : hlist)
        {
            list_of_habits.addHabit(h);
        }
//        ArrayList<Habit> habits = loadHabits();
//        ArrayList<Habit> habits = new HabitListController().getHabitList().getHabits();
//        final ArrayList<Habit> hlist = new ArrayList<Habit>(habits);
        final ArrayAdapter<Habit> habitTrackerAdapter = new ArrayAdapter<Habit>(this, android.R.layout.simple_list_item_1, list_of_habits.getHabits())
        {

            // Code to change text from: http://android--code.blogspot.ca/2015/08/android-listview-text-color.html
            @Override
            public View getView(int position, View convertView, ViewGroup parent)
            {
                View view = super.getView(position, convertView, parent);
                TextView tv = (TextView) view.findViewById(android.R.id.text1);

                String todaysDate = generateTodaysDate();

                // Change to encorporate day with completion
                if (hlist.get(position).getHabitCompletions() == 0)
                {
                    tv.setTextColor(Color.RED);
                }
                else
                {
                    tv.setTextColor(Color.GREEN);
                }
                //tv.setText(String.format("%s\n%s", hlist.get(position).getHabitName(), TextUtils.join(", ", hlist.get(position).getHabitRepeatDays())));
                return view;
            }
        };

        habitList.setAdapter(habitTrackerAdapter);

        HabitListController.getHabitList().addListener(new HabitListener() {
            @Override
            public void update()
            {
                hlist.clear();
                ArrayList<Habit> habits = list_of_habits.getHabits();
                hlist.addAll(habits);
                habitTrackerAdapter.notifyDataSetChanged();
                saveHabits();
            }
        });
        habitList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int pos, long id) {
                final Habit habitToRemove = hlist.get(pos);
                createDeletionDialog(habitToRemove);
                return true;
            }
        });

        habitList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id)
            {
                final Habit habitToComplete = hlist.get(pos);
                createCompletionDialog(habitToComplete);
                habitTrackerAdapter.notifyDataSetChanged();
            }
        });
    }

    public void addNewHabit(View v)
    {
        Intent intent = new Intent(HabitTracker.this, NewHabitScreen.class);
        startActivity(intent);
    }

    public void createDeletionDialog(Habit habit)
    {
        final Habit habitToRemove = habit;
        AlertDialog.Builder deleteDialog = new AlertDialog.Builder(HabitTracker.this);
        deleteDialog.setMessage("Delete " + habitToRemove.getHabitName() + "?");
        deleteDialog.setCancelable(true);
        deleteDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        deleteDialog.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                HabitListController.getHabitList().removeHabit(habitToRemove);
                saveHabits();
                Toast.makeText(HabitTracker.this, "Habit '" + habitToRemove.getHabitName() + "' deleted", Toast.LENGTH_SHORT).show();
            }
        });

    deleteDialog.show();
    }

    private void createCompletionDialog(Habit habit)
    {
        final Habit habitToComplete = habit;
        AlertDialog.Builder completeDialog = new AlertDialog.Builder(HabitTracker.this);
        completeDialog.setMessage("Add Completion to " + habitToComplete.getHabitName() + "?");
        completeDialog.setCancelable(true);
        completeDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        completeDialog.setPositiveButton("Complete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                HabitListController.getHabitList().updateHabitCompletion(habitToComplete);
                saveHabits();
                Toast.makeText(HabitTracker.this,
                        "Habit '" + habitToComplete.getHabitName() +
                        "' has " + habitToComplete.getHabitCompletions() +
                        " completions", Toast.LENGTH_SHORT).show();
            }
        });
        completeDialog.setNeutralButton("View Completions", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ArrayList<String> habitCompletions = habitToComplete.viewCompletions();
                    if (habitCompletions.size() == 0)
                {
                    Toast.makeText(HabitTracker.this, "Habit has no completions", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(HabitTracker.this, HabitCompletionsScreen.class);
                    intent.putExtra("com.example.daniel.cmput_301_assignment_1.data", habitToComplete);
                    startActivity(intent);
                }
            }
        });
        completeDialog.show();
    }

//    @Override
//    protected void onStart()
//    {
//        super.onStart();
//        loadHabits();
//
//    }
    private void loadHabits(Context context)
    {
        try
        {
            // Getting file directory code to ensure file is created from:
            // stackoverflow.com/questions/5017292/how-to-create-a-file-on-android-internal-storage
            ContextWrapper cw = new ContextWrapper(context);
            File dir = cw.getDir(FILENAME, context.MODE_PRIVATE);

            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader br_in = new BufferedReader(new InputStreamReader(fis));

            Gson gson = new Gson();

            // Code from http://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt
            Type listType = new TypeToken<ArrayList<Habit>>(){}.getType();

            hlist = gson.fromJson(br_in, listType);
        } catch (FileNotFoundException e) {
//            return new HabitListController().getHabitList().getHabits();
            hlist = HabitListController.getHabitList().getHabits();
        }
    }

    private void saveHabits()
    {
        try {
            FileOutputStream fos = openFileOutput(FILENAME, 0);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            Gson gson = new Gson();
            gson.toJson(hlist, bw);
            bw.flush();
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public String generateTodaysDate()
    {
        Date todaysDate = new Date();

        // Simple date format from: https://www.mkyong.com/java/java-how-to-get-current-date-time-date-and-calender/
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(todaysDate);
    }
//    public  list_of_habits()
//    {
//        ListView habitList = (ListView) findViewById(R.id.habitTrackerMainListView);
//
//        Collection<Habit> habits = new HabitListController().getHabitList().getHabits();
//        final ArrayList<Habit> list = new ArrayList<Habit>(habits);
//        final ArrayAdapter<Habit> habitTrackerAdapter = new ArrayAdapter<Habit>(this, android.R.layout.simple_list_item_1, list);
//
//        habitList.setAdapter(habitTrackerAdapter);
//
//        HabitListController.getHabitList().addListener(new HabitListener() {
//            @Override
//            public void update()
//            {
//                list.clear();
//                Collection<Habit> habits = new HabitListController().getHabitList().getHabits();
//                list.addAll(habits);
//                habitTrackerAdapter.notifyDataSetChanged();
//            }
//        });
//
//    }
}

