package anil.satymev_jayte;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.opengl.ETC1;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import anil.satymev_jayte.R.string;

public class Forpass extends Activity{
	Button cp;
	EditText editText81,editText82,editText83;
	Cursor cursor;
	SignupData database;
	int b;
	
    @Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.forpass);
		cp = (Button)findViewById(R.id.cp);
		editText81 = (EditText)findViewById(R.id.editText81);
		editText82 = (EditText)findViewById(R.id.editText82);
		editText83 = (EditText)findViewById(R.id.editText83);
		database = new SignupData(this);
		cp.setOnClickListener(new OnClickListener() {
	
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				b=0;
				
				String str1 = editText81.getText().toString();
			    String str2 = editText82.getText().toString();
			    String str3 = editText83.getText().toString();
			    
			    
			    cursor = database.fetchdata();
				  String[] uname = new String[cursor.getCount()];
				  String[] dob = new String[cursor.getCount()];
				  String[] mn = new String[cursor.getCount()];
				  
				  cursor.moveToFirst();
				  for(int i=0;i<cursor.getCount();i++)
				  {
					  uname[i] = cursor.getString(0);
					  mn[i] = cursor.getString(1);
					  dob[i] = cursor.getString(4);
					  if(uname[i].equals(str1) && mn[i].equals(str2)&&dob[i].equals(str3))
					  {
						  b=1;
						  break;
					  }
					 
					  else
						 cursor.moveToNext();
				    }
				   if(b==0)
				   {
					  Toast.makeText(Forpass.this,"Incorrect Entry", 10000).show();
				   }
			    
			    if(b==1){
			    	
			    	
			    	
				 Intent intent1 = new Intent(Forpass.this,Changepass.class);
				 intent1.putExtra("uname",editText81.getText().toString() );
					startActivity(intent1);
					finish();}
				
			}
		});
		
	}
	

}
