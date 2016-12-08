package tutorial.android.endava.androidtutorial.intro;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.viewpagerindicator.CirclePageIndicator;

import tutorial.android.endava.androidtutorial.R;

public class PresentationActivity extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    private Button mNextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        CirclePageIndicator pageIndicator = (CirclePageIndicator) findViewById(R.id.circle_indicator_view);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        pageIndicator.setViewPager(mViewPager);
        mViewPager.addOnPageChangeListener(this);
        final LayerDrawable background = (LayerDrawable) mViewPager.getBackground();

        background.getDrawable(0).setAlpha(0); // this is the lowest drawable
        background.getDrawable(1).setAlpha(0);
        background.getDrawable(2).setAlpha(255); // this is the upper one

        mViewPager.setPageTransformer(true, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(View view, float position) {
                int index = (Integer) view.getTag();
                Drawable currentDrawableInLayerDrawable;
                currentDrawableInLayerDrawable = background.getDrawable(index);
                if (position <= -1 || position >= 1) {
                    currentDrawableInLayerDrawable.setAlpha(0);
                } else if (position == 0) {
                    currentDrawableInLayerDrawable.setAlpha(255);
                } else {
                    currentDrawableInLayerDrawable.setAlpha((int) (255 - Math.abs(position * 255)));
                }

            }
        });
        mNextButton = (Button) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.next_button:
                Intent intent = new Intent(this, MenuActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (position == SectionsPagerAdapter.PAGE_COUNT - 1) {
            enableButton(true);
        } else {
            enableButton(false);

        }
    }

    private void enableButton(boolean enable) {
        mNextButton.setAlpha(enable ? 1 : 0.2f);
        mNextButton.setEnabled(enable);
        mNextButton.setClickable(enable);
    }


    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
