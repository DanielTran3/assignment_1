package com.example.daniel.cmput_301_assignment_1;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.support.v4.app.DialogFragment;
import android.widget.EditText;

import java.util.Calendar;

// Class modeled from https://developer.android.com/guide/topics/ui/controls/pickers.html
public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener
{
    String name;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        final Calendar pick_calendar_date = Calendar.getInstance();
        int year = pick_calendar_date.get(Calendar.YEAR);
        int month = pick_calendar_date.get(Calendar.MONTH);
        int day = pick_calendar_date.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public void onDateSet(DatePicker view, int year, int month, int day)
    {
        view.updateDate(year, month, day);
        name = Integer.toString(day) + Integer.toString(month) + Integer.toString(year);
    }
}
