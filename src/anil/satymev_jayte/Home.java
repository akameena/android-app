package anil.satymev_jayte;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils.TruncateAt;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
public class Home extends Activity {
	Button song,contact,about,feedback,home,reminder,season;
	TextView tv1;
    static MediaPlayer mediaPlayer;
	 @Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_page);
		home = (Button)findViewById(R.id.button6);
		season  = (Button)findViewById(R.id.button7);
		song = (Button)findViewById(R.id.button8);
		contact = (Button)findViewById(R.id.button11);
		about = (Button)findViewById(R.id.button10);
		feedback = (Button)findViewById(R.id.button9);
		reminder= (Button)findViewById(R.id.Reminder);
		/*tv1 = (TextView) this.findViewById(R.id.satymev1);  
        tv1.setSelected(true); // Set focus to the textview
		tv1.setEllipsize(TruncateAt.MARQUEE);
		tv1.setSingleLine();*/
//		if(mediaPlayer!=null)
//		{
//			mediaPlayer.stop();
//			mediaPlayer.release();
//		}
		
		if(mediaPlayer==null)
		{
			mediaPlayer = MediaPlayer.create(Home.this,R.raw.a);
	
			mediaPlayer.start();
		}
		
		song.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Home.this,Song.class);
				startActivity(intent);
				
			}
		});
       
        season.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Home.this,season.class);
				startActivity(intent);
				
			}
		});
       feedback.setOnClickListener(new OnClickListener() {
   		
   		@Override
   		public void onClick(View v) {
   			// TODO Auto-generated method stub
   			Intent intent = new Intent(Home.this,Feedback.class);
   			startActivity(intent);
   			
   		}
   	});
       
       contact.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent(Home.this,Contact.class);
			startActivity(intent);
		}
	});
       about.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent(Home.this,About.class);
			startActivity(intent);
			
		}
	});
       
       home.setOnClickListener(new OnClickListener() {
   		
   		@Override
   		public void onClick(View v) {
   			// TODO Auto-generated method stub
   			Intent intent = new Intent(Home.this,Home1.class);
   			startActivity(intent);
   			
   		}
   	});
       reminder.setOnClickListener(new OnClickListener() {
      		
      		@Override
      		public void onClick(View v) {
      			// TODO Auto-generated method stub
      			Intent intent = new Intent(Home.this,AlarmDemo.class);
      			startActivity(intent);
      			
      		}
      	});

       
		
	}
	 @Override
		public boolean onCreateOptionsMenu(Menu menu) {
			// TODO Auto-generated method stub
			MenuInflater inflater =  getMenuInflater();
			inflater.inflate(R.menu.main, menu);
			return super.onCreateOptionsMenu(menu);
			
		}
	 @Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		 
		 switch (item.getItemId())
		 {
		 
		
		 case R.id.item1:
		 {
			 

			 AlertDialog.Builder builder = new AlertDialog.Builder(Home.this);
				builder.setTitle("Music");
				builder.setMessage("Enable Music?");
				builder.setIcon(R.drawable.music);
				builder.setPositiveButton("YES",new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
					mediaPlayer.start();
					
						
					}
				});
				builder.setNegativeButton("NO",new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						mediaPlayer.pause();
						
					}
				});
				builder.show();
				break;
			 
		 }
		 
		 
		 case R.id.item2:
		 {
			 Intent intent = new Intent(Home.this,Info.class);
				startActivity(intent); 
				break;
			
		 }
		 case R.id.item3:
		 {
			 Toast.makeText(Home.this, "successfully log out", 3000).show();
			 Intent intent = new Intent(Home.this,logout.class);
			 startActivity(intent); 
			 mediaPlayer.pause();
			 finish();
			 break;

		 }
		 
		 
		 case R.id.item4:
		 { 
			 AlertDialog.Builder builder = new AlertDialog.Builder(Home.this);
				builder.setTitle("Satymev Jayte");
				builder.setMessage("Are you want to exit?");
				builder.setIcon(R.drawable.ic_launcher);
				builder.setPositiveButton("YES",new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						Intent intent = new Intent(Intent.ACTION_MAIN);
						intent .addCategory(Intent.CATEGORY_HOME);
						startActivity(intent);
						
					}
				});
				builder.setNegativeButton("NO",new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						Toast.makeText(Home.this, "NO", 3000).show();
						
					}
				});
				builder.show();
				break;
				
		 }	
		 }
			 
			  
				return super.onOptionsItemSelected(item);
					
		 
	
	}
}
