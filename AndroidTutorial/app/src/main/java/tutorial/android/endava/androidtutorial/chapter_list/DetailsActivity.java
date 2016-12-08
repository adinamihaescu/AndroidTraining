package tutorial.android.endava.androidtutorial.chapter_list;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import tutorial.android.endava.androidtutorial.R;

public class DetailsActivity extends AppCompatActivity {

    private Destination mDestination;

    private ImageView mBackdropImageView;
    private TextView mDescriptionView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        initViews();
        checkIntent();
        toolbar.setTitle(mDestination.getDestinationName());
        mDescriptionView.setText(mDestination.getDestinationDetails());
        mBackdropImageView.setImageResource(mDestination.getImageUrl());
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, String.format(getString(R.string.snack_bar_message),mDestination.getDestinationName()), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    private void checkIntent() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            int id = bundle.getInt(PlacesToSeeActivity.BUNDLE_POSITION);
            mDestination = getItem(id);
        }
    }

    private Destination getItem(int position) {
        String[] destinationNames = getResources().getStringArray(R.array.destination_name);
        String[] destinationDate = getResources().getStringArray(R.array.destination_date);
        String[] destinationLocation = getResources().getStringArray(R.array.destination_location);
        TypedArray destinationIcon = getResources().obtainTypedArray(R.array.destination_icon);
        String[] destinationDetails = getResources().getStringArray(R.array.destination_info);
        Destination destination = new Destination();
        destination.setDestinationName(destinationNames[position]);
        destination.setImageUrl(destinationIcon.getResourceId(position, -1));
        destination.setDestinationDetails(destinationDetails[position]);
        destination.setLocation(destinationLocation[position]);
        destination.setDestinationTime(destinationDate[position]);
        destinationIcon.recycle();
        return destination;
    }

    private void initViews() {
        mBackdropImageView = (ImageView) findViewById(R.id.backdrop);
        mDescriptionView = (TextView) findViewById(R.id.description_view);
    }


}
