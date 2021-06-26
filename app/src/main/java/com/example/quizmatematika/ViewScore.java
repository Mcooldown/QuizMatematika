package com.example.quizmatematika;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.quizmatematika.model.User;

import java.util.ArrayList;

public class ViewScore extends AppCompatActivity {

    private RecyclerView rv_user;
    private static ArrayList<User> users = new ArrayList<>();
    private UserAdapter userAdapter;
    public static final String EXTRA_OBJECT_USER = "extraUser";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_score);
        rv_user = findViewById(R.id.rv_user);

        Intent pass = getIntent();
        if(pass.hasExtra(EXTRA_OBJECT_USER)){
            users = (ArrayList<User>) pass.getSerializableExtra(EXTRA_OBJECT_USER);
            userAdapter = new UserAdapter(users);
            rv_user.setAdapter(userAdapter);
            rv_user.setLayoutManager(new LinearLayoutManager(this));
        }
    }
}