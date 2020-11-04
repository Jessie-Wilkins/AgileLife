package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.actual.myapplication.StoryBuilder;
import com.actual.myapplication.StoryManager;

public class EditStoryMenu extends AppCompatActivity {
    EditText editPoints;
    EditText editDescription;
    EditText editTitle;
    StoryManager storyManager;
    StoryBuilder storyBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_story_menu);
        storyManager = StoryManager.getExistingStoryManager();
        getStoryPoints();
        getStoryDescription();
        getStoryTitle();
    }

    protected void getStoryPoints() {
        editPoints = findViewById(R.id.editPointsAgain);
        if(storyManager.getStoriesIds().length > 0) {
            editPoints.setText(String.valueOf(storyManager.getStory(1).getPointsManagement().getPoints()));
        }
    }

    protected void getStoryDescription() {
        if (storyManager.getStoriesIds().length > 0) {
            editDescription = findViewById(R.id.editDescriptionAgain);
            editDescription.setText(storyManager.getStory(1).getDescription());
        }
    }

    protected void getStoryTitle() {
        if (storyManager.getStoriesIds().length > 0) {
            editTitle = findViewById(R.id.editTitleAgain);
            editTitle.setText(storyManager.getStory(1).getTitle());
        }
    }

    public void changeStoryAttributes(View view) {
        storyBuilder = StoryBuilder.initiateBuilder();
        setStoryDescription();
        setStoryPoints();
        setStoryTitle();
        storyManager.getStory(1).setChangedStoryAttributes(storyBuilder);
    }

    private void setStoryPoints() {
        editPoints = findViewById(R.id.editPointsAgain);
        if(!editPoints.getText().toString().trim().isEmpty()) {
            storyBuilder.setPoints(Integer.parseInt(editPoints.getText().toString()));
        }
    }

    private void setStoryDescription() {
        editDescription = findViewById(R.id.editDescriptionAgain);
        if(!editDescription.getText().toString().trim().isEmpty()) {
            storyBuilder.setDescription(editDescription.getText().toString());
        }
    }

    private void setStoryTitle() {
        editDescription = findViewById(R.id.editTitleAgain);
        if(!editTitle.getText().toString().trim().isEmpty()) {
            storyBuilder.setTitle(editTitle.getText().toString());
        }
    }
}
