package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.actual.myapplication.SprintManager;

public class EditSprintMenu extends AppCompatActivity {

    EditText editLabel;
    SprintManager sprintManager;
    int sprintId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_sprint_menu);
        sprintManager = SprintManager.getExistingSprintManager();
        sprintId = getIntent().getExtras().getInt("sprintId");
        getSprintLabel();
    }

    protected void getSprintLabel() {
        if (sprintId > 0) {
            editLabel = findViewById(R.id.editSprintTitleEditText);
            editLabel.setText(sprintManager.getSprint(sprintId).getLabel());
        }
    }
}
