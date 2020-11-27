package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.actual.myapplication.SprintManager;

public class ViewCurrentSprintMenu extends AppCompatActivity {

    SprintManager sprintManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_current_sprint_menu);
        retrieveSprintAttributes();
    }

    private void retrieveSprintAttributes() {
        sprintManager = SprintManager.getExistingSprintManager();
        retrieveSprintTitle();
        retrieveSprintCapacity();
        retrieveSprintFrequency();
        retrieveSprintLength();
        retrieveSprintTotalPoints();
        retrieveSprintTotalCompletedPoints();
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
}
