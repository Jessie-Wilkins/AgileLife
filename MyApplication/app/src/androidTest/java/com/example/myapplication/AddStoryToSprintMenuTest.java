package com.example.myapplication;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.actual.myapplication.SprintBuilder;
import com.actual.myapplication.SprintManager;
import com.actual.myapplication.StoryBuilder;
import com.actual.myapplication.StoryManager;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class AddStoryToSprintMenuTest {

    SprintManager sprintManager;

    StoryManager storyManager;

    @Before
    public void setUp() {
        sprintManager = SprintManager.initiateSprintManager();
        SprintBuilder sprintBuilder = SprintBuilder.initiateSprintBuilder();
        sprintBuilder.setCapacity(9);
        sprintBuilder.setLabel("Sprint Title");
        sprintBuilder.setFrequency(14);
        sprintBuilder.setLength(7);
        sprintManager.addSprint(sprintBuilder);
        sprintBuilder.setCapacity(12);
        sprintBuilder.setLabel("Sprint Title2");
        sprintBuilder.setFrequency(7);
        sprintBuilder.setLength(3);
        sprintManager.addSprint(sprintBuilder);
        storyManager = StoryManager.initiateStoryManager();
        StoryBuilder storyBuilder = StoryBuilder.initiateBuilder();
        storyBuilder.setPoints(9);
        storyBuilder.setDescription("Story Description");
        storyBuilder.setTitle("Story Title");
        storyManager.addStory(storyBuilder);
    }

    @Rule
    public ActivityScenarioRule<MainMenu> activityScenarioRule
            = new ActivityScenarioRule<>(MainMenu.class);

    @Test
    public void sprintChooserCanSelectExistingSprint() {
        onView(withId(R.id.addStoryToSprintButton)).perform(click());
        onView(withId(R.id.addStoryToSprintChooseSprintSpinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("Sprint Title"))).perform(click());
        onView(withText("Sprint Title")).check(matches(isDisplayed()));
    }

    @Test
    public void sprintChooserCanSelectAnotherExistingSprint() {
        onView(withId(R.id.addStoryToSprintButton)).perform(click());
        onView(withId(R.id.addStoryToSprintChooseSprintSpinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("Sprint Title2"))).perform(click());
        onView(withText("Sprint Title2")).check(matches(isDisplayed()));
    }

    @Test
    public void storyChooserCanSelectExistingStory() {
        onView(withId(R.id.addStoryToSprintButton)).perform(click());
        onView(withId(R.id.addStoryToSprintChooseStorySpinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("Story Title"))).perform(click());
        onView(withText("Story Title")).check(matches(isDisplayed()));
    }

    @Test
    public void clickingAddStoryToSprintSubmitButtonWillAddTheChosenStoryToTheChosenSprint() {
        onView(withId(R.id.addStoryToSprintButton)).perform(click());
        onView(withId(R.id.addStoryToSprintChooseStorySpinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("Story Title"))).perform(click());
        onView(withId(R.id.addStoryToSprintChooseSprintSpinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("Sprint Title2"))).perform(click());
        onView(withId(R.id.addStoryToSprintSubmitBtn)).perform(click());
        assertEquals("Story Title", sprintManager.getSprint(2).getStoryList().get(0));
    }

}
