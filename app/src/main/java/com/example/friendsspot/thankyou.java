package com.example.friendsspot;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class thankyou extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Thank you");
        setContentView(R.layout.activity_thankyou);
        findViewById(R.id.imageView);
        findViewById(R.id.textView);
        Intent intent = getIntent();
        int correct = intent.getIntExtra("correctans", 0);
        TextView textView2 = findViewById(R.id.textView2);
        textView2.setText("Final score: " + correct + "/40 ");
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
        System.exit(0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.signout:
                FirebaseAuth.getInstance().signOut();
                Intent intent3 = new Intent(thankyou.this, MainActivity.class);
                startActivity(intent3);
                return true;
            case R.id.exit:
                finishAffinity();
                System.exit(0);
                return true;
            case R.id.followus:
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/thegaietythoughts/"));
                startActivity(browserIntent);
                return true;
            default:
                return false;

        }
    }
}