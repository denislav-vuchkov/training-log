
package ss.test.pocketknife.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import ss.test.pocketknife.data.TrainingContract.TrainingEntry;

// Database helper, manages database creation and version management.
public class TrainingDbHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = TrainingDbHelper.class.getSimpleName();

    // Name of the database file
    private static final String DATABASE_NAME = "training.db";

    // Database version. If you change the database schema, you must increment the database version.
    private static final int DATABASE_VERSION = 1;

    public TrainingDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // This is called when the database is created for the first time.
    @Override
    public void onCreate(SQLiteDatabase db) {

        // String that contains the SQL statement to create the table
        String SQL_CREATE_TRAINING_TABLE = "CREATE TABLE " + TrainingEntry.TABLE_NAME + " ("
                + TrainingEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "

                + TrainingEntry.EXERCISE + " TEXT NOT NULL, "
                + TrainingEntry.WORKOUT_DATE + " TEXT NOT NULL, "

                + TrainingEntry.REPS_SET_01 + " INTEGER NOT NULL, "
                + TrainingEntry.REPS_SET_02 + " INTEGER NOT NULL, "
                + TrainingEntry.REPS_SET_03 + " INTEGER NOT NULL, "
                + TrainingEntry.REPS_SET_04 + " INTEGER NOT NULL, "
                + TrainingEntry.REPS_SET_05 + " INTEGER NOT NULL, "
                + TrainingEntry.REPS_SET_06 + " INTEGER NOT NULL, "
                + TrainingEntry.REPS_SET_07 + " INTEGER NOT NULL, "
                + TrainingEntry.REPS_SET_08 + " INTEGER NOT NULL, "
                + TrainingEntry.REPS_SET_09 + " INTEGER NOT NULL, "
                + TrainingEntry.REPS_SET_10 + " INTEGER NOT NULL, "

                + TrainingEntry.LOAD_SET_01 + " REAL NOT NULL, "
                + TrainingEntry.LOAD_SET_02 + " REAL NOT NULL, "
                + TrainingEntry.LOAD_SET_03 + " REAL NOT NULL, "
                + TrainingEntry.LOAD_SET_04 + " REAL NOT NULL, "
                + TrainingEntry.LOAD_SET_05 + " REAL NOT NULL, "
                + TrainingEntry.LOAD_SET_06 + " REAL NOT NULL, "
                + TrainingEntry.LOAD_SET_07 + " REAL NOT NULL, "
                + TrainingEntry.LOAD_SET_08 + " REAL NOT NULL, "
                + TrainingEntry.LOAD_SET_09 + " REAL NOT NULL, "
                + TrainingEntry.LOAD_SET_10 + " REAL NOT NULL);";

        db.execSQL(SQL_CREATE_TRAINING_TABLE);
    }

    // This is called when the database needs to be upgraded.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // The database is still at version 1, so there's nothing to do be done here.
    }
}
