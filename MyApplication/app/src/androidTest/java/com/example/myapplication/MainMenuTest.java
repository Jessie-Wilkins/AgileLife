package com.example.myapplication;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

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
public class MainMenuTest {

    @Rule
    public ActivityScenarioRule<MainMenu> activityScenarioRule
            = new ActivityScenarioRule<>(MainMenu.class);

    @Test
    public void AddStoryButtonGoesToNewActivity() {
        onView(withId(R.id.addNewStoryBtn)).perform(click());
        onView(withId(R.id.editPoints)).check(matches(isDisplayed()));

    }

    @Test
    public void EditStoryButtonGoesToNewActivity() {
        onView(withId(R.id.editStoryBtn)).perform(click());
        onView(withId(R.id.storyListView)).check(matches(isDisplayed()));
    }

    @Test
    public void AddSprintButtonGoesToNewActivity() {
        onView(withId(R.id.addNewSprintBtn)).perform(click());
        onView(withId(R.id.textSprintTitle)).check(matches(isDisplayed()));
    }

    @Test
    public void EditSprintButtonGoesToSprintListActivity() {
        onView(withId(R.id.editSprintBtn)).perform(click());
        onView(withId(R.id.sprintListView)).check(matches(isDisplayed()));
    }

    @Test
    public void AddStoryToSprintButtonGoesToAddStoryToSprintMenu() {
        onView(withId(R.id.editSprintBtn)).perform(click());
        onView(withId(R.id.addStoryToSprintChooseSprintTextView)).check(matches(isDisplayed()));
    }

}
