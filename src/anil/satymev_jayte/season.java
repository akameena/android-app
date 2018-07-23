package anil.satymev_jayte;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class season  extends Activity
{
	Button season1, season2,season3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.season);
		season1  = (Button)findViewById(R.id.season1);
		season2  = (Button)findViewById(R.id.season2);
		season3  = (Button)findViewById(R.id.season3);
		
    season1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent1= new Intent(Intent.ACTION_VIEW,
						Uri.parse("https://www.youtube.com/watch?v=NG3WygJmiVs&list=ELHRj2Wug-qa0"));
				startActivity(intent1);
				
			}
		});
    season2.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent1= new Intent(Intent.ACTION_VIEW,
					Uri.parse("https://www.youtube.com/watch?v=9J8ifuHyHjk&list=ELjfIS3nKM_jY"));
			startActivity(intent1);
			
		}
	});
    season3.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent1= new Intent(Intent.ACTION_VIEW,
					Uri.parse("https://www.youtube.com/watch?v=tH_RzErG0cA&list=ELrYgixVaLytMCvDWD6jObHQ"));
			startActivity(intent1);
			
		}
	});
		
	}
}
