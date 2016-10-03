package com.example.daniel.cmput_301_assignment_1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;

public class HabitListController extends Observable
{
    private static HabitList habitList = null;
//    private static StorageManager getStorageManager()
//    {
//        return StorageManager.getManager();
//    }
    public static HabitList getHabitList()
    {
        if (habitList == null)
        {
            habitList = new HabitList();
//            habitList.addListener(new HabitListener() {
//
//                @Override
//                public void update() {
//                    try {
//                        getStorageManager().saveHabits(habitList);
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//
//                }
//            });
//            habitList = StorageManager.loadHabits();
        }

        return habitList;
    }

//    public void saveHabits() throws IOException {
//        StorageManager.saveHabits(habitList);
//    }

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
