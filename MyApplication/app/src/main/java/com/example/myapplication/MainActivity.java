package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import com.actual.myapplication.StoryBuilder;
import com.actual.myapplication.StoryManager;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private StoryManager storyManager = StoryManager.initiateStoryManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addStoryPoints(View view) {

        StoryBuilder storyBuilder = StoryBuilder.initiateBuilder();

        EditText editPoints = findViewById(R.id.editPoints);

        System.out.println(editPoints.getText().toString());

        if(editPoints.getText().toString() != null && !editPoints.getText().toString().isEmpty()) {
            storyBuilder.setPoints(Integer.parseInt(editPoints.getEditableText().toString()));
            storyManager.addStory(storyBuilder);
            System.out.println("Added story #"+ storyManager.getStory(storyManager.getStoriesIds()[storyManager.getStoriesIds().length-1]).getId() +" with these points: "+storyManager.getStory(storyManager.getStoriesIds().length).getPointsManagement().getPoints());
        }

        else {
            System.out.println("Points were not successfully added");
        }
    }
}
