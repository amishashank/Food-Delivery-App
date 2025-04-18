package com.andro.myfoodz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class OnBoardActivity extends AppCompatActivity {
Button onboard_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_on_board);
        onboard_button = findViewById(R.id.onboard_button);

        onboard_button.setOnClickListener(v -> {
            Intent intent = new Intent(OnBoardActivity.this, LoginActivity.class);
            Toast.makeText(OnBoardActivity.this, "Hello from OnBoardActivity", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        });
    }
}