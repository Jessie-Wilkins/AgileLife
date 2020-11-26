package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.actual.myapplication.SprintManager;
import com.actual.myapplication.StoryManager;

import java.util.ArrayList;

public class AddStoryToSprintMenu extends AppCompatActivity {

    private Spinner spinner;

    private SprintManager sprintManager = SprintManager.getExistingSprintManager();

    private StoryManager storyManager = StoryManager.getExistingStoryManager();

    private ArrayAdapter<String> arrayAdapter;

    private ArrayList<String> arrayList;

    private static int sprintId;

    private static int storyId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_story_to_sprint_menu);
        populateSprintSpinner();
        populateStorySpinner();
    }

    public void addStoryToSprint(View view) {
        storyManager.getStory(getStoryId()).setSprintTitleAndId(sprintManager.getSprint(getSprintId()).getIdPlusLabel());
        goToMainMenu(view);
    }

    private void goToMainMenu(View view) {
        Intent myIntent = new Intent(view.getContext(), MainMenu.class);
        startActivityForResult(myIntent, 0);
    }

    public static int getSprintId() {
        return sprintId;
    }

    public static void setSprintId(int sprintId) {
        AddStoryToSprintMenu.sprintId = sprintId;
    }

    public static int getStoryId() {
        return storyId;
    }

    public static void setStoryId(int storyId) {
        AddStoryToSprintMenu.storyId = storyId;
    }


    private void populateSprintSpinner() {
        spinner = findViewById(R.id.addStoryToSprintChooseSprintSpinner);
        iterativeSprintAdd();
        setArrayAdapterForSpinner();
        spinner.setOnItemSelectedListener(new AddStoryToSprintSprintSpinner());
    }

    private void setArrayAdapterForSpinner() {
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
    }

    private void iterativeSprintAdd() {
        arrayList = new ArrayList<>();
        int id = 1;
        while (sprintManager.getSprint(id) != null) {
            arrayList.add(sprintManager.getSprint(id).getLabel());
            id++;
        }
    }

    private void populateStorySpinner() {
        spinner = findViewById(R.id.addStoryToSprintChooseStorySpinner);
        iterativeStoryAdd();
        setArrayAdapterForSpinner();
        spinner.setOnItemSelectedListener(new AddStoryToSprintStorySpinner());
    }

    private void iterativeStoryAdd() {
        arrayList = new ArrayList<>();
        for (Long id : storyManager.getStoriesIds() ) {
            arrayList.add(storyManager.getStory(id).getTitle());
        }
    }

}
