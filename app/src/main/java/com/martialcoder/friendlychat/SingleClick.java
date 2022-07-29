package com.martialcoder.friendlychat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;

import android.content.Intent;
import android.os.Bundle;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class SingleClick extends AppCompatActivity {

    private ImageView imageViewLarge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_click);
        imageViewLarge = findViewById(R.id.imageViewLarge);

        Intent intent = getIntent();
        String imagePath = intent.getStringExtra("url");


        Glide.with(getApplicationContext())
                .load(imagePath)
                .into(imageViewLarge);


    }


}