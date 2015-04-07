package com.ashish.remindit;

import java.sql.Date;
import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.method.DateTimeKeyListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

public class GetStarted extends Activity 
{
	private static String noteString = null;
	private static boolean isAlarmSet = false;
	private static Date reminderDate = null;
	private static Calendar myCalendar = Calendar.getInstance();
	
	TimePickerDialog.OnTimeSetListener timepicker = new TimePickerDialog.OnTimeSetListener() 
	{
		public void onTimeSet(TimePicker view, int hourOfDay, int minute) 
		{
			myCalendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
			myCalendar.set(Calendar.MINUTE, minute);
		}
	};
		
	DatePickerDialog.OnDateSetListener datepicker = new DatePickerDialog.OnDateSetListener() 
	{
		public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) 
		{
			myCalendar.set(Calendar.YEAR, year);
			myCalendar.set(Calendar.MONTH, monthOfYear);
			myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
		}
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
        	super.onCreate(savedInstanceState);
        	setContentView(R.layout.activity_get_started);
        	
        	final EditText reminderNote = (EditText)findViewById(R.id.textNote);
        	final Button setReminder = (Button)findViewById(R.id.btReminder);
        	final Button when = (Button)findViewById(R.id.btWhen);
        	final CheckBox setAlarm = (CheckBox)findViewById(R.id.chkSetAlarm);
        	
        	when.setOnClickListener(new OnClickListener() 
        	{
				@Override
				public void onClick(View arg0) 
				{
					new DatePickerDialog(GetStarted.this, datepicker, myCalendar
							.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
							myCalendar.get(Calendar.DAY_OF_MONTH)).show();
					
					new TimePickerDialog(GetStarted.this, timepicker, myCalendar
							.get(Calendar.HOUR_OF_DAY), myCalendar
							.get(Calendar.MINUTE), true).show();
				}
			});
        	
        	setReminder.setOnClickListener(new OnClickListener() 
        	{	
        		@Override
        		public void onClick(View v) 
        		{
        			noteString = reminderNote.getText().toString();
        			isAlarmSet = setAlarm.isSelected();
        			reminderNote.setText("");
        			setAlarm.setChecked(false);
        		}
        	});
		
	}

}
