package com.example.friendsspot;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Rules extends AppCompatActivity {
    public void letsstart(View view) {
        //start quiz intent
        Intent intent = new Intent(getApplicationContext(), ques.class);
        startActivity(intent);
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.buttonaud);
        mediaPlayer.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);
        findViewById(R.id.textView5);
        findViewById(R.id.textView4);
        findViewById(R.id.button);
    }
}