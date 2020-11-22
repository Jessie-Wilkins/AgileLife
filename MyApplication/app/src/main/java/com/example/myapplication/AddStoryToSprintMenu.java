package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import com.actual.myapplication.SprintManager;

import java.util.ArrayList;

public class AddStoryToSprintMenu extends AppCompatActivity {

    Spinner spinner;

    SprintManager sprintManager = SprintManager.getExistingSprintManager();

    ArrayAdapter<String> arrayAdapter;

    ArrayList<String> arrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_story_to_sprint_menu);
        populateSprintSpinner();
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

}
