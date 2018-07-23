package anil.satymev_jayte;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
public class MainActivity2 extends Activity
{
	Button signin,signup;
	@Override
	protected void  onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		signin = (Button)findViewById(R.id.button1);
		signup = (Button)findViewById(R.id.button2);
		//Toast.makeText(MainActivity2.this,Sign_In.d, 10000).show();
		
	/*	if(Sign_In.d==1)
		{
			Intent intent = new Intent(MainActivity2.this,Home.class);
			startActivity(intent);
			Toast.makeText(MainActivity2.this,Sign_In.d ,10000).show();
			finish();
		}
		else {
			Toast.makeText(MainActivity2.this,"d not ok", 10000).show();
			
			
		}*/
		signin.setOnClickListener(new OnClickListener() {
			
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity2.this,Sign_In.class);
				startActivity(intent);
			}
		});
		
		signup.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity2.this,Sign_up.class);
				startActivity(intent);
				
			}
		});
    }
}