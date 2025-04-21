package com.andro.myfoodz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LocationActivity extends AppCompatActivity {
    AutoCompleteTextView location_menu;
    Button location_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_location);

        // Initialize views
        location_menu = findViewById(R.id.location_menu);
        location_button = findViewById(R.id.location_button);

        // Set up the dropdown menu
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.city, // res/values/strings.xml
                android.R.layout.simple_dropdown_item_1line
        );
        location_menu.setAdapter(adapter);

        // Handle button click
        location_button.setOnClickListener(view -> {
            String selectedLocation = location_menu.getText().toString();
            if (selectedLocation.isEmpty()) {
                Toast.makeText(this, "Please select a location", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Selected: " + selectedLocation, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LocationActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}