package com.actual.myapplication;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class SprintTest {

    @Test
    public void canSetLabel() {
        Sprint spr_obj = new Sprint();
        spr_obj.setLabel("New Sprint");
        assertEquals("New Sprint", spr_obj.getLabel());
    }

    @Test
    public void canSetLength() {
        Sprint spr_obj = new Sprint();
        spr_obj.setLabel("New Sprint");
        spr_obj.setLength(3);
        assertEquals(3, spr_obj.getLength());
    }

    @Test
    public void canSetFrequency() {
        Sprint spr_obj = new Sprint();
        spr_obj.setLabel("New Sprint");
        spr_obj.setLength(3);
        spr_obj.setFrequencyInDays(14);
        assertEquals(14, spr_obj.getFrequencyInDays());
    }

    @Test
    public void canSetCapacity() {
        Sprint spr_obj = new Sprint();
        spr_obj.setLabel("New Sprint");
        spr_obj.setLength(3);
        spr_obj.setFrequencyInDays(14);
        spr_obj.setCapacity(8);
        assertEquals(8, spr_obj.getCapacity());
    }

    @Test
    public void canAddExistingStoryToSprint() {
        Sprint spr_obj = new Sprint();
        spr_obj.setLabel("New Sprint");
        spr_obj.setLength(3);
        spr_obj.setFrequencyInDays(14);
        spr_obj.setCapacity(8);
        StoryManager story_mgr = StoryManager.initiateStoryManager();
        story_mgr.addStory();
        spr_obj.addExistingStory(1);
        assertEquals("New Sprint", story_mgr.getStory(1).getSprint());
    }

    @Test
    public void canCreateStoryForSprintWithNoBuilder() {
        Sprint spr_obj = new Sprint();
        spr_obj.setLabel("New Sprint");
        spr_obj.setLength(3);
        spr_obj.setFrequencyInDays(14);
        spr_obj.setCapacity(8);
        StoryManager story_mgr = StoryManager.initiateStoryManager();
        story_mgr.addStory();
        spr_obj.addExistingStory(1);
        spr_obj.addNewStory();
        assertEquals("New Sprint", story_mgr.getStory(2).getSprint());
    }

    @Test
    public void canCreateStoryForSprintWithBuilder() {
        Sprint spr_obj = new Sprint();
        spr_obj.setLabel("New Sprint");
        spr_obj.setLength(3);
        spr_obj.setFrequencyInDays(14);
        spr_obj.setCapacity(8);
        StoryManager story_mgr = StoryManager.initiateStoryManager();
        story_mgr.addStory();
        spr_obj.addExistingStory(1);
        spr_obj.addNewStory();
        StoryBuilder story_builder = StoryBuilder.initiateBuilder();
        spr_obj.addNewStory(story_builder);
        assertEquals("New Sprint", story_mgr.getStory(3).getSprint());
    }

    @Test
    public void canGetTotalAssignedPointsForSprint() {
        StoryBuilder.resetBuilderAsUninitiated();
        Sprint spr_obj = new Sprint();
        spr_obj.setLabel("New Sprint");
        spr_obj.setLength(3);
        spr_obj.setFrequencyInDays(14);
        spr_obj.setCapacity(8);
        StoryManager story_mgr = StoryManager.initiateStoryManager();
        story_mgr.addStory();
        spr_obj.addExistingStory(1);
        spr_obj.addNewStory();
        StoryBuilder story_builder = StoryBuilder.initiateBuilder();
        spr_obj.addNewStory(story_builder);
        story_builder.setPoints(2);
        story_mgr.getStory(1).setChangedStoryAttributes(story_builder);
        story_builder.setPoints(2);
        story_mgr.getStory(2).setChangedStoryAttributes(story_builder);
        story_builder.setPoints(2);
        story_mgr.getStory(3).setChangedStoryAttributes(story_builder);
        assertEquals(6, spr_obj.getTotalAssignedPoints());
    }

}