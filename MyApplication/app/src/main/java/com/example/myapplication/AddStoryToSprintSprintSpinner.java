package com.example.myapplication;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;

public class AddStoryToSprintSprintSpinner extends Activity implements AdapterView.OnItemSelectedListener {


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        AddStoryToSprintMenu.setSprintId(position+1);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
