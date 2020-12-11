package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.actual.myapplication.Story;
import com.actual.myapplication.StoryManager;

import java.util.ArrayList;

public class ViewCurrentStoryMenu extends AppCompatActivity {

    StoryManager storyManager;
    long storyId;
    TextView editTitle;
    private Spinner spinner;
    private ArrayAdapter<String> arrayAdapter;
    private ArrayList<String> arrayList;

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

    public void completeGivenNumberOfPoints(View view) {
        EditText completeNumberOfPoints = findViewById(R.id.viewCurrentStoryCompletedPointsEditText);
        int completePoints = Integer.parseInt(completeNumberOfPoints.getText().toString());
        storyManager.getStory(storyId).getPointsManagement().completePoints(completePoints);
        goToViewCurrentStoryMenu(view);
    }

    private void goToViewCurrentStoryMenu(View view) {
        Intent myIntent = new Intent(view.getContext(), ViewCurrentStoryMenu.class);
        Bundle bundle = new Bundle();
        placeStoryIdInBundle(myIntent, bundle);
        startActivityForResult(myIntent, 0);
    }

    private void placeStoryIdInBundle(Intent myIntent, Bundle bundle) {
       int storyId = getIntent().getExtras().getInt("storyId");
        bundle.putInt("storyId", storyId);
        myIntent.putExtras(bundle);
    }

    private void populateStoryStatusSpinner() {
        spinner = findViewById(R.id.viewCurrentStoryStatusSpinner);
        setArrayAdapterForSpinner();
        //spinner.setOnItemSelectedListener(new AddStoryToSprintStorySpinner());
    }

    private void statusAdd() {
        arrayList = new ArrayList<>();
        for (Enum<Story.StoryStatus> storyStatus : Story.StoryStatus.values()) {
            arrayList.add(storyStatus.toString());
        }
    }

    private void setArrayAdapterForSpinner() {
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
    }


}
