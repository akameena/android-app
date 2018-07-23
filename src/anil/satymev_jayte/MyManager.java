package anil.satymev_jayte;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyManager extends BroadcastReceiver{
	
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
	Toast.makeText(context, "Alarm is recieved", 3000).show();	
	}

}
