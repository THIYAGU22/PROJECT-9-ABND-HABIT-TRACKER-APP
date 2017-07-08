package com.example.android.trackyourhabit;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    //tag for log msgs
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        habitDbHelper dbHelper = new habitDbHelper(this);
        //designing the date as yyyymmdd is sql format
        //implementing SimpledateFormat to format the date
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String dateStr =  formatter.format(date);
        int dateInt = Integer.parseInt(dateStr);

        dbHelper.insertHabit(dateInt, String.valueOf(habitContract.habitEntry.GAME_CRIC_SCORE));
        dbHelper.insertHabit(dateInt,String.valueOf(habitContract.habitEntry.GAME_COC_SCORE));

        Cursor cursor = dbHelper.readHabits();
        while (cursor.moveToNext()){
            Log.v(TAG,"habit:"+cursor.getInt(0)+""+cursor.getInt(1)+""+cursor.getInt(2)+""+cursor.getInt(3)+"");
        }
    }
}
