package com.example.myapplication;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.actual.myapplication.StoryManager;

public class EditStoryMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StoryManager storyManager = StoryManager.getExistingStoryManager();
        EditText editPointsAgain = findViewById(R.id.editPointsAgain);
        editPointsAgain.setText(storyManager.getStory(1).getPointsManagement().getPoints());
        setContentView(R.layout.activity_edit_story_menu);
    }
}
