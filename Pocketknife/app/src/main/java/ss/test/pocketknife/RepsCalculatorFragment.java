package ss.test.pocketknife;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class RepsCalculatorFragment extends Fragment {

    private int mReps = 1;
    private double mLoad = 100;

    private int[] mCellsBrzycki = new int[]{
            R.id.brzycki_1, R.id.brzycki_2, R.id.brzycki_3, R.id.brzycki_4,
            R.id.brzycki_5, R.id.brzycki_6, R.id.brzycki_7, R.id.brzycki_8,
            R.id.brzycki_9, R.id.brzycki_10, R.id.brzycki_11, R.id.brzycki_12};

    private int[] mCellsEpley = new int[]{
            R.id.epley_1, R.id.epley_2, R.id.epley_3, R.id.epley_4,
            R.id.epley_5, R.id.epley_6, R.id.epley_7, R.id.epley_8,
            R.id.epley_9, R.id.epley_10, R.id.epley_11, R.id.epley_12};

    private int[] mCellsLander = new int[]{
            R.id.lander_1, R.id.lander_2, R.id.lander_3, R.id.lander_4,
            R.id.lander_5, R.id.lander_6, R.id.lander_7, R.id.lander_8,
            R.id.lander_9, R.id.lander_10, R.id.lander_11, R.id.lander_12};

    private int[] mCellsAverage = new int[]{
            R.id.average_1, R.id.average_2, R.id.average_3, R.id.average_4,
            R.id.average_5, R.id.average_6, R.id.average_7, R.id.average_8,
            R.id.average_9, R.id.average_10, R.id.average_11, R.id.average_12};

    private int[] mCellsPercentage = new int[]{
            R.id.perc_95, R.id.perc_90, R.id.perc_85, R.id.perc_80,
            R.id.perc_75, R.id.perc_70, R.id.perc_65, R.id.perc_60};

    private OnFragmentInteractionListener mListener;

    public RepsCalculatorFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_reps_calculator, container, false);

        Button decrementButton = (Button) rootView.findViewById(R.id.decrement);
        decrementButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mReps == 1) {
                    return;
                }
                mReps = mReps - 1;
                displayReps(mReps);
            }
        });


        Button incrementButton = (Button) rootView.findViewById(R.id.increment);
        incrementButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mReps == 12) {
                    return;
                }
                mReps = mReps + 1;
                displayReps(mReps);
            }
        });

        Button calculateButton = (Button) rootView.findViewById(R.id.calculate);
        calculateButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                refreshTable();
            }
        });

        return rootView;
    }

    // This method displays the given quantity value on the screen.
    private void displayReps(int numberOfReps) {
        TextView repsTextView = (TextView) getActivity().findViewById(R.id.reps_text_view);
        repsTextView.setText("" + numberOfReps);
    }

    // This method is called when the "Calculate" button is clicked.
    public void refreshTable() {

        TextView repsTextView = (TextView) getActivity().findViewById(R.id.reps_text_view);
        TextView loadTextView = (TextView) getActivity().findViewById(R.id.load_edit_text);

        mReps = Integer.parseInt(repsTextView.getText().toString());

        if (loadTextView.getText().toString().isEmpty()) {
        mLoad = 0;
        } else {
            mLoad = Double.parseDouble(loadTextView.getText().toString());
        }

        updateValues(calculateBrzycki(mReps, mLoad), mCellsBrzycki);
        updateValues(calculateEpley(mReps, mLoad), mCellsEpley);
        updateValues(calculateLander(mReps, mLoad), mCellsLander);

        double[] averageValues = calculateAverage(
                calculateBrzycki(mReps, mLoad),
                calculateEpley(mReps, mLoad),
                calculateLander(mReps, mLoad));

        updateValues(averageValues, mCellsAverage);
        updateValues(getPercentages(averageValues), mCellsPercentage);

        DecimalFormat valueTrimmer = new DecimalFormat("#");
        valueTrimmer.setRoundingMode(RoundingMode.HALF_UP);
        TextView percOf1RM = (TextView) getActivity().findViewById(R.id.perc_100);
        percOf1RM.setText(getString(R.string.RC_percentages_of_1rm) + ": "
                + valueTrimmer.format(averageValues[0]));
    }

    // Calculating RM according to Brzycki formula.
    private double[] calculateBrzycki(int numberOfreps, double weightLifted) {

        double reps = numberOfreps;
        double maxBrzycki;
        double[] valuesBrzycki = new double[12];

        if (numberOfreps == 1) {
            maxBrzycki = weightLifted;
        } else {
            maxBrzycki = weightLifted / (1.0278 - (0.0278 * reps));
        }

        valuesBrzycki[0] = maxBrzycki / 1.00000;
        valuesBrzycki[1] = maxBrzycki / 1.02859;
        valuesBrzycki[2] = maxBrzycki / 1.05887;
        valuesBrzycki[3] = maxBrzycki / 1.09099;
        valuesBrzycki[4] = maxBrzycki / 1.12511;
        valuesBrzycki[5] = maxBrzycki / 1.16144;
        valuesBrzycki[6] = maxBrzycki / 1.20019;
        valuesBrzycki[7] = maxBrzycki / 1.24162;
        valuesBrzycki[8] = maxBrzycki / 1.28601;
        valuesBrzycki[9] = maxBrzycki / 1.33369;
        valuesBrzycki[10] = maxBrzycki / 1.38504;
        valuesBrzycki[11] = maxBrzycki / 1.44051;

        return valuesBrzycki;
    }

    // Calculating RM according to Epley formula.
    private double[] calculateEpley(int numberOfreps, double weightLifted) {

        double reps = numberOfreps;
        double maxEpley;
        double[] valuesEpley = new double[12];

        if (numberOfreps == 1) {
            maxEpley = weightLifted;
        } else {
            maxEpley = weightLifted * (1 + reps / 30);
        }

        valuesEpley[0] = maxEpley / 1.00000;
        valuesEpley[1] = maxEpley / 1.06667;
        valuesEpley[2] = maxEpley / 1.10000;
        valuesEpley[3] = maxEpley / 1.13333;
        valuesEpley[4] = maxEpley / 1.16667;
        valuesEpley[5] = maxEpley / 1.20000;
        valuesEpley[6] = maxEpley / 1.23333;
        valuesEpley[7] = maxEpley / 1.26667;
        valuesEpley[8] = maxEpley / 1.30000;
        valuesEpley[9] = maxEpley / 1.33333;
        valuesEpley[10] = maxEpley / 1.36667;
        valuesEpley[11] = maxEpley / 1.40000;

        return valuesEpley;
    }

    // Calculating RM according to Lander formula.
    private double[] calculateLander(int numberOfreps, double weightLifted) {

        double reps = numberOfreps;
        double maxLander;
        double[] valuesLander = new double[12];

        if (numberOfreps == 1) {
            maxLander = weightLifted;
        } else {
            maxLander = (100 * weightLifted) / (101.3 - 2.67123 * reps);
        }

        valuesLander[0] = maxLander / 1.00000;
        valuesLander[1] = maxLander / 1.04213;
        valuesLander[2] = maxLander / 1.07197;
        valuesLander[3] = maxLander / 1.10357;
        valuesLander[4] = maxLander / 1.13709;
        valuesLander[5] = maxLander / 1.17271;
        valuesLander[6] = maxLander / 1.21063;
        valuesLander[7] = maxLander / 1.25109;
        valuesLander[8] = maxLander / 1.29435;
        valuesLander[9] = maxLander / 1.34070;
        valuesLander[10] = maxLander / 1.39050;
        valuesLander[11] = maxLander / 1.44414;

        return valuesLander;
    }

    // Calculating Average of the 3 formulas.
    private double[] calculateAverage(double[] valuesBrzycki, double[] valuesEpley, double[] valuesLander) {

        double[] valuesAverage = new double[12];

        for (int i = 0; i < valuesAverage.length; i++) {
            valuesAverage[i] = (valuesBrzycki[i] + valuesEpley[i] + valuesLander[i]) / 3;
        }

        return valuesAverage;
    }

    // Calculate common percentage steps.
    private double[] getPercentages(double[] valuesAverage) {
        double[] valuesPercentage = new double[8];

        valuesPercentage[0] = valuesAverage[0] * 0.95;
        valuesPercentage[1] = valuesAverage[0] * 0.90;
        valuesPercentage[2] = valuesAverage[0] * 0.85;
        valuesPercentage[3] = valuesAverage[0] * 0.80;
        valuesPercentage[4] = valuesAverage[0] * 0.75;
        valuesPercentage[5] = valuesAverage[0] * 0.70;
        valuesPercentage[6] = valuesAverage[0] * 0.65;
        valuesPercentage[7] = valuesAverage[0] * 0.60;

        return valuesPercentage;
    }

    // Method for updating columns from the TableLayout.
    private void updateValues(double[] values, int[] buttons) {

        DecimalFormat valueTrimmer = new DecimalFormat("#");
        valueTrimmer.setRoundingMode(RoundingMode.HALF_UP);

        for (int i = 0; i < values.length; i++) {
            TextView row = (TextView) getActivity().findViewById(buttons[i]);
            row.setText("" + valueTrimmer.format(values[i]));

        }
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
