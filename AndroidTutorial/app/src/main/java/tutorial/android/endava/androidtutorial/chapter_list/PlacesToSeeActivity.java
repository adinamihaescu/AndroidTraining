package tutorial.android.endava.androidtutorial.chapter_list;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import tutorial.android.endava.androidtutorial.R;

/**
 * Created by radpopescu on 7/14/2016.
 */
public class PlacesToSeeActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Destination>>,
        AdapterView.OnItemClickListener {

    private static final int DATA_LOADER = 10;
    public static final String BUNDLE_POSITION = "bundle_position";

    private ListView mListView;
    private PlacesToSeeAdapter mAdapter;
    private long startTime;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        mListView = (ListView) findViewById(R.id.list_view);
        mAdapter = new PlacesToSeeAdapter(this, new ArrayList<Destination>());
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getSupportLoaderManager().restartLoader(DATA_LOADER, null, this);
    }

    @Override
    public Loader<List<Destination>> onCreateLoader(int id, Bundle args) {
        switch (id) {
            case DATA_LOADER:
                return new DestinationLoader(PlacesToSeeActivity.this);
            default:
                break;
        }
        return null;
    }

    @Override
    public void onLoadFinished(Loader<List<Destination>> loader, List<Destination> data) {
        switch (loader.getId()) {
            case DATA_LOADER:
                mAdapter.clear();
                mAdapter.addAll(data);
                break;
        }
    }

    @Override
    public void onLoaderReset(Loader<List<Destination>> loader) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra(BUNDLE_POSITION, position);
        startActivity(intent);
    }
}
