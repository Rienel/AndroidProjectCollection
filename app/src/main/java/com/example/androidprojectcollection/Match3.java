package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

public class Match3 extends AppCompatActivity {

    private Button[][] buttons = new Button[5][5];
    private int[][] colors = new int[5][5];
    private int score = 0;
    private TextView scoreTextView;
    private int selectedRow = -1;
    private int selectedCol = -1;
    private boolean isFirstButtonSelected = false;
    private Button restartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match3);

//        Assign 5x5 ButtonView to Button Object[5][5]
//
//        for(int row = 0; row < 5; row++) {
//            for(int col = 0; col < 5; col++) {
//                String reslDname = "Id of buttons" + row + col;
//                button name[row][col] = findviewbyid(this resource(.getidentifier(reslDname, "id", this.getpackagename);

        restartButton = findViewById(R.id.btnRestart);
        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restartGame();
            }
        });

        scoreTextView = findViewById(R.id.textView3);
        initializeButtons();
        initializeColors();
        displayColors();
        updateScoreText();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                final int finalI = i;
                final int finalJ = j;
                buttons[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!isFirstButtonSelected) {
                            selectedRow = finalI;
                            selectedCol = finalJ;
                            isFirstButtonSelected = true;
                        } else {
                            swapColors(selectedRow, selectedCol, finalI, finalJ);
                            isFirstButtonSelected = false;
                        }
                    }
                });
            }
        }
    }

    private void updateScoreText() {
        if (scoreTextView != null) {
            scoreTextView.setText("Score: " + score);
        }
    }

    private void initializeButtons() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                String buttonId = "btn" + (i + 1) + (j + 1);
                int resId = getResources().getIdentifier(buttonId, "id", getPackageName());
                buttons[i][j] = findViewById(resId);
            }
        }
    }

    private void initializeColors() {
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                colors[i][j] = rand.nextInt(4);
            }
        }
    }

    private void displayColors() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                setColor(buttons[i][j], colors[i][j]);
            }
        }
    }

    private void setColor(Button button, int color) {
        switch (color) {
            case 0:
                button.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
                break;
            case 1:
                button.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
                break;
            case 2:
                button.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));
                break;
            case 3:
                button.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                break;
        }
    }

    private void swapColors(int row1, int col1, int row2, int col2) {
        int temp = colors[row1][col1];
        colors[row1][col1] = colors[row2][col2];
        colors[row2][col2] = temp;

        // Check for matches only in the swapped cells
        boolean[][] checked = new boolean[5][5];
        checked[row1][col1] = true;
        checked[row2][col2] = true;

        if (checkMatches(checked)) {
            score++;
            updateScoreText();
            replaceMatchedButtons(checked);
        } else {
            displayColors();
        }
    }

    private boolean checkMatches(boolean[][] checked) {
        boolean matchesFound = false;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (!checked[i][j] && checkMatchAt(i, j)) {
                    matchesFound = true;
                    markCheckedButtons(i, j, checked);
                }
            }
        }

        return matchesFound;
    }

    private boolean checkMatchAt(int row, int col) {
        int color = colors[row][col];

        if (col >= 2 && colors[row][col - 1] == color && colors[row][col - 2] == color) {
            return true;
        }
        if (col <= 2 && colors[row][col + 1] == color && colors[row][col + 2] == color) {
            return true;
        }

        if (row >= 2 && colors[row - 1][col] == color && colors[row - 2][col] == color) {
            return true;
        }
        if (row <= 2 && colors[row + 1][col] == color && colors[row + 2][col] == color) {
            return true;
        }

        return false;
    }

    private void markCheckedButtons(int row, int col, boolean[][] checked) {
        checked[row][col] = true;

        if (col >= 2 && colors[row][col - 1] == colors[row][col] && colors[row][col - 2] == colors[row][col]) {
            checked[row][col - 1] = true;
            checked[row][col - 2] = true;
        }
        if (col <= 2 && colors[row][col + 1] == colors[row][col] && colors[row][col + 2] == colors[row][col]) {
            checked[row][col + 1] = true;
            checked[row][col + 2] = true;
        }

        if (row >= 2 && colors[row - 1][col] == colors[row][col] && colors[row - 2][col] == colors[row][col]) {
            checked[row - 1][col] = true;
            checked[row - 2][col] = true;
        }
        if (row <= 2 && colors[row + 1][col] == colors[row][col] && colors[row + 2][col] == colors[row][col]) {
            checked[row + 1][col] = true;
            checked[row + 2][col] = true;
        }
    }

    private void replaceMatchedButtons(boolean[][] checked) {
        Random rand = new Random();
        boolean newMatchFound = false;

        // Replace matched buttons only in the checked cells
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (checked[i][j]) {
                    colors[i][j] = rand.nextInt(4);

                    if (!newMatchFound && checkMatchAt(i, j)) {
                        newMatchFound = true;
                    }
                }
            }
        }
        displayColors();

        if (newMatchFound) {
            boolean[][] newChecked = new boolean[5][5];
            if (checkMatches(newChecked)) {
                score++;
                updateScoreText();
                replaceMatchedButtons(newChecked);
            }
        }
    }

    private void restartGame() {
        initializeColors();
        displayColors();
        score = 0;
        updateScoreText();
    }
}

