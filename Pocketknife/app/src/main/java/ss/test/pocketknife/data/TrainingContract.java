
package ss.test.pocketknife.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

// API Contract for the app.
public final class TrainingContract {

    public static final String CONTENT_AUTHORITY = "ss.test.pocketknife";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_EXERCISES = "exercises";

    // Empty constructor, preventing accidental instantiating of the contract class
    private TrainingContract() {
    }

    // Defining constant values for the database table. Each entry represents a single exercise.
    public static final class TrainingEntry implements BaseColumns {

        // The content URI to access data in the provider
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_EXERCISES);

        // The MIME type of the {@link #CONTENT_URI} for a list of exercises.
        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_EXERCISES;

        // The MIME type of the {@link #CONTENT_URI} for a single exercise.
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_EXERCISES;

        public final static String TABLE_NAME = "workouts";

        public final static String _ID = BaseColumns._ID;
        public final static String EXERCISE = "exercise";
        public final static String WORKOUT_DATE = "workout_date";

        public final static String REPS_SET_01 = "reps01";
        public final static String REPS_SET_02 = "reps02";
        public final static String REPS_SET_03 = "reps03";
        public final static String REPS_SET_04 = "reps04";
        public final static String REPS_SET_05 = "reps05";
        public final static String REPS_SET_06 = "reps06";
        public final static String REPS_SET_07 = "reps07";
        public final static String REPS_SET_08 = "reps08";
        public final static String REPS_SET_09 = "reps09";
        public final static String REPS_SET_10 = "reps10";

        public final static String LOAD_SET_01 = "load01";
        public final static String LOAD_SET_02 = "load02";
        public final static String LOAD_SET_03 = "load03";
        public final static String LOAD_SET_04 = "load04";
        public final static String LOAD_SET_05 = "load05";
        public final static String LOAD_SET_06 = "load06";
        public final static String LOAD_SET_07 = "load07";
        public final static String LOAD_SET_08 = "load08";
        public final static String LOAD_SET_09 = "load09";
        public final static String LOAD_SET_10 = "load10";

    }

}
