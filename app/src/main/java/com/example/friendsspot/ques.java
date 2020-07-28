package com.example.friendsspot;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.friendsspot.Model.Question;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ques extends AppCompatActivity {
    MediaPlayer mediaPlayer1;
    MediaPlayer mediaPlayer2;
    TextView questionview;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    TextView textView3;
    // Write a message to the database
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference;
    public static int total = 0;
    public static int correct = 0;

    public void nextquestion() {
        total++;
        if (total > 20) {
            Intent intent1 = new Intent(ques.this, thankyou.class);
            intent1.putExtra("correctans", correct);
            startActivity(intent1);

        } else {
            reference = database.getReference().child("Questions").child(String.valueOf(total));
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    final Question question = dataSnapshot.getValue(Question.class);
                    assert question != null;
                    questionview.clearAnimation();
                    questionview.setTranslationX(-1000);
                    questionview.animate().translationXBy(1000).setDuration(1500);
                    questionview.setText(question.getQues());
                    button1.setVisibility(View.INVISIBLE);
                    button2.setVisibility(View.INVISIBLE);
                    button3.setVisibility(View.INVISIBLE);
                    button4.setVisibility(View.INVISIBLE);
                    button5.setVisibility(View.INVISIBLE);
                    button1.setText(question.getOption1());
                    button2.setText(question.getOption2());
                    button3.setText(question.getOption3());
                    button4.setText(question.getOption4());
                    button5.setText("Pass");
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Do something after 1s = 1000ms
                            button1.setVisibility(View.VISIBLE);
                            button2.setVisibility(View.VISIBLE);
                            button3.setVisibility(View.VISIBLE);
                            button4.setVisibility(View.VISIBLE);
                            button5.setVisibility(View.VISIBLE);

                        }
                    }, 1400);
                    button5.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            button5.setBackgroundColor(Color.BLUE);
                            textView3.setText("Score : +0");
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    button5.setBackgroundColor(Color.parseColor("#0B0A0A"));
                                    nextquestion();
                                }
                            }, 800);
                        }
                    });

                    button1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (button1.getText().toString().equals(question.getResult())) {
                                button1.setBackgroundColor(Color.GREEN);
                                mediaPlayer1.start();
                                textView3.setText("Score : +2");
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct += 2;
                                        button1.setBackgroundColor(Color.parseColor("#0B0A0A"));
                                        nextquestion();
                                    }
                                }, 1000);
                            }
                            else {
                                textView3.setText("Score : -1");
                                correct -= 1;
                                mediaPlayer2.start();
                                button1.setBackgroundColor(Color.RED);
                                if (button2.getText().toString().equals(question.getResult())) {
                                    button2.setBackgroundColor(Color.GREEN);
                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            button1.setBackgroundColor(Color.parseColor("#0B0A0A"));
                                            button2.setBackgroundColor(Color.parseColor("#0B0A0A"));
                                            button3.setBackgroundColor(Color.parseColor("#0B0A0A"));
                                        button4.setBackgroundColor(Color.parseColor("#0B0A0A"));
                                        nextquestion();
                                    }
                                },1000);
                            }
                            else if (button3.getText().toString().equals(question.getResult())){
                                button3.setBackgroundColor(Color.GREEN);
                                Handler handler=new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        button1.setBackgroundColor(Color.parseColor("#0B0A0A"));
                                        button2.setBackgroundColor(Color.parseColor("#0B0A0A"));
                                        button3.setBackgroundColor(Color.parseColor("#0B0A0A"));
                                        button4.setBackgroundColor(Color.parseColor("#0B0A0A"));
                                        nextquestion();
                                    }
                                },1000);
                            }
                             else   if (button4.getText().toString().equals(question.getResult())){
                                    button4.setBackgroundColor(Color.GREEN);
                                    Handler handler=new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            button1.setBackgroundColor(Color.parseColor("#0B0A0A"));
                                            button2.setBackgroundColor(Color.parseColor("#0B0A0A"));
                                            button3.setBackgroundColor(Color.parseColor("#0B0A0A"));
                                            button4.setBackgroundColor(Color.parseColor("#0B0A0A"));
                                            nextquestion();
                                        }
                                    },1000);

                                }
                            }
                        }
                    });
                    button2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(button2.getText().toString().equals(question.getResult())) {
                                button2.setBackgroundColor(Color.GREEN);
                                mediaPlayer1.start();
                                textView3.setText("Score : +2");
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct += 2;
                                        button2.setBackgroundColor(Color.parseColor("#0B0A0A"));
                                        nextquestion();
                                    }
                                }, 1000);
                            }
                            else {
                                textView3.setText("Score : -1");
                                correct -= 1;
                                mediaPlayer2.start();
                                button2.setBackgroundColor(Color.RED);
                                if (button1.getText().toString().equals(question.getResult())) {
                                    button1.setBackgroundColor(Color.GREEN);
                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            button1.setBackgroundColor(Color.parseColor("#0B0A0A"));
                                            button2.setBackgroundColor(Color.parseColor("#0B0A0A"));
                                            button3.setBackgroundColor(Color.parseColor("#0B0A0A"));
                                            button4.setBackgroundColor(Color.parseColor("#0B0A0A"));
                                            nextquestion();
                                        }
                                    },1000);
                                }
                                else if (button3.getText().toString().equals(question.getResult())){
                                    button3.setBackgroundColor(Color.GREEN);
                                    Handler handler=new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            button1.setBackgroundColor(Color.parseColor("#0B0A0A"));
                                            button2.setBackgroundColor(Color.parseColor("#0B0A0A"));
                                            button3.setBackgroundColor(Color.parseColor("#0B0A0A"));
                                            button4.setBackgroundColor(Color.parseColor("#0B0A0A"));
                                            nextquestion();
                                        }
                                    },1000);
                                }
                                else   if (button4.getText().toString().equals(question.getResult())){
                                    button4.setBackgroundColor(Color.GREEN);
                                    Handler handler=new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            button1.setBackgroundColor(Color.parseColor("#0B0A0A"));
                                            button2.setBackgroundColor(Color.parseColor("#0B0A0A"));
                                            button3.setBackgroundColor(Color.parseColor("#0B0A0A"));
                                            button4.setBackgroundColor(Color.parseColor("#0B0A0A"));
                                            nextquestion();
                                        }
                                    }, 1000);

                                }
                            }
                        }
                    });
                    button3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(button3.getText().toString().equals(question.getResult())) {
                                button3.setBackgroundColor(Color.GREEN);
                                mediaPlayer1.start();
                                textView3.setText("Score : +2");
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct += 2;
                                        button3.setBackgroundColor(Color.parseColor("#0B0A0A"));
                                        nextquestion();
                                    }
                                }, 1000);
                            }
                            else {
                                textView3.setText("Score : -1");
                                correct -= 1;
                                mediaPlayer2.start();
                                button3.setBackgroundColor(Color.RED);
                                if (button2.getText().toString().equals(question.getResult())) {
                                    button2.setBackgroundColor(Color.GREEN);
                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            button1.setBackgroundColor(Color.parseColor("#0B0A0A"));
                                            button2.setBackgroundColor(Color.parseColor("#0B0A0A"));
                                            button3.setBackgroundColor(Color.parseColor("#0B0A0A"));
                                            button4.setBackgroundColor(Color.parseColor("#0B0A0A"));
                                            nextquestion();
                                        }
                                    },1000);
                                }
                                else if (button1.getText().toString().equals(question.getResult())){
                                    button1.setBackgroundColor(Color.GREEN);
                                    Handler handler=new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            button1.setBackgroundColor(Color.parseColor("#0B0A0A"));
                                            button2.setBackgroundColor(Color.parseColor("#0B0A0A"));
                                            button3.setBackgroundColor(Color.parseColor("#0B0A0A"));
                                            button4.setBackgroundColor(Color.parseColor("#0B0A0A"));
                                            nextquestion();
                                        }
                                    },1000);
                                }
                                else   if (button4.getText().toString().equals(question.getResult())){
                                    button4.setBackgroundColor(Color.GREEN);
                                    Handler handler=new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            button1.setBackgroundColor(Color.parseColor("#0B0A0A"));
                                            button2.setBackgroundColor(Color.parseColor("#0B0A0A"));
                                            button3.setBackgroundColor(Color.parseColor("#0B0A0A"));
                                            button4.setBackgroundColor(Color.parseColor("#0B0A0A"));
                                            nextquestion();
                                        }
                                    }, 1000);

                                }
                            }
                        }
                    });
                    button4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(button4.getText().toString().equals(question.getResult())) {
                                button4.setBackgroundColor(Color.GREEN);
                                mediaPlayer1.start();
                                textView3.setText("Score : +2");
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct += 2;
                                        button4.setBackgroundColor(Color.parseColor("#0B0A0A"));
                                        nextquestion();
                                    }
                                }, 1000);
                            }
                            else {
                                textView3.setText("Score : -1");
                                correct -= 1;
                                mediaPlayer2.start();
                                button4.setBackgroundColor(Color.RED);
                                if (button2.getText().toString().equals(question.getResult())) {
                                    button2.setBackgroundColor(Color.GREEN);
                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            button1.setBackgroundColor(Color.parseColor("#0B0A0A"));
                                            button2.setBackgroundColor(Color.parseColor("#0B0A0A"));
                                            button3.setBackgroundColor(Color.parseColor("#0B0A0A"));
                                            button4.setBackgroundColor(Color.parseColor("#0B0A0A"));
                                            nextquestion();
                                        }
                                    },1000);
                                }
                                else if (button3.getText().toString().equals(question.getResult())){
                                    button3.setBackgroundColor(Color.GREEN);
                                    Handler handler=new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            button1.setBackgroundColor(Color.parseColor("#0B0A0A"));
                                            button2.setBackgroundColor(Color.parseColor("#0B0A0A"));
                                            button3.setBackgroundColor(Color.parseColor("#0B0A0A"));
                                            button4.setBackgroundColor(Color.parseColor("#0B0A0A"));
                                            nextquestion();
                                        }
                                    },1000);
                                }
                                else   if (button1.getText().toString().equals(question.getResult())){
                                    button1.setBackgroundColor(Color.GREEN);
                                    Handler handler=new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            button1.setBackgroundColor(Color.parseColor("#0B0A0A"));
                                            button2.setBackgroundColor(Color.parseColor("#0B0A0A"));
                                            button3.setBackgroundColor(Color.parseColor("#0B0A0A"));
                                            button4.setBackgroundColor(Color.parseColor("#0B0A0A"));
                                            nextquestion();
                                        }
                                    }, 1000);

                                }
                            }
                        }
                    });
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("F.r.i.e.n.d.s Spot");
        setContentView(R.layout.activity_ques);
        questionview = findViewById(R.id.questionView);
        button1 = findViewById(R.id.Button1);
        button2 = findViewById(R.id.Button2);
        button3 = findViewById(R.id.Button3);
        button4 = findViewById(R.id.Button4);
        button5 = findViewById(R.id.Button5);
        textView3 = findViewById(R.id.textView3);
        button1.setVisibility(View.INVISIBLE);
        button2.setVisibility(View.INVISIBLE);
        button3.setVisibility(View.INVISIBLE);
        button4.setVisibility(View.INVISIBLE);
        button5.setVisibility(View.INVISIBLE);
        mediaPlayer1 = MediaPlayer.create(this, R.raw.correct);
        mediaPlayer2 = MediaPlayer.create(this, R.raw.wronganswer);
        nextquestion();
        Intent intent2 = getIntent();
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
                System.exit(0);
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