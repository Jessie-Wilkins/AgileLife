package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.actual.myapplication.SprintManager;
import com.actual.myapplication.StoryManager;

import java.util.ArrayList;

public class AddStoryToSprintMenu extends AppCompatActivity {

    Spinner spinner;

    SprintManager sprintManager = SprintManager.getExistingSprintManager();

    StoryManager storyManager = StoryManager.getExistingStoryManager();

    ArrayAdapter<String> arrayAdapter;

    ArrayList<String> arrayList;

    public static int sprintOrStoryId;

    private int sprintId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_story_to_sprint_menu);
        populateSprintSpinner();
        populateStorySpinner();
    }

    public void addStoryToSprint() {
        spinner = findViewById(R.id.addStoryToSprintChooseSprintSpinner);
        spinner.setOnItemSelectedListener(new AddStoryToSprintSpinner());
        sprintId = sprintOrStoryId;
        spinner = findViewById(R.id.addStoryToSprintChooseSprintSpinner);
        spinner.setOnItemSelectedListener(new AddStoryToSprintSpinner());

    }

    private void populateSprintSpinner() {
        spinner = findViewById(R.id.addStoryToSprintChooseSprintSpinner);
        iterativeSprintAdd();
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
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
    }


    private void iterativeStoryAdd() {
        arrayList = new ArrayList<>();
        for (Long id : storyManager.getStoriesIds() ) {
            arrayList.add(storyManager.getStory(id).getTitle());
        }
    }

}
