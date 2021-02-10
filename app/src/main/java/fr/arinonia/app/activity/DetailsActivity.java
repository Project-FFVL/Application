package fr.arinonia.app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;

import fr.arinonia.app.R;

public class DetailsActivity extends AppCompatActivity {

    private int id;
    private int pressiure;
    private int wind_speed;
    private int wind_direction;
    private int wind_min;
    private int wind_max;
    private int temperature;
    private int hygrometry;

    public DetailsActivity() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity);

        if (this.getSupportActionBar() != null) {
            this.getSupportActionBar().hide();
        }

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Bundle bundle = this.getIntent().getExtras();
        this.id = bundle.getInt("id");
        this.pressiure = bundle.getInt("pressiure");
        this.wind_speed = bundle.getInt("wind_speed");
        this.wind_direction = bundle.getInt("wind_direction");
        this.wind_min = bundle.getInt("wind_min");
        this.wind_max = bundle.getInt("wind_max");
        this.temperature = bundle.getInt("temperature");
        this.hygrometry = bundle.getInt("hygrometry");

        System.out.println(this.toString());



    }

    public int getId() {
        return id;
    }

    public int getPressiure() {
        return pressiure;
    }

    public int getWind_speed() {
        return wind_speed;
    }

    public int getWind_direction() {
        return wind_direction;
    }

    public int getWind_min() {
        return wind_min;
    }

    public int getWind_max() {
        return wind_max;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getHygrometry() {
        return hygrometry;
    }

    @Override
    public String toString() {
        return "DetailsActivity{" +
                "id=" + id +
                ", pressiure=" + pressiure +
                ", wind_speed=" + wind_speed +
                ", wind_direction=" + wind_direction +
                ", wind_min=" + wind_min +
                ", wind_max=" + wind_max +
                ", temperature=" + temperature +
                ", hygrometry=" + hygrometry +
                '}';
    }
}