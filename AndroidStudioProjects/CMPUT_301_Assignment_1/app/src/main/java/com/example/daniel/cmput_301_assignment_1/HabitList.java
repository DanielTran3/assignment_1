package com.example.daniel.cmput_301_assignment_1;

import java.util.ArrayList;

/**
 * Created by Daniel on 2016-09-28.
 */
public class HabitList
{

    protected ArrayList<Habit> habitList;

    public HabitList()
    {
        habitList = new ArrayList<Habit>();
    }

    public void addHabit(Habit habit)
    {
        habitList.add(habit);
        notifyListeners();
    }

    private void notifyListeners() {
    }

    public void removeHabit(Habit habit)
    {
        habitList.remove(habit);
    }

    public ArrayList<Habit> getHabits()
    {
        return habitList;
    }
}
