package fr.arinonia.app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import fr.arinonia.app.R;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_register);
        
        if (this.getSupportActionBar() != null) {
            this.getSupportActionBar().hide();
        }
    }
}