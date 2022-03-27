
package ss.test.pocketknife;

import android.app.AlertDialog;
import android.app.LoaderManager;
import android.content.ContentValues;
import android.content.CursorLoader;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import ss.test.pocketknife.data.TrainingContract.TrainingEntry;

// Allows user to create a new exercise or edit an existing one.
public class EditorActivity extends AppCompatActivity implements
        LoaderManager.LoaderCallbacks<Cursor> {

    // Identifier for the exercise data loader
    private static final int EXISTING_LOADER = 0;

    // Content URI for the existing exercise (null if it's a new exercise)
    private Uri mCurrentUri;
    // Boolean flag that keeps track of whether the exercise has been edited (true) or not (false)
    private boolean mExerciseHasChanged = false;
    // OnTouchListener that listens for any user touches on a View, implying they are modifying
    // the view, and we change the mExerciseHasChanged boolean to true.
    private View.OnTouchListener mTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            mExerciseHasChanged = true;
            return false;
        }
    };

    private EditText mExercise;
    private TextView mDate;
    private int mSets = 3;

    private LinearLayout mMainView;
    private List<View> mSetRows = new ArrayList<View>();
    private static List<EditText> mRepsFields = new ArrayList<EditText>();
    private static List<EditText> mLoadFields = new ArrayList<EditText>();

    private List<String> mRepsValues = new ArrayList<String>() {{
        add("0");
        add("0");
        add("0");
        add("0");
        add("0");
        add("0");
        add("0");
        add("0");
        add("0");
        add("0");
    }};

    private List<String> mLoadValues = new ArrayList<String>() {{
        add("0");
        add("0");
        add("0");
        add("0");
        add("0");
        add("0");
        add("0");
        add("0");
        add("0");
        add("0");
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_training_log_editor);

        String[] listOfExercises = {
                getString(R.string.back_squat),
                getString(R.string.front_squat),
                getString(R.string.leg_press),
                getString(R.string.lunges),
                getString(R.string.standing_calf_raise),
                getString(R.string.seated_calf_raise),
                getString(R.string.flat_bench_press),
                getString(R.string.incline_bench_press),
                getString(R.string.standing_overhead_press),
                getString(R.string.dip),
                getString(R.string.pull_up),
                getString(R.string.chin_up),
                getString(R.string.lat_pull_down),
                getString(R.string.pendlay_row),
                getString(R.string.bent_over_row),
                getString(R.string.conventional_deadlift),
                getString(R.string.sumo_deadlift)
        };

        // Creating the instance of ArrayAdapter containing list of exercise names
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.select_dialog_item, listOfExercises);

        // Getting the instance of AutoCompleteTextView
        AutoCompleteTextView actv = (AutoCompleteTextView) findViewById(R.id.edit_exercise);
        actv.setThreshold(1);       //will start working from first character
        actv.setAdapter(adapter);   //setting the adapter data into the AutoCompleteTextView

        //Get a new instance of Calendar
        Calendar c = Calendar.getInstance();
        int year = c.get(c.YEAR);
        int month = c.get(c.MONTH);
        int dayOfMonth = c.get(c.DAY_OF_MONTH);

        //Get the widgets reference from XML layout
        final TextView dateView = (TextView) findViewById(R.id.view_date);
        final DatePicker datePicker = (DatePicker) findViewById(R.id.date_picker);

        //Display the DatePicker initial date
        int monthFix = month + 1;
        dateView.setText("" + dayOfMonth + "/" + monthFix + "/" + year);

        //init(int year, int monthOfYear, int dayOfMonth, DatePicker.OnDateChangedListener onDateChangedListener) Initialize the state.
        datePicker.init(year, month, dayOfMonth, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                //Display the changed date to app interface
                int monthFix = monthOfYear + 1;
                dateView.setText("" + dayOfMonth + "/" + monthFix + "/" + year);
            }
        });


        // Determine if we are creating a new exercise or editing an existing one from the intent.
        Intent intent = getIntent();
        mCurrentUri = intent.getData();

        // If the intent DOES NOT contain a content URI, then we are creating a new exercise.
        if (mCurrentUri == null) {
            setTitle(getString(R.string.editor_activity_title_new_entry));
            invalidateOptionsMenu();
            mMainView = (LinearLayout) findViewById(R.id.main_layout);

            for (int i = 0; i < mSets; i++) {
                View newRow = getLayoutInflater().inflate(R.layout.editor_row, null, false);
                mSetRows.add(i,newRow);

                TextView setNumber = (TextView) newRow.findViewById(R.id.set_number);
                setNumber.setText(getString(R.string.TL_set) + " " + (i + 1));

                EditText repsField = (EditText) newRow.findViewById(R.id.edit_reps);
                repsField.setTag(100 + i);
                mRepsFields.add(repsField);

                EditText loadField = (EditText) newRow.findViewById(R.id.edit_load);
                repsField.setTag(200 + i);
                mLoadFields.add(loadField);

                TextView massUnit = (TextView) newRow.findViewById(R.id.unit);
                massUnit.setText(getString(R.string.label_kg));

                mMainView.addView(newRow);
            }

        } else {

            // Otherwise this is an existing exercise, so change app bar to say "Edit Exercise"
            setTitle(getString(R.string.editor_activity_title_edit_entry));

            // Initialize a loader to display the current values in the editor
            getLoaderManager().initLoader(EXISTING_LOADER, null, this);
        }

        // Find all relevant views that we will need to read user input from
        mExercise = (EditText) findViewById(R.id.edit_exercise);
        mDate = (TextView) findViewById(R.id.view_date);

        // Setup OnTouchListeners on all the input fields. This will let us know if there are
        // unsaved changes or not, if the user tries to leave the editor without saving.
        mExercise.setOnTouchListener(mTouchListener);
        mDate.setOnTouchListener(mTouchListener);

        for (EditText repField : mRepsFields) {
            repField.setOnTouchListener(mTouchListener);
        }

        for (EditText loadField : mLoadFields) {
            loadField.setOnTouchListener(mTouchListener);
        }
    }


    // Get user input from editor and save exercise into database.
    private void saveExercise() {

        // Read from input fields, trim leading or trailing white spaces.
        String exerciseValue = mExercise.getText().toString().trim();
        String dateValue = mDate.getText().toString().trim();

        for (int i = 0; i < mRepsFields.size(); i++) {
            mRepsValues.set(i, mRepsFields.get(i).getText().toString().trim());
        }

        for (int i = 0; i < mLoadFields.size(); i++) {
            mLoadValues.set(i, mLoadFields.get(i).getText().toString().trim());
        }

        // Check if this is supposed to be a new exercise
        // and check if all the fields in the editor are blank
        if (mCurrentUri == null && TextUtils.isEmpty(exerciseValue) && TextUtils.isEmpty(dateValue)) {

            // Since no fields were modified, no need to do any ContentProvider operations.
            return;
        }

        // Create a ContentValues object where column names are the keys,
        // and string attributes from the editor are the values.
        ContentValues values = new ContentValues();

        values.put(TrainingEntry.EXERCISE, exerciseValue);
        values.put(TrainingEntry.WORKOUT_DATE, dateValue);

        values.put(TrainingEntry.REPS_SET_01, mRepsValues.get(0));
        values.put(TrainingEntry.REPS_SET_02, mRepsValues.get(1));
        values.put(TrainingEntry.REPS_SET_03, mRepsValues.get(2));
        values.put(TrainingEntry.REPS_SET_04, mRepsValues.get(3));
        values.put(TrainingEntry.REPS_SET_05, mRepsValues.get(4));
        values.put(TrainingEntry.REPS_SET_06, mRepsValues.get(5));
        values.put(TrainingEntry.REPS_SET_07, mRepsValues.get(6));
        values.put(TrainingEntry.REPS_SET_08, mRepsValues.get(7));
        values.put(TrainingEntry.REPS_SET_09, mRepsValues.get(8));
        values.put(TrainingEntry.REPS_SET_10, mRepsValues.get(9));

        values.put(TrainingEntry.LOAD_SET_01, mLoadValues.get(0));
        values.put(TrainingEntry.LOAD_SET_02, mLoadValues.get(1));
        values.put(TrainingEntry.LOAD_SET_03, mLoadValues.get(2));
        values.put(TrainingEntry.LOAD_SET_04, mLoadValues.get(3));
        values.put(TrainingEntry.LOAD_SET_05, mLoadValues.get(4));
        values.put(TrainingEntry.LOAD_SET_06, mLoadValues.get(5));
        values.put(TrainingEntry.LOAD_SET_07, mLoadValues.get(6));
        values.put(TrainingEntry.LOAD_SET_08, mLoadValues.get(7));
        values.put(TrainingEntry.LOAD_SET_09, mLoadValues.get(8));
        values.put(TrainingEntry.LOAD_SET_10, mLoadValues.get(9));

        // Determine if this is a new or existing exercise.
        if (mCurrentUri == null) {

            // This is a NEW entry, so insert a new exercise into the provider.
            Uri newUri = getContentResolver().insert(TrainingEntry.CONTENT_URI, values);

            // Show a toast message depending on whether or not the insertion was successful.
            if (newUri == null) {

                // If the new content URI is null, then there was an error with insertion.
                Toast.makeText(this, getString(R.string.editor_insert_failed),
                        Toast.LENGTH_SHORT).show();
            } else {

                // Otherwise, the insertion was successful and we can display a toast.
                Toast.makeText(this, getString(R.string.editor_insert_successful),
                        Toast.LENGTH_SHORT).show();
            }
        } else {

            // This is an EXISTING exercise, so update it with content URI: mCurrentUri and the
            // new ContentValues. Pass in null for the selection and selection args because
            // mCurrentUri will already identify the correct row in the database to modify.
            int rowsAffected = getContentResolver().update(mCurrentUri, values, null, null);

            // Show a toast message depending on whether or not the update was successful.
            if (rowsAffected == 0) {

                // If no rows were affected, then there was an error with the update.
                Toast.makeText(this, getString(R.string.editor_update_failed),
                        Toast.LENGTH_SHORT).show();
            } else {

                // Otherwise, the update was successful and we can display a toast.
                Toast.makeText(this, getString(R.string.editor_update_successful),
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu options from the res/menu/menu_editor.xml file.
        // This adds menu items to the app bar.
        getMenuInflater().inflate(R.menu.menu_editor, menu);
        return true;
    }

    // This method is called after invalidateOptionsMenu(), so that the
    // menu can be updated (some menu items can be hidden or made visible).
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);

        // If this is a new exercise, hide the "Delete" menu item.
        if (mCurrentUri == null) {
            MenuItem menuItem = menu.findItem(R.id.action_delete);
            menuItem.setVisible(false);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // User clicked on a menu option in the app bar overflow menu
        switch (item.getItemId()) {

            // Respond to a click on the "Save" menu option
            case R.id.action_save:

                // Save exercise to database
                saveExercise();

                // Exit activity
                finish();
                return true;

            // Respond to a click on the "Delete" menu option
            case R.id.action_delete:

                // Pop up confirmation dialog for deletion
                showDeleteConfirmationDialog();
                return true;

            // Respond to a click on the "Up" arrow button in the app bar
            case android.R.id.home:

                // If the exercise hasn't changed, continue with navigating up to parent activity
                // which is the {@link CatalogActivity}.
                if (!mExerciseHasChanged) {
                    NavUtils.navigateUpFromSameTask(EditorActivity.this);
                    return true;
                }

                // Otherwise if there are unsaved changes, setup a dialog to warn the user.
                // Create a click listener to handle the user confirming that
                // changes should be discarded.
                DialogInterface.OnClickListener discardButtonClickListener =
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                // User clicked "Discard" button, navigate to parent activity.
                                NavUtils.navigateUpFromSameTask(EditorActivity.this);
                            }
                        };

                // Show a dialog that notifies the user they have unsaved changes
                showUnsavedChangesDialog(discardButtonClickListener);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // This method is called when the back button is pressed.
    @Override
    public void onBackPressed() {

        // If the exercise hasn't changed, continue with handling back button press
        if (!mExerciseHasChanged) {
            super.onBackPressed();
            return;
        }

        // Otherwise if there are unsaved changes, setup a dialog to warn the user.
        // Create a click listener to handle the user confirming that changes should be discarded.
        DialogInterface.OnClickListener discardButtonClickListener =
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // User clicked "Discard" button, close the current activity.
                        finish();
                    }
                };

        // Show dialog that there are unsaved changes
        showUnsavedChangesDialog(discardButtonClickListener);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {

        // Since the editor shows all exercise attributes, define a projection that contains
        // all columns from the table.
        String[] projection = {

                TrainingEntry._ID,

                TrainingEntry.EXERCISE,
                TrainingEntry.WORKOUT_DATE,

                TrainingEntry.REPS_SET_01,
                TrainingEntry.REPS_SET_02,
                TrainingEntry.REPS_SET_03,
                TrainingEntry.REPS_SET_04,
                TrainingEntry.REPS_SET_05,
                TrainingEntry.REPS_SET_06,
                TrainingEntry.REPS_SET_07,
                TrainingEntry.REPS_SET_08,
                TrainingEntry.REPS_SET_09,
                TrainingEntry.REPS_SET_10,

                TrainingEntry.LOAD_SET_01,
                TrainingEntry.LOAD_SET_02,
                TrainingEntry.LOAD_SET_03,
                TrainingEntry.LOAD_SET_04,
                TrainingEntry.LOAD_SET_05,
                TrainingEntry.LOAD_SET_06,
                TrainingEntry.LOAD_SET_07,
                TrainingEntry.LOAD_SET_08,
                TrainingEntry.LOAD_SET_09,
                TrainingEntry.LOAD_SET_10

        };

        // This loader will execute the ContentProvider's query method on a background thread
        return new CursorLoader(this,   // Parent activity context
                mCurrentUri,                    // Query the content URI for the current exercise
                projection,                     // Columns to include in the resulting Cursor
                null,                  // No selection clause
                null,               // No selection arguments
                null);                 // Default sort order
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {

        // Bail early if the cursor is null or there is less than 1 row in the cursor
        if (cursor == null || cursor.getCount() < 1) {
            return;
        }

        // Proceed with moving to the first row of the cursor and reading data from it
        // (This should be the only row in the cursor)
        if (cursor.moveToFirst()) {

            // Extract out the value from the Cursor for the given column index
            String exercise = cursor.getString(cursor.getColumnIndex(TrainingEntry.EXERCISE));
            String date = cursor.getString(cursor.getColumnIndex(TrainingEntry.WORKOUT_DATE));

            List<Integer> convertReps = new ArrayList<Integer>();
            convertReps.add(cursor.getInt(cursor.getColumnIndex(TrainingEntry.REPS_SET_01)));
            convertReps.add(cursor.getInt(cursor.getColumnIndex(TrainingEntry.REPS_SET_02)));
            convertReps.add(cursor.getInt(cursor.getColumnIndex(TrainingEntry.REPS_SET_03)));
            convertReps.add(cursor.getInt(cursor.getColumnIndex(TrainingEntry.REPS_SET_04)));
            convertReps.add(cursor.getInt(cursor.getColumnIndex(TrainingEntry.REPS_SET_05)));
            convertReps.add(cursor.getInt(cursor.getColumnIndex(TrainingEntry.REPS_SET_06)));
            convertReps.add(cursor.getInt(cursor.getColumnIndex(TrainingEntry.REPS_SET_07)));
            convertReps.add(cursor.getInt(cursor.getColumnIndex(TrainingEntry.REPS_SET_08)));
            convertReps.add(cursor.getInt(cursor.getColumnIndex(TrainingEntry.REPS_SET_09)));
            convertReps.add(cursor.getInt(cursor.getColumnIndex(TrainingEntry.REPS_SET_10)));

            List<Double> convertLoad = new ArrayList<Double>();
            convertLoad.add(cursor.getDouble(cursor.getColumnIndex(TrainingEntry.LOAD_SET_01)));
            convertLoad.add(cursor.getDouble(cursor.getColumnIndex(TrainingEntry.LOAD_SET_02)));
            convertLoad.add(cursor.getDouble(cursor.getColumnIndex(TrainingEntry.LOAD_SET_03)));
            convertLoad.add(cursor.getDouble(cursor.getColumnIndex(TrainingEntry.LOAD_SET_04)));
            convertLoad.add(cursor.getDouble(cursor.getColumnIndex(TrainingEntry.LOAD_SET_05)));
            convertLoad.add(cursor.getDouble(cursor.getColumnIndex(TrainingEntry.LOAD_SET_06)));
            convertLoad.add(cursor.getDouble(cursor.getColumnIndex(TrainingEntry.LOAD_SET_07)));
            convertLoad.add(cursor.getDouble(cursor.getColumnIndex(TrainingEntry.LOAD_SET_08)));
            convertLoad.add(cursor.getDouble(cursor.getColumnIndex(TrainingEntry.LOAD_SET_09)));
            convertLoad.add(cursor.getDouble(cursor.getColumnIndex(TrainingEntry.LOAD_SET_10)));

            // Update the views on the screen with the values from the database
            mExercise.setText(exercise);
            mDate.setText(date);

            for (int i = 0; i < mRepsFields.size(); i++) {
                if (convertReps.get(i) > 0 ) {
                    mRepsFields.get(i).setText(Integer.toString(convertReps.get(i)));
                    mLoadFields.get(i).setText(Double.toString(convertLoad.get(i)));
                }
            }
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

        // If the loader is invalidated, clear out all the data from the input fields.
        mExercise.setText("");
        mDate.setText("");

        for (EditText repField : mRepsFields) {
            repField.setText("");
        }

        for (EditText loadField : mLoadFields) {
            loadField.setText("");
        }
    }

    // Show a dialog that warns the user there are unsaved changes that will be lost
    // if they continue leaving the editor.

    // Click listener for what to do when the user confirms they want to discard their changes.
    private void showUnsavedChangesDialog(
            DialogInterface.OnClickListener discardButtonClickListener) {

        // Create an AlertDialog.Builder and set the message, and click listeners
        // for the postivie and negative buttons on the dialog.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.unsaved_changes_dialog_msg);
        builder.setPositiveButton(R.string.discard, discardButtonClickListener);
        builder.setNegativeButton(R.string.keep_editing, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                // User clicked the "Keep editing" button, so dismiss the dialog.
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        });

        // Create and show the AlertDialog
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    // Prompt the user to confirm that they want to delete this exercise.
    private void showDeleteConfirmationDialog() {

        // Create an AlertDialog.Builder and set the message, and click listeners
        // for the postivie and negative buttons on the dialog.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.delete_dialog_msg);
        builder.setPositiveButton(R.string.delete, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                deleteExercise();
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        });

        // Create and show the AlertDialog
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    // Perform the deletion of the exercise in the database.
    private void deleteExercise() {
        if (mCurrentUri != null) {

            // Pass in null for the selection and selection args because the mCurrentUri
            // content URI already identifies the exercise.
            int rowsDeleted = getContentResolver().delete(mCurrentUri, null, null);

            // Show a toast message depending on whether or not the delete was successful.
            if (rowsDeleted == 0) {
                Toast.makeText(this, getString(R.string.editor_delete_failed),
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, getString(R.string.editor_delete_successful),
                        Toast.LENGTH_SHORT).show();
            }
        }
        finish();
    }

    public void showDatePicker(View view) {
        TextView viewDate = (TextView) findViewById(R.id.view_date);
        LinearLayout editDate = (LinearLayout) findViewById(R.id.edit_date);
        viewDate.setVisibility(View.GONE);
        editDate.setVisibility(View.VISIBLE);
    }

    public void hideDatePicker(View view) {
        TextView viewDate = (TextView) findViewById(R.id.view_date);
        LinearLayout editDate = (LinearLayout) findViewById(R.id.edit_date);
        viewDate.setVisibility(View.VISIBLE);
        editDate.setVisibility(View.GONE);
    }

    public void decrementSets (View view){
            if (mSets == 1) {
                return;
            }

        mSets = mSets - 1;
        TextView numberSets = (TextView) findViewById(R.id.number_sets);
        numberSets.setText("" + mSets);

        mMainView.removeView(mSetRows.get(mSetRows.size()-1));
        mSetRows.remove(mSetRows.size()-1);
        mRepsFields.remove(mSetRows.size()-1);
        mLoadFields.remove(mSetRows.size()-1);
    }


    public void incrementSets (View view){
        if (mSets == 10) {
            return;
        }
        mSets = mSets + 1;
        TextView numberSets = (TextView) findViewById(R.id.number_sets);
        numberSets.setText("" + mSets);


        LayoutInflater inflater = LayoutInflater.from(EditorActivity.this);
        View newRow = inflater.inflate(R.layout.editor_row, null, false);

        int newId = mSetRows.size();

        String newTitle = getString(R.string.TL_set) + " " + (newId + 1);
        TextView setNumber = (TextView) newRow.findViewById(R.id.set_number);
        setNumber.setText(newTitle);

        EditText repsField = (EditText) newRow.findViewById(R.id.edit_reps);
        repsField.setTag(100 + newId);

        EditText loadField = (EditText) newRow.findViewById(R.id.edit_load);
        repsField.setTag(200 + newId);

        TextView massUnit = (TextView) newRow.findViewById(R.id.unit);
        massUnit.setText(getString(R.string.label_kg));

        mMainView.addView(newRow);
        mSetRows.add(newId,newRow);
        mRepsFields.add(newId,repsField);
        mLoadFields.add(newId,loadField);
    }

    public static List<EditText> getRepsFields() {
        return mRepsFields;
    }

    public static List<EditText> getLoadFields() {
        return mLoadFields;
    }
}
