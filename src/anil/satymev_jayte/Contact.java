package anil.satymev_jayte;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Contact extends Activity {
	TextView textView61,textView62,textView63;
	Button button68,button69;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contact);
		textView61 = (TextView)findViewById(R.id.textView61);
		textView62 = (TextView)findViewById(R.id.textView62);
		textView63 = (TextView)findViewById(R.id.textView63);
		button68 = (Button)findViewById(R.id.button17);
		button69 = (Button)findViewById(R.id.button16);
		
		textView61.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent1= new Intent(Intent.ACTION_VIEW,
						Uri.parse("http://gmail.com"));
				startActivity(intent1);
				
			}
		});
		textView62.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent2= new Intent(Intent.ACTION_VIEW,
						Uri.parse("https://www.facebook.com/SatyamevJayate"));
				startActivity(intent2);
				
			}
		});
		textView63.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent3= new Intent(Intent.ACTION_VIEW,
						Uri.parse("https://twitter.com/satyamevjayate"));
				startActivity(intent3);
				
			}
		});
		button68.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent4= new Intent(Intent.ACTION_CALL,
						Uri.parse("tel:121"));
				startActivity(intent4);
				
			}
		});
		button69.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Contact.this,Home.class);
				startActivity(intent);
				finish();
				
			}
		});
		
	}
	
}
