package com.example.friendsspot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.friendsspot.Model.Question;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ques extends AppCompatActivity {
    TextView questionview;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    // Write a message to the database
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference;
    int total=0;
    int correct=0;

    public void nextquestion(){
        total++;
        if(total>2) {
            Intent intent1 = new Intent(ques.this, thankyou.class);
            startActivity(intent1);
        }
        else{
            reference=database.getReference().child("Questions").child(String.valueOf(total));
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    final Question question=dataSnapshot.getValue(Question.class);
                    assert question != null;
                    questionview.setText(question.getQues());
                    button1.setText(question.getOption1());
                    button2.setText(question.getOption2());
                    button3.setText(question.getOption3());
                    button4.setText(question.getOption4());
                    button1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(button1.getText().toString().equals(question.getResult())){
                                button1.setBackgroundColor(Color.GREEN);
                                Handler handler=new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                   correct++;
                                 button1.setBackgroundColor(Color.parseColor("#0B0A0A"));
                                 nextquestion();
                                    }
                                },1500);
                            }
                            else{
                            button1.setBackgroundColor(Color.RED);
                            if (button2.getText().toString().equals(question.getResult())){
                                button2.setBackgroundColor(Color.GREEN);
                            }
                            else if (button3.getText().toString().equals(question.getResult())){
                                button3.setBackgroundColor(Color.GREEN);
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
                                    },1500);

                                }
                            }
                        }
                    });
                    button2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(button2.getText().toString().equals(question.getResult())){
                                button2.setBackgroundColor(Color.GREEN);
                                Handler handler=new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        button2.setBackgroundColor(Color.parseColor("#0B0A0A"));
                                        nextquestion();
                                    }
                                },1500);
                            }
                            else{
                                button2.setBackgroundColor(Color.RED);
                                if (button1.getText().toString().equals(question.getResult())){
                                    button1.setBackgroundColor(Color.GREEN);
                                }
                                else if (button3.getText().toString().equals(question.getResult())){
                                    button3.setBackgroundColor(Color.GREEN);
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
                                    },1500);

                                }
                            }
                        }
                    });
                    button3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(button3.getText().toString().equals(question.getResult())){
                                button3.setBackgroundColor(Color.GREEN);
                                Handler handler=new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        button3.setBackgroundColor(Color.parseColor("#0B0A0A"));
                                        nextquestion();
                                    }
                                },1500);
                            }
                            else{
                                button3.setBackgroundColor(Color.RED);
                                if (button2.getText().toString().equals(question.getResult())){
                                    button2.setBackgroundColor(Color.GREEN);
                                }
                                else if (button1.getText().toString().equals(question.getResult())){
                                    button1.setBackgroundColor(Color.GREEN);
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
                                    },1500);

                                }
                            }
                        }
                    });
                    button4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(button4.getText().toString().equals(question.getResult())){
                                button4.setBackgroundColor(Color.GREEN);
                                Handler handler=new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        button4.setBackgroundColor(Color.parseColor("#0B0A0A"));
                                        nextquestion();
                                    }
                                },1500);
                            }
                            else{
                                button4.setBackgroundColor(Color.RED);
                                if (button2.getText().toString().equals(question.getResult())){
                                    button2.setBackgroundColor(Color.GREEN);
                                }
                                else if (button3.getText().toString().equals(question.getResult())){
                                    button3.setBackgroundColor(Color.GREEN);
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
                                    },1500);

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
        setContentView(R.layout.activity_ques);
        questionview=findViewById(R.id.questionView);
        button1=findViewById(R.id.Button1);
        button2=findViewById(R.id.Button2);
        button3=findViewById(R.id.Button3);
        button4=findViewById(R.id.Button4);
        nextquestion();
        Intent intent2=getIntent();
    }
}