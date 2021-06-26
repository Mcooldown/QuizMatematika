package com.example.quizmatematika;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizmatematika.model.User;

import java.util.ArrayList;
import java.util.Random;

public class PlayActivity extends AppCompatActivity {

    public static final String EXTRA_OBJECT_USER = "extra object";
    Random rand = new Random();
    private TextView score;
    private TextView operation;
    private Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_0, btn_erase, btn_submit;
    private long result;
    private int number1,number2, score_total;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        score = findViewById(R.id.score);
        operation = findViewById(R.id.operation);

        User user = (User) getIntent().getSerializableExtra(EXTRA_OBJECT_USER);
        username = user.getUsername();

        btn_0 = findViewById(R.id.btn_0);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);
        btn_8 = findViewById(R.id.btn_8);
        btn_9 = findViewById(R.id.btn_9);
        btn_erase = findViewById(R.id.btn_erase);
        btn_submit = findViewById(R.id.btn_submit);

        startGame();
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(PlayActivity.this, MainActivity.class);
        User user = new User();
        user.setUsername(username);
        user.setScore(score_total);
        back.putExtra(MainActivity.EXTRA_OBJECT_USER, user);
        startActivity(back);
        finish();
    }

    private void startGame(){
        number1 = rand.nextInt(100);
        number2 = rand.nextInt(100);
        result = 0;
        score_total = 0;

        operation.setText(number1 + " + "+ number2 + " = ");

        btn_1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                result = result*10 + 1;
                operation.setText(number1 + " + "+ number2 + " = " + result);
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                result = result*10 + 2;
                operation.setText(number1 + " + "+ number2 + " = " + result);
            }
        });

        btn_3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                result = result*10 + 3;
                operation.setText(number1 + " + "+ number2 + " = " + result);
            }
        });

        btn_4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                result = result*10 + 4;
                operation.setText(number1 + " + "+ number2 + " = " + result);
            }
        });

        btn_5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                result = result*10 + 5;
                operation.setText(number1 + " + "+ number2 + " = " + result);
            }
        });

        btn_6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                result = result*10 + 6;
                operation.setText(number1 + " + "+ number2 + " = " + result);
            }
        });

        btn_7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                result = result*10 + 7;
                operation.setText(number1 + " + "+ number2 + " = " + result);
            }
        });

        btn_8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                result = result*10 + 8;
                operation.setText(number1 + " + "+ number2 + " = " + result);
            }
        });

        btn_9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                result = result*10 + 9;
                operation.setText(number1 + " + "+ number2 + " = " + result);
            }
        });

        btn_0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                result = result*10;
                operation.setText(number1 + " + "+ number2 + " = " + result);
            }
        });

        btn_erase.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(result >= 10){
                    result = (result-(result%10))/10;
                    operation.setText(number1 + " + "+ number2 + " = " + result);
                }else{
                    result = 0;
                    operation.setText(number1 + " + "+ number2 + " = ");
                }
            }
        });

        btn_submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(result == (number1+number2)){
                    score_total += 10;
                }else{
                    score_total -= 10;
                }
                score.setText("Score: "+ score_total);

                number1 = rand.nextInt(100);
                number2 = rand.nextInt(100);
                result = 0;
                operation.setText(number1 + " + "+ number2 + " = ");
            }
        });
    }
}