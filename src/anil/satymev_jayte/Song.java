package anil.satymev_jayte;
import android.R.string;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
public class Song extends Activity
{
	ListView listView;
	String[] str = {"Satamev Jayate Theme Song", "O Ri Chiriya","Dheere Dheere Haule Haule","Rupaiya","Zindagi Zindagi","Ghar Yaad Aata Hai Mujhe","Sakhi","Mitti Bole Matti Bole",
			"Aye Zindagi Tu Hi Bata","Bahut yaad aate Ho Tum","Jal Naa Jaaye Jal","Nikal Pado Re"};
	Button back;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.song);
		back = (Button)findViewById(R.id.button13);
		listView = (ListView)findViewById(R.id.listView1);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1,str);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				if(position ==0)
				{
					Intent intent1= new Intent(Intent.ACTION_GET_CONTENT);
					intent1.setType("audio/*");
					startActivity(intent1);
				}
				else if(position == 1)
				{
					Intent intent1= new Intent(Intent.ACTION_VIEW,
							Uri.parse("https://www.youtube.com/watch?v=11tplQiXxok"));
					startActivity(intent1);
				}
				else if(position == 2)
				{
					Intent intent1= new Intent(Intent.ACTION_VIEW,
							Uri.parse("https://www.youtube.com/watch?v=vOe3-WOOcQ4&spfreload=10"));
					startActivity(intent1);
				}
				else if(position == 3)
				{
					Intent intent1= new Intent(Intent.ACTION_VIEW,
							Uri.parse("https://www.youtube.com/watch?v=BKzZNLByngU"));
					startActivity(intent1);
				}
				else if(position == 5)
				{
					Intent intent1= new Intent(Intent.ACTION_VIEW,
							Uri.parse("https://www.youtube.com/watch?v=9Pw9v5XnMsg"));
					startActivity(intent1);
				}
				
				else
				Toast.makeText(Song.this, "Currently Song Not Available", 3000).show();
				
			}
			
		});
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Song.this,Home.class);
				startActivity(intent);
				finish();
				
			}
		});
	}
}