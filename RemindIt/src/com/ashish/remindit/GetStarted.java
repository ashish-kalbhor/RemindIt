package com.ashish.remindit;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class GetStarted extends Activity 
{
	private static String noteString = null;
	private static boolean isAlarmSet = false;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_get_started);
		
		final EditText reminderNote = (EditText)findViewById(R.id.textNote);
		final Button setReminder = (Button)findViewById(R.id.btReminder);
		final CheckBox setAlarm = (CheckBox)findViewById(R.id.chkSetAlarm);
		
		setReminder.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				GetStarted.noteString = reminderNote.getText().toString();
				GetStarted.isAlarmSet = setAlarm.isSelected();
				reminderNote.setText("");
				setAlarm.setChecked(false);
			}
		});
		
	}

}
