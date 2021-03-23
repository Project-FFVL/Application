package fr.arinonia.app.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import fr.arinonia.app.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_login);

        if (this.getSupportActionBar() != null) {
            this.getSupportActionBar().hide();
        }

        Window window = this.getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(Color.parseColor("#686868"));
            window.setNavigationBarColor(Color.parseColor("#1e1e1e"));
        }

        TextView createAccount = (TextView)findViewById(R.id.createAccount);
        createAccount.setOnClickListener(this::setupListeners);

    }

    @SuppressLint("NonConstantResourceId")
    private void setupListeners(View view) {
        Intent registerIntent = new Intent(this, RegisterActivity.class);
        Intent homeIntent = new Intent(this, RegisterActivity.class);

        switch (view.getId()) {
            case R.id.createAccount :
                this.startActivity(registerIntent);
                break;

            case R.id.forgotPassword :

                break;

            case R.id.button :
                EditText emailField = this.findViewById(R.id.inputEmail);
                EditText passwordField = this.findViewById(R.id.inputPassword);

                if (emailField.getText().toString().isEmpty()) {
                    System.out.println("pas bo");
                }
                System.out.println(emailField.getText().toString());
                this.startActivity(homeIntent);
                break;
        }
    }
    @Override
    public void onBackPressed() {}
}