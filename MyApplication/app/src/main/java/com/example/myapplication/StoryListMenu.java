package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.actual.myapplication.Story;
import com.actual.myapplication.StoryManager;

import java.util.ArrayList;

public class StoryListMenu extends AppCompatActivity {

    ListView listView;

    StoryManager storyManager = StoryManager.getExistingStoryManager();

    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_list);
        listView = findViewById(R.id.storyListView);
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add(storyManager.getStory(1).getTitle());

        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);

        listView.setAdapter(arrayAdapter);

        arrayAdapter.notifyDataSetChanged();

    }
}
