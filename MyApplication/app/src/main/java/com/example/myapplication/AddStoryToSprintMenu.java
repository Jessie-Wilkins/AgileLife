package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.actual.myapplication.SprintManager;

import java.util.ArrayList;

public class AddStoryToSprintMenu extends AppCompatActivity {

    ListView listView;

    SprintManager sprintManager = SprintManager.getExistingSprintManager();

    ArrayAdapter<String> arrayAdapter;

    ArrayList<String> arrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_story_to_sprint_menu);
    }

    public void populateSprintSpinner(View view) {
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, arrayList);
    }


}
