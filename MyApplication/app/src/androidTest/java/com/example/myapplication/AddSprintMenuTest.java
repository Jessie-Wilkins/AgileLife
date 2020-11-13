package com.example.myapplication;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.actual.myapplication.SprintManager;

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
import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class AddSprintMenuTest {

    SprintManager sprintManager;

    @Rule
    public ActivityScenarioRule<AddSprintMenu> activityScenarioRule
            = new ActivityScenarioRule<>(AddSprintMenu.class);

    @Test
    public void addTitleToNewSprint() {
        sprintManager = SprintManager.initiateSprintManager();
        onView(withId(R.id.addSprintTitleEditText))
                .perform(typeText("Test Title"), closeSoftKeyboard());
        onView(withId(R.id.addSprintSubmitBtn)).perform(click());

        assertEquals("Test Title", sprintManager.getSprint(1).getLabel());
    }

    @Test
    public void addLengthToNewSprint() {
        sprintManager = SprintManager.initiateSprintManager();
        onView(withId(R.id.addSprintLengthEditText))
                .perform(typeText("7"), closeSoftKeyboard());
        onView(withId(R.id.addSprintSubmitBtn)).perform(click());

        assertEquals(7, sprintManager.getSprint(1).getLength());
    }

    @Test
    public void addFrequencyToNewSprint() {
        sprintManager = SprintManager.initiateSprintManager();
        onView(withId(R.id.addSprintFrequencyEditText))
                .perform(typeText("9"), closeSoftKeyboard());
        onView(withId(R.id.addSprintSubmitBtn)).perform(click());

        assertEquals(9, sprintManager.getSprint(1).getFrequencyInDays());
    }

    @Test
    public void addCapacityToNewSprint() {
        sprintManager = SprintManager.initiateSprintManager();
        onView(withId(R.id.addSprintCapacityEditText))
                .perform(typeText("14"), closeSoftKeyboard());
        onView(withId(R.id.addSprintSubmitBtn)).perform(click());

        assertEquals(14, sprintManager.getSprint(1).getCapacity());
    }

    @Test
    public void addingNewSprintTakesUserToMainMenu() {
        sprintManager = SprintManager.initiateSprintManager();
        onView(withId(R.id.addSprintTitleEditText))
                .perform(typeText("Test Title"), closeSoftKeyboard());
        onView(withId(R.id.addSprintLengthEditText))
                .perform(typeText("7"), closeSoftKeyboard());
        onView(withId(R.id.addSprintFrequencyEditText))
                .perform(typeText("9"), closeSoftKeyboard());
        onView(withId(R.id.addSprintCapacityEditText))
                .perform(typeText("14"), closeSoftKeyboard());
        onView(withId(R.id.addSprintSubmitBtn)).perform(click());

       onView(withId(R.id.addNewSprintBtn)).check(matches(isDisplayed()));
    }

}