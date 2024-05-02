package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Maps extends AppCompatActivity {

    ImageButton btnCat, btnFuji, btnPanth, btnGala, btnShrine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        btnCat = (ImageButton) findViewById(R.id.btnCatIsland);
        btnCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:35.503165, 134.154762"));
                startActivity(intent);
            }
        });

        btnFuji = (ImageButton) findViewById(R.id.btnFujiM);
        btnFuji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:35.360485, 138.727793"));
                startActivity(intent);
            }
        });

        btnPanth = (ImageButton) findViewById(R.id.btnPantheon);
        btnPanth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:41.898583, 12.476844"));
                startActivity(intent);
            }
        });

        btnGala = (ImageButton) findViewById(R.id.btnGalapa);
        btnGala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:-0.264700, -90.716196"));
                startActivity(intent);
            }
        });

        btnShrine = (ImageButton) findViewById(R.id.btnShrines);
        btnShrine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:35°40'35.0, 139°41'57.6"));
                startActivity(intent);
            }
        });
    }
}