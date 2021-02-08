package fr.arinonia.app.activity;

import androidx.fragment.app.FragmentActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import fr.arinonia.app.R;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.mMap = googleMap;

        mMap.addMarker(new MarkerOptions().position(new LatLng(49.43760170457457, 1.095723344298659)).title("<3 <3 <3 <3"));
        this.mMap.setOnMarkerClickListener(e -> {

            AlertDialog.Builder popup = new AlertDialog.Builder(this);
            popup.setTitle("wesh");
            popup.setMessage("salut mon reuf");
            popup.setPositiveButton("Yes", (dialog, which) -> Toast.makeText(getApplicationContext(), "tu as cliqué sur oui", Toast.LENGTH_SHORT));
            popup.setNegativeButton("non", (dialog, which) -> Toast.makeText(getApplicationContext(), "tu as cliqué sur non", Toast.LENGTH_SHORT));
            popup.show();
            return false;
        });
        this.mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(49.43760170457457, 1.095723344298659)));
        this.mMap.setMinZoomPreference(6.55f);
    }
}