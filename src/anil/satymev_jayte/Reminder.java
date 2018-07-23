package anil.satymev_jayte;

import java.util.Calendar;




import android.app.Activity;
import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

public class Reminder extends Activity {
	Button date1,time1,alarm1;
	TextView datet,timet;
	Calendar calendar;
	int year= calendar.YEAR;
	int month= calendar.MONTH;
	int day= calendar.DAY_OF_MONTH;
	int hours= calendar.HOUR;
	int minute= calendar.MINUTE;
	String date;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.reminder);
		date1 = (Button)findViewById(R.id.date1);
		time1 = (Button)findViewById(R.id.time1);
		datet = (TextView)findViewById(R.id.date1t);
		timet = (TextView)findViewById(R.id.date2t);
		alarm1 = (Button)findViewById(R.id.alarm1);
		
		date1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				OnDateSetListener dateSetListener=  new OnDateSetListener() {
					@Override
					public void onDateSet(DatePicker view, int year, int monthOfYear,
							int dayOfMonth) {
						// TODO Auto-generated method stub
						
						date= dayOfMonth+"/"+monthOfYear+"/"+year;
						Reminder.this.year= year;
						Reminder.this.month= monthOfYear;
						Reminder.this.day= dayOfMonth;
						datet.setText(dayOfMonth+"/"+monthOfYear+"/"+year);
						
						
					}};
				DatePickerDialog datePickerDialog = new DatePickerDialog(Reminder.this, dateSetListener, 2016, 7,
						30);
				datePickerDialog.show();
				
			}
		});
		time1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				OnTimeSetListener timeSetListener = new OnTimeSetListener() {
					
					@Override
					public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
						// TODO Auto-generated method stub
						
					/*	String time= hourOfDay+":"+minute;
						
						Reminder.this.hours= hourOfDay;
					    Reminder.this.minute= minute;
					    calendar.set(year, month, day, hourOfDay, minute);*/
					    timet.setText(hours + ":"+minute );
						
					}
				};
				TimePickerDialog timePickerDialog = new TimePickerDialog(Reminder.this, timeSetListener, hours,
						minute, true);
				timePickerDialog.show();
			}
		});
		
	/*	alarm1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showAlarm(calendar);
				
			}
		});*/
	}
		
		 void showAlarm(Calendar calendar){
		    	AlarmManager alarmManager= (AlarmManager) getSystemService(Context.ALARM_SERVICE);
		    	Intent intent= new Intent(Reminder.this, MyManager.class);
		    	PendingIntent intent1= PendingIntent.getBroadcast(Reminder.this,
		    			1, intent, 0);
		    	alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, 
		    			calendar.getTimeInMillis(), 10000, intent1);
		
	}

}
