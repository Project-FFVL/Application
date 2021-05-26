package fr.arinonia.app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import fr.arinonia.app.R;
import fr.arinonia.app.balise.Balise;
import fr.arinonia.app.balise.WindSpeed;
import fr.arinonia.app.utils.Constants;
import fr.arinonia.app.utils.IJsonReadable;



public class DetailsActivity extends AppCompatActivity implements IJsonReadable {

    private static final Gson JSON = new Gson();
    private LineChart chart;
    private int id;

    public DetailsActivity() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.details_activity);

        if (this.getSupportActionBar() != null) {
            this.getSupportActionBar().hide();
        }

        Window window = this.getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(Color.parseColor("#686868"));
            window.setNavigationBarColor(Color.parseColor("#1e1e1e"));
        }


        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Bundle bundle = this.getIntent().getExtras();
        this.id = bundle.getInt("id");
        new Thread() {
            @Override
            public void run() {
                jsonDeserialize();
            }
        }.start();

    }


    @SuppressLint("SetTextI18n")
    @Override
    public void jsonDeserialize() {
        Balise balise = JSON.fromJson(this.getUrlContents(Constants.getBaliseUrlById(this.id)), Balise.class);
        ImageView imageView = (ImageView) findViewById(R.id.favbtn);
        TextView pressionAtmospherique = (TextView) findViewById(R.id.pression_atmospherique);
        TextView temperature = (TextView) findViewById(R.id.temperature);
        TextView hygrometrie = (TextView) findViewById(R.id.hygrometrie);
        TextView vitesse_vent = (TextView) findViewById(R.id.vitesse_vent);
        TextView vent_minimum = (TextView) findViewById(R.id.vent_minimum);
        TextView vent_maximum = (TextView) findViewById(R.id.vent_maximum);
        this.chart = (LineChart) findViewById(R.id.chart);



        this.runOnUiThread(() -> {
            imageView.getLayoutParams().height = 200;
            imageView.getLayoutParams().width = 200;
            imageView.requestLayout();
            pressionAtmospherique.setText(balise.getPression_atmospherique() + " hPa");
            temperature.setText(balise.getTemperature() + " °C");
            hygrometrie.setText(balise.getHygrometrie() + " g/m³");
            vitesse_vent.setText("Vitesse du vent " + balise.getVitesse_vent() + " km/s");
            vent_minimum.setText("Vitesse du vent minimum " + balise.getVent_minimum() + " km/s");
            vent_maximum.setText("Vitesse du vent maximum " + balise.getVent_maximum() + " km/s");
            //TODO DIAGRAMME
            List<Entry> entries = new ArrayList<>();
            chart.getDescription().setEnabled(false);
            chart.setDrawGridBackground(false);
            chart.setBackgroundColor(Color.DKGRAY);



            XAxis xAxis = chart.getXAxis();
            xAxis.setPosition(XAxis.XAxisPosition.BOTTOM_INSIDE);
            xAxis.setTextSize(10f);
            xAxis.setTextColor(Color.WHITE);
            xAxis.setDrawAxisLine(false);
            xAxis.setDrawGridLines(true);
            xAxis.setTextColor(Color.rgb(255, 192, 56));
            xAxis.setCenterAxisLabels(true);
            xAxis.setGranularity(1f);
            xAxis.setValueFormatter(new ValueFormatter() {

                private final SimpleDateFormat mFormat = new SimpleDateFormat("HH:mm", Locale.ENGLISH);

                @Override
                public String getFormattedValue(float value) {

                    long millis = TimeUnit.HOURS.toMillis((long) value);
                    return mFormat.format(new Date(millis));
                }
            });

            YAxis leftAxis = chart.getAxisLeft();
            leftAxis.setPosition(YAxis.YAxisLabelPosition.INSIDE_CHART);
            leftAxis.setTextColor(ColorTemplate.getHoloBlue());
            leftAxis.setDrawGridLines(true);
            leftAxis.setGranularityEnabled(true);
            leftAxis.setAxisMinimum(0f);
            leftAxis.setYOffset(-9f);
            leftAxis.setTextColor(Color.rgb(255, 192, 56));

            this.setData(10, 50);
            YAxis rightAxis = chart.getAxisRight();
            rightAxis.setEnabled(false);
            chart.invalidate();
        });

    }

    private void setData(int count, float range) {

        // now in hours
        long now = TimeUnit.MILLISECONDS.toHours(System.currentTimeMillis());

        ArrayList<Entry> values = new ArrayList<>();

        // count = hours
        float to = now + count;

        // increment by 1 hour
        for (float x = now; x < to; x++) {

            float y = getRandom(range, 50);
            values.add(new Entry(x, y)); // add one entry per hour
        }

        // create a dataset and give it a type
        LineDataSet set1 = new LineDataSet(values, "Vitesse du vent en Km/H");
        set1.setAxisDependency(YAxis.AxisDependency.LEFT);
        set1.setColor(ColorTemplate.getHoloBlue());
        set1.setValueTextColor(ColorTemplate.getHoloBlue());
        set1.setLineWidth(1.5f);
        set1.setDrawCircles(false);
        set1.setDrawValues(false);
        set1.setFillAlpha(65);
        set1.setFillColor(ColorTemplate.getHoloBlue());
        set1.setHighLightColor(Color.rgb(244, 117, 117));
        set1.setDrawCircleHole(false);

        // create a data object with the data sets
        LineData data = new LineData(set1);
        data.setValueTextColor(Color.WHITE);
        data.setValueTextSize(9f);

        // set data
        chart.setData(data);
    }
    protected float getRandom(float range, float start) {
        return (float) (Math.random() * range) + start;
    }

    /**
     * get content of web page from url
     * @param theUrl String
     * @return String : content of web page
     */
    @Override
    public String getUrlContents(String theUrl) {
        StringBuilder content = new StringBuilder();

        try {
            URL url = new URL(theUrl);
            System.out.println(url);
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