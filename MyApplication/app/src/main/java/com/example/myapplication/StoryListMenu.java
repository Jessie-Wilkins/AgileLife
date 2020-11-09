package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.actual.myapplication.StoryManager;

import java.util.ArrayList;

public class StoryListMenu extends AppCompatActivity {

    ListView listView;

    StoryManager storyManager = StoryManager.getExistingStoryManager();

    ArrayAdapter<String> arrayAdapter;

    ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_list);
        createStoryList();

    }

    private void createStoryList() {
        iterativeStoryAdd();
        addToAdapter();
    }

    private void addToAdapter() {
        listView = findViewById(R.id.storyListView);
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                goToEditStoryMenu(view, position);
            }
        });
    }

    private void goToEditStoryMenu(View view, int position) {
        Intent myIntent = new Intent(view.getContext(), EditStoryMenu.class);
        Bundle bundle = new Bundle();
        bundle.putInt("storyId", position+1);
        myIntent.putExtras(bundle);
        startActivityForResult(myIntent, 0);
    }

    private void iterativeStoryAdd() {
        arrayList = new ArrayList<>();
        for(long id : storyManager.getStoriesIds()) {
            arrayList.add(storyManager.getStory(id).getTitle());
        }
    }
}
