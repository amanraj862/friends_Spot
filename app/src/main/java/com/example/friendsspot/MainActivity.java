package com.example.friendsspot;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    ImageButton loginimageButton;
    TextView welcometextview;
    EditText emailText;
    EditText passwordText;
    MediaPlayer mediaPlayer;
    MediaPlayer mediaPlayer1;

    private FirebaseAuth mAuth;

    public void login(View view) {
        mediaPlayer.start();
        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();
        try {
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                signup();
                            } else {
                                signin();

                            }

                            // ...
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Enter a valid email and password", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        getIntent();
        welcometextview = findViewById(R.id.WelcometextView);
        emailText = findViewById(R.id.editEmailAddress);
        loginimageButton = findViewById(R.id.loginimageButton);
        mediaPlayer = MediaPlayer.create(this, R.raw.buttonaud);
        mediaPlayer1 = MediaPlayer.create(this, R.raw.friendstheme);
        if (!mediaPlayer1.isPlaying()) {
            mediaPlayer1.start();
            mediaPlayer1.setLooping(true);
        }
        passwordText = findViewById(R.id.editTextPassword);
        mAuth = FirebaseAuth.getInstance();
    }
    public void signin(){String email=emailText.getText().toString();
        String password=passwordText.getText().toString();
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            signup();
                        } else {
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });
    }

    public void signup() {
        Intent intent = new Intent(MainActivity.this, Rules.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
        mediaPlayer1.stop();
    }
}