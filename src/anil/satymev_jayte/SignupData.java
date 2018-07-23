package anil.satymev_jayte;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class SignupData extends SQLiteOpenHelper{
	SQLiteDatabase database;
	public SignupData(Context context) {
		// TODO Auto-generated constructor stub
		super(context, "usertable", null, 1);
		
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String query = "Create table table1(username text,mobile text,email text,password text,dateofbirth text,city text)";
		db.execSQL(query);
		
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
	}
	public void insertdata(String uname,String mn,String email,String pass,String dob,String city) {
		// TODO Auto-generated method stub
		database = this.getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		contentValues.put("username" , uname);
		contentValues.put("mobile",mn);
		contentValues.put("email",email);
		contentValues.put("password",pass);
		contentValues.put("dateofbirth",dob);
		contentValues.put("city",city);
		database.insert("table1",null,contentValues);
	}
	Cursor fetchdata()
	{
		Cursor cursor;
		database = this.getReadableDatabase();
		cursor  = database.query("table1", new String[]{"username","mobile","email","password","dateofbirth","city"}, null, null, null, null, null);
		return cursor;
	}
	 void updateData(String pass){
		 database= this.getWritableDatabase();
		 ContentValues contentValues= new ContentValues();
			contentValues.put("password", pass);
			 database.update("table1", contentValues, "password =?",new String[]{"uname"});
			 
	 }
	


}
