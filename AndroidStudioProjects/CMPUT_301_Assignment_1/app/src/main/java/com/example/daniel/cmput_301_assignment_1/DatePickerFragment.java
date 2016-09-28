package com.example.daniel.cmput_301_assignment_1;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.DatePicker;
import android.support.v4.app.DialogFragment;
import android.widget.EditText;

import java.util.Calendar;

// Class modeled from https://developer.android.com/guide/topics/ui/controls/pickers.html
public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener
{

    // Code for listener from: http://stackoverflow.com/questions/15121373/returning-string-from-dialog-fragment-back-to-activity
    public static interface OnCompleteListener {
        public abstract void onComplete(String date);
    }

    private OnCompleteListener mListener;

    // make sure the Activity implemented it
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            this.mListener = (OnCompleteListener)context;
        }
        catch (final ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnCompleteListener");
        }
    }

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
        String date = Integer.toString(year) + "-" + Integer.toString(month) + Integer.toString(day);
        this.mListener.onComplete(date);
    }

}
