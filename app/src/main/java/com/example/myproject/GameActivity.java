package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.Random;

public class GameActivity extends AppCompatActivity {

    String currentMark;
    String computerMark;
    LinkedList<Button> buttons;
    LinkedList<Button> enabledButtons;
    LinkedList<ImageView> markViews;

    int[] skinsX = new int[] {R.drawable.x1, R.drawable.x2, R.drawable.x3,
                              R.drawable.x4, R.drawable.x5, R.drawable.x6};

    int[] skinsO = new int[] {R.drawable.o1, R.drawable.o2, R.drawable.o3,
                              R.drawable.o4, R.drawable.o5, R.drawable.o6};

    String skinX;
    String skinO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent intentMenu = getIntent();
        String difficulty = intentMenu.getStringExtra("difficulty");
        skinX = intentMenu.getStringExtra("skinX");
        skinO = intentMenu.getStringExtra("skinO");

        buttons = new LinkedList<>();
        buttons.add(findViewById(R.id.button0));
        buttons.add(findViewById(R.id.button1));
        buttons.add(findViewById(R.id.button2));
        buttons.add(findViewById(R.id.button3));
        buttons.add(findViewById(R.id.button4));
        buttons.add(findViewById(R.id.button5));
        buttons.add(findViewById(R.id.button6));
        buttons.add(findViewById(R.id.button7));
        buttons.add(findViewById(R.id.button8));

        markViews = new LinkedList<>();
        markViews.add(findViewById(R.id.imageView0));
        markViews.add(findViewById(R.id.imageView1));
        markViews.add(findViewById(R.id.imageView2));
        markViews.add(findViewById(R.id.imageView3));
        markViews.add(findViewById(R.id.imageView4));
        markViews.add(findViewById(R.id.imageView5));
        markViews.add(findViewById(R.id.imageView6));
        markViews.add(findViewById(R.id.imageView7));
        markViews.add(findViewById(R.id.imageView8));

        enabledButtons = new LinkedList<>();
        enabledButtons.addAll(buttons);

        ImageView currentMarkImage = findViewById(R.id.currentMarkImage);
        if (difficulty.equals("two players")){
            currentMark = "X";
        }
        else {
            Random random = new Random();
            currentMark = new String[] {"X", "O"} [random.nextInt(2)];
        }
        if (currentMark.equals("X")) {
            Logic.turnButtons(enabledButtons, true);
            computerMark = "O";
        } else {
            computerMark = "X";
        }
        Logic.setCurrentMarkImage(currentMarkImage, currentMark, skinsX[Integer.parseInt(skinX)], skinsO[Integer.parseInt(skinO)]);
        Button quitButton = findViewById(R.id.quit_button);
        TextView winnerText = findViewById(R.id.winnerText);

        if (currentMark.equals("O")) {
            switch (difficulty) {
                case "easy": {
                    Logic.setCurrentMarkImage(currentMarkImage, computerMark, skinsX[Integer.parseInt(skinX)], skinsO[Integer.parseInt(skinO)]);
                    Logic.turnButtons(enabledButtons, false);
                    new Handler().postDelayed(() -> {
                        Random random = new Random();
                        Button computerButton = enabledButtons.get(random.nextInt(enabledButtons.size()));
                        computerButton.setText(computerMark);
                        computerButton.setEnabled(false);
                        enabledButtons.remove(computerButton);
                        Logic.setCurrentMarkImage(currentMarkImage, currentMark, skinsX[Integer.parseInt(skinX)], skinsO[Integer.parseInt(skinO)]);
                        Logic.turnButtons(enabledButtons, true);
                        Logic.checkWin(buttons, enabledButtons, computerMark, winnerText, quitButton);
                        Logic.drawMarks(markViews, buttons, skinsX[Integer.parseInt(skinX)], skinsO[Integer.parseInt(skinO)]);
                    }, 1000);
                    break;
                }

                case "hard": {
                    Logic.setCurrentMarkImage(currentMarkImage, computerMark, skinsX[Integer.parseInt(skinX)], skinsO[Integer.parseInt(skinO)]);
                    Logic.turnButtons(enabledButtons, false);
                    new Handler().postDelayed(() -> {
                        Button computerButton = Logic.computerBrain(buttons, enabledButtons, computerMark, currentMark);
                        computerButton.setText(computerMark);
                        computerButton.setEnabled(false);
                        enabledButtons.remove(computerButton);
                        Logic.setCurrentMarkImage(currentMarkImage, currentMark, skinsX[Integer.parseInt(skinX)], skinsO[Integer.parseInt(skinO)]);
                        Logic.turnButtons(enabledButtons, true);
                        Logic.checkWin(buttons, enabledButtons, computerMark, winnerText, quitButton);
                        Logic.drawMarks(markViews, buttons, skinsX[Integer.parseInt(skinX)], skinsO[Integer.parseInt(skinO)]);
                    }, 1000);
                    break;
                }
            }
        }

        for (Button button : buttons) {
            button.setOnClickListener(view -> {
                Button clicked = (Button) view;

                clicked.setText(currentMark);
                clicked.setEnabled(false);

                enabledButtons.remove(clicked);
                Logic.drawMarks(markViews, buttons, skinsX[Integer.parseInt(skinX)], skinsO[Integer.parseInt(skinO)]);

                if (!Logic.checkWin(buttons, enabledButtons, currentMark, winnerText, quitButton)) {
                    switch (difficulty) {
                        case "two players":
                            if (currentMark.equals("X")) {
                                currentMark = "O";
                            } else {
                                currentMark = "X";
                            }
                            Logic.setCurrentMarkImage(currentMarkImage, currentMark, skinsX[Integer.parseInt(skinX)], skinsO[Integer.parseInt(skinO)]);
                            break;

                        case "easy": {
                            Logic.setCurrentMarkImage(currentMarkImage, computerMark, skinsX[Integer.parseInt(skinX)], skinsO[Integer.parseInt(skinO)]);
                            Logic.turnButtons(enabledButtons, false);
                            new Handler().postDelayed(() -> {
                                Random random = new Random();
                                Button computerButton = enabledButtons.get(random.nextInt(enabledButtons.size()));
                                computerButton.setText(computerMark);
                                computerButton.setEnabled(false);
                                enabledButtons.remove(computerButton);
                                Logic.setCurrentMarkImage(currentMarkImage, currentMark, skinsX[Integer.parseInt(skinX)], skinsO[Integer.parseInt(skinO)]);
                                Logic.turnButtons(enabledButtons, true);
                                Logic.checkWin(buttons, enabledButtons, computerMark, winnerText, quitButton);
                                Logic.drawMarks(markViews, buttons, skinsX[Integer.parseInt(skinX)], skinsO[Integer.parseInt(skinO)]);
                            }, 1000);
                            break;
                        }

                        case "hard": {
                            Logic.setCurrentMarkImage(currentMarkImage, computerMark, skinsX[Integer.parseInt(skinX)], skinsO[Integer.parseInt(skinO)]);
                            Logic.turnButtons(enabledButtons, false);
                            new Handler().postDelayed(() -> {
                                Button computerButton = Logic.computerBrain(buttons, enabledButtons, computerMark, currentMark);
                                computerButton.setText(computerMark);
                                computerButton.setEnabled(false);
                                enabledButtons.remove(computerButton);
                                Logic.setCurrentMarkImage(currentMarkImage, currentMark, skinsX[Integer.parseInt(skinX)], skinsO[Integer.parseInt(skinO)]);
                                Logic.turnButtons(enabledButtons, true);
                                Logic.checkWin(buttons, enabledButtons, computerMark, winnerText, quitButton);
                                Logic.drawMarks(markViews, buttons, skinsX[Integer.parseInt(skinX)], skinsO[Integer.parseInt(skinO)]);
                            }, 1000);
                            break;
                        }
                    }
                }
            });
        }

        quitButton.setOnClickListener(view -> {
            Intent intentGame = new Intent(GameActivity.this, MenuActivity.class);

            intentGame.putExtra("difficulty", difficulty);
            intentGame.putExtra("skinX", skinX);
            intentGame.putExtra("skinO", skinO);

            startActivity(intentGame);
        });
    }
}
