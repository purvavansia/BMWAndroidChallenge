package com.example.purva.bmwandroidchallenge;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    double mylat, mylong;
    String time, address, name;
    TextView  tvname, tvtime, tvaddr, tvlong, tvlat, tvtitle;
    MapView mapView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        mapView = findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        tvaddr = findViewById(R.id.address);
        tvlat = findViewById(R.id.Latitude);
        tvlong = findViewById(R.id.Longitude);
        tvname = findViewById(R.id.name);
        tvtime = findViewById(R.id.arrivalTime);
        tvtitle = findViewById(R.id.title);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

        mapView.getMapAsync(this);
        Bundle receive = getIntent().getExtras().getBundle("location");
        mylat = receive.getDouble("latitude");
        mylong = receive.getDouble("longitude");
        time = receive.getString("time");
        address = receive.getString("address");
        name = receive.getString("name");

        setTitle(name);

        tvtime.setText("Arrival time: "+time);
        tvname.setText("Name: "+name);
        tvlong.setText("Longitude: "+mylong);
        tvlat.setText("Latitude: "+mylat);
        tvaddr.setText("Address: "+address);
        tvtitle.setText(name);
        Toast.makeText(this,""+mylat+" "+mylong,Toast.LENGTH_SHORT).show();
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
        LatLng current = new LatLng(mylat, mylong);
        mMap.addMarker(new MarkerOptions().position(current).title("Marker in United States"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(current));
    }
}
