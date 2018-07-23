package anil.satymev_jayte;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class FeedbackData extends SQLiteOpenHelper{

	SQLiteDatabase database;

	public FeedbackData(Context context) {
		super(context, "userfeedback", null, 3);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String query = "create table Feedback_Table(Feedback text)";
		db.execSQL(query);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	

	public void insert(String feedback1) {
		// TODO Auto-generated method stub
		database = this.getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		contentValues.put("Feedback", feedback1);
		//contentValues.put("UserID", uid);
		database.insert("Feedback_Table", null,contentValues);
		
	}
	Cursor fetchdata()
	{
		Cursor cursor;
		database = this.getReadableDatabase();
		cursor  = database.query("Feedback_Table", new String[]{"Feedback"}, null, null, null, null, null);
		return cursor;
	}
	
}