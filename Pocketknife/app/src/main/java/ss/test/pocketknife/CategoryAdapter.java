package ss.test.pocketknife;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class CategoryAdapter extends FragmentStatePagerAdapter {

    public CategoryAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new TrainingLogFragment();
        } else if (position == 1) {
            return new RepsCalculatorFragment();
        } else  {
            return new StrengthStandardsFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "Training Log";
        } else if (position == 1) {
            return "Reps Calculator";
        } else {
            return "Strength Standards";
        }
    }
}
