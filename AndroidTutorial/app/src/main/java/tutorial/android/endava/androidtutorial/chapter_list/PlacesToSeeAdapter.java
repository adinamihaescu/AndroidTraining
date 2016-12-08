package tutorial.android.endava.androidtutorial.chapter_list;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

import tutorial.android.endava.androidtutorial.R;

/**
 * Created by radpopescu on 7/14/2016.
 */
public class PlacesToSeeAdapter extends ArrayAdapter<Destination> {


    private LayoutInflater mInflater;

    public PlacesToSeeAdapter(Context context, ArrayList<Destination> list) {
        super(context, R.layout.item_list_destination, list);
        mInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /**
     * How many items are in the data set represented by this Adapter.
     *
     * @return Count of items.
     */
    @Override
    public int getCount() {
        return super.getCount();
    }

    /**
     * Get a View that displays the data at the specified position in the data set. You can either
     * create a View manually or inflate it from an XML layout file. When the View is inflated,
     * the parent View (GridView, ListView...) will apply default layout parameters unless you use
     * inflate(int, android.view.ViewGroup, boolean) to specify a root view and to prevent
     * attachment to the root.
     *
     * @param position    int: The position of the item within the adapter's data set of the item whose
     *                    view we want.
     * @param convertView View: The old view to reuse, if possible. Note: You should check that
     *                    this view is non-null and of an appropriate type before using. If it is
     *                    not possible to convert this view to display the correct data, this
     *                    method can create a new view. Heterogeneous lists can specify their
     *                    number of view types, so that this View is always of the right type
     *                    (see getViewTypeCount() and getItemViewType(int)).
     * @param parent      ViewGroup: The parent that this view will eventually be attached to
     * @return A View corresponding to the data at the specified position.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_list_destination, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.image_view);
            viewHolder.destinationNameView = (TextView) convertView.findViewById(R.id.destination_name_view);
            viewHolder.destinationTimeView = (TextView) convertView.findViewById(R.id.time_view);
            viewHolder.destinationLocationView = (TextView) convertView.findViewById(R.id.location_view);
            viewHolder.destinationDetailsView = (TextView) convertView.findViewById(R.id.description_view);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Destination destination = getItem(position);
        viewHolder.destinationNameView.setText(destination.getDestinationName());
        viewHolder.destinationTimeView.setText(destination.getDestinationTime());
        viewHolder.destinationLocationView.setText(destination.getLocation());
        Picasso.with(getContext()).load(destination.getImageUrl()).placeholder(R.drawable.ic_placeholder).into(viewHolder.imageView);
        viewHolder.destinationDetailsView.setText(destination.getDestinationDetails());
        return convertView;
    }


    /**
     * A {@link ViewHolder} object stores each of the component views inside the tag field of the Layout,
     * so you can immediately access them without the need to look them up repeatedly.
     */
    static class ViewHolder {
        public ImageView imageView;
        public TextView destinationNameView;
        public TextView destinationTimeView;
        public TextView destinationLocationView;
        public TextView destinationDetailsView;
    }
}
