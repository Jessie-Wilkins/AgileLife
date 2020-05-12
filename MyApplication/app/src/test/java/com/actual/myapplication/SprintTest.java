package com.actual.myapplication;

import org.junit.Test;

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
        IdGenerator.setStrategy(SprintIdGenerator.getSprintIdGenerator());
        IdGenerator.resetId();
        Sprint spr_obj = new Sprint();
        spr_obj.setLabel("New Sprint");
        assertEquals("New Sprint", spr_obj.getLabel());
    }

    @Test
    public void canSetLength() {
        IdGenerator.setStrategy(SprintIdGenerator.getSprintIdGenerator());
        IdGenerator.resetId();
        Sprint spr_obj = new Sprint();
        spr_obj.setLabel("New Sprint");
        spr_obj.setLength(3);
        assertEquals(3, spr_obj.getLength());
    }

    @Test
    public void canSetFrequency() {
        IdGenerator.setStrategy(SprintIdGenerator.getSprintIdGenerator());
        IdGenerator.resetId();
        Sprint spr_obj = new Sprint();
        spr_obj.setLabel("New Sprint");
        spr_obj.setLength(3);
        spr_obj.setFrequencyInDays(14);
        assertEquals(14, spr_obj.getFrequencyInDays());
    }

    @Test
    public void canSetCapacity() {
        IdGenerator.setStrategy(SprintIdGenerator.getSprintIdGenerator());
        IdGenerator.resetId();
        Sprint spr_obj = new Sprint();
        spr_obj.setLabel("New Sprint");
        spr_obj.setLength(3);
        spr_obj.setFrequencyInDays(14);
        spr_obj.setCapacity(8);
        assertEquals(8, spr_obj.getCapacity());
    }

    @Test
    public void canAddExistingStoryToSprint() {
        IdGenerator.setStrategy(SprintIdGenerator.getSprintIdGenerator());
        IdGenerator.resetId();
        Sprint spr_obj = new Sprint();
        spr_obj.setLabel("New Sprint");
        spr_obj.setLength(3);
        spr_obj.setFrequencyInDays(14);
        spr_obj.setCapacity(8);
        StoryManager story_mgr = StoryManager.initiateStoryManager();
        story_mgr.addStory();
        spr_obj.addExistingStory(1);
        assertEquals("1:New Sprint", story_mgr.getStory(1).getSprintTitleAndId());
    }

    @Test
    public void canCreateStoryForSprintWithNoBuilder() {
        IdGenerator.setStrategy(SprintIdGenerator.getSprintIdGenerator());
        IdGenerator.resetId();
        Sprint spr_obj = new Sprint();
        spr_obj.setLabel("New Sprint");
        spr_obj.setLength(3);
        spr_obj.setFrequencyInDays(14);
        spr_obj.setCapacity(8);
        StoryManager story_mgr = StoryManager.initiateStoryManager();
        story_mgr.addStory();
        spr_obj.addExistingStory(1);
        spr_obj.addNewStory();
        assertEquals("1:New Sprint", story_mgr.getStory(2).getSprintTitleAndId());
    }

    @Test
    public void canCreateStoryForSprintWithBuilder() {
        StoryBuilder.resetBuilderAsUninitiated();
        IdGenerator.setStrategy(SprintIdGenerator.getSprintIdGenerator());
        IdGenerator.resetId();
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
        assertEquals("1:New Sprint", story_mgr.getStory(3).getSprintTitleAndId());
    }

    @Test
    public void canGetTotalAssignedPointsForSprint() {
        StoryBuilder.resetBuilderAsUninitiated();
        IdGenerator.setStrategy(SprintIdGenerator.getSprintIdGenerator());
        IdGenerator.resetId();
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

    @Test
    public void canGetTotalCompletedPoints() {
        StoryBuilder.resetBuilderAsUninitiated();
        IdGenerator.setStrategy(SprintIdGenerator.getSprintIdGenerator());
        IdGenerator.resetId();
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
        story_mgr.getStory(1).getPointsManagement().completePoints(1);
        story_mgr.getStory(2).getPointsManagement().completePoints(1);
        story_mgr.getStory(3).getPointsManagement().completePoints(1);
        assertEquals(3, spr_obj.getTotalCompletedPoints());
    }

    @Test
    public void canGetUniqueIdForSprint() {
        StoryBuilder.resetBuilderAsUninitiated();
        IdGenerator.setStrategy(SprintIdGenerator.getSprintIdGenerator());
        IdGenerator.resetId();
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
        story_mgr.getStory(1).getPointsManagement().completePoints(1);
        story_mgr.getStory(2).getPointsManagement().completePoints(1);
        story_mgr.getStory(3).getPointsManagement().completePoints(1);
        Sprint spr_obj2 = new Sprint();
        assertEquals(2, spr_obj2.getId());

    }

    @Test
    public void canGetIdForFutureSprint() {
        StoryBuilder.resetBuilderAsUninitiated();
        IdGenerator.setStrategy(SprintIdGenerator.getSprintIdGenerator());
        IdGenerator.resetId();
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
        story_mgr.getStory(1).getPointsManagement().completePoints(1);
        story_mgr.getStory(2).getPointsManagement().completePoints(1);
        story_mgr.getStory(3).getPointsManagement().completePoints(1);
        Sprint spr_obj2 = new Sprint();
        spr_obj2.setFutureSprintId(3);
        assertEquals(3, spr_obj2.getFutureSprintId());
    }

    @Test
    public void canGetPastSprintId() {
        StoryBuilder.resetBuilderAsUninitiated();
        IdGenerator.setStrategy(SprintIdGenerator.getSprintIdGenerator());
        IdGenerator.resetId();
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
        story_mgr.getStory(1).getPointsManagement().completePoints(1);
        story_mgr.getStory(2).getPointsManagement().completePoints(1);
        story_mgr.getStory(3).getPointsManagement().completePoints(1);
        Sprint spr_obj2 = new Sprint();
        spr_obj2.setFutureSprintId(3);
        spr_obj2.setPastSprintId(1);
        assertEquals(1, spr_obj2.getPastSprintId());
    }


}