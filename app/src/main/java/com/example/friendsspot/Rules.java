package com.example.friendsspot;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class Rules extends AppCompatActivity {
    public void letsstart(View view) {
        //start quiz intent
        Intent intent = new Intent(getApplicationContext(), ques.class);
        startActivity(intent);
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.buttonaud);
        mediaPlayer.start();
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set title to Rules
        Objects.requireNonNull(getSupportActionBar()).setTitle("Rules");
        setContentView(R.layout.activity_rules);
        findViewById(R.id.button);
        getIntent();
    }
}