
package ss.test.pocketknife.data;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;

import ss.test.pocketknife.data.TrainingContract.TrainingEntry;

// {@link ContentProvider} for the app.
public class TrainingProvider extends ContentProvider {

    public static final String LOG_TAG = TrainingProvider.class.getSimpleName();

    // URI matcher code for the content URI for the exercises table
    private static final int EXERCISES = 100;

    // URI matcher code for the content URI for a single exercise
    private static final int EXERCISE_ID = 101;

    /**
     * UriMatcher object to match a content URI to a corresponding code.
     * The input passed into the constructor represents the code to return for the root URI.
     * It's common to use NO_MATCH as the input for this case.
     */
    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    // Static initializer. This is run the first time anything is called from this class.
    static {

        sUriMatcher.addURI(TrainingContract.CONTENT_AUTHORITY, TrainingContract.PATH_EXERCISES, EXERCISES);

        sUriMatcher.addURI(TrainingContract.CONTENT_AUTHORITY, TrainingContract.PATH_EXERCISES + "/#", EXERCISE_ID);
    }

    // Database helper object
    private TrainingDbHelper mDbHelper;

    @Override
    public boolean onCreate() {
        mDbHelper = new TrainingDbHelper(getContext());
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs,
                        String sortOrder) {
        // Get readable database
        SQLiteDatabase database = mDbHelper.getReadableDatabase();

        // This cursor will hold the result of the query
        Cursor cursor;

        // Figure out if the URI matcher can match the URI to a specific code
        int match = sUriMatcher.match(uri);
        switch (match) {
            case EXERCISES:
                // Query the exercises table directly with the given
                // projection, selection, selection arguments, and sort order. The cursor
                // could contain multiple rows of the table.
                cursor = database.query(TrainingEntry.TABLE_NAME, projection, selection, selectionArgs,
                        null, null, sortOrder);
                break;
            case EXERCISE_ID:
                // Extract out the ID from the URI. The selection will be "_id=?" and the selection
                // argument will be a String array containing the actual ID .
                // For every "?" in the selection, we need to have an element in the selection
                // arguments that will fill in the "?". Since we have 1 question mark in the
                // selection, we have 1 String in the selection arguments' String array.
                selection = TrainingEntry._ID + "=?";
                selectionArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};
                cursor = database.query(TrainingEntry.TABLE_NAME, projection, selection, selectionArgs,
                        null, null, sortOrder);
                break;
            default:
                throw new IllegalArgumentException("Cannot query unknown URI " + uri);
        }

        // Set notification URI on the Cursor, so we know what content URI it was created for.
        // If the data at this URI changes, then we know we need to update the Cursor.
        cursor.setNotificationUri(getContext().getContentResolver(), uri);
        return cursor;
    }

    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        final int match = sUriMatcher.match(uri);
        switch (match) {
            case EXERCISES:
                return insertExercise(uri, contentValues);
            default:
                throw new IllegalArgumentException("Insertion is not supported for " + uri);
        }
    }

    // Insert an exercise into the database with the given content values.
    // Return the new content URI for that specific row in the database.
    private Uri insertExercise(Uri uri, ContentValues values) {

        if (values.getAsString(TrainingEntry.EXERCISE) == null) {
            throw new IllegalArgumentException("No exercise entered!");
        }

        if (values.getAsString(TrainingEntry.WORKOUT_DATE) == null) {
            throw new IllegalArgumentException("Invalid date!");
        }

        if (values.getAsInteger(TrainingEntry.REPS_SET_01) != null && values.getAsInteger(TrainingEntry.REPS_SET_01) < 0) {
            throw new IllegalArgumentException("Repetitions not entered!");
        }

        if (values.getAsInteger(TrainingEntry.REPS_SET_02) != null && values.getAsInteger(TrainingEntry.REPS_SET_02) < 0) {
            throw new IllegalArgumentException("Repetitions not entered!");
        }

        if (values.getAsInteger(TrainingEntry.REPS_SET_03) != null && values.getAsInteger(TrainingEntry.REPS_SET_03) < 0) {
            throw new IllegalArgumentException("Repetitions not entered!");
        }

        if (values.getAsInteger(TrainingEntry.REPS_SET_04) != null && values.getAsInteger(TrainingEntry.REPS_SET_04) < 0) {
            throw new IllegalArgumentException("Repetitions not entered!");
        }

        if (values.getAsInteger(TrainingEntry.REPS_SET_05) != null && values.getAsInteger(TrainingEntry.REPS_SET_05) < 0) {
            throw new IllegalArgumentException("Repetitions not entered!");
        }

        if (values.getAsInteger(TrainingEntry.REPS_SET_06) != null && values.getAsInteger(TrainingEntry.REPS_SET_06) < 0) {
            throw new IllegalArgumentException("Repetitions not entered!");
        }

        if (values.getAsInteger(TrainingEntry.REPS_SET_07) != null && values.getAsInteger(TrainingEntry.REPS_SET_07) < 0) {
            throw new IllegalArgumentException("Repetitions not entered!");
        }

        if (values.getAsInteger(TrainingEntry.REPS_SET_08) != null && values.getAsInteger(TrainingEntry.REPS_SET_08) < 0) {
            throw new IllegalArgumentException("Repetitions not entered!");
        }

        if (values.getAsInteger(TrainingEntry.REPS_SET_09) != null && values.getAsInteger(TrainingEntry.REPS_SET_09) < 0) {
            throw new IllegalArgumentException("Repetitions not entered!");
        }

        if (values.getAsInteger(TrainingEntry.REPS_SET_10) != null && values.getAsInteger(TrainingEntry.REPS_SET_10) < 0) {
            throw new IllegalArgumentException("Repetitions not entered!");
        }

        if (values.getAsDouble(TrainingEntry.LOAD_SET_01) != null && values.getAsDouble(TrainingEntry.LOAD_SET_01) < 0) {
            throw new IllegalArgumentException("Load not entered!");
        }

        if (values.getAsDouble(TrainingEntry.LOAD_SET_02) != null && values.getAsDouble(TrainingEntry.LOAD_SET_02) < 0) {
            throw new IllegalArgumentException("Load not entered!");
        }

        if (values.getAsDouble(TrainingEntry.LOAD_SET_03) != null && values.getAsDouble(TrainingEntry.LOAD_SET_03) < 0) {
            throw new IllegalArgumentException("Load not entered!");
        }

        if (values.getAsDouble(TrainingEntry.LOAD_SET_04) != null && values.getAsDouble(TrainingEntry.LOAD_SET_04) < 0) {
            throw new IllegalArgumentException("Load not entered!");
        }

        if (values.getAsDouble(TrainingEntry.LOAD_SET_05) != null && values.getAsDouble(TrainingEntry.LOAD_SET_05) < 0) {
            throw new IllegalArgumentException("Load not entered!");
        }
		
		if (values.getAsDouble(TrainingEntry.LOAD_SET_06) != null && values.getAsDouble(TrainingEntry.LOAD_SET_06) < 0) {
            throw new IllegalArgumentException("Load not entered!");
        }

        if (values.getAsDouble(TrainingEntry.LOAD_SET_07) != null && values.getAsDouble(TrainingEntry.LOAD_SET_07) < 0) {
            throw new IllegalArgumentException("Load not entered!");
        }

        if (values.getAsDouble(TrainingEntry.LOAD_SET_08) != null && values.getAsDouble(TrainingEntry.LOAD_SET_08) < 0) {
            throw new IllegalArgumentException("Load not entered!");
        }

        if (values.getAsDouble(TrainingEntry.LOAD_SET_09) != null && values.getAsDouble(TrainingEntry.LOAD_SET_09) < 0) {
            throw new IllegalArgumentException("Load not entered!");
        }

        if (values.getAsDouble(TrainingEntry.LOAD_SET_10) != null && values.getAsDouble(TrainingEntry.LOAD_SET_10) < 0) {
            throw new IllegalArgumentException("Load not entered!");
        }

        SQLiteDatabase database = mDbHelper.getWritableDatabase();

        long id = database.insert(TrainingEntry.TABLE_NAME, null, values);

        if (id == -1) {
            Log.e(LOG_TAG, "Failed to insert row for " + uri);
            return null;
        }
        getContext().getContentResolver().notifyChange(uri, null);

        // Return the new URI with the ID (of the newly inserted row) appended at the end
        return ContentUris.withAppendedId(uri, id);
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String selection,
                      String[] selectionArgs) {
        final int match = sUriMatcher.match(uri);
        switch (match) {
            case EXERCISES:
                return updateExercise(uri, contentValues, selection, selectionArgs);
            case EXERCISE_ID:
                selection = TrainingEntry._ID + "=?";
                selectionArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};
                return updateExercise(uri, contentValues, selection, selectionArgs);
            default:
                throw new IllegalArgumentException("Update is not supported for " + uri);
        }
    }

    // Update exercises in the database with the given content values. Apply the changes to the
    // rows specified in the selection and selection arguments (which could be 0 or 1 or
    // more exercises). Return the number of rows that were successfully updated.
    private int updateExercise(Uri uri, ContentValues values, String selection, String[] selectionArgs) {

        if (values.containsKey(TrainingEntry.EXERCISE)) {
            if (values.getAsString(TrainingEntry.EXERCISE) == null) {
                throw new IllegalArgumentException("No exercise entered!");
            }
        }

        if (values.getAsString(TrainingEntry.WORKOUT_DATE) == null) {
            throw new IllegalArgumentException("Invalid date!");
        }

        if (values.getAsInteger(TrainingEntry.REPS_SET_01) != null && values.getAsInteger(TrainingEntry.REPS_SET_01) < 0) {
            throw new IllegalArgumentException("Repetitions not entered!");
        }

        if (values.getAsInteger(TrainingEntry.REPS_SET_02) != null && values.getAsInteger(TrainingEntry.REPS_SET_02) < 0) {
            throw new IllegalArgumentException("Repetitions not entered!");
        }

        if (values.getAsInteger(TrainingEntry.REPS_SET_03) != null && values.getAsInteger(TrainingEntry.REPS_SET_03) < 0) {
            throw new IllegalArgumentException("Repetitions not entered!");
        }

        if (values.getAsInteger(TrainingEntry.REPS_SET_04) != null && values.getAsInteger(TrainingEntry.REPS_SET_04) < 0) {
            throw new IllegalArgumentException("Repetitions not entered!");
        }

        if (values.getAsInteger(TrainingEntry.REPS_SET_05) != null && values.getAsInteger(TrainingEntry.REPS_SET_05) < 0) {
            throw new IllegalArgumentException("Repetitions not entered!");
        }

        if (values.getAsInteger(TrainingEntry.REPS_SET_06) != null && values.getAsInteger(TrainingEntry.REPS_SET_06) < 0) {
            throw new IllegalArgumentException("Repetitions not entered!");
        }

        if (values.getAsInteger(TrainingEntry.REPS_SET_07) != null && values.getAsInteger(TrainingEntry.REPS_SET_07) < 0) {
            throw new IllegalArgumentException("Repetitions not entered!");
        }

        if (values.getAsInteger(TrainingEntry.REPS_SET_08) != null && values.getAsInteger(TrainingEntry.REPS_SET_08) < 0) {
            throw new IllegalArgumentException("Repetitions not entered!");
        }

        if (values.getAsInteger(TrainingEntry.REPS_SET_09) != null && values.getAsInteger(TrainingEntry.REPS_SET_09) < 0) {
            throw new IllegalArgumentException("Repetitions not entered!");
        }

        if (values.getAsInteger(TrainingEntry.REPS_SET_10) != null && values.getAsInteger(TrainingEntry.REPS_SET_10) < 0) {
            throw new IllegalArgumentException("Repetitions not entered!");
        }

        if (values.getAsDouble(TrainingEntry.LOAD_SET_01) != null && values.getAsDouble(TrainingEntry.LOAD_SET_01) < 0) {
            throw new IllegalArgumentException("Load not entered!");
        }

        if (values.getAsDouble(TrainingEntry.LOAD_SET_02) != null && values.getAsDouble(TrainingEntry.LOAD_SET_02) < 0) {
            throw new IllegalArgumentException("Load not entered!");
        }

        if (values.getAsDouble(TrainingEntry.LOAD_SET_03) != null && values.getAsDouble(TrainingEntry.LOAD_SET_03) < 0) {
            throw new IllegalArgumentException("Load not entered!");
        }

        if (values.getAsDouble(TrainingEntry.LOAD_SET_04) != null && values.getAsDouble(TrainingEntry.LOAD_SET_04) < 0) {
            throw new IllegalArgumentException("Load not entered!");
        }

        if (values.getAsDouble(TrainingEntry.LOAD_SET_05) != null && values.getAsDouble(TrainingEntry.LOAD_SET_05) < 0) {
            throw new IllegalArgumentException("Load not entered!");
        }
		
		if (values.getAsDouble(TrainingEntry.LOAD_SET_06) != null && values.getAsDouble(TrainingEntry.LOAD_SET_06) < 0) {
            throw new IllegalArgumentException("Load not entered!");
        }

        if (values.getAsDouble(TrainingEntry.LOAD_SET_07) != null && values.getAsDouble(TrainingEntry.LOAD_SET_07) < 0) {
            throw new IllegalArgumentException("Load not entered!");
        }

        if (values.getAsDouble(TrainingEntry.LOAD_SET_08) != null && values.getAsDouble(TrainingEntry.LOAD_SET_08) < 0) {
            throw new IllegalArgumentException("Load not entered!");
        }

        if (values.getAsDouble(TrainingEntry.LOAD_SET_09) != null && values.getAsDouble(TrainingEntry.LOAD_SET_09) < 0) {
            throw new IllegalArgumentException("Load not entered!");
        }

        if (values.getAsDouble(TrainingEntry.LOAD_SET_10) != null && values.getAsDouble(TrainingEntry.LOAD_SET_10) < 0) {
            throw new IllegalArgumentException("Load not entered!");
        }

        if (values.size() == 0) {
            return 0;
        }

        SQLiteDatabase database = mDbHelper.getWritableDatabase();

        // Perform the update on the database and get the number of rows affected
        int rowsUpdated = database.update(TrainingEntry.TABLE_NAME, values, selection, selectionArgs);

        // If 1 or more rows were updated, notify listeners that data at the given URI has changed.
        if (rowsUpdated != 0) {
            getContext().getContentResolver().notifyChange(uri, null);
        }

        // Return the number of rows updated
        return rowsUpdated;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {

        SQLiteDatabase database = mDbHelper.getWritableDatabase();

        int rowsDeleted;

        final int match = sUriMatcher.match(uri);
        switch (match) {
            case EXERCISES:
                // Delete all rows that match the selection and selection args
                rowsDeleted = database.delete(TrainingEntry.TABLE_NAME, selection, selectionArgs);
                break;
            case EXERCISE_ID:
                // Delete a single row given by the ID in the URI
                selection = TrainingEntry._ID + "=?";
                selectionArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};
                rowsDeleted = database.delete(TrainingEntry.TABLE_NAME, selection, selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("Deletion is not supported for " + uri);
        }

        // If 1 or more rows were deleted, notify listeners the data at the given URI has changed.
        if (rowsDeleted != 0) {
            getContext().getContentResolver().notifyChange(uri, null);
        }

        // Return the number of rows deleted
        return rowsDeleted;
    }

    @Override
    public String getType(Uri uri) {
        final int match = sUriMatcher.match(uri);
        switch (match) {
            case EXERCISES:
                return TrainingEntry.CONTENT_LIST_TYPE;
            case EXERCISE_ID:
                return TrainingEntry.CONTENT_ITEM_TYPE;
            default:
                throw new IllegalStateException("Unknown URI " + uri + " with match " + match);
        }
    }
}
