package com.example.daniel.cmput_301_assignment_1;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;


public class HabitTest extends TestCase
{
    public void testConstructor()
    {
        String testName = "Work";
        String testDate = "2016-02-23";
        ArrayList<String> testHabitRepeatDays = new ArrayList<String>();

        Habit habit = new Habit(testName, testDate, testHabitRepeatDays);

        assertTrue(habit.getHabitName().equals("Work"));
        assertTrue(habit.getHabitDate().equals("2016-02-23"));
        assertTrue(habit.getHabitRepeatDays().equals(testHabitRepeatDays));
    }

    public void testSetters()
    {
        String testName = "Work";
        String testDate = "2016-02-23";
        ArrayList<String> testHabitRepeatDays = new ArrayList<String>();

        Habit habit = new Habit(testName, testDate, testHabitRepeatDays);

        habit.setHabitName("Yoga");
        assertFalse(habit.getHabitName().equals("Work"));
        assertTrue(habit.getHabitName().equals("Yoga"));
    }
}
