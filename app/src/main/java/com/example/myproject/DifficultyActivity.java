package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class DifficultyActivity extends AppCompatActivity {

    String difficulty;
    String skinX;
    String skinO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty);

        Intent intentGame = getIntent();
        difficulty = intentGame.getStringExtra("difficulty");
        skinX = intentGame.getStringExtra("skinX");
        skinO = intentGame.getStringExtra("skinO");
        Button twoPlayerButton = findViewById(R.id.buttonTwoPlayers);
        Button easyButton = findViewById(R.id.buttonEasy);
        Button hardButton = findViewById(R.id.buttonHard);
        Button backButton = findViewById(R.id.backButton2);

        twoPlayerButton.setOnClickListener(view -> {
            easyButton.setEnabled(true);
            hardButton.setEnabled(true);
            twoPlayerButton.setEnabled(false);
            difficulty = "two players";
        });

        easyButton.setOnClickListener(view -> {
            twoPlayerButton.setEnabled(true);
            hardButton.setEnabled(true);
            easyButton.setEnabled(false);
            difficulty = "easy";
        });

        hardButton.setOnClickListener(view -> {
            easyButton.setEnabled(true);
            twoPlayerButton.setEnabled(true);
            hardButton.setEnabled(false);
            difficulty = "hard";
        });

        if (difficulty.equals("easy")) {
            twoPlayerButton.setEnabled(true);
            hardButton.setEnabled(true);
            easyButton.setEnabled(false);
        }

        else if (difficulty.equals("hard")) {
            easyButton.setEnabled(true);
            twoPlayerButton.setEnabled(true);
            hardButton.setEnabled(false);
        }

        backButton.setOnClickListener(view -> {
            Intent intentDifficulty = new Intent(DifficultyActivity.this, MenuActivity.class);

            intentDifficulty.putExtra("difficulty", difficulty);
            intentDifficulty.putExtra("skinX", skinX);
            intentDifficulty.putExtra("skinO", skinO);

            startActivity(intentDifficulty);
        });
    }
}