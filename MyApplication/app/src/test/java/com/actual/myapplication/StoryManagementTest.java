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
}