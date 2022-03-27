
package ss.test.pocketknife;

import android.content.Context;
import android.database.Cursor;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import java.util.ArrayList;
import java.util.List;

import ss.test.pocketknife.data.TrainingContract.TrainingEntry;

public class ExerciseCursorAdapter extends SectionCursorAdapter  {


    public ExerciseCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    protected Object getSectionFromCursor(Cursor cursor) {
        final String DateOfEntry = cursor.getString(cursor.getColumnIndex(TrainingEntry.WORKOUT_DATE));
        return DateOfEntry;
    }

    @Override
    protected View newSectionView(Context context, Object item, ViewGroup parent) {
        return getLayoutInflater().inflate(R.layout.log_header, parent, false);
    }

    @Override
    protected void bindSectionView(View convertView, Context context, int position, Object item) {
        TextView dateText = (TextView) convertView.findViewById(R.id.date_header);
        dateText.setText((String) item);
    }

    @Override
    protected View newItemView(Context context, Cursor cursor, ViewGroup parent) {
        View convertView = getLayoutInflater().inflate(R.layout.log_entry, parent, false);
        return convertView;
    }

    @Override
    protected void bindItemView(View convertView, Context context, Cursor cursor) {
        TextView exerciseTextView = (TextView) convertView.findViewById(R.id.exercise_name);
        TextView dateTextView = (TextView) convertView.findViewById(R.id.exercise_date);

        exerciseTextView.setText(cursor.getString(cursor.getColumnIndex(TrainingEntry.EXERCISE)));
        dateTextView.setText(cursor.getString(cursor.getColumnIndex(TrainingEntry.WORKOUT_DATE)));

        TextView repsSet1 = (TextView) convertView.findViewById(R.id.reps_1);
        TextView repsSet2 = (TextView) convertView.findViewById(R.id.reps_2);
        TextView repsSet3 = (TextView) convertView.findViewById(R.id.reps_3);
        TextView repsSet4 = (TextView) convertView.findViewById(R.id.reps_4);
        TextView repsSet5 = (TextView) convertView.findViewById(R.id.reps_5);

        TextView loadSet1 = (TextView) convertView.findViewById(R.id.load_1);
        TextView loadSet2 = (TextView) convertView.findViewById(R.id.load_2);
        TextView loadSet3 = (TextView) convertView.findViewById(R.id.load_3);
        TextView loadSet4 = (TextView) convertView.findViewById(R.id.load_4);
        TextView loadSet5 = (TextView) convertView.findViewById(R.id.load_5);

        repsSet1.setText(cursor.getString(cursor.getColumnIndex(TrainingEntry.REPS_SET_01)));
        repsSet2.setText(cursor.getString(cursor.getColumnIndex(TrainingEntry.REPS_SET_02)));
        repsSet3.setText(cursor.getString(cursor.getColumnIndex(TrainingEntry.REPS_SET_03)));
        repsSet4.setText(cursor.getString(cursor.getColumnIndex(TrainingEntry.REPS_SET_04)));
        repsSet5.setText(cursor.getString(cursor.getColumnIndex(TrainingEntry.REPS_SET_05)));

        loadSet1.setText(cursor.getString(cursor.getColumnIndex(TrainingEntry.LOAD_SET_01)));
        loadSet2.setText(cursor.getString(cursor.getColumnIndex(TrainingEntry.LOAD_SET_02)));
        loadSet3.setText(cursor.getString(cursor.getColumnIndex(TrainingEntry.LOAD_SET_03)));
        loadSet4.setText(cursor.getString(cursor.getColumnIndex(TrainingEntry.LOAD_SET_04)));
        loadSet5.setText(cursor.getString(cursor.getColumnIndex(TrainingEntry.LOAD_SET_05)));

    }

    @Override
    protected int getMaxIndexerLength() {
        return 1;
    }

}