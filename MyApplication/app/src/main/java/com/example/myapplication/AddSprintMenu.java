package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.actual.myapplication.SprintBuilder;
import com.actual.myapplication.SprintManager;

public class AddSprintMenu extends AppCompatActivity {

    SprintManager sprintManager = SprintManager.initiateSprintManager();;

    SprintBuilder sprintBuilder = SprintBuilder.initiateSprintBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sprint_menu);
    }

    public void addSprint(View view) {
        addSprintTitle();
        addSprintLength();
        addSprintFrequency();
        addSprintCapacity();
        sprintManager.addSprint(sprintBuilder);
    }

    private void addSprintTitle() {
        EditText editTitle = findViewById(R.id.addSprintTitleEditText);

        determineIfValueCanBeAdded(editTitle);
    }

    private void addSprintLength() {
        EditText editLength = findViewById(R.id.addSprintLengthEditText);

        determineIfValueCanBeAdded(editLength);
    }

    private void addSprintFrequency() {
        EditText editFrequency = findViewById(R.id.addSprintFrequencyEditText);

        determineIfValueCanBeAdded(editFrequency);
    }

    private void addSprintCapacity() {
        EditText editCapacity = findViewById(R.id.addSprintCapacityEditText);

        determineIfValueCanBeAdded(editCapacity);
    }

    private void determineIfValueCanBeAdded(EditText editText) {

        if(editText.getText().toString() != null && !editText.getText().toString().isEmpty()) {

            if(editText.getId() == R.id.addSprintTitleEditText) {
                sprintBuilder.setLabel(editText.getText().toString());
            }

            else if(editText.getId() == R.id.addSprintLengthEditText) {
                sprintBuilder.setLength(Integer.parseInt(editText.getText().toString()));
            }

            else if(editText.getId() == R.id.addSprintFrequencyEditText) {
                sprintBuilder.setFrequency(Integer.parseInt(editText.getText().toString()));
            }

            else if(editText.getId() == R.id.addSprintCapacityEditText) {
                sprintBuilder.setCapacity(Integer.parseInt(editText.getText().toString()));
            }
        }
    }
}
