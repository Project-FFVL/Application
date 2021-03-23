package fr.arinonia.app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
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

        TextView createAccount = (TextView)findViewById(R.id.createAccount);
        createAccount.setOnClickListener(this::setupListeners);

    }

    private void setupListeners(View view) {
        switch (view.getId()) {
            case R.id.createAccount:
                Intent registerIntent = new Intent(this, RegisterActivity.class);
                this.startActivity(registerIntent);
                break;
        }
    }
    /*private void onCreateAccountClicked(View view) {
        if (view.getId() == R.id.createAccount) {

        }
        Toast.makeText(LoginActivity.this,"Tu as cliqué sur créer un compte", Toast.LENGTH_LONG).show();

    }*/
    @Override
    public void onBackPressed() {
        Toast.makeText(LoginActivity.this,"There is no back action",Toast.LENGTH_LONG).show();
    }
}