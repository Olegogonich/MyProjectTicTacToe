package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.LinkedList;

public class SkinsActivity extends AppCompatActivity {

    LinkedList<ImageButton> skinXButtons;
    LinkedList<ImageButton> skinOButtons;

    String skinO;
    String skinX;
    String difficulty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skins);

        Intent intentMenu = getIntent();
        skinX = intentMenu.getStringExtra("skinX");
        skinO = intentMenu.getStringExtra("skinO");
        difficulty = intentMenu.getStringExtra("difficulty");

        skinXButtons = new LinkedList<>();
        skinXButtons.add(findViewById(R.id.imageButton0));
        skinXButtons.add(findViewById(R.id.imageButton1));
        skinXButtons.add(findViewById(R.id.imageButton2));
        skinXButtons.add(findViewById(R.id.imageButton3));
        skinXButtons.add(findViewById(R.id.imageButton4));
        skinXButtons.add(findViewById(R.id.imageButton5));

        ImageButton pressedX = skinXButtons.get(Integer.parseInt(skinX));
        pressedX.setClickable(false);
        pressedX.setSelected(true);

        skinOButtons = new LinkedList<>();
        skinOButtons.add(findViewById(R.id.imageButton6));
        skinOButtons.add(findViewById(R.id.imageButton7));
        skinOButtons.add(findViewById(R.id.imageButton8));
        skinOButtons.add(findViewById(R.id.imageButton9));
        skinOButtons.add(findViewById(R.id.imageButton10));
        skinOButtons.add(findViewById(R.id.imageButton11));

        ImageButton pressedO = skinOButtons.get(Integer.parseInt(skinO));
        pressedO.setClickable(false);
        pressedO.setSelected(true);

        Button backButton = findViewById(R.id.backButton);

        for (ImageButton skinXButton : skinXButtons) {
            skinXButton.setOnClickListener(view -> {
                ImageButton clicked = (ImageButton) view;
                for (ImageButton skinButton : skinXButtons) {
                    skinButton.setClickable(true);
                    skinButton.setSelected(false);
                }
                clicked.setClickable(false);
                clicked.setSelected(true);
                skinX = clicked.getContentDescription().toString();
            });
        }

        for (ImageButton skinOButton : skinOButtons) {
            skinOButton.setOnClickListener(view -> {
                ImageButton clicked = (ImageButton) view;
                for (ImageButton skinButton : skinOButtons) {
                    skinButton.setClickable(true);
                    skinButton.setSelected(false);
                }
                clicked.setClickable(false);
                clicked.setSelected(true);
                skinO = clicked.getContentDescription().toString();
            });
        }

        backButton.setOnClickListener(view -> {
            Intent intentSkin = new Intent(SkinsActivity.this, MenuActivity.class);

            intentSkin.putExtra("difficulty", difficulty);
            intentSkin.putExtra("skinO", skinO);
            intentSkin.putExtra("skinX", skinX);

            startActivity(intentSkin);
        });
    }
}