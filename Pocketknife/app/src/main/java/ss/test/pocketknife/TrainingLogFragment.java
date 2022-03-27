package ss.test.pocketknife;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.CursorAdapter;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import ss.test.pocketknife.data.TrainingContract.TrainingEntry;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TrainingLogFragment extends Fragment implements
        LoaderManager.LoaderCallbacks<Cursor> {

    // Identifier for the data loader
    private static final int EXERCISE_LOADER = 0;

    // Adapter for the ListView
    ExerciseCursorAdapter mCursorAdapter;

    private OnFragmentInteractionListener mListener;

    public TrainingLogFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_training_log_catalog, container, false);

        // Setup FAB to open EditorActivity
        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Intent intent = new Intent(getActivity(), EditorActivity.class);
               startActivity(intent);
            }
        });


        // Find the ListView which will be populated with the exercise data
        ListView exerciseListView = (ListView) rootView.findViewById(R.id.list);

        // Find and set empty view on the ListView, so that it only shows when the list has 0 items.
        View emptyView = rootView.findViewById(R.id.empty_view);
        exerciseListView.setEmptyView(emptyView);

        // Setup an Adapter to create a list item for each row of data in the Cursor.
        // There is no data yet (until the loader finishes) so pass in null for the Cursor.
        mCursorAdapter = new ExerciseCursorAdapter(getContext(), null);
        exerciseListView.setAdapter(mCursorAdapter);

        // Setup the item click listener
        exerciseListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                // Create new intent to go to {@link EditorActivity}
                Intent intent = new Intent(getActivity(), EditorActivity.class);

                // Form the content URI that represents the specific exercise that was clicked on.
                Uri currentExerciseUri = ContentUris.withAppendedId(TrainingEntry.CONTENT_URI, id);

                // Set the URI on the data field of the intent
                intent.setData(currentExerciseUri);

                // Launch the {@link EditorActivity} to display the data for the current exercise.
                startActivity(intent);
            }
        });

        // Kick off the loader
        android.support.v4.app.LoaderManager.getInstance(this).initLoader(EXERCISE_LOADER, null, this).forceLoad();

    return rootView;
    }
    private void insertDemo() {
        ContentValues values = new ContentValues();

        values.put(TrainingEntry.EXERCISE, getString(R.string.flat_bench_press));
        values.put(TrainingEntry.WORKOUT_DATE, new SimpleDateFormat("dd/MM/yyyy").format(new Date()));

        values.put(TrainingEntry.REPS_SET_01, "5");
        values.put(TrainingEntry.REPS_SET_02, "4");
        values.put(TrainingEntry.REPS_SET_03, "3");
        values.put(TrainingEntry.REPS_SET_04, "2");
        values.put(TrainingEntry.REPS_SET_05, "1");

        values.put(TrainingEntry.LOAD_SET_01, "100");
        values.put(TrainingEntry.LOAD_SET_02, "97.5");
        values.put(TrainingEntry.LOAD_SET_03, "95");
        values.put(TrainingEntry.LOAD_SET_04, "92.5");
        values.put(TrainingEntry.LOAD_SET_05, "90");

        Uri newUri = getActivity().getContentResolver().insert(TrainingEntry.CONTENT_URI, values);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        // Define a projection that specifies the columns from the table we care about.
        String[] projection = {

                TrainingEntry._ID,
                TrainingEntry.EXERCISE,
                TrainingEntry.WORKOUT_DATE,

                TrainingEntry.REPS_SET_01,
                TrainingEntry.REPS_SET_02,
                TrainingEntry.REPS_SET_03,
                TrainingEntry.REPS_SET_04,
                TrainingEntry.REPS_SET_05,

                TrainingEntry.LOAD_SET_01,
                TrainingEntry.LOAD_SET_02,
                TrainingEntry.LOAD_SET_03,
                TrainingEntry.LOAD_SET_04,
                TrainingEntry.LOAD_SET_05
        };

        // This loader will execute the ContentProvider's query method on a background thread
        return new CursorLoader(getContext(),   // Parent activity context
                TrainingEntry.CONTENT_URI,      // Provider content URI to query
                projection,                     // Columns to include in the resulting Cursor
                null,                  // No selection clause
                null,               // No selection arguments
                null);                 // Default sort order
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        // Update {@link ExerciseCursorAdapter} with this new cursor containing updated data
        mCursorAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        // Callback called when the data needs to be deleted
        mCursorAdapter.swapCursor(null);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
