package anil.satymev_jayte;

import java.nio.charset.UnmappableCharacterException;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager.OnActivityResultListener;
import android.speech.RecognizerIntent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Sign_up extends Activity{
	SignupData database;
	Button submit,city;
	EditText editText1,editText2,editText3,editText4,editText5,editText6;
	int count;
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sign_up);
		submit = (Button)findViewById(R.id.button4);
		city = (Button)findViewById(R.id.button3);
		editText1 = (EditText)findViewById(R.id.editText1);
		editText2 = (EditText)findViewById(R.id.editText2);
		editText3 = (EditText)findViewById(R.id.editText3);
		editText4 = (EditText)findViewById(R.id.editText4);
		editText5 = (EditText)findViewById(R.id.editText5);
		editText6 = (EditText)findViewById(R.id.editText6);
		database = new SignupData(this);
		
		
		city.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent =  new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
				intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "en-US");
				startActivityForResult(intent, 10);
				
			}
		});
submit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			    count=0;
				String uname = editText1.getText().toString();
				if(uname.equals(""))
				count++;
			    		
				String mn =  editText2.getText().toString();
				if(mn.equals(""))
					count++;
				String email = editText3.getText().toString();
				if(email.equals(""))
					count++;
				String pass = editText4.getText().toString();
				if(pass.equals(""))
					count++;
				String dob = editText5.getText().toString();
				if(dob.equals(""))
					count++;
				String city =  editText6.getText().toString();
				if(city.equals(""))
					count++;
				if(count>=1){
					Toast.makeText(Sign_up.this, "please fill all entry", 3000).show();
				Toast.makeText(Sign_up.this, "count: "+count, 3000).show();
					}
			
					
				if(count==0){
				database.insertdata(uname,mn,email,pass,dob,city);
				Toast.makeText(Sign_up.this, "Registeration Successfull", 5000).show();
				Intent intent = new Intent(Sign_up.this,Sign_In.class);
				startActivity(intent);
				finish();
				}
			}
		});
	         
	}
	
   	  
   	  
     @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	// TODO Auto-generated method stub
    	super.onActivityResult(requestCode, resultCode, data);
    	if(requestCode == 10&&resultCode ==RESULT_OK&&data!=null)
    	{
    		ArrayList<String>arrayList=data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
    		editText6.setText(arrayList.get(0));
    	}
    }
	

}
