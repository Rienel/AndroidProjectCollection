package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btnLayoutExercise);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        MainActivity.this, LayoutExercise.class
                );
                startActivity(intent);
            }
        });

        btn2 = (Button) findViewById(R.id.btnButtonExercise);
        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        MainActivity.this, ButtonExercise.class
                );
                startActivity(intent);
            }
        });

        btn3 = (Button) findViewById(R.id.btnCalculator);
        btn3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        MainActivity.this, CalculatorExercise.class
                );
                startActivity(intent);
            }
        });

        btn4 = (Button) findViewById(R.id.btnMatch3);
        btn4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        MainActivity.this, Match3.class
                );
                startActivity(intent);
            }
        });
        btn5 = (Button) findViewById(R.id.btnPassingIntentsExercise);
        btn5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        MainActivity.this, PassingIntentsExercise.class
                );
                startActivity(intent);
            }
        });

        btn6 = (Button) findViewById(R.id.btnMenus);
        btn6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        MainActivity.this, MenuExercise.class
                );
                startActivity(intent);
            }
        });

    }
}