package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.widget.EditText;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.actual.myapplication.StoryBuilder;
import com.actual.myapplication.StoryManager;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class EditStoryMenuTest {

    StoryManager storyManager;
    @Before
    public void setUp() {
        storyManager = StoryManager.initiateStoryManager();
        StoryBuilder storyBuilder = StoryBuilder.initiateBuilder();
        storyBuilder.setPoints(9);
        storyBuilder.setDescription("Test Description");
        storyBuilder.setTitle("Test Title");
        storyManager.addStory(storyBuilder);
    }

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        assertEquals("com.example.myapplication", appContext.getPackageName());
    }

    @Rule
    public ActivityScenarioRule<MainMenu> activityScenarioRule
            = new ActivityScenarioRule<>(MainMenu.class);

    @Test
    public void AssigningStoryPointsCausesPointsValueInEditStoryMenuToBeShown() {
        onView(withId(R.id.editStoryBtn)).perform(click());
        onView(withId(R.id.editPointsAgain)).check(matches(withText("9")));
    }

    @Test
    public void AssigningStoryDescriptionCausesDescriptionValueInEditStoryMenuToBeShown()  {
        onView(withId(R.id.editStoryBtn)).perform(click());
        onView(withId(R.id.editDescriptionAgain)).check(matches(withText("Test Description")));
    }

    @Test
    public void AssigningStoryTitleCausesTitleValueInEditStoryMenuToBeShown()  {
        onView(withId(R.id.editStoryBtn)).perform(click());
        onView(withId(R.id.editTitleAgain)).check(matches(withText("Test Title")));
    }

    @Test
    public void ChangingPointsInEditStoryMenuChangesActualStoryPointsValue() {
        onView(withId(R.id.editStoryBtn)).perform(click());
        onView(withId(R.id.editPointsAgain)).perform(ViewActions.replaceText("7"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.editStoryMenuBtn)).perform(click());
        assertEquals(7, storyManager.getStory(1).getPointsManagement().getPoints());
    }

    @Test
    public void ChangingDescriptionInEditStoryMenuChangesActualStoryDescription() {
        onView(withId(R.id.editStoryBtn)).perform(click());
        onView(withId(R.id.editDescriptionAgain)).perform(ViewActions.replaceText("New Description"));
        onView(withId(R.id.editStoryMenuBtn)).perform(click());
        assertEquals("New Description", storyManager.getStory(1).getDescription());
    }

    @Test
    public void ChangingTitleInEditStoryMenuChangesActualStoryTitle() {
        onView(withId(R.id.editStoryBtn)).perform(click());
        onView(withId(R.id.editTitleAgain)).perform(ViewActions.replaceText("New Title"));
        onView(withId(R.id.editStoryMenuBtn)).perform(click());
        assertEquals("New Title", storyManager.getStory(1).getTitle());
    }

    @Test
    public void GivingTheStoryABlankPointsValueDoesNotChangeTheStoryPointsValue() {
        onView(withId(R.id.editStoryBtn)).perform(click());
        onView(withId(R.id.editPointsAgain)).perform(ViewActions.replaceText(""));
        onView(withId(R.id.editStoryMenuBtn)).perform(click());
        assertEquals(9, storyManager.getStory(1).getPointsManagement().getPoints());
    }

    @Test
    public void GivingTheStoryABlankTitleDoesNotChangeTheStoryTitle() {
        onView(withId(R.id.editStoryBtn)).perform(click());
        onView(withId(R.id.editTitleAgain)).perform(ViewActions.replaceText(""));
        onView(withId(R.id.editStoryMenuBtn)).perform(click());
        assertEquals("Test Title", storyManager.getStory(1).getTitle());
    }

    @Test
    public void GivingTheStoryABlankDescriptionDoesNotChangeTheStoryDescription() {
        onView(withId(R.id.editStoryBtn)).perform(click());
        onView(withId(R.id.editDescriptionAgain)).perform(ViewActions.replaceText(""));
        onView(withId(R.id.editStoryMenuBtn)).perform(click());
        assertEquals("Test Description", storyManager.getStory(1).getDescription());
    }

}
