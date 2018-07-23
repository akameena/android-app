package anil.satymev_jayte; 


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class SigninData extends SQLiteOpenHelper {
	SQLiteDatabase database;
	
	public SigninData(Context context) {
		// TODO Auto-generated constructor stub
		super(context, "logintable", null, 1);
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String query = "Create table table2(username text,password text,login)";
		db.execSQL(query);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	public void insertdata(String uname,String pass) {
		// TODO Auto-generated method stub
		database = this.getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		contentValues.put("username" , uname);
        contentValues.put("password",pass);
        contentValues.put("login", "no");
		database.insert("table2",null,contentValues);
	}
	/*public void deleteAll() {
		// TODO Auto-generated method stub
		database= this.getWritableDatabase();
      database.delete("table2", null, null);
	}*/
	Cursor fetchdata()
	{
		Cursor cursor;
		database = this.getReadableDatabase();
		cursor  = database.query("table2", new String[]{"username","password","login"}, null, null, null, null, null);
        //Toast.makeText(SigninData.this,cursor.getString(0), 2000).show();
		return cursor;
	}
}
