package anil.satymev_jayte;

import java.util.Calendar;
import java.util.Date;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;


public class AlarmDemo extends Activity {
Button rbutton, rbutton2, rbutton3;
TextView rtextView;
Calendar calendar;
int year= calendar.YEAR;
int month= calendar.MONTH;
int day= calendar.DAY_OF_MONTH;
int hours= calendar.HOUR;
int minute= calendar.MINUTE;
String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reminder);
        rbutton= (Button)findViewById(R.id.rbutton1);
        rbutton2= (Button)findViewById(R.id.rbutton2);
        rbutton3= (Button)findViewById(R.id.rbutton3);
        rtextView= (TextView)findViewById(R.id.rtextView1);
        calendar= Calendar.getInstance();
       
        calendar.set(year, month, day);
        calendar.setTime(new Date());
        rbutton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				OnDateSetListener callBack=
						new OnDateSetListener() {
							
							@Override
							public void onDateSet(DatePicker view, int year, int monthOfYear,
									int dayOfMonth) {
								// TODO Auto-generated method stub
								
								date= dayOfMonth+"/"+monthOfYear+"/"+year;
								AlarmDemo.this.year= year;
								AlarmDemo.this.month= monthOfYear;
								AlarmDemo.this.day= dayOfMonth;
								
							}
						};
				DatePickerDialog datePickerDialog=
						new DatePickerDialog(AlarmDemo.this, callBack, 2016, month, day);
			datePickerDialog.show();
			}
		}); 
        rbutton2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				OnTimeSetListener callBack=
						new OnTimeSetListener() {

							@Override
							public void onTimeSet(TimePicker view,
									int hourOfDay, int minute) {
								// TODO Auto-generated method stub
								String time= hourOfDay+":"+minute;
								
								AlarmDemo.this.hours= hourOfDay;
								AlarmDemo.this.minute= minute;
								
								calendar.set(year, month, day, hourOfDay, minute);
							//	textView.setText(date+" "+time);
								rtextView.setText(""+calendar.getTime());
							}
							
							
						};
				TimePickerDialog timePickerDialog=
						new TimePickerDialog(AlarmDemo.this, callBack, hours, minute, true);
			timePickerDialog.show();
			}
		});
        
        rbutton3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
				showAlarm(calendar);
			}
		});
    }
    
    void showAlarm(Calendar calendar){
    	AlarmManager alarmManager= (AlarmManager) getSystemService(Context.ALARM_SERVICE);
    	Intent intent= new Intent(AlarmDemo.this, MyManager.class);
    	PendingIntent intent1= PendingIntent.getBroadcast(AlarmDemo.this,
    			1, intent, 0);
    	alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, 
    			calendar.getTimeInMillis(), 10000, intent1);
    	
    }


}
