package fr.arinonia.app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import fr.arinonia.app.R;
import fr.arinonia.app.utils.Constants;

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

        TextView createAccount = (TextView) findViewById(R.id.createAccount);
        createAccount.setOnClickListener(this::setupListeners);
        Button buttonLogin = this.findViewById(R.id.button);
        buttonLogin.setOnClickListener(this::setupListeners);
        TextView forgotPassword = (TextView) findViewById(R.id.forgotPassword);
        forgotPassword.setOnClickListener(this::setupListeners);
    }

    @SuppressLint("NonConstantResourceId")
    private void setupListeners(View view) {
        Intent registerIntent = new Intent(this, RegisterActivity.class);
        Intent homeIntent = new Intent(this, HomeActivity.class);

        switch (view.getId()) {
            case R.id.createAccount:
                this.startActivity(registerIntent);
                break;

            case R.id.forgotPassword:

                break;

            case R.id.button:
                EditText emailField = this.findViewById(R.id.inputEmail);
                EditText passwordField = this.findViewById(R.id.inputPassword);

                if (emailField.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Merci d'entrer un email !", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (passwordField.getText().toString().isEmpty()) {
                    //Toast.makeText(this, "Merci d'entrer un mot de passe !", Toast.LENGTH_SHORT).show();
                    new AlertDialog.Builder(this)
                            .setTitle("Erreur de connexion")
                            .setMessage("Veuillez entrer un mot de passe !")
                            .setPositiveButton("Pardon:c", (dialog, which) -> {

                            })
                            .setIcon(android.R.drawable.stat_notify_error)
                            .show();
                    return;
                }
                System.out.println(emailField.getText().toString());
                this.startActivity(homeIntent);
                break;
        }
    }

    @Override
    public void onBackPressed() {}
}