package com.example.daniel.cmput_301_assignment_1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class Habit implements Serializable
{
    private String habitName;
    private String habitDate;
    private ArrayList<String> habitRepeatDays;
    private int completions;
    private ArrayList<String> completionList = new ArrayList<String>();

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

    public void setHabitName(String name)
    {
        this.habitName = name;
    }

    public int getHabitCompletions()
    {
        return this.completions;
    }

    public void updateHabitCompletion()
    {
        Date newCompletion = new Date();
        this.completionList.add(newCompletion.toString());
        this.completions = completionList.size();
    }

    //possibly update to position instead of String
    public void removeHabitCompletion(String removeCompletion)
    {
        completionList.remove(removeCompletion.toString());
        this.completions = completionList.size();
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

    public ArrayList<String> viewCompletions()
    {
        //Implement later
        return completionList;
    }

    public String toString()
    {
        return getHabitName();
    }


}
