package com.example.daniel.cmput_301_assignment_1;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;


public class NewHabitScreen extends AppCompatActivity implements DatePickerFragment.OnCompleteListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_habit_screen);

    }

    public void openDateSelector(View v)
    {
        // Code from http://android-developers.blogspot.ca/2012/05/using-dialogfragments.html
        FragmentManager fm = getSupportFragmentManager();
        DatePickerFragment pickDate = new DatePickerFragment();
        pickDate.show(fm,"pick_date");
    }

    public void onComplete(String date) {
        Toast.makeText(this, "complete date", Toast.LENGTH_SHORT).show();
        // Change button text
    }
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
