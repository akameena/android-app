package anil.satymev_jayte;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class Feedback extends Activity{
	Button submit,back;
	EditText editText71;
	FeedbackData database;
	ListView listView2;
	Cursor cursor;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.feedback);
		submit = (Button)findViewById(R.id.button71);
		back = (Button)findViewById(R.id.button72);
		editText71=(EditText)findViewById(R.id.editText71);
		listView2 = (ListView)findViewById(R.id.listView71);
		//edittext72 = (EditText)findViewById(R.id.editText1);
		database = new FeedbackData(Feedback.this);
		cursor = database.fetchdata();
		String[] feed = new String[cursor.getCount()];
		cursor.moveToNext();
		
		for(int i=0;i<cursor.getCount();i++)
		{
		 feed[i] = cursor.getString(0);
			//Toast.makeText(Feedback.this, feed,3000).show();
			cursor.moveToNext();
		}
		ArrayAdapter<String>adapter = new ArrayAdapter<String>(Feedback.this, android.R.layout.simple_list_item_1,feed);
		listView2.setAdapter(adapter);
		
        submit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//String uid   = edittext72.getText().toString();
				String feedback1 = editText71.getText().toString();
				database.insert(feedback1);
				Toast.makeText(Feedback.this, "Thank You for your feedback", 3000).show();
				cursor = database.fetchdata();
				String[] feed = new String[cursor.getCount()];
				cursor.moveToNext();
				
				for(int i=0;i<cursor.getCount();i++)
				{
				 feed[i] = cursor.getString(0);
					//Toast.makeText(Feedback.this, feed,3000).show();
					cursor.moveToNext();
				}
				ArrayAdapter<String>adapter = new ArrayAdapter<String>(Feedback.this, android.R.layout.simple_list_item_1,feed);
				listView2.setAdapter(adapter);
			}
			
		});
        back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Feedback.this,Home.class);
				startActivity(intent);
				finish();
				
			}
		});
	}

}
