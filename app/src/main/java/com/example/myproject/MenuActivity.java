package com.example.myproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    String difficulty;
    String skinX;
    String skinO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button startButton = findViewById(R.id.startButton);
        Button goToDifficultyButton = findViewById(R.id.buttonDifficultyGo);

        Button goToSkinsButton = findViewById(R.id.buttonSkinGo);

        Intent intentGame = getIntent();
        difficulty = intentGame.getStringExtra("difficulty");
        skinX = intentGame.getStringExtra("skinX");
        skinO = intentGame.getStringExtra("skinO");

        if (difficulty == null) {
            difficulty = "two players";
        }
        if (skinX == null) {
            skinX = "0";
        }
        if (skinO == null) {
            skinO = "0";
        }

        startButton.setOnClickListener(view -> {
            Intent intentMenu = new Intent(MenuActivity.this, GameActivity.class);

            intentMenu.putExtra("difficulty", difficulty);
            intentMenu.putExtra("skinX", skinX);
            intentMenu.putExtra("skinO", skinO);

            startActivity(intentMenu);
        });

        goToSkinsButton.setOnClickListener(view -> {
            Intent intentMenu = new Intent(MenuActivity.this, SkinsActivity.class);

            intentMenu.putExtra("difficulty", difficulty);
            intentMenu.putExtra("skinX", skinX);
            intentMenu.putExtra("skinO", skinO);

            startActivity(intentMenu);
        });

        goToDifficultyButton.setOnClickListener(view -> {
            Intent intentMenu = new Intent(MenuActivity.this, DifficultyActivity.class);

            intentMenu.putExtra("difficulty", difficulty);
            intentMenu.putExtra("skinX", skinX);
            intentMenu.putExtra("skinO", skinO);

            startActivity(intentMenu);
        });
    }
}