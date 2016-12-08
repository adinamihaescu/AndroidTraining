package tutorial.android.endava.androidtutorial.chapter_photography;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

import tutorial.android.endava.androidtutorial.R;

/**
 * Created by radpopescu on 8/2/2016.
 */
public class PhotographyActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = PhotographyActivity.class.getSimpleName();
    private static final int RESULT_CODE_TAKE_PHOTO = 10;
    public static final String ANDROID_TUTORIAL_DIR_NAME = "AndroidTutorial";
    private static final int REQUEST_STORAGE_AND_CAMERA = 1;
    private static final String[] PERMISSIONS_CAMERA_AND_STORAGE = {
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA
    };

    private File mPhotoFile;
    private ImageView mCapturedImageView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photography);
        initViews();
        checkPermissions();
    }

    private void initViews() {
        mCapturedImageView = (ImageView) findViewById(R.id.image_container);
        findViewById(R.id.take_picture_image_button).setOnClickListener(this);
    }

    private void checkPermissions() {
        boolean writePermission = hasPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        boolean cameraPermission = hasPermission(this, Manifest.permission.CAMERA);
    if (!writePermission || !cameraPermission) {
        requestPermissions(this, PERMISSIONS_CAMERA_AND_STORAGE, REQUEST_STORAGE_AND_CAMERA);
    }
}


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {

            case RESULT_CODE_TAKE_PHOTO:
                if (resultCode == RESULT_OK) {
                    loadScaleDownImageToView(mCapturedImageView, mPhotoFile.getAbsolutePath());
                }
                break;


        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.take_picture_image_button:
                if (hasCameraPermission(this)) {
                    dispatchTakePictureIntent();
                } else {
                    Toast.makeText(this, R.string.toast_permission_denied, Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }


    private static boolean hasPermission(Activity activity, String permission) {
        return ActivityCompat.checkSelfPermission(activity, permission) == PackageManager.PERMISSION_GRANTED;
    }

    public static boolean hasCameraPermission(Activity activity) {
        return hasPermission(activity, Manifest.permission.CAMERA) &&
                hasPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);
    }

    private void dispatchTakePictureIntent() {
        try {
            if (mPhotoFile == null) {
                mPhotoFile = createImageFile(this);
            }
        } catch (IOException ex) {
            Log.d(TAG, "Error creating image file: " + ex.getMessage());
        }
        if (mPhotoFile != null) {
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(mPhotoFile));
            startActivityForResult(takePictureIntent, RESULT_CODE_TAKE_PHOTO);
        } else {
            Toast.makeText(this, getString(R.string.error_creating_file), Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Helper method that creates local file to store the customer image
     *
     * @return file where to save the photo
     * @throws IOException
     */
    public static File createImageFile(Context context) throws IOException {
        String imageFileName = "tutorial";
        // Save a file: path for use with ACTION_VIEW intents
        // String path = "file:" + image.getAbsolutePath();
        return File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                getProjectDir(context) /* directory */
        );
    }

    /**
     * Helper method to create the directory in which files will be stored
     *
     * @param context context object
     */
    public static File getProjectDir(Context context) {
        // Create an image file name
        File storageDir = context.getExternalFilesDir(ANDROID_TUTORIAL_DIR_NAME);
        if (!storageDir.exists()) {
            storageDir.mkdirs();
        }
        return storageDir;
    }

    /**
     * Helper method that scales down image and loads it in the ImageView
     *
     * @param imageView container View in which to load an image
     * @param filePath: location of the image on the disk
     */
    public static void loadScaleDownImageToView(ImageView imageView, String filePath) {
        // Get the dimensions of the View
        int targetW = imageView.getWidth();
        int targetH = imageView.getHeight();

        Bitmap newBitmap = bitmapCompressAndScaleDown(filePath, targetW, targetH);
        imageView.setImageBitmap(newBitmap);
    }

    /**
     * Compress the picture and also scale it down to a target width and height
     *
     * @param filePath     The file to modify
     * @param targetWidth
     * @param targetHeight
     */
    public static Bitmap bitmapCompressAndScaleDown(String filePath, int targetWidth, int targetHeight) {
        // Get the dimensions of the bitmap
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        bmOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filePath, bmOptions);
        int photoW = bmOptions.outWidth;
        int photoH = bmOptions.outHeight;

        targetWidth = Math.min(targetWidth, photoW);
        targetHeight = Math.min(targetHeight, photoH);

        // Determine how much to scale down the image
        int scaleFactor = Math.min(photoW / targetWidth, photoH / targetHeight);
        // Decode the image file into a Bitmap sized to fill the View
        bmOptions.inJustDecodeBounds = false;
        bmOptions.inSampleSize = scaleFactor;

        Bitmap bitmap = BitmapFactory.decodeFile(filePath, bmOptions);
        Matrix matrix = new Matrix();
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    private static void requestPermissions(Activity activity, String[] permissions, int callback) {
        ActivityCompat.requestPermissions(
                activity,
                permissions,
                callback
        );
    }


}
