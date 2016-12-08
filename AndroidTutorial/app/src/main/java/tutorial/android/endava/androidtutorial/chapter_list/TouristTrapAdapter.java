package tutorial.android.endava.androidtutorial.chapter_list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import tutorial.android.endava.androidtutorial.R;

/**
 * Created by radpopescu on 7/15/2016.
 */
public class TouristTrapAdapter extends ArrayAdapter<Destination> {
    private LayoutInflater mInflater;

    public TouristTrapAdapter(Context context, ArrayList<Destination> list) {
        super(context, R.layout.item_list_destination, list);
        mInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = mInflater.inflate(R.layout.item_list_destination, parent, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.image_view);
        TextView nameView = (TextView) view.findViewById(R.id.destination_name_view);
        TextView timeView = (TextView) view.findViewById(R.id.time_view);
        TextView locationView = (TextView) view.findViewById(R.id.location_view);
        TextView detailsView = (TextView) view.findViewById(R.id.description_view);
        Destination destination = getItem(position);
        nameView.setText(destination.getDestinationName());
        timeView.setText(destination.getDestinationTime());
        locationView.setText(destination.getLocation());
        imageView.setImageResource(destination.getImageUrl());
        detailsView.setText(destination.getDestinationDetails());
        return view;

    }
}
