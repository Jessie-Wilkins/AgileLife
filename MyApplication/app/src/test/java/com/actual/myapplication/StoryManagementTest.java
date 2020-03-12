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
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void canAddStoryObject() {
        IdGenerator.resetId();
        Story story_obj = new Story();


        assertNotEquals(null,story_obj);
    }

    @Test
    public void canSetTitle() {
        IdGenerator.resetId();
        Story story_obj = new Story();
        StoryBuilder builder = StoryBuilder.initiateBuilder();

        builder.setTitle("Title 1");
        story_obj.setStoryAttributes(builder);

        assertEquals("Title 1", story_obj.getTitle());

    }

    @Test
    public void canSetDescription() {
        IdGenerator.resetId();
        Story story_obj = new Story();

        StoryBuilder builder = StoryBuilder.initiateBuilder();

        builder.setTitle("Title 1");

        builder.setDescription("Description 1");

        story_obj.setStoryAttributes(builder);

        assertEquals("Description 1", story_obj.getDescription());

    }

    @Test
    public void canSetPoints() {
        IdGenerator.resetId();
        Story story_obj = new Story();

        StoryBuilder builder = StoryBuilder.initiateBuilder();

        builder.setTitle("Title 1");

        builder.setDescription("Description 1");

        builder.setPoints(4);

        story_obj.setStoryAttributes(builder);

        assertEquals(4, story_obj.getPoints().getTotalPoints());

    }

    @Test
    public void canSetStatus() {
        IdGenerator.resetId();
        Story story_obj = new Story();

        StoryBuilder builder = StoryBuilder.initiateBuilder();

        builder.setTitle("Title 1");

        builder.setDescription("Description 1");

        builder.setPoints(4);

        builder.setStatus(Story.StoryStatus.IN_PROGRESS);

        story_obj.setStoryAttributes(builder);

        assertEquals(Story.StoryStatus.IN_PROGRESS, story_obj.getStatus());

    }

    @Test
    public void canSetSprint() {
        IdGenerator.resetId();
        Story story_obj = new Story();

        StoryBuilder builder = StoryBuilder.initiateBuilder();

        builder.setTitle("Title 1");

        builder.setDescription("Description 1");

        builder.setPoints(4);

        builder.setStatus(Story.StoryStatus.IN_PROGRESS);

        builder.setSprint("Sprint 1");

        story_obj.setStoryAttributes(builder);

        assertEquals("Sprint 1", story_obj.getSprint());

    }

    @Test
    public void canSetCompletedPoints() {
        IdGenerator.resetId();
        Story story_obj = new Story();

        StoryBuilder builder = StoryBuilder.initiateBuilder();

        builder.setTitle("Title 1");

        builder.setDescription("Description 1");

        builder.setPoints(4);

        builder.setStatus(Story.StoryStatus.IN_PROGRESS);

        builder.setSprint("Sprint 1");

        builder.setCompletedPoints(2);

        story_obj.setStoryAttributes(builder);

        assertEquals(2, story_obj.getPoints().getCompletedPoints());

    }

    @Test
    public void canGetGeneratedId() {
        IdGenerator.resetId();
        Story story_obj = new Story();

        StoryBuilder builder = StoryBuilder.initiateBuilder();

        builder.setTitle("Title 1");

        builder.setDescription("Description 1");

        builder.setPoints(4);

        builder.setStatus(Story.StoryStatus.IN_PROGRESS);

        builder.setSprint("Sprint 1");

        builder.setCompletedPoints(2);

        story_obj.setStoryAttributes(builder);

        assertEquals(1, story_obj.getId());

    }

    @Test
    public void canGetGeneratedUniqueId() {
        IdGenerator.resetId();
        Story story_obj = new Story();

        StoryBuilder builder = StoryBuilder.initiateBuilder();

        builder.setTitle("Title 1");

        builder.setDescription("Description 1");

        builder.setPoints(4);

        builder.setStatus(Story.StoryStatus.IN_PROGRESS);

        builder.setSprint("Sprint 1");

        builder.setCompletedPoints(2);

        story_obj.setStoryAttributes(builder);

        Story story_obj2 = new Story();

        assertEquals(2, story_obj2.getId());

    }

    @Test
    public void canAddAStoryToStoryQueue() {
        StoryManager story_mgr = new StoryManager();
        story_mgr.addStory();
        assertThat(story_mgr.getStory(1), instanceOf(Story.class));

    }
}