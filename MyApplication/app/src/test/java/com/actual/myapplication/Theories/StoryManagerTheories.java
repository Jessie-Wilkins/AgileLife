package com.actual.myapplication.Theories;

import com.actual.myapplication.Story;
import com.actual.myapplication.StoryManager;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import org.junit.runner.RunWith;

import java.util.ArrayList;

@RunWith(JUnitQuickcheck.class)
public class StoryManagerTheories {

    private StoryManager story_mgr = StoryManager.initiateStoryManager();

    @Property public void testThatStoriesDeletedKeepTheSameIdEveryTime() {
        int id;

        story_mgr.addStory();
        long [] array = story_mgr.getStoriesIds();
    }

}
