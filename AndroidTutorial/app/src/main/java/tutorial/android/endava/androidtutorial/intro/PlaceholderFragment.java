package tutorial.android.endava.androidtutorial.intro;

/**
 * Created by radpopescu on 7/14/2016.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import tutorial.android.endava.androidtutorial.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_TITLE = "section_title";
    private static final String ARG_SECTION_IMAGE_LOGO = "section_image_logo";
    private static final String ARG_SECTION_MESSAGE = "section_message";

    public PlaceholderFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PlaceholderFragment newInstance(int imageResourceId, int titleResourceId, int messageResourceId) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_IMAGE_LOGO, imageResourceId);
        args.putInt(ARG_SECTION_TITLE, titleResourceId);
        args.putInt(ARG_SECTION_MESSAGE, messageResourceId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        ImageView imageViewTitle = (ImageView) rootView.findViewById(R.id.section_image_view);
        TextView textViewTitle = (TextView) rootView.findViewById(R.id.section_title);
        TextView textViewMessage = (TextView) rootView.findViewById(R.id.section_text);
        imageViewTitle.setImageResource(getArguments().getInt(ARG_SECTION_IMAGE_LOGO));
        textViewTitle.setText(getResources().getString(getArguments().getInt(ARG_SECTION_TITLE)));
        textViewMessage.setText(getResources().getString(getArguments().getInt(ARG_SECTION_MESSAGE)));
        return rootView;
    }

    public int getIndex() {
        int value = getArguments().getInt(ARG_SECTION_IMAGE_LOGO);
        switch (value) {
            case R.drawable.ic_slide_1:
                return 2;
            case R.drawable.ic_slide_2:
                return 1;
            case R.drawable.ic_slide_3:
                return 0;
        }
        return 0;
    }

}
