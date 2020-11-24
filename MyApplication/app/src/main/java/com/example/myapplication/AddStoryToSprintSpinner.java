package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

public class AddStoryToSprintSpinner extends Activity implements AdapterView.OnItemSelectedListener {


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        AddStoryToSprintMenu.sprintOrStoryId = position;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
