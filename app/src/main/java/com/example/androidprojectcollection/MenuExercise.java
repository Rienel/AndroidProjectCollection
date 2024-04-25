package com.example.androidprojectcollection;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.drawable.GradientDrawable;
import android.opengl.Visibility;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import java.util.Random;

public class MenuExercise extends AppCompatActivity {

    Button btnChanger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_exercise);

        btnChanger = findViewById(R.id.btnTransformingButton);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.choice_menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.mItemChange) {
            Toast.makeText(this, "Edit Object Item is clicked", Toast.LENGTH_SHORT).show();
        } else if(item.getItemId() == R.id.mItemReset) {
            Toast.makeText(this, "Reset Object Item is clicked", Toast.LENGTH_SHORT).show();
            //RESET
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) btnChanger.getLayoutParams();

            layoutParams.width = 500;
            layoutParams.height = 500;
            btnChanger.setBackgroundResource(R.color.purple_500);
            btnChanger.setText("");
            btnChanger.setLayoutParams(layoutParams);
            btnChanger.setVisibility(View.VISIBLE);
        } else if (item.getItemId() == R.id.mItemChangeColor) {
            Random random = new Random();
            int color = android.graphics.Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
            btnChanger.setBackgroundColor(color);
        } else if(item.getItemId() == R.id.mItemChangeText) {
            String newText = textChanger();
            btnChanger.setText(newText);
        } else if(item.getItemId() == R.id.mItemChangeShape) {
            btnChanger.setBackgroundResource(R.drawable.round_button);
            btnChanger.getBackground();
        } else if(item.getItemId() == R.id.mItemChangeSize) {
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) btnChanger.getLayoutParams();

            layoutParams.width = 1000;
            layoutParams.height = 1000;

            btnChanger.setLayoutParams(layoutParams);
        } else if(item.getItemId() == R.id.mItemChangeVisibility) {
            btnChanger.setVisibility(View.GONE);
        } else if (item.getItemId() == R.id.mItemExit) {
            finish();
        }

        return true;
    }



    private String textChanger() {
        String[] text = {"BASILISCO", "SALARDE", "ELIZABETH", "REN", "ZEN", "RIENEL", "PEDRO PEDRO PEDRO PEDRO PE", "MEOW", "WOOF", "AWOOOOO", "BIRD", "SQUEK", "LAUGH", "JEFF", "DARTH VADER", "TARGARYEN", "RINA ELIZABETH JORAELZA ISSA"};
        Random random = new Random();
        int rands = random.nextInt(text.length);
        return text[rands];
    }

}