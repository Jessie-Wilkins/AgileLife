package com.actual.myapplication;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.instanceOf;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class StoryManagementTest {

    @Test
    public void canAddAStoryToStoryList() {
        StoryManager story_mgr = StoryManager.initiateStoryManager();
        story_mgr.addStory();
        assertThat(story_mgr.getStory(1), instanceOf(Story.class));

    }

    @Test
    public void canAddTwoStoriesToStoryList() {
        StoryManager story_mgr = StoryManager.initiateStoryManager();
        story_mgr.addStory();
        story_mgr.addStory();
        assertEquals(story_mgr.getStory(2), story_mgr.getStory(2));
    }

    @Test
    public void canAddStoryWithBuilderItems() {
        StoryManager story_mgr = StoryManager.initiateStoryManager();
        story_mgr.addStory();
        story_mgr.addStory();
        StoryBuilder.resetBuilderAsUninitiated();
        StoryBuilder builder = StoryBuilder.initiateBuilder();

        builder.setTitle("Title 1");

        builder.setDescription("Description 1");

        builder.setPoints(4);

        builder.setStatus(Story.StoryStatus.IN_PROGRESS);

        builder.setSprint("Sprint 1");

        builder.setCompletedPoints(2);

        story_mgr.addStory(builder);
        assertEquals("Sprint 1", story_mgr.getStory(3).getSprint());
    }

    @Test
    public void canEditStoryWithBuilderItem() {
        StoryManager story_mgr = StoryManager.initiateStoryManager();
        story_mgr.addStory();
        story_mgr.addStory();
        StoryBuilder.resetBuilderAsUninitiated();
        StoryBuilder builder = StoryBuilder.initiateBuilder();

        builder.setTitle("Title 1");

        builder.setDescription("Description 1");

        builder.setPoints(4);

        builder.setStatus(Story.StoryStatus.IN_PROGRESS);

        builder.setSprint("Sprint 1");

        builder.setCompletedPoints(2);

        story_mgr.addStory(builder);

        builder.setPoints(7);

        story_mgr.editStory(3, builder);

        assertEquals(7, story_mgr.getStory(3).getPointsManagement().getPoints());
    }

    @Test
    public void canEditStoryPointsDirectlyWithStoryManager() {
        StoryManager story_mgr = StoryManager.initiateStoryManager();
        story_mgr.addStory();
        story_mgr.addStory();
        StoryBuilder.resetBuilderAsUninitiated();
        StoryBuilder builder = StoryBuilder.initiateBuilder();

        builder.setTitle("Title 1");

        builder.setDescription("Description 1");

        builder.setPoints(4);

        builder.setStatus(Story.StoryStatus.IN_PROGRESS);

        builder.setSprint("Sprint 1");

        builder.setCompletedPoints(2);

        story_mgr.addStory(builder);

        builder.setPoints(7);

        story_mgr.editStory(3, builder);

        story_mgr.getStory(3).getPointsManagement().addPoints(3);

        assertEquals(10, story_mgr.getStory(3).getPointsManagement().getPoints());
    }

    @Test
    public void canEditAnotherStoryWithBuilderWithOnlyChangedAttributes() {
        StoryManager story_mgr = StoryManager.initiateStoryManager();
        story_mgr.addStory();
        story_mgr.addStory();
        StoryBuilder.resetBuilderAsUninitiated();
        StoryBuilder builder = StoryBuilder.initiateBuilder();

        builder.setTitle("Title 1");

        builder.setDescription("Description 1");

        builder.setPoints(4);

        builder.setStatus(Story.StoryStatus.IN_PROGRESS);

        builder.setSprint("Sprint 1");

        builder.setCompletedPoints(2);

        story_mgr.addStory(builder);

        builder.setPoints(7);

        story_mgr.editStory(3, builder);

        story_mgr.getStory(3).getPointsManagement().addPoints(3);

        builder.setSprint("Sprint 3");

        story_mgr.editStoryWithOnlyChangedAttributes(2, builder);

        assertEquals("Sprint 3", story_mgr.getStory(2).getSprint());

    }

    @Test
    public void canGetTheCorrectAttributeAfterEditingADifferentStory() {
        StoryManager story_mgr = StoryManager.initiateStoryManager();
        story_mgr.addStory();
        story_mgr.addStory();
        StoryBuilder.resetBuilderAsUninitiated();
        StoryBuilder builder = StoryBuilder.initiateBuilder();

        builder.setTitle("Title 1");

        builder.setDescription("Description 1");

        builder.setPoints(4);

        builder.setStatus(Story.StoryStatus.IN_PROGRESS);

        builder.setSprint("Sprint 1");

        builder.setCompletedPoints(2);

        story_mgr.addStory(builder);

        builder.setPoints(7);

        story_mgr.editStory(3, builder);

        story_mgr.getStory(3).getPointsManagement().addPoints(3);

        builder.setSprint("Sprint 3");

        story_mgr.editStoryWithOnlyChangedAttributes(2, builder);

        assertNotEquals("Sprint 3", story_mgr.getStory(3).getSprint());
    }

    @Test
    public void canGetOriginalAttributeForUnchangedStoryValueIfEditedWithDeltaOrChangedOnlyAttributes() {
        StoryManager story_mgr = StoryManager.initiateStoryManager();
        story_mgr.addStory();
        story_mgr.addStory();
        StoryBuilder.resetBuilderAsUninitiated();
        StoryBuilder builder = StoryBuilder.initiateBuilder();

        builder.setTitle("Title 1");

        builder.setDescription("Description 1");

        builder.setPoints(4);

        builder.setStatus(Story.StoryStatus.IN_PROGRESS);

        builder.setSprint("Sprint 1");

        builder.setCompletedPoints(2);

        story_mgr.addStory(builder);

        builder.setPoints(7);

        story_mgr.editStory(3, builder);

        story_mgr.getStory(3).getPointsManagement().addPoints(3);

        builder.setSprint("Sprint 3");

        story_mgr.editStoryWithOnlyChangedAttributes(2, builder);

        assertNotEquals(7, story_mgr.getStory(2).getPointsManagement().getPoints());
    }

    @Test
    public void canNotRetrieveDeletedStoryFromStoryList() {
        StoryManager story_mgr = StoryManager.initiateStoryManager();
        story_mgr.addStory();
        story_mgr.addStory();
        StoryBuilder.resetBuilderAsUninitiated();
        StoryBuilder builder = StoryBuilder.initiateBuilder();

        builder.setTitle("Title 1");

        builder.setDescription("Description 1");

        builder.setPoints(4);

        builder.setStatus(Story.StoryStatus.IN_PROGRESS);

        builder.setSprint("Sprint 1");

        builder.setCompletedPoints(2);

        story_mgr.addStory(builder);

        builder.setPoints(7);

        story_mgr.editStory(3, builder);

        story_mgr.getStory(3).getPointsManagement().addPoints(3);

        builder.setSprint("Sprint 3");

        story_mgr.editStoryWithOnlyChangedAttributes(2, builder);

        story_mgr.deleteStory(1);

        assertEquals(null, story_mgr.getStory(1));
    }

    @Test
    public void canRetrieveDeletedStoryFromDeletedStoryList() {
        StoryManager story_mgr = StoryManager.initiateStoryManager();
        story_mgr.addStory();
        story_mgr.addStory();
        StoryBuilder.resetBuilderAsUninitiated();
        StoryBuilder builder = StoryBuilder.initiateBuilder();

        builder.setTitle("Title 1");

        builder.setDescription("Description 1");

        builder.setPoints(4);

        builder.setStatus(Story.StoryStatus.IN_PROGRESS);

        builder.setSprint("Sprint 1");

        builder.setCompletedPoints(2);

        story_mgr.addStory(builder);

        builder.setPoints(7);

        story_mgr.editStory(3, builder);

        story_mgr.getStory(3).getPointsManagement().addPoints(3);

        builder.setSprint("Sprint 3");

        story_mgr.editStoryWithOnlyChangedAttributes(2, builder);

        Story temp_story = story_mgr.getStory(1);

        story_mgr.deleteStory(1);

        assertEquals(temp_story, story_mgr.getDeletedStory(1));
    }

}