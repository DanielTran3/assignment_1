package com.example.daniel.cmput_301_assignment_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class NewHabitScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_habit_screen);

        TextView viewTodaysDate = (TextView) findViewById(R.id.new_habit_date);
        viewTodaysDate.setText(generateTodaysDate());

        //.invalidate() method for refresh from: http://stackoverflow.com/questions/13150073/how-to-dynamically-update-textview-text
        viewTodaysDate.invalidate();
    }

    public String generateTodaysDate()
    {
        Date todaysDate = new Date();

        // Simple date format from: https://www.mkyong.com/java/java-how-to-get-current-date-time-date-and-calender/
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(todaysDate);

    }

    public ArrayList<String> getDaysOfWeek()
    {
        ArrayList<String> dayChecked = new ArrayList<String>();

        // int[] format from: http://stackoverflow.com/questions/26606348/how-to-make-array-of-unique-android-ids
        int[] idArray = new int[]{R.id.checkbox_Sunday, R.id.checkbox_Monday, R.id.checkbox_Tuesday,
                R.id.checkbox_Wednesday, R.id.checkbox_Thursday, R.id.checkbox_Friday, R.id.checkbox_Saturday};

        for (int checkBoxID : idArray)
        {
            CheckBox isDayChecked = (CheckBox) findViewById(checkBoxID);
            if (isDayChecked.isChecked())
            {
                String checkedDayName = isDayChecked.getText().toString();
                dayChecked.add(checkedDayName);
            }
        }
        return dayChecked;
    }

    public String getHabitName()
    {
        EditText enteredHabitName = (EditText) findViewById(R.id.new_habit_text);
        return enteredHabitName.getText().toString();
    }

    public void cancelNewHabit(View v)
    {
        finish();
    }

    public void createNewHabit(View v)
    {
        HabitListController hlController = new HabitListController();
        if(getHabitName().equals(""))
        {
            Toast.makeText(this, "Please input a habit name", Toast.LENGTH_SHORT).show();
        }

        else if(getDaysOfWeek().size() == 0)
        {
            Toast.makeText(this, "Please select a day or multiple days to repeat", Toast.LENGTH_SHORT).show();
        }

        else
        {
            Toast.makeText(this, "New habit successfully created!", Toast.LENGTH_SHORT).show();
            String newDate = generateTodaysDate();
            String newName = getHabitName();
            ArrayList<String> newDaysOfWeek = getDaysOfWeek();
            hlController.addHabit(new Habit(newDate, newName, newDaysOfWeek));
            finish();
        }

    }
//    public void openDateSelector(View v)
//    {
//        // Code from http://android-developers.blogspot.ca/2012/05/using-dialogfragments.html
//        FragmentManager fm = getSupportFragmentManager();
//        DatePickerFragment pickDate = new DatePickerFragment();
//        pickDate.show(fm,"pick_date");
//    }

//    public void onComplete(String date) {
//        Toast.makeText(this, "complete date", Toast.LENGTH_SHORT).show();
//        // Change button text
//    }
}


//    private CheckBox sundayBox;
//    private CheckBox mondayBox;
//    private CheckBox tuesdayBox;
//    private CheckBox wednesdayBox;
//    private CheckBox thursdayBox;
//    private CheckBox fridayBox;
//    private CheckBox saturdayBox;
//
//    private Button ok_button;
//    private Button cancel_button;
//    private Button calendar_button;
//sundayBox = (CheckBox) findViewById(R.id.checkbox_Sunday);
//        mondayBox = (CheckBox) findViewById(R.id.checkbox_Monday);
//        tuesdayBox = (CheckBox) findViewById(R.id.checkbox_Tuesday);
//        wednesdayBox = (CheckBox) findViewById(R.id.checkbox_Wednesday);
//        thursdayBox = (CheckBox) findViewById(R.id.checkbox_Thursday);
//        fridayBox = (CheckBox) findViewById(R.id.checkbox_Friday);
//        saturdayBox = (CheckBox) findViewById(R.id.checkbox_Saturday);
//
//        ok_button = (Button) findViewById(R.id.new_habit_ok);
//        cancel_button = (Button) findViewById(R.id.new_habit_cancel);
//        calendar_button = (Button) findViewById(R.id.calendar_button);
//
//        ok_button.setOnClickListener(new View.OnClickListener() {
//
//@Override
//public void onClick(View v)
//        {
//        if(sundayBox.isChecked())
//        {
//
//        }
//
//        if(mondayBox.isChecked())
//        {
//
//        }
//
//        if(saturdayBox.isChecked())
//        {
//
//        }
//
//        if(saturdayBox.isChecked())
//        {
//
//        }
//
//        if(saturdayBox.isChecked())
//        {
//
//        }
//
//        if(saturdayBox.isChecked())
//        {
//
//        }
//
//        if(saturdayBox.isChecked())
//        {
//
//        }
//        }
//        });
//
//        cancel_button.setOnClickListener(new View.OnClickListener() {
//
//@Override
//public void onClick(View v)
//        {
//        finish();
//        }
//        });
//
//        calendar_button.setOnClickListener(new View.OnClickListener() {
//
//@Override
//public void onClick(View v)
//        {
//        DialogFragment newFragment = new DatePickerFragment();
//
//        newFragment.show(getSupportFragmentManager(), "datePicker");
//
//
////                date_picker = (DatePicker) findViewById(R.id.pick_date);
////                date_picker.setVisibility(View.VISIBLE);
//
//
//        }
//        });
