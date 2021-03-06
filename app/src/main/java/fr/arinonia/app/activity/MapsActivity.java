package fr.arinonia.app.activity;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import fr.arinonia.app.R;
import fr.arinonia.app.balise.Balise;
import fr.arinonia.app.balise.Data;
import fr.arinonia.app.utils.Constants;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private static final Gson JSON = new Gson();

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

        this.mMap.setOnMarkerClickListener(e -> {
            Balise balise = (Balise)e.getTag();

            Intent intent = new Intent(this, DetailsActivity.class);
            assert balise != null;
            intent.putExtra("id", balise.getId());
            intent.putExtra("pressiure", balise.getPressiure());
            intent.putExtra("wind_speed", balise.getWind_speed());
            intent.putExtra("wind_direction", balise.getWind_direction());
            intent.putExtra("wind_min", balise.getWind_min());
            intent.putExtra("wind_max", balise.getWind_max());
            intent.putExtra("temperature", balise.getTemperature());
            intent.putExtra("hygrometry", balise.getHygrometry());



            startActivity(intent);
            return false;
        });
        this.mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(49.43760170457457, 1.095723344298659)));
        this.mMap.setMinZoomPreference(6.55f);

        new Thread() {
            @Override
            public void run() {
                jsonDeserialize();
            }
        }.start();
    }


    /**
     * add all markers from balises in the json
     */
    private void jsonDeserialize() {
        Data data = JSON.fromJson(this.getUrlContents(Constants.API_URL), Data.class);

        if (data != null) {
            for (Balise balise : data.getBalises()) {
                if (balise != null) {
                    this.runOnUiThread(() -> {
                        Marker mrk = balise.isState() ?  mMap.addMarker(new MarkerOptions().position(new LatLng(balise.getLatitude(), balise.getLongitude()))) : null;
                        assert mrk != null;
                        mrk.setTag(balise);
                    });
                }
            }
        }
    }

    /**
     * get content of web page from url
     * @param theUrl String
     * @return String : content of web page
     */
    private String getUrlContents(String theUrl) {
        StringBuilder content = new StringBuilder();

        try {
            URL url = new URL(theUrl);
            URLConnection urlConnection = url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                content.append(line).append("\n");
            }
            bufferedReader.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return content.toString();
    }
}