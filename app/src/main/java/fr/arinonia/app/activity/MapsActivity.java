package fr.arinonia.app.activity;

import androidx.fragment.app.FragmentActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.widget.Toast;

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
        Window window = this.getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(Color.parseColor("#686868"));
            window.setNavigationBarColor(Color.parseColor("#1e1e1e"));
        }


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
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
            this.startActivity(intent);
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
                    if (balise.isState()) {
                        this.runOnUiThread(() -> {
                            Marker mrk = balise.isState() ?  mMap.addMarker(new MarkerOptions().position(new LatLng(balise.getLatitude(), balise.getLongitude()))) : null;
                            assert mrk != null;
                            mrk.setTag(balise);
                        });
                    }
                }
            }
        } else {
           this.runOnUiThread(() ->  {
               AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
               alertDialogBuilder.setTitle("Erreur de chargement des balises");
               alertDialogBuilder
                       .setMessage("Verifiez votre connexion\nRessayer")
                       .setCancelable(false)
                       .setPositiveButton("Oui", (dialog, id) -> MapsActivity.this.finish())
                       .setNegativeButton("Non", (dialog, id) -> dialog.cancel());
               AlertDialog alertDialog = alertDialogBuilder.create();
               alertDialog.show();
           });
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
            this.runOnUiThread(() ->  {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                alertDialogBuilder.setTitle("Une erreur est survenue");
                alertDialogBuilder
                        .setMessage("Impossible de comuniquer avec " + e.getMessage())
                        .setCancelable(false)
                        .setPositiveButton("Oui", (dialog, id) -> MapsActivity.this.finish())
                        .setNegativeButton("Non", (dialog, id) -> dialog.cancel());
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            });
            e.printStackTrace();
        }
        return content.toString();
    }
}