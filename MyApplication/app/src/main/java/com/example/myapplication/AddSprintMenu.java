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
        sprintManager.addSprint(sprintBuilder);
    }

    private void addSprintTitle() {
        EditText editDescription = findViewById(R.id.addSprintTitleEditText);

        if(editDescription.getText().toString() != null && !editDescription.getText().toString().isEmpty()) {
            sprintBuilder.setLabel(editDescription.getText().toString());
        }

        else {
            System.out.println("Description was not successfully added");
        }
    }

    private void addSprintLength() {
        EditText editDescription = findViewById(R.id.addSprintLengthEditText);

        if(editDescription.getText().toString() != null && !editDescription.getText().toString().isEmpty()) {
            sprintBuilder.setLength(Integer.parseInt(editDescription.getText().toString()));
        }

        else {
            System.out.println("Description was not successfully added");
        }
    }
}
