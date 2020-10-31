package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import com.actual.myapplication.StoryBuilder;
import com.actual.myapplication.StoryManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddStoryMenu extends AppCompatActivity {

    private StoryManager storyManager = StoryManager.initiateStoryManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_story_menu);
    }

    public void addStory(View view) {

        StoryBuilder storyBuilder = StoryBuilder.initiateBuilder();

        addPoints(storyBuilder);

        addTitle(storyBuilder);

        addDescription(storyBuilder);

        storyManager.addStory(storyBuilder);

        Intent myIntent = new Intent(view.getContext(), MainMenu.class);
        startActivityForResult(myIntent, 0);
    }

    private void addDescription(StoryBuilder storyBuilder) {
        EditText editDescription = findViewById(R.id.editDescription);

        if(editDescription.getText().toString() != null && !editDescription.getText().toString().isEmpty()) {
            storyBuilder.setDescription(editDescription.getText().toString());
        }

        else {
            System.out.println("Description was not successfully added");
        }
    }

    private void addTitle(StoryBuilder storyBuilder) {
        EditText editTitle = findViewById(R.id.editTitle);

        if(editTitle.getText().toString() != null && !editTitle.getText().toString().isEmpty()) {
            storyBuilder.setTitle(editTitle.getText().toString());
        }

        else {
            System.out.println("Title was not successfully added");
        }
    }

    private void addPoints(StoryBuilder storyBuilder) {
        EditText editPoints = findViewById(R.id.editPoints);

        if(editPoints.getText().toString() != null && !editPoints.getText().toString().isEmpty()) {
            storyBuilder.setPoints(Integer.parseInt(editPoints.getEditableText().toString()));
        }

        else {
            System.out.println("Points were not successfully added");
        }
    }
}
