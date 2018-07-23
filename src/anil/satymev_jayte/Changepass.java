package anil.satymev_jayte;

import android.R.string;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Changepass extends Activity{
	Button change;
	EditText editText1,editText2;
	SignupData database;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.changepass);
		change = (Button)findViewById(R.id.change);
		editText1 = (EditText)findViewById(R.id.newpass1);
		editText2 = (EditText)findViewById(R.id.newpass2);
		
		
		Intent intent = getIntent();
		String uname = intent.getStringExtra("uname");
		change.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String str1 = editText1.getText().toString();
			    String str2 = editText2.getText().toString();
			    
			    if(str1.equals(str2))
			    {
			    	
			    }
			    
			  
				
			}
		});	
		
	}

}
