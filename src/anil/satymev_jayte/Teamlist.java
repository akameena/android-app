package anil.satymev_jayte;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

public class Teamlist extends Activity {
	Button backa;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.teamlist);
		backa = (Button)findViewById(R.id.button61);
	backa.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent(Teamlist.this,About.class);
			startActivity(intent);
			finish();
			
		}
	});
	}
	

}
