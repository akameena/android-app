package anil.satymev_jayte;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class About extends Activity {
	Button backh,backt;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about);
		backt = (Button)findViewById(R.id.button14);
		backh = (Button)findViewById(R.id.button15);
	backh.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent(About.this,Home.class);
			startActivity(intent);
			finish();
		}
	});
	backt.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent(About.this,Teamlist.class);
			startActivity(intent);
			finish();
			
		}
	});
		
	}

}
