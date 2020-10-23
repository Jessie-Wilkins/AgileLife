package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import com.actual.myapplication.StoryBuilder;
import com.actual.myapplication.StoryManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_main);
    }

    public void goToAddNewStoryMenu(View view) {
        Intent myIntent = new Intent(view.getContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
    }
}
