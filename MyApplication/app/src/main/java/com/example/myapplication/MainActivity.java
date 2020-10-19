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

    public void addStory(View view) {

        StoryBuilder storyBuilder = StoryBuilder.initiateBuilder();

        EditText editPoints = findViewById(R.id.editPoints);

        EditText editTitle = findViewById(R.id.editTitle);

        System.out.println(editPoints.getText().toString());

        if(editPoints.getText().toString() != null && !editPoints.getText().toString().isEmpty()) {
            storyBuilder.setPoints(Integer.parseInt(editPoints.getEditableText().toString()));
        }

        else {
            System.out.println("Points were not successfully added");
        }

        if(editTitle.getText().toString() != null && !editTitle.getText().toString().isEmpty()) {
            storyBuilder.setTitle(editTitle.getText().toString());
        }

        else {
            System.out.println("Title was not successfully added");
        }

        storyManager.addStory(storyBuilder);

        if(storyManager.getStory(storyManager.getStoriesIds()[storyManager.getStoriesIds().length-1])!= null) {
            System.out.print("Added story #"+ storyManager.getStory(storyManager.getStoriesIds()[storyManager.getStoriesIds().length-1]).getId());
        }

        if(storyManager.getStory(storyManager.getStoriesIds()[storyManager.getStoriesIds().length-1]).getPointsManagement().getPoints() != 0) {
            System.out.println(" with these points: "+storyManager.getStory(storyManager.getStoriesIds().length).getPointsManagement().getPoints());
        }

        if(storyManager.getStory(storyManager.getStoriesIds()[storyManager.getStoriesIds().length-1]).getTitle() != null) {
            System.out.println(" with this title: "+storyManager.getStory(storyManager.getStoriesIds().length).getTitle());
        }

    }
}
