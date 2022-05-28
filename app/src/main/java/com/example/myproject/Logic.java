package com.example.myproject;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.Random;

public class Logic {

    public static boolean checkWin(LinkedList<Button> buttons, LinkedList<Button> enabledButtons, String currentMark, TextView winnerText, Button quitButton) {
        //проверка по диагонали
        if (buttons.get(0).getText().equals(currentMark) &&
                buttons.get(4).getText().equals(currentMark) &&
                buttons.get(8).getText().equals(currentMark))
        {
            buttons.get(0).setSelected(true);
            buttons.get(4).setSelected(true);
            buttons.get(8).setSelected(true);
            gameEnding(buttons, winnerText, quitButton, currentMark);
            return true;
        }

        else if (buttons.get(2).getText().equals(currentMark) &&
                buttons.get(4).getText().equals(currentMark) &&
                buttons.get(6).getText().equals(currentMark))
        {
            buttons.get(2).setSelected(true);
            buttons.get(4).setSelected(true);
            buttons.get(6).setSelected(true);
            gameEnding(buttons, winnerText, quitButton, currentMark);
            return true;
        }

        // проверка по горизонтали
        else if (buttons.get(0).getText().equals(currentMark) &&
                buttons.get(1).getText().equals(currentMark) &&
                buttons.get(2).getText().equals(currentMark))
        {
            buttons.get(0).setSelected(true);
            buttons.get(1).setSelected(true);
            buttons.get(2).setSelected(true);
            gameEnding(buttons, winnerText, quitButton, currentMark);
            return true;
        }

        else if (buttons.get(3).getText().equals(currentMark) &&
                buttons.get(4).getText().equals(currentMark) &&
                buttons.get(5).getText().equals(currentMark))
        {
            buttons.get(3).setSelected(true);
            buttons.get(4).setSelected(true);
            buttons.get(5).setSelected(true);
            gameEnding(buttons, winnerText, quitButton, currentMark);
            return true;
        }

        else if (buttons.get(6).getText().equals(currentMark) &&
                buttons.get(7).getText().equals(currentMark) &&
                buttons.get(8).getText().equals(currentMark))
        {
            buttons.get(6).setSelected(true);
            buttons.get(7).setSelected(true);
            buttons.get(8).setSelected(true);
            gameEnding(buttons, winnerText, quitButton, currentMark);
            return true;
        }

        //проверка по вертикали
        else if (buttons.get(0).getText().equals(currentMark) &&
                buttons.get(3).getText().equals(currentMark) &&
                buttons.get(6).getText().equals(currentMark))
        {
            buttons.get(0).setSelected(true);
            buttons.get(3).setSelected(true);
            buttons.get(6).setSelected(true);
            gameEnding(buttons, winnerText, quitButton, currentMark);
            return true;
        }

        else if (buttons.get(1).getText().equals(currentMark) &&
                buttons.get(4).getText().equals(currentMark) &&
                buttons.get(7).getText().equals(currentMark))
        {
            buttons.get(1).setSelected(true);
            buttons.get(4).setSelected(true);
            buttons.get(7).setSelected(true);
            gameEnding(buttons, winnerText, quitButton, currentMark);
            return true;
        }

        else if (buttons.get(2).getText().equals(currentMark) &&
                buttons.get(5).getText().equals(currentMark) &&
                buttons.get(8).getText().equals(currentMark))
        {
            buttons.get(2).setSelected(true);
            buttons.get(5).setSelected(true);
            buttons.get(8).setSelected(true);
            gameEnding(buttons, winnerText, quitButton, currentMark);
            return true;
        }

        //ничья
        else if (enabledButtons.isEmpty())
        {
            gameEnding(buttons, winnerText, quitButton, "-");
            return true;
        }
        return false;
    }

    public static void gameEnding(LinkedList<Button> buttons, TextView winnerText, Button quitButton, String currentMark) {
        for (Button button : buttons) {
            button.setEnabled(false);
        }
        if (currentMark.equals("O")) {
            winnerText.setText("Выиграли нолики!");
        }

        else if (currentMark.equals("X")) {
            winnerText.setText("Выиграли крестики!");
        }

        else {
            winnerText.setText("Ничья!");
        }


        quitButton.setEnabled(true);
    }


    public static Button computerBrain(LinkedList<Button> buttons, LinkedList<Button> enabledButtons, String computerMark, String currentMark) {

        // Проверка победы программы

        // Проверка по диагонали
        if (buttons.get(0).getText().equals("") && buttons.get(4).getText().equals(computerMark) && buttons.get(8).getText().equals(computerMark)) {
            return buttons.get(0);
        }
        else if (buttons.get(4).getText().equals("") && buttons.get(0).getText().equals(computerMark) && buttons.get(8).getText().equals(computerMark)) {
            return buttons.get(4);
        }
        else if (buttons.get(8).getText().equals("") && buttons.get(0).getText().equals(computerMark) && buttons.get(4).getText().equals(computerMark)) {
            return buttons.get(8);
        }

        else if (buttons.get(2).getText().equals("") && buttons.get(4).getText().equals(computerMark) && buttons.get(6).getText().equals(computerMark)) {
            return buttons.get(2);
        }
        else if (buttons.get(4).getText().equals("") && buttons.get(2).getText().equals(computerMark) && buttons.get(6).getText().equals(computerMark)) {
            return buttons.get(4);
        }
        else if (buttons.get(6).getText().equals("") && buttons.get(2).getText().equals(computerMark) && buttons.get(4).getText().equals(computerMark)) {
            return buttons.get(6);
        }

        // Проверка по горизонтали
        // Ряд 1
        else if (buttons.get(0).getText().equals("") && buttons.get(1).getText().equals(computerMark) && buttons.get(2).getText().equals(computerMark)) {
            return buttons.get(0);
        }
        else if (buttons.get(1).getText().equals("") && buttons.get(0).getText().equals(computerMark) && buttons.get(2).getText().equals(computerMark)) {
            return buttons.get(1);
        }
        else if (buttons.get(2).getText().equals("") && buttons.get(0).getText().equals(computerMark) && buttons.get(1).getText().equals(computerMark)) {
            return buttons.get(2);
        }
        // Ряд 2
        else if (buttons.get(3).getText().equals("") && buttons.get(4).getText().equals(computerMark) && buttons.get(5).getText().equals(computerMark)) {
            return buttons.get(3);
        }
        else if (buttons.get(4).getText().equals("") && buttons.get(3).getText().equals(computerMark) && buttons.get(5).getText().equals(computerMark)) {
            return buttons.get(4);
        }
        else if (buttons.get(5).getText().equals("") && buttons.get(3).getText().equals(computerMark) && buttons.get(4).getText().equals(computerMark)) {
            return buttons.get(5);
        }
        // Ряд 3
        else if (buttons.get(6).getText().equals("") && buttons.get(7).getText().equals(computerMark) && buttons.get(8).getText().equals(computerMark)) {
            return buttons.get(6);
        }
        else if (buttons.get(7).getText().equals("") && buttons.get(6).getText().equals(computerMark) && buttons.get(8).getText().equals(computerMark)) {
            return buttons.get(7);
        }
        else if (buttons.get(8).getText().equals("") && buttons.get(6).getText().equals(computerMark) && buttons.get(7).getText().equals(computerMark)) {
            return buttons.get(8);
        }

        // Проверка по вертикали
        // Ряд 1
        if (buttons.get(0).getText().equals("") && buttons.get(3).getText().equals(computerMark) && buttons.get(6).getText().equals(computerMark)) {
            return buttons.get(0);
        }
        else if (buttons.get(3).getText().equals("") && buttons.get(0).getText().equals(computerMark) && buttons.get(6).getText().equals(computerMark)) {
            return buttons.get(3);
        }
        else if (buttons.get(6).getText().equals("") && buttons.get(0).getText().equals(computerMark) && buttons.get(3).getText().equals(computerMark)) {
            return buttons.get(6);
        }
        // Ряд 2
        else if (buttons.get(1).getText().equals("") && buttons.get(4).getText().equals(computerMark) && buttons.get(7).getText().equals(computerMark)) {
            return buttons.get(1);
        }
        else if (buttons.get(4).getText().equals("") && buttons.get(1).getText().equals(computerMark) && buttons.get(7).getText().equals(computerMark)) {
            return buttons.get(4);
        }
        else if (buttons.get(7).getText().equals("") && buttons.get(1).getText().equals(computerMark) && buttons.get(4).getText().equals(computerMark)) {
            return buttons.get(7);
        }
        // Ряд 3
        else if (buttons.get(2).getText().equals("") && buttons.get(5).getText().equals(computerMark) && buttons.get(8).getText().equals(computerMark)) {
            return buttons.get(2);
        }
        else if (buttons.get(5).getText().equals("") && buttons.get(2).getText().equals(computerMark) && buttons.get(8).getText().equals(computerMark)) {
            return buttons.get(5);
        }
        else if (buttons.get(8).getText().equals("") && buttons.get(2).getText().equals(computerMark) && buttons.get(5).getText().equals(computerMark)) {
            return buttons.get(8);
        }


        // Проверка победы игрока

        // Проверка по диагонали
        else if (buttons.get(0).getText().equals("") && buttons.get(4).getText().equals(currentMark) && buttons.get(8).getText().equals(currentMark)) {
            return buttons.get(0);
        }
        else if (buttons.get(4).getText().equals("") && buttons.get(0).getText().equals(currentMark) && buttons.get(8).getText().equals(currentMark)) {
            return buttons.get(4);
        }
        else if (buttons.get(8).getText().equals("") && buttons.get(0).getText().equals(currentMark) && buttons.get(4).getText().equals(currentMark)) {
            return buttons.get(8);
        }

        else if (buttons.get(2).getText().equals("") && buttons.get(4).getText().equals(currentMark) && buttons.get(6).getText().equals(currentMark)) {
            return buttons.get(2);
        }
        else if (buttons.get(4).getText().equals("") && buttons.get(2).getText().equals(currentMark) && buttons.get(6).getText().equals(currentMark)) {
            return buttons.get(4);
        }
        else if (buttons.get(6).getText().equals("") && buttons.get(2).getText().equals(currentMark) && buttons.get(4).getText().equals(currentMark)) {
            return buttons.get(6);
        }

        // Проверка по горизонтали
        // Ряд 1
        if (buttons.get(0).getText().equals("") && buttons.get(1).getText().equals(currentMark) && buttons.get(2).getText().equals(currentMark)) {
            return buttons.get(0);
        }
        else if (buttons.get(1).getText().equals("") && buttons.get(0).getText().equals(currentMark) && buttons.get(2).getText().equals(currentMark)) {
            return buttons.get(1);
        }
        else if (buttons.get(2).getText().equals("") && buttons.get(0).getText().equals(currentMark) && buttons.get(1).getText().equals(currentMark)) {
            return buttons.get(2);
        }
        // Ряд 2
        else if (buttons.get(3).getText().equals("") && buttons.get(4).getText().equals(currentMark) && buttons.get(5).getText().equals(currentMark)) {
            return buttons.get(3);
        }
        else if (buttons.get(4).getText().equals("") && buttons.get(3).getText().equals(currentMark) && buttons.get(5).getText().equals(currentMark)) {
            return buttons.get(4);
        }
        else if (buttons.get(5).getText().equals("") && buttons.get(3).getText().equals(currentMark) && buttons.get(4).getText().equals(currentMark)) {
            return buttons.get(5);
        }
        // Ряд 3
        else if (buttons.get(6).getText().equals("") && buttons.get(7).getText().equals(currentMark) && buttons.get(8).getText().equals(currentMark)) {
            return buttons.get(6);
        }
        else if (buttons.get(7).getText().equals("") && buttons.get(6).getText().equals(currentMark) && buttons.get(8).getText().equals(currentMark)) {
            return buttons.get(7);
        }
        else if (buttons.get(8).getText().equals("") && buttons.get(6).getText().equals(currentMark) && buttons.get(7).getText().equals(currentMark)) {
            return buttons.get(8);
        }

        // Проверка по вертикали
        // Ряд 1
        if (buttons.get(0).getText().equals("") && buttons.get(3).getText().equals(currentMark) && buttons.get(6).getText().equals(currentMark)) {
            return buttons.get(0);
        }
        else if (buttons.get(3).getText().equals("") && buttons.get(0).getText().equals(currentMark) && buttons.get(6).getText().equals(currentMark)) {
            return buttons.get(3);
        }
        else if (buttons.get(6).getText().equals("") && buttons.get(0).getText().equals(currentMark) && buttons.get(3).getText().equals(currentMark)) {
            return buttons.get(6);
        }
        // Ряд 2
        else if (buttons.get(1).getText().equals("") && buttons.get(4).getText().equals(currentMark) && buttons.get(7).getText().equals(currentMark)) {
            return buttons.get(1);
        }
        else if (buttons.get(4).getText().equals("") && buttons.get(1).getText().equals(currentMark) && buttons.get(7).getText().equals(currentMark)) {
            return buttons.get(4);
        }
        else if (buttons.get(7).getText().equals("") && buttons.get(1).getText().equals(currentMark) && buttons.get(4).getText().equals(currentMark)) {
            return buttons.get(7);
        }
        // Ряд 3
        else if (buttons.get(2).getText().equals("") && buttons.get(5).getText().equals(currentMark) && buttons.get(8).getText().equals(currentMark)) {
            return buttons.get(2);
        }
        else if (buttons.get(5).getText().equals("") && buttons.get(2).getText().equals(currentMark) && buttons.get(8).getText().equals(currentMark)) {
            return buttons.get(5);
        }
        else if (buttons.get(8).getText().equals("") && buttons.get(2).getText().equals(currentMark) && buttons.get(5).getText().equals(currentMark)) {
            return buttons.get(8);
        }

        // Ничего не подходит
        else {
            Random random = new Random();
            return enabledButtons.get(random.nextInt(enabledButtons.size()));
        }
    }

    public static void turnButtons(LinkedList<Button> buttons, boolean turning) {
        for (Button button : buttons) {
            button.setEnabled(turning);
        }
    }

    public static void drawMarks(LinkedList<ImageView> marksViews, LinkedList<Button> buttons, int x, int o) {
        for (int i = 0; i < marksViews.size(); i++) {
            if (buttons.get(i).getText().equals("X")) {
                marksViews.get(i).setImageResource(x);
                marksViews.get(i).setVisibility(View.VISIBLE);
            }
        }
        for (int i = 0; i < marksViews.size(); i++) {
            if (buttons.get(i).getText().equals("O")) {
                marksViews.get(i).setImageResource(o);
                marksViews.get(i).setVisibility(View.VISIBLE);
            }
        }
    }

    public static void setCurrentMarkImage(ImageView currentMarkImage, String currentMark, int x, int o) {
        if (currentMark.equals("X")) {
            currentMarkImage.setImageResource(x);
        }
        else {
            currentMarkImage.setImageResource(o);
        }
        currentMarkImage.setVisibility(View.VISIBLE);
    }
}
