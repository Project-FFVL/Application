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

    private final boolean DEV_ENV = true;
    private boolean isLogin = false;
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
        Intent loginIntent = new Intent(this, LoginActivity.class);
        Intent homeIntent = new Intent(this, HomeActivity.class);

        /*  TODO
            ping google maps API
            ping FFVL API
            if some api doesn't reply, display an error message
            check if user is login
            if is login, go to HomePanel
            if is not login, go to LoginPanel
         */
        new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                System.out.println("tick " + millisUntilFinished);
            }

            @Override
            public void onFinish() {
                startActivity(isLogin ? homeIntent : loginIntent);
            }
        }.start();
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(LoadingScreen.this,"There is no back action",Toast.LENGTH_LONG).show();
    }
}
