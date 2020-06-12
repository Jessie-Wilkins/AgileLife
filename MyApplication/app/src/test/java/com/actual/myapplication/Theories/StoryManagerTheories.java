package com.actual.myapplication.Theories;

import com.actual.myapplication.Story;
import com.actual.myapplication.StoryBuilder;
import com.actual.myapplication.StoryManager;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import org.junit.runner.RunWith;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitQuickcheck.class)
public class StoryManagerTheories {

    @Property public void testThatStoriesDeletedKeepTheSameIdEveryTime(@InRange(minInt = 1, maxInt = 999999)int amount_of_times_to_generate) {

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

        deleted_id = array[0];

        assertEquals(story_id, deleted_id);

    }

    @Property public void testThatStoriesUndeletedKeepTheSameIdEveryTime(@InRange(minInt = 1, maxInt = 999999)int amount_of_times_to_generate) {
        StoryManager story_mgr = StoryManager.initiateStoryManager();

        long story_id;

        long deleted_id;

        long undeleted_id;

        for(int i = 0; i<amount_of_times_to_generate; i++) {
            story_mgr.addStory();
        }

        long [] array = story_mgr.getStoriesIds();

        story_id = array[(array.length-1)];

        story_mgr.deleteStory(story_id);

        array = story_mgr.getDeletedStoriesIds();

        deleted_id = array[0];

        story_mgr.retrieveStoryFromDeletedStoryList(deleted_id);

        array = story_mgr.getStoriesIds();

        undeleted_id = array[(array.length-1)];

        assertEquals(deleted_id, undeleted_id);
    }

    @Property public void testThatStoriesCompletedKeepTheSameIdEveryTime(@InRange(minInt = 1, maxInt = 999999) int amount_of_times_to_generate) {
        StoryManager story_mgr = StoryManager.initiateStoryManager();

        long story_id;

        long completed_id;

        for(int i = 0; i<amount_of_times_to_generate; i++) {
            story_mgr.addStory();
        }

        long [] array = story_mgr.getStoriesIds();

        story_id = array[(array.length-1)];

        story_mgr.completeStory(story_id);

        array = story_mgr.getCompletedStoriesIds();

        completed_id = array[0];

        assertEquals(story_id, completed_id);
    }

    @Property public void testThatStoriesReturnedFromCompletedKeepTheSameIdEveryTime(@InRange(minInt = 1, maxInt = 999999) int amount_of_times_to_generate) {
        StoryManager story_mgr = StoryManager.initiateStoryManager();

        long story_id;

        long completed_id;

        long uncompleted_id;

        for(int i = 0; i<amount_of_times_to_generate; i++) {
            story_mgr.addStory();
        }

        long [] array = story_mgr.getStoriesIds();

        story_id = array[(array.length-1)];

        story_mgr.completeStory(story_id);

        array = story_mgr.getCompletedStoriesIds();

        completed_id = array[0];

        story_mgr.retrieveStoryFromCompletedStoryList(completed_id);

        array = story_mgr.getStoriesIds();

        uncompleted_id = array[(array.length-1)];

        assertEquals(completed_id, uncompleted_id);
    }

    @Property public void testThatCreatingAStoryWithABuilderAllowsStoryToReturnSameAssignedValuesEveryTime(String title, String description, @InRange(minInt = 1, maxInt = 999999) int points, Story.StoryStatus status, String sprint_title, @InRange(minInt = 1, maxInt = 999999) int completed_points) {

        StoryBuilder.resetBuilderAsUninitiated();
        StoryBuilder story_builder = StoryBuilder.initiateBuilder();

        StoryManager story_manager = StoryManager.initiateStoryManager();

        story_builder.setTitle(title);

        story_builder.setDescription(description);

        story_builder.setPoints(points);

        story_builder.setStatus(status);

        story_builder.setSprintTitleAndId(sprint_title);

        story_builder.setCompletedPoints(completed_points);

        story_manager.addStory(story_builder);


    }

}
