package com.actual.myapplication.Theories;

import com.actual.myapplication.StoryManager;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import org.junit.runner.RunWith;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitQuickcheck.class)
public class StoryManagerTheories {

    @Property public void testThatStoriesDeletedKeepTheSameIdEveryTime(@InRange(minInt = 1, maxInt = 9999999)int amount_of_times_to_generate) {

        StoryManager story_mgr = StoryManager.initiateStoryManager();

        long story_id;

        long deleted_id;

        for(int i = 0; i<amount_of_times_to_generate; i++) {
            story_mgr.addStory();
        }

        long [] array = story_mgr.getStoriesIds();

        story_id = array[(array.length-1)];

        story_mgr.deleteStory(story_id);

        array = story_mgr.getDeletedStoriesIds();

        deleted_id = array[(array.length-1)];

        assertEquals(story_id, deleted_id);

    }

}
