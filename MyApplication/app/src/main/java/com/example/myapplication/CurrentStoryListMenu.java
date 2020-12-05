package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.actual.myapplication.SprintManager;
import com.actual.myapplication.Story;
import com.actual.myapplication.StoryManager;

import java.util.ArrayList;

public class CurrentStoryListMenu extends AppCompatActivity {

    StoryManager storyManager;
    SprintManager sprintManager;
    ArrayList<String> arrayList;
    int sprintId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_story_list_menu);
        sprintId = getIntent().getExtras().getInt("sprintId");
        storyManager = StoryManager.getExistingStoryManager();
        sprintManager = SprintManager.getExistingSprintManager();
        retrieveSprintStories();
    }

    private void retrieveSprintStories() {
        iterativeStoryAdd();
        addToAdapter();
    }

    private void addToAdapter() {
        ListView listView = findViewById(R.id.viewCurrentStoryListView);
        ArrayAdapter arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();
        setTheCurrentStoryListener(listView);
    }

    private void setTheCurrentStoryListener(ListView listView) {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                goToViewCurrentStoryMenu(view, position);
            }
        });
    }

    private void iterativeStoryAdd() {
        arrayList = new ArrayList<>();
        for(Story story: sprintManager.getSprint(sprintId).getStoryList()) {
            arrayList.add(story.getTitle());
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
