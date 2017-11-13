package test.rahul.movies.movies;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Rahul on 13/11/2017.
 */

public class MovieDatabase extends SQLiteOpenHelper {
    public SQLiteDatabase myDB;
    public static final String ID = "ID";
    public static final String TITLE = "TITLE";
    public static final String RELEASE_DATE = "RELEASE_DATE";
    public static final String VOTE_COUNT = "VOTE_COUNT";
    public static final String DESCRIPTION = "DESCRIPTION";
    public static final String THUMB_URL = "THUMB_URL";

    public static final String DATABASE_NAME = "MOVIESDB";
    public static final String TABLE_NAME = "MOVIES";
    private static final int DB_VERSION = 3;
    private static final String CREATE_TABLE_TUTORIALS = "create table " + TABLE_NAME
            + " (" + ID + " integer primary key autoincrement, " + TITLE
            + " text not null, " + RELEASE_DATE + " text not null, " + VOTE_COUNT + " text not null, " + DESCRIPTION + "text not null, " + THUMB_URL + "text not null );";
    private static final String DB_SCHEMA = CREATE_TABLE_TUTORIALS;

    public MovieDatabase(Context context) {
        super(context, DATABASE_NAME, null, DB_VERSION);

        try {

            this.myDB = getWritableDatabase();

            Log.d("CREATEDB", "ONCREATE2");
        }
        catch ( Exception e){
            Log.d("TAG","ONCREATE2"+e.getMessage());
        }
    }



    @Override
    public void onCreate(SQLiteDatabase db) {

        db = getWritableDatabase();

        Log.d("ONCREATE","ONCREATE3");

        try {
            db.execSQL(DB_SCHEMA);
        }
        catch (Exception e){
            Log.d("ONCREATE","ONCREATE3"+e.getMessage());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }
        catch (Exception e){
            Log.d("TAG","ONCREATE4"+e.getMessage());
        }
    }


    public void getAllRows(){

        Cursor cursor = null;

        Log.d("TAG","ONCREATE4");

    }
}
