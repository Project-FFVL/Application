package fr.arinonia.app.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import fr.arinonia.app.R;

public class HomeActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_home);

        if (this.getSupportActionBar() != null) {
            this.getSupportActionBar().hide();
        }

        Window window = this.getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(Color.parseColor("#686868"));
            window.setNavigationBarColor(Color.parseColor("#1e1e1e"));
        }

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ConstraintLayout constraintLayout = this.findViewById(R.id.constraint_layout);
        constraintLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.scrollpane));


        LinearLayout layout = this.findViewById(R.id.linear_layout);
        ScrollView scrollView = this.findViewById(R.id.scrollbar);

        scrollView.setSmoothScrollingEnabled(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            scrollView.setBottomEdgeEffectColor(Color.parseColor("#1e1e1e"));
            scrollView.setTopEdgeEffectColor(Color.parseColor("#1e1e1e"));
        }
        for (int i = 0; i < 10; i++) {
            MaterialButton btn = new MaterialButton(this);
            btn.setText("Balise " + i);
            btn.setStrokeColor(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.orange)));
            btn.setBackgroundColor(ContextCompat.getColor(this, R.color.gray));
            btn.setCornerRadius(0);
            btn.setStrokeWidth(1);
            btn.setOnClickListener(e -> {
                Toast.makeText(HomeActivity.this,"Display Balise", Toast.LENGTH_LONG).show();
            });
            layout.addView(btn);
        }

        MaterialButton otherBaliseBtn = this.findViewById(R.id.otherBaliseBtn);
        otherBaliseBtn.setOnClickListener(e -> {
            Intent intent = new Intent(this, MapsActivity.class);
            this.startActivity(intent);
        });
    }


    @Override
    public void onBackPressed() {}
}