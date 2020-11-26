package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.actual.myapplication.SprintManager;

public class ViewCurrentSprintMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_current_sprint_menu);
        retrieveSprint();
    }

    private void retrieveSprint() {
        SprintManager sprintManager = SprintManager.getExistingSprintManager();

        TextView viewCurrentSprintTitle = findViewById(R.id.viewCurrentSprintTitleTextView);

        viewCurrentSprintTitle.setText(sprintManager.getSprint(1).getLabel());
    }
}
