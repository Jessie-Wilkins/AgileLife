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
        storyManager = StoryManager.getExistingStoryManager();
        storyId = getIntent().getExtras().getInt("storyId");
        getStoryTitle();
    }

    protected void getStoryTitle() {
        if (storyManager.getStoriesIds().length > 0) {
            editTitle = findViewById(R.id.viewCurrentStoryTitleTextView);
            editTitle.setText(storyManager.getStory(storyId).getTitle());
        }
    }
}
