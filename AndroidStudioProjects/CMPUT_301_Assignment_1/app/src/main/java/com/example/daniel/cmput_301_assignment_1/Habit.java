package com.example.daniel.cmput_301_assignment_1;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Mike on 2016-09-26.
 */
public class Habit
{
    private String habitName;
    private String habitDate;
    private ArrayList<String> habitRepeatDays;
    private int completions;

    public Habit(String inputName, String inputDate, ArrayList<String> inputRepeatDays)
    {
        this.habitName = inputName;
        this.habitDate = inputDate;
        this.habitRepeatDays= inputRepeatDays;
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

    public String getHabitDate()
    {
        return this.habitDate;
    }

    public void setHabitRepeatDays(ArrayList<String> listOfHabitDays)
    {
        this.habitRepeatDays = listOfHabitDays;
    }

    public ArrayList<String> getHabitRepeatDays()
    {
        return this.habitRepeatDays;
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
