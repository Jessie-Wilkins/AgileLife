package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.actual.myapplication.StoryBuilder;
import com.actual.myapplication.StoryManager;


public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_main);
    }

    public void goToAddNewStoryMenu(View view) {
        Intent myIntent = new Intent(view.getContext(), AddStoryMenu.class);
        startActivityForResult(myIntent, 0);

    }

    public void goToEditStoryMenu(View view) {
        Intent myIntent = new Intent(view.getContext(), EditStoryMenu.class);
        startActivityForResult(myIntent, 0);
    }
}