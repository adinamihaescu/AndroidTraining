package tutorial.android.endava.androidtutorial.intro;

/**
 * Created by radpopescu on 7/14/2016.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;

import tutorial.android.endava.androidtutorial.R;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public static final int PAGE_COUNT = 3;

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return PlaceholderFragment.newInstance(R.drawable.ic_slide_1,
                        R.string.welcome_title,
                        R.string.welcome_message);
            case 1:
                return PlaceholderFragment.newInstance(R.drawable.ic_slide_2,
                        R.string.slide_title_2,
                        R.string.slide_text_2);
            case 2:
                return PlaceholderFragment.newInstance(R.drawable.ic_slide_3,
                        R.string.slide_title_3,
                        R.string.slide_text_3);
        }

        return null;
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return PAGE_COUNT;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        if (object instanceof PlaceholderFragment){
            view.setTag(((PlaceholderFragment)object).getIndex());
        }
        return super.isViewFromObject(view, object);
    }

}