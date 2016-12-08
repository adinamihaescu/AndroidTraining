package tutorial.android.endava.androidtutorial.chapter_list;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

import tutorial.android.endava.androidtutorial.R;

/**
 * Created by radpopescu on 7/15/2016.
 */
public class TouristTrapActivity extends AppCompatActivity {

    private ListView mListView;
    private TouristTrapAdapter mAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        mListView = (ListView) findViewById(R.id.list_view);
        mAdapter = new TouristTrapAdapter(this, new ArrayList<Destination>());
        mListView.setAdapter(mAdapter);
        populateAdapter();
    }

    private void populateAdapter() {
        String[] destinationNames = getResources().getStringArray(R.array.trap_name);
        String[] destinationDate = getResources().getStringArray(R.array.destination_date);
        String[] destinationLocation = getResources().getStringArray(R.array.destination_location);
        TypedArray destinationIcon = getResources().obtainTypedArray(R.array.trap_icon);
        String[] destinationDetails = getResources().getStringArray(R.array.trap_info);
        ArrayList<Destination> list = new ArrayList<>();
        for (int i = 0; i < destinationNames.length; i++) {
            Destination destination = new Destination();
            destination.setDestinationName(destinationNames[i]);
            destination.setImageUrl(destinationIcon.getResourceId(i, -1));
            destination.setDestinationDetails(destinationDetails[i]);
            destination.setLocation(destinationLocation[i]);
            destination.setDestinationTime(destinationDate[i]);
            list.add(destination);
        }
        destinationIcon.recycle();
        //adds the list to the adapter and notifies it in order for the list to be redrawn(only
        // if the mNotifyOnChange boolean from the adapter is set to true, which is, by default).
        // If the mNotifyOnChange is false you will have to call notifyDataSetChanged()l
        mAdapter.addAll(list);
        //mAdapter.notifyDataSetChanged();
    }
}