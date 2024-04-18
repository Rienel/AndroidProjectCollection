package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;
import java.util.Random;

public class ButtonExercise extends AppCompatActivity {

    Button btn;
    Button b;
    Button btn1;
    Button btn2;
    Button btn3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_exercise);

        btn = (Button) findViewById(R.id.btnClose);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        ButtonExercise.this, Return.class
                );
                startActivity(intent);
            }
        });

        b = (Button) findViewById(R.id.btnToast);
        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                switch(v.getId()){
                    case R.id.btnToast:
                        MessageBox("This is a toast!");
                        break;
                }
            }
        });

        btn1 = (Button) findViewById(R.id.btnChangeButtonBackground);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeButtonBackgroundColor();
            }
        });

        btn2 =  findViewById(R.id.btnChangeBackground);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeBackgroundColor();
            }
        });

        btn3 = (Button) findViewById(R.id.btnDisappear);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeButtonInvisible();
            }
        });
    }

    public void MessageBox(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void changeButtonBackgroundColor() {
        Random random = new Random();
        int color = android.graphics.Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
        btn1.setBackgroundColor(color);
    }

    private void changeBackgroundColor() {
        Random random = new Random();
        int color = android.graphics.Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
        ConstraintLayout constraintLayout = findViewById(R.id.button_exercise);
        constraintLayout.setBackgroundColor(color);
    }

    private void makeButtonInvisible() {
        btn3.setVisibility(View.INVISIBLE);
    }
}