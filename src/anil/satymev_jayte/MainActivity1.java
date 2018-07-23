package anil.satymev_jayte;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity1 extends Activity
{
	TextView textview0;
	ProgressBar progressBar;
	Handler handler;
	SigninData database3;
	Cursor cursor;
	int i,b=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		progressBar = (ProgressBar)findViewById(R.id.progressBar1);
		textview0 = (TextView)findViewById(R.id.textView0);
		database3 = new SigninData(this);
		progressBar.setMax(2000);
		handler = new Handler();
	     i = 0;
	     
	     cursor = database3.fetchdata();
	    // Toast.makeText(MainActivity1.this,cursor.getString(0), 2000).show();
	     handler.postDelayed(new Runnable() {
	    @Override
			public void run() {
				// TODO Auto-generated method stub
				if(i<=2000)
				{
					progressBar.setProgress(i);
					i = i+100;
					textview0.setText((i*100)/2100+"%");
					handler.postDelayed(this,100);
					
					
				}
				
				else 
				{
					 
				cursor = database3.fetchdata();
		      // Toast.makeText(MainActivity1.this,"getstring = "+cursor.getString(0), 2000).show();
			   String[] log = new String[10];
			   Intent intent = new Intent(MainActivity1.this,Sign_In.class);
		    	 startActivity(intent);
			     finish();
			 }
			}
	     },1000);
	     
	     
	}
}
	