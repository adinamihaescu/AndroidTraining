package tutorial.android.endava.androidtutorial.chapter_activties;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import tutorial.android.endava.androidtutorial.R;

/**
 * Created by radpopescu on 7/15/2016.
 */
public class ActivitiesActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = ActivitiesActivity.class.getSimpleName();
    public static final String BUNDLE_DATA = "bundle_data";
    private ImageView mCreateView;
    private ImageView mStartView;
    private ImageView mResumeView;
    private ImageView mPauseView;
    private ImageView mStopView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activities);
        initViews();
        showLogs("onCreate");
        mCreateView.setVisibility(View.VISIBLE);

    }

    @Override
    protected void onStart() {
        super.onStart();
        showLogs("onStart");
        mStartView.setVisibility(View.VISIBLE);


    }

    @Override
    protected void onResume() {
        super.onResume();
        showLogs("onResume");
        mResumeView.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onPause() {
        super.onPause();
        showLogs("onPause");
        showToast(getString(R.string.pause_activity_toast));
        mPauseView.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        showLogs("onStop");
        mStopView.setVisibility(View.VISIBLE);
        showToast(getString(R.string.stop_activity_toast));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        showLogs("onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        showLogs("onRestart");
    }

    private void showLogs(String action) {
        Log.i(TAG, action);
    }

    private void initViews() {
        mCreateView = (ImageView) findViewById(R.id.create_view);
        mResumeView = (ImageView) findViewById(R.id.resume_view);
        mStartView = (ImageView) findViewById(R.id.start_view);
        mPauseView = (ImageView) findViewById(R.id.pause_view);
        mStopView = (ImageView) findViewById(R.id.stop_view);
        findViewById(R.id.stop_activity_button).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.stop_activity_button:
                startPauseActivity();
                break;
        }
    }

    private void startPauseActivity() {
        Intent intent = new Intent(this, PauseActivity.class);
        intent.putExtra(BUNDLE_DATA, getResources().getString(R.string.stop_activity_message));
        startActivity(intent);
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }


}
