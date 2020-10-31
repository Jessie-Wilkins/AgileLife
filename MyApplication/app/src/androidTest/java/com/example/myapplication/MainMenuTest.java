package com.example.myapplication;

import android.content.Context;

import androidx.test.core.app.ActivityScenario;
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
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
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

    StoryManager storyManager;
    @Before
    public void setUp() {
       storyManager = StoryManager.getExistingStoryManager();
        StoryBuilder storyBuilder = StoryBuilder.initiateBuilder();
        storyBuilder.setPoints(9);
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
    public void AddStoryButtonGoesToNewActivity() {
        onView(withId(R.id.addNewStoryBtn)).perform(click());
        onView(withId(R.id.editPoints)).check(matches(isDisplayed()));

    }

    @Test
    public void EditStoryButtonGoesToNewActivity() {
        onView(withId(R.id.editStoryBtn)).perform(click());
        onView(withId(R.id.pointsTextView)).check(matches(isDisplayed()));
    }

    @Test
    public void AssigningStoryPointsCausesPointsValueInEditStoryMenuToBeShown() {
        onView(withId(R.id.editStoryBtn)).perform(click());
        onView(withId(R.id.editPointsAgain)).check(matches(withText("9")));
    }

}