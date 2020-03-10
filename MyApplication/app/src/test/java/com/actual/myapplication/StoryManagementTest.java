package com.actual.myapplication;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

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
        Story story_obj = new Story();

        assertNotEquals(null,story_obj);
    }

    @Test
    public void canSetTitle() {
        Story story_obj = new Story();
        StoryBuilder builder = StoryBuilder.initiateBuilder();

        builder.setTitle("Title 1");
        story_obj.setStoryAttributes(builder);

        assertEquals("Title 1", story_obj.getTitle());

    }

    @Test
    public void canSetDescription() {
        Story story_obj = new Story();
        StoryBuilder builder = StoryBuilder.initiateBuilder();

        builder.setTitle("Title 1");

        builder.setDescription("Description 1");

        story_obj.setStoryAttributes(builder);

        assertEquals("Description 1", story_obj.getDescription());

    }

    @Test
    public void canSetPoints() {
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
        Story story_obj = new Story();
        StoryBuilder builder = StoryBuilder.initiateBuilder();

        builder.setTitle("Title 1");

        builder.setDescription("Description 1");

        builder.setPoints(4);

        builder.setStatus("Status 1");

        story_obj.setStoryAttributes(builder);

        assertEquals("Status 1", story_obj.getStatus());

    }

    @Test
    public void canSetSprint() {
        Story story_obj = new Story();
        StoryBuilder builder = StoryBuilder.initiateBuilder();

        builder.setTitle("Title 1");

        builder.setDescription("Description 1");

        builder.setPoints(4);

        builder.setStatus("Status 1");

        builder.setSprint("Sprint 1");

        story_obj.setStoryAttributes(builder);

        assertEquals("Sprint 1", story_obj.getSprint());

    }

    @Test
    public void canSetCompletedPoints() {
        Story story_obj = new Story();
        StoryBuilder builder = StoryBuilder.initiateBuilder();

        builder.setTitle("Title 1");

        builder.setDescription("Description 1");

        builder.setPoints(4);

        builder.setStatus("Status 1");

        builder.setSprint("Sprint 1");

        builder.setCompletedPoints(2);

        story_obj.setStoryAttributes(builder);

        assertEquals(2, story_obj.getPoints().getCompletedPoints());

    }

    /*@Test
    public void canSetTitle() {
        Story story_obj = new Story();
        StoryBuilder builder = StoryBuilder.initiateBuilder();
        builder.setTitle("Title 1");
        story_obj.setStoryAttributes(builder);
        assertEquals("Title 1", story_obj.getTitle());

    }*/
}