package com.example.daniel.cmput_301_assignment_1;


import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import android.util.Log;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;

public class StorageManager implements Serializable
{
    static final String prefFile = "habit_data_file";
    static final String habitKey = "habitList";
    Context context;

    public StorageManager(Context context)
    {
        this.context = context;
    }

    public HabitList loadHabits() throws IOException, ClassNotFoundException {
        SharedPreferences sp = context.getSharedPreferences(prefFile, Context.MODE_PRIVATE);
        String habitListData = sp.getString(habitKey, "");
        if (habitListData.equals(""))
        {
            return new HabitList();
        }
        else
        {
            return habitDataFromString(habitListData);
        }
    }


    public void saveHabits(HabitList hl) throws IOException {
        SharedPreferences sp = context.getSharedPreferences(prefFile, Context.MODE_PRIVATE);
        sp.edit().putString(habitKey, habitDataToString(hl));
        sp.edit().apply();
        //Editor editor = sp.edit();
        //editor.putString(habitKey, habitDataToString(hl));
        //editor.commit();
    }

    private HabitList habitDataFromString(String habitListData) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bais = new ByteArrayInputStream(Base64.decode(habitListData, Base64.DEFAULT));
        ObjectInputStream ois = new ObjectInputStream(bais);
        return (HabitList) ois.readObject();
    }

    private String habitDataToString(HabitList hl) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(hl);
        oos.close();
        byte bytes[] =  baos.toByteArray();
        baos.close();
        return Base64.encodeToString(bytes, Base64.DEFAULT);
    }

}



//    public HabitList loadHabits()
//    {
//        SharedPreferences settings = context.getSharedPreferences(FILENAME, context.MODE_PRIVATE);
//        String habitData = settings.getString("ListOfHabits", "");
//        if (habitData.equals(""))
//        {
//            return new HabitList();
//        }
//        else
//        {
//
//        }
//        return habitData;
//    }