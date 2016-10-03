package com.example.daniel.cmput_301_assignment_1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;

public class HabitListController extends Observable
{
    private static HabitList habitList = null;

    public static HabitList getHabitList()
    {
        if (habitList == null)
        {
            habitList = new HabitList();
        }

        return habitList;
    }

    public void addHabit(Habit habit)
    {
        getHabitList().addHabit(habit);
        notifyListeners();
    }

    private void notifyListeners() {
    }

    public void removeHabit(Habit habit)
    {
        getHabitList().removeHabit(habit);
    }

}
