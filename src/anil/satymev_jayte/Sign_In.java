package anil.satymev_jayte;
import java.util.Calendar;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import anil.satymev_jayte.R.string;

public class Sign_In extends Activity {
	Button login;
	EditText editText1,editText2;
	TextView textView2,textac;
	SignupData database;
	SigninData database2;
	Cursor cursor;
	int a,b,c;
	//public static int d =0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sign_in_page);
		login = (Button)findViewById(R.id.button5);
		editText1 = (EditText)findViewById(R.id.editText7);
		editText2 = (EditText)findViewById(R.id.editText8);
		textView2 = (TextView)findViewById(R.id.forpass);
		textac = (TextView)findViewById(R.id.createnewac);
		database = new SignupData(this);
		database2 = new SigninData(this);
		
	    login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				a=0;
				b=0;
				c=0;
				// TODO Auto-generated method stub
				String str1 = editText1.getText().toString();
			    String str2 = editText2.getText().toString();
				if(str1.equals("")  &&str2.equals(""))
				{
					Toast.makeText(Sign_In.this, "please enter Username and password", 5000).show();
					a=1;
				}
				else if(str1.equals(""))
			    {
					a=1;
			    	Toast.makeText(Sign_In.this, "please enter Username", 5000).show();
			    	
			    }
			   
				else if(str2.equals(""))
			    {
			    	a=1;
			    	Toast.makeText(Sign_In.this, "please enter Password", 5000).show();
			     }
			  cursor= database.fetchdata();
			  String[] uname = new String[cursor.getCount()];
			  String[] pass = new String[cursor.getCount()];
			  cursor.moveToFirst();
			  for(int i=0;i<cursor.getCount();i++)
			  {
				  uname[i] = cursor.getString(0);
				  pass[i] = cursor.getString(3);
				
				  if(uname[i].equals(str1) && pass[i].equals(str2))
				  {
					  b=1;
					  break;
				  }
				 
				  else
					 cursor.moveToNext();
			    }
			   if(b==0&&a==0)
			   {
				  Toast.makeText(Sign_In.this,"Incorrect username or password", 10000).show();
			   }
			  
			     if(a==0&&b==1)
			    {
	
			    database2.insertdata(str1,str2);
			    Intent intent = new Intent(Sign_In.this,Home.class);
				startActivity(intent);
				finish();
				}
			}
		});
	    textView2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 Intent intent1 = new Intent(Sign_In.this,Forpass.class);
					startActivity(intent1);
	}
		});
 textac.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 Intent intent1 = new Intent(Sign_In.this,Sign_up.class);
					startActivity(intent1);
	
			}
		});
	    }}
