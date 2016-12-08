package tutorial.android.endava.androidtutorial.intro;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import tutorial.android.endava.androidtutorial.R;

/**
 * Created by radpopescu on 7/25/2016.
 */
public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {
    private List<String> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;

        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView) v.findViewById(android.R.id.text1);
            mTextView.setCompoundDrawablePadding(10);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MenuAdapter(List<String> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MenuAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(android.R.layout.simple_list_item_1, parent, false);
         ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mTextView.setText(mDataset.get(position));
        switch (position){
            case 0:
                holder.mTextView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_menu_activities,0,0,0);
                break;
            case 1:
                holder.mTextView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_menu_postcards,0,0,0);
                break;
            case 2:
                holder.mTextView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_menu_places_to_see,0,0,0);
                break;
            case 3:
                holder.mTextView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_menu_tourist_traps,0,0,0);
                break;
            case 4:
                holder.mTextView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_menu_camera,0,0,0);
                break;
            case 5:
                holder.mTextView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_menu_travel,0,0,0);
                break;
        }


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
