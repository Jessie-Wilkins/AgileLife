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

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ViewCurrentStoryMenuTest {

    SprintManager sprintManager;
    StoryManager storyManager;
    @Before
    public void setUp() {
        sprintManager = SprintManager.initiateSprintManager();
        SprintBuilder sprintBuilder = SprintBuilder.initiateSprintBuilder();
        sprintBuilder.setLabel("Test Title");
        sprintBuilder.setLength(7);
        sprintBuilder.setFrequency(14);
        sprintBuilder.setCapacity(16);
        sprintManager.addSprint(sprintBuilder);

        storyManager = StoryManager.initiateStoryManager();
        StoryBuilder storyBuilder = StoryBuilder.initiateBuilder();
        storyBuilder.setPoints(9);
        storyBuilder.setDescription("Story Description");
        storyBuilder.setTitle("Story Title");
        storyManager.addStory(storyBuilder);

        storyBuilder.setPoints(4);
        storyBuilder.setDescription("Story Description2");
        storyBuilder.setTitle("Story Title2");
        storyManager.addStory(storyBuilder);

        storyBuilder.setPoints(3);
        storyBuilder.setDescription("Story Description3");
        storyBuilder.setTitle("Story Title3");
        storyManager.addStory(storyBuilder);

        storyBuilder.setPoints(1);
        storyBuilder.setDescription("Story Description4");
        storyBuilder.setTitle("Story Title4");
        storyManager.addStory(storyBuilder);

        storyManager.getStory(1).setSprintTitleAndId(sprintManager.getSprint(1).getIdPlusLabel());
        storyManager.getStory(2).setSprintTitleAndId(sprintManager.getSprint(1).getIdPlusLabel());
        storyManager.getStory(4).setSprintTitleAndId(sprintManager.getSprint(1).getIdPlusLabel());
    }

    @Rule
    public ActivityScenarioRule<MainMenu> activityScenarioRule
            = new ActivityScenarioRule<>(MainMenu.class);

    @Test
    public void viewCurrentSprintMenuShowsStoryListView() {
        onView(withId(R.id.ViewCurrentSprintBtn)).perform(click());
        onView(withId(R.id.viewCurrentSprintSeeStoriesBtn)).perform(click());
        onView(allOf(withText("1:Story Title"))).perform(click());
        onView(withId(R.id.viewCurrentStoryTotalPointsTextView)).check(matches(isDisplayed()));
    }

   /* @Test
    public void viewCurrentSprintMenuShowsExistingStoryInStoryListView() {
        onView(withId(R.id.ViewCurrentSprintBtn)).perform(click());
        onView(withText("Story Title")).check(matches(isDisplayed()));
    }

    @Test
    public void viewCurrentSprintMenuShowsAnotherExistingStoryInStoryListView() {
        onView(withId(R.id.ViewCurrentSprintBtn)).perform(click());
        onView(withText("Story Title2")).check(matches(isDisplayed()));
    }

    @Test
    public void clickingOnStoryTitleTakesUserToStoryPage() {
        onView(withId(R.id.ViewCurrentSprintBtn)).perform(click());
        onView(allOf(withText("Story Title2"))).perform(scrollTo());
        onView(allOf(withText("Story Title2"))).perform(click());
        onView(withId(R.id.viewCurrentStoryTitleTextView)).check(matches(withText("Story Title2")));
    }*/

}
