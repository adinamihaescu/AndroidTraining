package tutorial.android.endava.androidtutorial.chapter_layouts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import tutorial.android.endava.androidtutorial.R;

/**
 * Created by amihaescu on 2/8/2016.
 */
public class PostcardEditActivity extends AppCompatActivity {

    public static final String BUNDLE_POSTCARD_DATA = "postcard_data";

    private TextView mPostcardTextView;
    private TextView mDestinationTextView;
    private TextView mDateTextView;
    private Button mSaveBtn;

    private PostCard mPostcard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postcard_edit);

        initViews();
        initData();
        displayData();
    }

    private void initData() {
        if (getIntent() != null && getIntent().getExtras() != null) {
            mPostcard = (PostCard) getIntent().getExtras().getSerializable(BUNDLE_POSTCARD_DATA);
        } else {
            mPostcard = new PostCard();
        }
    }

    private void displayData() {
        mPostcardTextView.setText(mPostcard.getText());
        mDateTextView.setText(mPostcard.getDate());
        mDestinationTextView.setText(mPostcard.getDestination());
    }

    private void initViews() {
        mPostcardTextView = (TextView) findViewById(R.id.et_postcard_text);
        mDestinationTextView = (TextView) findViewById(R.id.et_postcard_destination);
        mDateTextView = (TextView) findViewById(R.id.et_postcard_date);
        mSaveBtn = (Button) findViewById(R.id.btn_save);

        mSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });
    }

    private void saveData() {
        if (mDateTextView.getText().toString().isEmpty() || mDestinationTextView.getText().toString().isEmpty() || mPostcardTextView.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.postcard_validation_message), Toast.LENGTH_LONG).show();
            return;
        }

        mPostcard.setDate(mDateTextView.getText().toString());
        mPostcard.setDestination(mDestinationTextView.getText().toString());
        mPostcard.setText(mPostcardTextView.getText().toString());

        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putSerializable(BUNDLE_POSTCARD_DATA, mPostcard);
        intent.putExtras(bundle);
        setResult(RESULT_OK, intent);
        finish();
    }
}
