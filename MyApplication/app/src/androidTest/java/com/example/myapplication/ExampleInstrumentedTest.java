package com.example.myapplication;

import android.content.Context;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.actual.myapplication.StoryManager;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    StoryManager storyManager;

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        assertEquals("com.example.myapplication", appContext.getPackageName());
    }

    @Rule
    public ActivityScenarioRule<AddStoryMenu> activityScenarioRule
            = new ActivityScenarioRule<>(AddStoryMenu.class);

    @Test
    public void addPointsToNewStory() {
        storyManager = StoryManager.initiateStoryManager();
        onView(withId(R.id.editPoints))
                .perform(typeText("4"), closeSoftKeyboard());
        onView(withId(R.id.button)).perform(click());

        assertEquals(4, storyManager.getStory(1).getPointsManagement().getPoints());
    }

    @Test
    public void addTitleToNewStory() {
        storyManager = StoryManager.initiateStoryManager();
        onView(withId(R.id.editTitle))
                .perform(typeText("Test Title"), closeSoftKeyboard());
        onView(withId(R.id.button)).perform(click());

        assertEquals("Test Title", storyManager.getStory(1).getTitle());
    }

    @Test
    public void addDescriptionToNewStory() {
        storyManager = StoryManager.initiateStoryManager();
        onView(withId(R.id.editDescription))
                .perform(typeText("This is a test description"), closeSoftKeyboard());
        onView(withId(R.id.button)).perform(click());

        assertEquals("This is a test description", storyManager.getStory(1).getDescription());
    }

    @Test
    public void addPointsAndTitleAndDescriptionToNewStory() {
        storyManager = StoryManager.initiateStoryManager();
        onView(withId(R.id.editDescription))
                .perform(typeText("This is a test description"), closeSoftKeyboard());
        onView(withId(R.id.editPoints))
                .perform(typeText("4"), closeSoftKeyboard());
        onView(withId(R.id.editTitle))
                .perform(typeText("Test Title"), closeSoftKeyboard());
        onView(withId(R.id.button)).perform(click());

        assertEquals("This is a test description"+"4"+"Test Title",
                storyManager.getStory(1).getDescription()
                +storyManager.getStory(1).getPointsManagement().getPoints()
                +storyManager.getStory(1).getTitle());
    }

    @Test
    public void buttonTakesUserBackToMenu() {
        storyManager = StoryManager.initiateStoryManager();
        onView(withId(R.id.editDescription))
                .perform(typeText("This is a test description"), closeSoftKeyboard());
        onView(withId(R.id.editPoints))
                .perform(typeText("4"), closeSoftKeyboard());
        onView(withId(R.id.editTitle))
                .perform(typeText("Test Title"), closeSoftKeyboard());
        onView(withId(R.id.button)).perform(click());

        onView(withId(R.id.addNewStoryBtn)).check(matches(isDisplayed()));

    }
}
