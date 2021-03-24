package fr.arinonia.app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import java.io.IOException;

import fr.arinonia.app.R;
import fr.arinonia.app.RegisterUsername;
import fr.arinonia.app.components.UnderlineTextView;
import fr.arinonia.app.utils.Constants;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RegisterActivity extends AppCompatActivity {

    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    private final OkHttpClient client = new OkHttpClient();

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
        UnderlineTextView alwreadyHaveAccountText = this.findViewById(R.id.HaveAccountRegister);
        alwreadyHaveAccountText.setOnClickListener(this::setupListener);
    }

    @SuppressLint("NonConstantResourceId")
    private void setupListener(View view) {
        Intent homeIntent = new Intent(this, HomeActivity.class);
        Intent loginIntent = new Intent(this, LoginActivity.class);

        switch (view.getId()) {
            case R.id.registerButton :
                EditText usernameField = this.findViewById(R.id.nomRegister);
                EditText userFirstNameField = this.findViewById(R.id.prenomRegister);
                EditText emailField = this.findViewById(R.id.emailRegister);
                EditText passwordField = this.findViewById(R.id.passwordRegister);
                EditText passwordConfirmField = this.findViewById(R.id.confirmPasswordRegister);

                if (usernameField.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Merci d'entrer votre nom !", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (userFirstNameField.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Merci d'entrer votre prénom !", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (emailField.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Merci d'entrer votre email !", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (passwordField.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Merci d'entrer votre mot de passe !", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (passwordConfirmField.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Merci de confirmer votre mot de passe !", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!passwordField.getText().toString().equals(passwordConfirmField.getText().toString())) {
                    passwordField.setText("");
                    passwordConfirmField.setText("");
                    Toast.makeText(this, "Les deux mots de passe ne sont pas identique !", Toast.LENGTH_SHORT).show();
                    return;
                }
                String json = "{\"username\": \"thibaud\"}";
                new Thread(() -> {
                    try {
                        this.post(Constants.API_URL, json);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();

                this.startActivity(homeIntent);
                break;
            case R.id.HaveAccountRegister :
                this.startActivity(loginIntent);
                break;
        }

    }

    @Deprecated
    String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

}