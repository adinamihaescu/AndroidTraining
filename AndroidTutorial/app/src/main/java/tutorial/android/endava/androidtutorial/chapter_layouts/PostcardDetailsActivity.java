package tutorial.android.endava.androidtutorial.chapter_layouts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import tutorial.android.endava.androidtutorial.R;

/**
 * Created by amihaescu on 2/8/2016.
 */
public class PostcardDetailsActivity extends AppCompatActivity {

    private static final int RESULT_CODE_FOR_EDIT = 1;

    private TextView mPostcardTextView;
    private TextView mDestinationTextView;
    private TextView mDateTextView;
    private Button mEditBtn;

    private PostCard mPostcard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postcard_details);

        initViews();
        initData();
        displayData();
    }

    private void initViews() {
        mPostcardTextView = (TextView) findViewById(R.id.tv_postcard_text);
        mDestinationTextView = (TextView) findViewById(R.id.tv_postcard_destination);
        mDateTextView = (TextView) findViewById(R.id.tv_postcard_date);
        mEditBtn = (Button) findViewById(R.id.btn_edit);

        // make the TextView scrollable
        mPostcardTextView.setMovementMethod(new ScrollingMovementMethod());
        mEditBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent editPostcardIntent = new Intent(PostcardDetailsActivity.this, PostcardEditActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable(PostcardEditActivity.BUNDLE_POSTCARD_DATA, mPostcard);
                editPostcardIntent.putExtras(bundle);
                startActivityForResult(editPostcardIntent, RESULT_CODE_FOR_EDIT);
            }
        });
    }

    private void initData() {
        mPostcard = new PostCard();
        mPostcard.setDestination("Paris");
        mPostcard.setDate("11/11/2015");
        mPostcard.setText(getResources().getString(R.string.postcard_details_text));
    }

    /**
     * Display the date from Postcard object in the specific views
     */
    private void displayData() {
        //set the destination and the date of the postcard
        String destination = String.format(getResources().getString(R.string.postcard_details_destination), mPostcard.getDestination());
        mDestinationTextView.setText(destination);
        String date = String.format(getResources().getString(R.string.postcard_details_date), mPostcard.getDate());
        mDateTextView.setText(date);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case RESULT_CODE_FOR_EDIT:
                if (resultCode == RESULT_OK) {
                    mPostcard = (PostCard) data.getExtras().getSerializable(PostcardEditActivity.BUNDLE_POSTCARD_DATA);
                    displayData();
                }
                break;
        }
    }
}
