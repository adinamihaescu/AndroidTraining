package tutorial.android.endava.androidtutorial.chapter_list;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.content.AsyncTaskLoader;

import java.util.ArrayList;
import java.util.List;

import tutorial.android.endava.androidtutorial.R;

/**
 * Created by radpopescu on 8/2/2016.
 */
public class DestinationLoader extends AsyncTaskLoader<List<Destination>> {

    private Context mContext;

    public DestinationLoader(Context context) {
        super(context);
        mContext = context;
    }


    @Override
    public List<Destination> loadInBackground() {
        return getDataFromResources();
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }
    private List<Destination> getDataFromResources() {
        String[] destinationNames = mContext.getResources().getStringArray(R.array.destination_name);
        String[] destinationDate = mContext.getResources().getStringArray(R.array.destination_date);
        String[] destinationLocation = mContext.getResources().getStringArray(R.array.destination_location);
        TypedArray destinationIcon = mContext.getResources().obtainTypedArray(R.array.destination_icon);
        String[] destinationDetails = mContext.getResources().getStringArray(R.array.destination_info);
        List<Destination> list = new ArrayList<>();
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
        return list;
    }
}