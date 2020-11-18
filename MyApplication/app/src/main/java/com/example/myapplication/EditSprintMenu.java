package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.actual.myapplication.SprintManager;

public class EditSprintMenu extends AppCompatActivity {

    EditText editInput;
    SprintManager sprintManager;
    int sprintId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_sprint_menu);
        sprintManager = SprintManager.getExistingSprintManager();
        sprintId = getIntent().getExtras().getInt("sprintId");
        getSprintAttributes();
    }

    protected void getSprintAttributes() {
        if (sprintId > 0) {
            getSprintLabel();
            getSprintFrequency();
            getSprintCapacity();
            getSprintLength();
        }
    }

    private void getSprintCapacity() {
        editInput = findViewById(R.id.editSprintCapacityEditText);
        editInput.setText(String.valueOf(sprintManager.getSprint(sprintId).getCapacity()));
    }

    private void getSprintLabel() {
        editInput = findViewById(R.id.editSprintTitleEditText);
        editInput.setText(sprintManager.getSprint(sprintId).getLabel());
    }

    private void getSprintFrequency() {
        editInput = findViewById(R.id.editSprintFrequencyEditText);
        editInput.setText(String.valueOf(sprintManager.getSprint(sprintId).getFrequencyInDays()));
    }

    private void getSprintLength() {
        editInput = findViewById(R.id.editSprintLengthEditText);
        editInput.setText(String.valueOf(sprintManager.getSprint(sprintId).getLength()));
    }

    public void changeStoryAttributes(View view) {
        setSprintCapacity();
        setSprintLabel();
        setSprintFrequency();
        setSprintLength();
        Intent myIntent = new Intent(view.getContext(), MainMenu.class);
        startActivityForResult(myIntent, 0);
    }

    private void setSprintCapacity() {
        editInput = findViewById(R.id.editSprintCapacityEditText);
        if(!editInput.getText().toString().trim().isEmpty()) {
            sprintManager.getSprint(sprintId).setCapacity(Integer.parseInt(editInput.getText().toString()));
        }
    }

    private void setSprintLabel() {
        editInput = findViewById(R.id.editSprintTitleEditText);
        if(!editInput.getText().toString().trim().isEmpty()) {
            sprintManager.getSprint(sprintId).setLabel(editInput.getText().toString());
        }
    }

    private void setSprintFrequency() {
        editInput = findViewById(R.id.editSprintFrequencyEditText);
        if(!editInput.getText().toString().trim().isEmpty()) {
            sprintManager.getSprint(sprintId).setFrequencyInDays(Integer.parseInt(editInput.getText().toString()));
        }
    }

    private void setSprintLength() {
        editInput = findViewById(R.id.editSprintLengthEditText);
        if(!editInput.getText().toString().trim().isEmpty()) {
            sprintManager.getSprint(sprintId).setLength(Integer.parseInt(editInput.getText().toString()));
        }
    }

}
