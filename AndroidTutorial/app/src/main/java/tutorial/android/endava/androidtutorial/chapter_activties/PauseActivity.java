package tutorial.android.endava.androidtutorial.chapter_activties;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import tutorial.android.endava.androidtutorial.R;

/**
 * Created by radpopescu on 7/26/2016.
 */
public class PauseActivity extends AppCompatActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pause);
        mTextView = (TextView) findViewById(R.id.text_view);
        retrieveData();
    }

    private void retrieveData() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String data = bundle.getString(ActivitiesActivity.BUNDLE_DATA);
            mTextView.setText(data);
        }
    }

}
