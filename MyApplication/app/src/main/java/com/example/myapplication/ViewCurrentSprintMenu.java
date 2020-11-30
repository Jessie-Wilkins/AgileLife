package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.actual.myapplication.SprintManager;
import com.actual.myapplication.StoryManager;

import java.util.ArrayList;

public class ViewCurrentSprintMenu extends AppCompatActivity {

    SprintManager sprintManager;

    StoryManager storyManager;

    ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_current_sprint_menu);
        retrieveSprintAttributes();
    }

    private void retrieveSprintAttributes() {
        sprintManager = SprintManager.getExistingSprintManager();
        storyManager = StoryManager.getExistingStoryManager();
        retrieveSprintTitle();
        retrieveSprintCapacity();
        retrieveSprintFrequency();
        retrieveSprintLength();
        retrieveSprintTotalPoints();
        retrieveSprintTotalCompletedPoints();
        retrieveSprintStories();
    }

    private void retrieveSprintTitle() {


        TextView viewCurrentSprintTitle = findViewById(R.id.viewCurrentSprintTitleTextView);

        viewCurrentSprintTitle.setText(new StringBuilder().append("Sprint Title:\n").append(sprintManager.getSprint(1).getLabel()).toString());
    }

    private void retrieveSprintCapacity() {
        SprintManager sprintManager = SprintManager.getExistingSprintManager();

        TextView viewCurrentSprintCapacity = findViewById(R.id.viewCurrentSprintCapacityTextView);

        viewCurrentSprintCapacity.setText(new StringBuilder().append("Sprint Capacity:\n").append(sprintManager.getSprint(1).getCapacity()).toString());
    }

    private void retrieveSprintFrequency() {
        SprintManager sprintManager = SprintManager.getExistingSprintManager();

        TextView viewCurrentSprintFrequency = findViewById(R.id.viewCurrentSprintFrequencyTextView);

        viewCurrentSprintFrequency.setText(new StringBuilder().append("Sprint Frequency:\n").append(sprintManager.getSprint(1).getFrequencyInDays()).toString());
    }

    private void retrieveSprintLength() {
        SprintManager sprintManager = SprintManager.getExistingSprintManager();

        TextView viewCurrentSprintLength = findViewById(R.id.viewCurrentSprintLengthTextView);

        viewCurrentSprintLength.setText(new StringBuilder().append("Sprint Length:\n").append(sprintManager.getSprint(1).getLength()).toString());
    }

    private void retrieveSprintTotalPoints() {
        SprintManager sprintManager = SprintManager.getExistingSprintManager();

        TextView viewCurrentSprintLength = findViewById(R.id.viewCurrentSprintTotalPointsTextView);

        viewCurrentSprintLength.setText(new StringBuilder().append("Sprint Total Points:\n").append(sprintManager.getSprint(1).getTotalAssignedPoints()).toString());
    }

    private void retrieveSprintTotalCompletedPoints() {
        SprintManager sprintManager = SprintManager.getExistingSprintManager();

        TextView viewCurrentSprintLength = findViewById(R.id.viewCurrentSprintTotalCompletedPointsTextView);

        viewCurrentSprintLength.setText(new StringBuilder().append("Sprint Total Completed Points:\n").append(sprintManager.getSprint(1).getTotalCompletedPoints()).toString());
    }

    private void retrieveSprintStories() {
        iterativeStoryAdd();
        addToAdapter();
    }

    private void addToAdapter() {
        ListView listView = findViewById(R.id.viewCurrentSprintStoriesListView);
        ArrayAdapter arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                goToViewCurrentStoryMenu(view, position);
            }
        });
    }

    private void iterativeStoryAdd() {
        arrayList = new ArrayList<>();
        for(long id : storyManager.getStoriesIds()) {
            arrayList.add(storyManager.getStory(id).getTitle());
        }
    }

    private void goToViewCurrentStoryMenu(View view, int position) {
        Intent myIntent = new Intent(view.getContext(), ViewCurrentStoryMenu.class);
        Bundle bundle = new Bundle();
        bundle.putInt("storyId", position+1);
        myIntent.putExtras(bundle);
        startActivityForResult(myIntent, 0);
    }
}
