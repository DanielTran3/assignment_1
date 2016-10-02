package com.example.daniel.cmput_301_assignment_1;

import android.net.sip.SipAudioCall;

import java.util.ArrayList;

/**
 * Created by Daniel on 2016-09-28.
 */
public class HabitList
{

    protected ArrayList<Habit> habitList;
    protected ArrayList<HabitListener> listeners;

    public HabitList()
    {
        habitList = new ArrayList<Habit>();
        listeners = new ArrayList<HabitListener>();
    }

    public void addHabit(Habit habit)
    {
        habitList.add(habit);
        notifyListeners();
    }

    public void notifyListeners()
    {
        for (HabitListener hl : listeners)
        {
            hl.update();
        }
    }

    public void addListener(HabitListener hl)
    {
        listeners.add(hl);
    }

    public void removeListener(HabitListener hl)
    {
        listeners.remove(hl);
    }

    public void removeHabit(Habit habit)
    {
        habitList.remove(habit);
        notifyListeners();
    }

    public ArrayList<Habit> getHabits()
    {
        return habitList;
    }

    public void updateHabitCompletion(Habit retrieveHabit)
    {
        for (Habit h : habitList)
        {
            if (h.equals(retrieveHabit))
            {
                h.updateHabitCompletion();
            }
        }
    }
}
