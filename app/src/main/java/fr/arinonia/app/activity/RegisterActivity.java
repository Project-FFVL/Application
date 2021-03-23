package fr.arinonia.app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import fr.arinonia.app.R;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_register);

        if (this.getSupportActionBar() != null) {
            this.getSupportActionBar().hide();
        }
        Window window = this.getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(Color.parseColor("#686868"));
            window.setNavigationBarColor(Color.parseColor("#1e1e1e"));
        }

        Button registerButton = this.findViewById(R.id.registerButton);
        registerButton.setOnClickListener(this::setupListener);
    }

    private void setupListener(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        this.startActivity(intent);
    }
}