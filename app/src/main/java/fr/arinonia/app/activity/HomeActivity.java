package fr.arinonia.app.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

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

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ConstraintLayout constraintLayout = this.findViewById(R.id.constraint_layout);
        constraintLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.scrollpane));



        LinearLayout layout = this.findViewById(R.id.linear_layout);

        for (int i = 0; i < 10; i++) {
            MaterialButton btn = new MaterialButton(this);

            btn.setText("Balise " + i);
            btn.setStrokeColor(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.orange)));
            btn.setBackgroundColor(ContextCompat.getColor(this, R.color.gray));
            btn.setCornerRadius(0);
            btn.setStrokeWidth(1);
            layout.addView(btn);


        }
    }
}