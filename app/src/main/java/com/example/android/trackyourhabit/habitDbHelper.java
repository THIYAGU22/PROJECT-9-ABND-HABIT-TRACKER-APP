package com.example.android.trackyourhabit;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.android.trackyourhabit.habitContract.habitEntry;

import static android.R.attr.name;
/**
 * Created by ravi on 6/20/2017.
 */

/**
 * database helper for habitstracking which manages db creation and version management
 */

public class habitDbHelper extends SQLiteOpenHelper{

    public static final String LOG_TAG=habitDbHelper.class.getSimpleName();

    //name of the db file

    private static final String DATABASE_NAME="habits.db";

    /**
     *db version.if we change the db schema, we must increment the db version
     */

    private static final int DATABASE_VERSION = 2;

    /**
     * constructs a new instance of {@Link PetDbHelper}
     */
    public habitDbHelper(Context context){
        super
            (context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    /**
     * THIS method is called when the db is crreated for first time
     */

    @Override
    public void onCreate(SQLiteDatabase db){
        //create a sttring that contains the SQL statement to create the habit table
        String SQL_CREATE_HABITS_TABLE=" CREATE TABLE " + habitEntry.HABIT_TABLE_NAME + " ( "
        +habitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
        +habitEntry.COLUMN_HABIT_NAME + " TEXT NOT NULL, "
        +habitEntry.COLUMN_HABIT_DATE + " INTEGER NOT NULL, " +
         habitEntry.COLUMN_HABIT_EXPERIENCE + " TEXT )";
        // Execute the SQL statement
        db.execSQL(SQL_CREATE_HABITS_TABLE);
    }

    //THIS METHOD IS CALLED WHEN THE DB NEEDS TO BE UPGRADED
    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion, int newVersion){
    }

    //calling the content values and keys altogether

    public void insertHabit(int date, String experience){
        SQLiteDatabase db = getWritableDatabase();
        // Create a ContentValues object where column names are the keys,
        ContentValues values = new ContentValues();
        values.put(habitEntry.COLUMN_HABIT_DATE,date);
        values.put(habitEntry.COLUMN_HABIT_NAME,name);
        values.put(habitEntry.COLUMN_HABIT_EXPERIENCE,experience);
        db.insert(habitEntry.HABIT_TABLE_NAME,null,values);
    }

    public Cursor readHabits(){
        SQLiteDatabase db = getReadableDatabase();

        // Define a projection that specifies which columns from the database
        String[] projection =  {
              habitContract.habitEntry._ID,
               habitContract.habitEntry.COLUMN_HABIT_DATE,
                habitContract.habitEntry.COLUMN_HABIT_NAME,
               habitContract.habitEntry.COLUMN_HABIT_EXPERIENCE
        };
        // Perform a query on the pets table
        Cursor cursor = db.query(
                habitContract.habitEntry.HABIT_TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );
    return cursor;
    }
}
