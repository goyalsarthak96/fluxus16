package com.example.sarthak.fluxus2k16;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database {

	private static String DB_PATH = "";
	public static final String DATABASE_NAME = "FluxusDB";

	public static final int DATABASE_VERSION = 1;
	String months[] = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug",
			"Sep", "Oct", "Nov", "Dec" };

	private DbHelper ourHelper;
	private static Context ourContext;
	private static SQLiteDatabase ourDatabase;

	public Database(Context ctx) {
		ourContext = ctx;
		ourHelper = new DbHelper(ourContext);
	}

	private static class DbHelper extends SQLiteOpenHelper {

		public DbHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
			DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
			
		}

		@Override
		public void onCreate(SQLiteDatabase db) {

		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

		}

	}

	public void createDataBase() throws IOException {
		// If database not exists copy it from the assets

		boolean mDataBaseExist = checkDataBase();
		if (!mDataBaseExist) {
			ourHelper.getWritableDatabase();
			ourHelper.close();
			try {
				// Copy the database from assests
				copyDataBase();

			} catch (IOException mIOException) {
				throw new Error("ErrorCopyingDataBase");
			}
		}
	}

	// Check that the database exists here: /data/data/your package/databases/Da
	// Name
	private boolean checkDataBase() {
		File dbFile = new File(DB_PATH + DATABASE_NAME);
		return dbFile.exists();
	}

	// Copy the database from assets
	private void copyDataBase() throws IOException {
		InputStream mInput = ourContext.getAssets().open(DATABASE_NAME);
		String outFileName = DB_PATH + DATABASE_NAME;
		OutputStream mOutput = new FileOutputStream(outFileName);
		byte[] mBuffer = new byte[1024];
		int mLength;
		while ((mLength = mInput.read(mBuffer)) > 0) {
			mOutput.write(mBuffer, 0, mLength);
		}
		mOutput.flush();
		mOutput.close();
		mInput.close();
	}

	// Open the database, so we can query it
	public boolean openDataBase() throws SQLException {
		String mPath = DB_PATH + DATABASE_NAME;
		// Log.v("mPath", mPath);
		ourDatabase = SQLiteDatabase.openDatabase(mPath, null,
				SQLiteDatabase.CREATE_IF_NECESSARY);
		// mDataBase = SQLiteDatabase.openDatabase(mPath, null,
		// SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		return ourDatabase != null;
	}

	public void open() throws SQLException {
		try {
			if (openDataBase())
				ourDatabase = ourHelper.getReadableDatabase();
		} catch (SQLException mSQLException) {
			throw mSQLException;
		}
	}

	public synchronized void close() {
		if (ourDatabase != null)
			ourDatabase.close();
		ourHelper.close();
	}



	public String[] getEventInfo(String event, String table_) {

		try {
			this.createDataBase();
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		this.open();
		String about="";
		String desc = "";
		String type = "";
		String from = "";
		String to = "";
		String venue = "";
		String contact_name="";
		String contact_number="";
		String prizes="";

		String columns[] = { "event", "about","desc", "type", "from_", "to_",
				"venue","contact_name","contact_number","prizes","star" };
		Cursor cu = ourDatabase.query(table_, columns, "event" + "=?",
				new String[] { event }, null, null, null);

		int a= cu.getColumnIndex("about");
		int d = cu.getColumnIndex("desc");
		int t = cu.getColumnIndex("type");
		int from_ = cu.getColumnIndex("from_");
		int to_ = cu.getColumnIndex("to_");
		int venue_ = cu.getColumnIndex("venue");
		int cna = cu.getColumnIndex("contact_name");
		int cnu = cu.getColumnIndex("contact_number");
		int pr= cu.getColumnIndex("prizes");

		for (cu.moveToFirst(); !cu.isAfterLast(); cu.moveToNext()) {
			about = cu.getString(a);
			desc = cu.getString(d);
			type = cu.getString(t);
			from = cu.getString(from_);
			to = cu.getString(to_);
			venue=cu.getString(venue_);
			contact_name =cu.getString(cna);
			contact_number=cu.getString(cnu);
			prizes=cu.getString(pr);
		}
		this.close();
		return new String[] {about,desc,type,from,to,venue, contact_name,contact_number,prizes };
	}

	public ArrayList<String> getEventTypeArray(String table) {
		ArrayList<String> arr = new ArrayList<String>();
		Set<String> se = new HashSet<>();

		try {
			this.createDataBase();
		} catch (Exception e) {

		}
		this.open();

		String q = "SELECT type FROM "+table;
		Cursor c = ourDatabase.rawQuery(q, null);
		if (c != null) {
			int index = c.getColumnIndex("type");
			for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
				arr.add(c.getString(index));
			}
		}
		this.close();
		se.addAll(arr);
		arr.clear();
		arr.addAll(se);
		return arr;
	}


	public void toggleStar(String table,String event, int star) {

		ContentValues cv = new ContentValues();
		cv.put("star", star);
		try {
			this.createDataBase();
		} catch (Exception e) {

		}
		this.open();

		ourDatabase.update(table, cv, "event" + "=?", new String[] {event});
		this.close();
	}

	public ArrayList<String> getEventsOfType(String table, String type){
		ArrayList<String> arr = new ArrayList<String>();

		try {
			this.createDataBase();
		} catch (Exception e) {

		}
		this.open();
		String columns[] = { "event", "desc", "type", "from", "to",
				"venue","contact_name","contact_number" };
		Cursor c = ourDatabase.query(table, columns, "type" + "=?",
				new String[] { type }, null, null, null);


		if (c != null) {
			int d = c.getColumnIndex("event");
			for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
				arr.add(c.getString(d));
			}
		}
		this.close();
		return arr;

	}

	public void saveNotifications(int id, String title, String message){
		String dater = "1/1/1";
		GregorianCalendar gcalendar = new GregorianCalendar();
		dater = months[gcalendar.get(Calendar.MONTH)] + " "
				+ gcalendar.get(Calendar.DATE) + " "
				+ gcalendar.get(Calendar.YEAR);
		try {
			this.createDataBase();
		} catch (Exception e) {

		}
		this.open();
		ContentValues cv = new ContentValues();
		cv.put("Id", id);
		cv.put("title", title);
		cv.put("message", message);
		cv.put("date",dater);

		ourDatabase.insert("notifications", null, cv);

		this.close();

	}

	public ArrayList<String> getAllNotifications(){
		ArrayList<String> arr = new ArrayList<String>();

		try {
			this.createDataBase();
		} catch (Exception e) {

		}
		this.open();
		String columns[] = { "id","title","message","date" };

		Cursor c = ourDatabase.query("notifications", columns, null,
				null, null, null, null);


		if (c != null) {
			int d1 = c.getColumnIndex("title");
			int d2 = c.getColumnIndex("message");
			int d3 = c.getColumnIndex("date");
			for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {

				arr.add(c.getString(d1)+"^"+c.getString(d2)+"^"+c.getString(d3));
			}
		}
		this.close();
		return arr;

	}




	public ArrayList<String> getSchedule(String type,String day){
		ArrayList<String> arr = new ArrayList<String>();

		try {
			this.createDataBase();
		} catch (Exception e) {

		}
		this.open();
		String columns[] = { "time","event","type"};
		Cursor c=null;
		if(type.equals("All"))
			c= ourDatabase.query(day, columns, null, null, null, null, null);
		else
			c= ourDatabase.query(day, columns, "type" + "=?", new String[] { type }, null, null, null);


		if (c != null) {
			int d1 = c.getColumnIndex("time");
			int d2 = c.getColumnIndex("event");
			int d3 = c.getColumnIndex("type");
			for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {

				arr.add(c.getString(d1)+"^"+c.getString(d2)+"^"+c.getString(d3));
			}
		}
		this.close();
		return arr;

	}



	
}
