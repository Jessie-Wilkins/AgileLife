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
    StoryManager storyManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_story_menu);
        editPoints = findViewById(R.id.editPointsAgain);
        storyManager = StoryManager.getExistingStoryManager();
        if(storyManager.getStoriesIds().length > 0) {
            editPoints.setText(String.valueOf(storyManager.getStory(1).getPointsManagement().getPoints()));
        }
        else {
            editPoints.setText("7");
        }

    }

    public void getPoints() {

    }
}
