package com.example.daniel.cmput_301_assignment_1;


import junit.framework.TestCase;

import java.util.ArrayList;

public class StorageManagerTest extends TestCase
{
    public void testSavingHabits()
    {
        ArrayList<String> days = new ArrayList<String>();
        days.add("Monday");
        Habit newHabit = new Habit("Do Homework", "2016-10-11", days);
        HabitList habitList = new HabitList();
        habitList.addHabit(newHabit);
        StorageManager hts = new StorageManager(getContext());

        hts.storeHabits(habitList);

        HabitList loadHabitList = hts.loadHabits();

    }
}
