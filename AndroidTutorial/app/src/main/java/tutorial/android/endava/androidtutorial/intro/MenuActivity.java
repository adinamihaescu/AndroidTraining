package tutorial.android.endava.androidtutorial.intro;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import tutorial.android.endava.androidtutorial.R;
import tutorial.android.endava.androidtutorial.chapter_activties.ActivitiesActivity;
import tutorial.android.endava.androidtutorial.chapter_layouts.PostcardActivity;
import tutorial.android.endava.androidtutorial.chapter_list.TouristTrapActivity;
import tutorial.android.endava.androidtutorial.chapter_list.PlacesToSeeActivity;
import tutorial.android.endava.androidtutorial.chapter_photography.PhotographyActivity;
import tutorial.android.endava.androidtutorial.chapter_travel.MapsActivity;

/**
 * Created by radpopescu on 7/14/2016.
 */
public class MenuActivity extends AppCompatActivity {

    public static final int ACTIVITIES_POSITION = 0;
    public static final int PLACES_TO_SEE_POSITION = 2;
    public static final int TOURIST_TRAPS_POSITION = 3;
    public static final int PHOTOGRAPHY_POSITION = 4;
    public static final int POSTCARDS_POSITION = 1;
    public static final int TRAVEL_POSITION =5;

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        List<String> menuList = new ArrayList<>();
        menuList.add(getString(R.string.second_chapter_text));
        menuList.add(getString(R.string.third_chapter_text));
        menuList.add(getString(R.string.fourth_chapter_text));
        menuList.add(getString(R.string.fifth_chapter_text));
        menuList.add(getString(R.string.seventh_chapter_text));
        menuList.add(getString(R.string.eighth_chapter_text));
        mRecyclerView = (RecyclerView) findViewById(R.id.list_view_menu);
        mRecyclerView.setHasFixedSize(true);
        // use a linear layout manager
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(new MenuAdapter(menuList));
        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, mRecyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                switch (position) {
                    case ACTIVITIES_POSITION:
                        Intent activityChapterIntent = new Intent(getContext(), ActivitiesActivity.class);
                        startActivity(activityChapterIntent);
                        break;
                    case POSTCARDS_POSITION:
                        Intent layoutsChapterIntent = new Intent(getContext(), PostcardActivity.class);
                        startActivity(layoutsChapterIntent);
                        break;
                    case PLACES_TO_SEE_POSITION:
                        Intent goodListChapterIntent = new Intent(getContext(), PlacesToSeeActivity.class);
                        startActivity(goodListChapterIntent);
                        break;
                    case TOURIST_TRAPS_POSITION:
                        Intent badListChapterIntent = new Intent(getContext(), TouristTrapActivity.class);
                        startActivity(badListChapterIntent);
                        break;
                    case PHOTOGRAPHY_POSITION:
                        Intent photographyIntent = new Intent(getContext(), PhotographyActivity.class);
                        startActivity(photographyIntent);
                        break;
                    case TRAVEL_POSITION:
                        Intent travelIntent = new Intent(getContext(), MapsActivity.class);
                        startActivity(travelIntent);
                        break;
                }
            }

            @Override
            public void onLongItemClick(View view, int position) {
                // do whatever
            }
        }));
    }

    private Context getContext() {
        return this;
    }


}
