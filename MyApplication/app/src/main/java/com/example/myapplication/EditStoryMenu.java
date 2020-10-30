package com.example.myapplication;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.actual.myapplication.StoryBuilder;
import com.actual.myapplication.StoryManager;

public class EditStoryMenu extends AppCompatActivity {
    EditText editPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_story_menu);
        StoryManager storyManager = StoryManager.getExistingStoryManager();
        editPoints = findViewById(R.id.editPointsAgain);
        editPoints.setText("7");
    }

    public void getPoints() {

    }
}
