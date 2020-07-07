package com.example.friendsspot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageButton nextbutton;
    TextView welcometextview;
    EditText nametextview;
    public void newpage(View view){
        Intent nextintent= new Intent(getApplicationContext(),ques1.class);
        startActivity(nextintent);
        Log.i("key press:","successful");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        welcometextview=findViewById(R.id.WelcometextView);
        nametextview=findViewById(R.id.nametextview);
        nextbutton=findViewById(R.id.nextbutton);

    }
}