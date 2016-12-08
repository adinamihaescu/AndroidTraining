package tutorial.android.endava.androidtutorial.chapter_layouts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import tutorial.android.endava.androidtutorial.R;

/**
 * Created by amihaescu on 2/8/2016.
 */
public class PostcardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postcard);

        LinearLayout postcard1 = (LinearLayout) findViewById(R.id.postcard_item_1);
        postcard1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goodListChapterIntent = new Intent(PostcardActivity.this, PostcardDetailsActivity.class);
                startActivity(goodListChapterIntent);
            }
        });

    }
}
