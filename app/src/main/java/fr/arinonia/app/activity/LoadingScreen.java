package fr.arinonia.app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import fr.arinonia.app.R;


public class LoadingScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);

        if (this.getSupportActionBar() != null) {
            this.getSupportActionBar().hide();
        }
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

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


    @Override
    public void onBackPressed() {
        Toast.makeText(LoadingScreen.this,"There is no back action",Toast.LENGTH_LONG).show();
        return;
    }
}
