package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.actual.myapplication.SprintManager;
import com.actual.myapplication.StoryManager;

import java.util.ArrayList;

public class SprintListMenu extends AppCompatActivity {

    ListView listView;

    SprintManager sprintManager = SprintManager.getExistingSprintManager();

    ArrayAdapter<String> arrayAdapter;

    ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sprint_list_menu);
        createSprintList();
    }

    private void createSprintList() {
        iterativeSprintAdd();
        addToAdapter();
    }

    private void addToAdapter() {
        listView = findViewById(R.id.sprintListView);
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                goToEditSprintMenu(view, position);
            }
        });
    }

    private void goToEditSprintMenu(View view, int position) {
        Intent myIntent = new Intent(view.getContext(), EditSprintMenu.class);
        Bundle bundle = new Bundle();
        bundle.putInt("sprintId", position+1);
        myIntent.putExtras(bundle);
        startActivityForResult(myIntent, 0);
    }


    private void iterativeSprintAdd() {
        arrayList = new ArrayList<>();
        int id = 1;
        while(sprintManager.getSprint(id) != null) {
            arrayList.add(sprintManager.getSprint(id).getLabel());
            id++;
        }
    }
}
