package com.example.android.trackyourhabit;

import android.provider.BaseColumns;

/**
 * Created by ravi on 6/20/2017.
 */

public class habitContract {
    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public habitContract() {}


    /**
     * creating a Habit entry to define the inner resource of the habit table(db)
     */
    public static final class habitEntry implements BaseColumns{
        //creating a name for the table
        public static final String HABIT_TABLE_NAME="playing_games";
        //various fields of the playing table
        public static final String _ID = BaseColumns._ID;

        public static final String COLUMN_HABIT_DATE = "date";

        public static final String COLUMN_HABIT_EXPERIENCE="experience";
        /**
         * game --->habit
         *
         * Type: INTEGER
         */
        public static final String  COLUMN_HABIT_NAME="gameName";

        /**
         * Possible values for the score of the game
         */
        public static final int GAME_COC_SCORE = 9;

        public static final int GAME_CRIC_SCORE = 7;

    }
}
