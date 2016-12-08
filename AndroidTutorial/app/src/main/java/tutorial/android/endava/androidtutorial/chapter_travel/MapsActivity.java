package tutorial.android.endava.androidtutorial.chapter_travel;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import tutorial.android.endava.androidtutorial.R;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, View.OnClickListener {

    private GoogleMap mMap;
    private int mMapType = GoogleMap.MAP_TYPE_TERRAIN;
    private EditText mLatitudeEditText;
    private EditText mLongitudeEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        initViews();

    }

    private void initViews() {
        mLatitudeEditText = (EditText) findViewById(R.id.latitude_edit_text);
        mLongitudeEditText = (EditText) findViewById(R.id.longitude_edit_text);
        findViewById(R.id.change_terrain).setOnClickListener(this);
        findViewById(R.id.add_marker_button).setOnClickListener(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.change_terrain:
                switch (mMapType) {
                    case GoogleMap.MAP_TYPE_TERRAIN:
                        mMapType = GoogleMap.MAP_TYPE_SATELLITE;
                        break;
                    case GoogleMap.MAP_TYPE_SATELLITE:
                        mMapType = GoogleMap.MAP_TYPE_NORMAL;
                        break;
                    case GoogleMap.MAP_TYPE_NORMAL:
                        mMapType = GoogleMap.MAP_TYPE_TERRAIN;
                        break;
                }
                mMap.setMapType(mMapType);
                break;
            case R.id.add_marker_button:
                double latitude = Double.valueOf(mLatitudeEditText.getText().toString());
                double longitude = Double.valueOf(mLongitudeEditText.getText().toString());
                mMap.addMarker(new MarkerOptions().position(new LatLng(latitude, longitude)).title(getString(R.string.my_marker)));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(latitude, longitude)));
                break;
        }
    }
}
