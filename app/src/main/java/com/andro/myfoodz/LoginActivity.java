package com.andro.myfoodz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {
Button loginbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);


        loginbutton = findViewById(R.id.login_button);
        loginbutton.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, LocationActivity.class);
            Toast.makeText(this, "Hello from Login Button", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        });

    }
}