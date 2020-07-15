package com.example.friendsspot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ques extends AppCompatActivity {
    TextView restextview;
    Button button1;
    Button button2;
    Button button3;
    Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ques);
        button1=findViewById(R.id.Button1);
        button2=findViewById(R.id.Button2);
        button3=findViewById(R.id.Button3);
        button4=findViewById(R.id.Button4);
        Intent intent=getIntent();
    }
}