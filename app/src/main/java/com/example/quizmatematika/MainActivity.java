package com.example.quizmatematika;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizmatematika.model.User;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btn_play;
    private Button btn_score;
    private EditText username;
    private TextView test;
    public static final String EXTRA_OBJECT_USER = "extraUser";
    public static ArrayList<User> users = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_play = findViewById(R.id.btn_play);
        btn_score = findViewById(R.id.btn_score);
        username = findViewById(R.id.username);

        Intent intent_pass = getIntent();
        if(intent_pass.hasExtra(EXTRA_OBJECT_USER)){
            User new_user = (User)getIntent().getSerializableExtra(EXTRA_OBJECT_USER);
            users.add(new_user);
        }

        btn_play.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(validateUsername()){
                    Intent intent = new Intent(MainActivity.this, PlayActivity.class);

                    User user = new User();
                    user.setUsername(username.getText().toString());
                    intent.putExtra(PlayActivity.EXTRA_OBJECT_USER,user);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(MainActivity.this, "Please input your name", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, ViewScore.class);
                intent2.putExtra(ViewScore.EXTRA_OBJECT_USER, users);
                startActivity(intent2);
            }
        });
    }

    private boolean validateUsername(){
        if(username.getText().toString().equals(""))return false;
        else return true;
    }
}