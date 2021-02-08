package fr.arinonia.app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.WindowManager;

import fr.arinonia.app.Application;
import fr.arinonia.app.R;
import fr.arinonia.app.activity.MapsActivity;


public class LoadingScreen extends AppCompatActivity {


    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);

        if (this.getSupportActionBar() != null) {
            this.getSupportActionBar().hide();
        }

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Intent myIntent = new Intent(this, HomeActivity.class);


        new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                System.out.println("tick " + millisUntilFinished);
            }

            @Override
            public void onFinish() {
                startActivity(myIntent);
            }
        }.start();

    }
}
