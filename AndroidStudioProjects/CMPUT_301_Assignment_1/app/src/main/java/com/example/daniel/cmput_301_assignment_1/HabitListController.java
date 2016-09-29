package com.example.daniel.cmput_301_assignment_1;

/**
 * Created by Daniel on 2016-09-28.
 */
public class HabitListController
{
    private static HabitList habitList = null;

    public HabitList getHabitList()
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
    }

    public void removeHabit(Habit habit)
    {
        getHabitList().removeHabit(habit);
    }

}
