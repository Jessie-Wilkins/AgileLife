package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import com.actual.myapplication.StoryBuilder;
import com.actual.myapplication.StoryManager;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addStoryPoints(View view) {
        StoryManager storyManager = StoryManager.initiateStoryManager();

        StoryBuilder storyBuilder = StoryBuilder.initiateBuilder();

        storyBuilder.setPoints(1);

        storyManager.addStory(storyBuilder);

        System.out.println("Added story #"+ storyManager.getStory(storyManager.getStoriesIds().length).getId() +" with these points: "+storyManager.getStory(storyManager.getStoriesIds().length).getPointsManagement().getPoints());
    }
}
