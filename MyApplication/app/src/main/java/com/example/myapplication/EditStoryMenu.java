package com.example.myapplication;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.actual.myapplication.StoryBuilder;
import com.actual.myapplication.StoryManager;

public class EditStoryMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_story_menu);

    }

    @Override
    protected void onPostResume() {
        getPoints();
        super.onPostResume();

    }

    public void getPoints() {

        StoryManager storyManager = StoryManager.initiateStoryManager();

        StoryBuilder storyBuilder = StoryBuilder.initiateBuilder();
        storyBuilder.setPoints(8);

        storyManager.addStory(storyBuilder);

        EditText editPoints = findViewById(R.id.editPointsAgain);

        editPoints.setText(storyManager.getStory(1).getPointsManagement().getPoints());
    }
}
