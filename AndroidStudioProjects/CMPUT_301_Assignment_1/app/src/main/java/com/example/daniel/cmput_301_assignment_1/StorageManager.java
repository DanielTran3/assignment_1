package com.example.daniel.cmput_301_assignment_1;


import android.content.Context;
import android.content.SharedPreferences;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class StorageManager
{
    static String FILENAME = "habit_tracker_save_data";
    static Context context;

    public StorageManager(Context context)
    {
        this.context = context;
    }

    public static void storeHabits(HabitList habitList)
    {
        try {
            FileOutputStream fos = context.openFileOutput(FILENAME, Context.MODE_PRIVATE);
            fos.write(habitList);
        }
        catch(FileNotFoundException e)
        {

        }

    }

    public HabitList loadHabits()
    {

    }


}
