package com.example.friendsspot;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
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
            //sign in into app using firebase
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
        Objects.requireNonNull(getSupportActionBar()).setTitle("Login/Signup");
        setContentView(R.layout.activity_main);
        getIntent();
        welcometextview = findViewById(R.id.WelcometextView);
        emailText = findViewById(R.id.editEmailAddress);
        loginimageButton = findViewById(R.id.loginimageButton);
        mediaPlayer = MediaPlayer.create(this, R.raw.buttonaud);
        mediaPlayer1 = MediaPlayer.create(this, R.raw.friendstheme);
        //Play background music
            mediaPlayer1.start();
            mediaPlayer1.setVolume(0.5f, 0.5f);
            mediaPlayer1.setLooping(true);
        passwordText = findViewById(R.id.editTextPassword);
        mAuth = FirebaseAuth.getInstance();
    }

    public void signin() {
        //sign up into the app using firebase
        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();
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
        //jump to rules class intent
        Intent intent = new Intent(MainActivity.this, Rules.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        // Exit app
        finishAffinity();
        System.exit(0);
    }
}