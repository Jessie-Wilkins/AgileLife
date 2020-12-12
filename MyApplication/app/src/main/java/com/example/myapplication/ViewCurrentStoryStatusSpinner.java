package com.example.myapplication;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;

import com.actual.myapplication.Story;
import com.actual.myapplication.StoryBuilder;
import com.actual.myapplication.StoryManager;

public class ViewCurrentStoryStatusSpinner extends Activity implements AdapterView.OnItemSelectedListener {

    private static long storyId;

    private StoryManager storyManager;

    private StoryBuilder storyBuilder;

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String status =  parent.getItemAtPosition(position).toString();

        setUpStoryManagerAndBuilder();

        setStoryStatusToSelected(status);

    }

    private void setStoryStatusToSelected(String status) {
        storyBuilder.setStatus(Story.StoryStatus.valueOf(status));

        storyManager.getStory(storyId).setChangedStoryAttributes(storyBuilder);
    }

    private void setUpStoryManagerAndBuilder() {
        storyManager = StoryManager.getExistingStoryManager();

        storyBuilder = StoryBuilder.initiateBuilder();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public static void setStoryId(long id) {
        storyId = id;
    }
}
