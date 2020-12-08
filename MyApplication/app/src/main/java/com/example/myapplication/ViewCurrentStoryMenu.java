package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.actual.myapplication.StoryManager;

public class ViewCurrentStoryMenu extends AppCompatActivity {

    StoryManager storyManager;
    long storyId;
    TextView editTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_current_story_menu);
        getStoryValues();
    }

    private void getStoryValues() {
        initiateStoryValues();
        getStoryTitle();
        getStoryPoints();
        getStoryDescription();
        getWorkableStoryPoints();
        getCompletedStoryPoints();
    }

    private void initiateStoryValues() {
        storyManager = StoryManager.getExistingStoryManager();
        storyId = getIntent().getExtras().getInt("storyId");
    }

    protected void getStoryTitle() {
        if (storyManager.getStoriesIds().length > 0) {
            editTitle = findViewById(R.id.viewCurrentStoryTitleTextView);
            editTitle.setText(storyManager.getStory(storyId).getTitle());
        }
    }

    private void getStoryPoints() {
        editTitle = findViewById(R.id.viewCurrentStoryTotalPointsTextView);
        editTitle.setText("Total Points:\n"+Integer.toString(storyManager.getStory(storyId).getPointsManagement().getTotalPoints()));
    }

    private void getStoryDescription() {
        editTitle = findViewById(R.id.viewCurrentStoryDescriptionTextView);
        editTitle.setText("Description:\n"+storyManager.getStory(storyId).getDescription());
    }

    private void getWorkableStoryPoints() {
        editTitle = findViewById(R.id.viewCurrentStoryWorkablePointsTextView);
        editTitle.setText("Points Left:\n"+Integer.toString(storyManager.getStory(storyId).getPointsManagement().getPoints()));
    }

    private void getCompletedStoryPoints() {
        editTitle = findViewById(R.id.viewCurrentStoryCompletedPointsTextView);
        editTitle.setText("Points Completed:\n"+Integer.toString(storyManager.getStory(storyId).getPointsManagement().getCompletedPoints()));
    }
}
