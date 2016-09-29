package com.example.daniel.cmput_301_assignment_1;

import java.util.ArrayList;

/**
 * Created by Mike on 2016-09-26.
 */
public class Habit
{
    private String habitName;
    private String habitDate;
    private ArrayList<String> habitRepeatDays;
    private int completions;

    public Habit(String habitName, String habitDate, ArrayList<String> habitRepeatDays)
    {
        this.habitName = habitName;
        this.habitDate = habitDate;
        this.habitRepeatDays= habitRepeatDays;
        this.completions = 0;
    }

    public String getHabitName()
    {
        return this.habitName;
    }

    public int getNumberOfCompletions()
    {
        return this.completions;
    }
    public void setHabitName(String name)
    {
        this.habitName = name;
    }

    public void setHabitDate(String date)
    {
        this.habitDate = date;
    }

    public void setHabitRepeatDays(ArrayList<String> listOfHabitDays)
    {
        this.habitRepeatDays = listOfHabitDays;
    }

    public ArrayList<String> viewCompletions(Habit habit)
    {
        //Implement later
        return null;
    }

    public String toString()
    {
        return getHabitName();
    }
}
