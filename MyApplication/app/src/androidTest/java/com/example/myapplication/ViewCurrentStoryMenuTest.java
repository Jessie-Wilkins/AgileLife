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
import static org.junit.Assert.assertEquals;

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
    public void viewCurrentStoryMenuShowsStoryPoints() {
        onView(withId(R.id.ViewCurrentSprintBtn)).perform(click());
        onView(withId(R.id.viewCurrentSprintSeeStoriesBtn)).perform(click());
        onView(allOf(withText("1:Story Title"))).perform(click());
        onView(withId(R.id.viewCurrentStoryTotalPointsTextView)).check(matches(isDisplayed()));
    }

    @Test
    public void viewCurrentStoryMenuShowsCorrectStoryPointsAmount() {
        onView(withId(R.id.ViewCurrentSprintBtn)).perform(click());
        onView(withId(R.id.viewCurrentSprintSeeStoriesBtn)).perform(click());
        onView(allOf(withText("1:Story Title"))).perform(click());
        onView(withId(R.id.viewCurrentStoryTotalPointsTextView)).check(matches(withText("Total Points:\n9")));
    }

    @Test
    public void viewCurrentStoryMenuShowsStoryDescription() {
        onView(withId(R.id.ViewCurrentSprintBtn)).perform(click());
        onView(withId(R.id.viewCurrentSprintSeeStoriesBtn)).perform(click());
        onView(allOf(withText("1:Story Title"))).perform(click());
        onView(withId(R.id.viewCurrentStoryDescriptionTextView)).check(matches(isDisplayed()));
    }

    @Test
    public void viewCurrentStoryMenuShowsCorrectStoryDescriptionContent() {
        onView(withId(R.id.ViewCurrentSprintBtn)).perform(click());
        onView(withId(R.id.viewCurrentSprintSeeStoriesBtn)).perform(click());
        onView(allOf(withText("1:Story Title"))).perform(click());
        onView(withId(R.id.viewCurrentStoryDescriptionTextView)).check(matches(withText("Description:\nStory Description")));
    }

    @Test
    public void viewCurrentStoryMenuShowsCorrectWorkableStoryPointsAmount() {
        onView(withId(R.id.ViewCurrentSprintBtn)).perform(click());
        onView(withId(R.id.viewCurrentSprintSeeStoriesBtn)).perform(click());
        onView(allOf(withText("1:Story Title"))).perform(click());
        onView(withId(R.id.viewCurrentStoryWorkablePointsTextView)).check(matches(withText("Points Left:\n9")));
    }

    @Test
    public void viewCurrentStoryMenuShowsCorrectCompletedStoryPointsAmount() {
        onView(withId(R.id.ViewCurrentSprintBtn)).perform(click());
        onView(withId(R.id.viewCurrentSprintSeeStoriesBtn)).perform(click());
        onView(allOf(withText("1:Story Title"))).perform(click());
        onView(withId(R.id.viewCurrentStoryCompletedPointsTextView)).check(matches(withText("Points Completed:\n0")));
    }

    @Test
    public void viewCurrentStoryMenuCanChangePointsCompletedAmount() {
        onView(withId(R.id.ViewCurrentSprintBtn)).perform(click());
        onView(withId(R.id.viewCurrentSprintSeeStoriesBtn)).perform(click());
        onView(allOf(withText("1:Story Title"))).perform(click());
        onView(withId(R.id.viewCurrentStoryCompletedPointsEditText)).perform(typeText("1"), closeSoftKeyboard());
        onView(withId(R.id.viewCurrentStoryCompletedPointsBtn)).perform(click());
        onView(withId(R.id.viewCurrentStoryCompletedPointsTextView)).check(matches(withText("Points Completed:\n1")));
    }

    @Test
    public void viewCurrentStoryMenuCanChangePointsAssignedAmount() {
        onView(withId(R.id.ViewCurrentSprintBtn)).perform(click());
        onView(withId(R.id.viewCurrentSprintSeeStoriesBtn)).perform(click());
        onView(allOf(withText("1:Story Title"))).perform(click());
        onView(withId(R.id.viewCurrentStoryCompletedPointsEditText)).perform(typeText("1"), closeSoftKeyboard());
        onView(withId(R.id.viewCurrentStoryCompletedPointsBtn)).perform(click());
        onView(withId(R.id.viewCurrentStoryWorkablePointsTextView)).check(matches(withText("Points Left:\n8")));
    }

    @Test
    public void viewCurrentStoryMenuCanShowStoryStatus() {
        onView(withId(R.id.ViewCurrentSprintBtn)).perform(click());
        onView(withId(R.id.viewCurrentSprintSeeStoriesBtn)).perform(click());
        onView(allOf(withText("1:Story Title"))).perform(click());
        onView(withText("READY")).check(matches(isDisplayed()));
    }

    @Test
    public void viewCurrentStoryMenuCanChangeStoryStatus() {
        onView(withId(R.id.ViewCurrentSprintBtn)).perform(click());
        onView(withId(R.id.viewCurrentSprintSeeStoriesBtn)).perform(click());
        onView(allOf(withText("1:Story Title"))).perform(click());
        onView(withId(R.id.viewCurrentStoryStatusSpinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("IN_PROGRESS"))).perform(click());
        assertEquals("IN_PROGRESS" ,storyManager.getStory(1).getStatus().toString());
    }

    @Test
    public void viewCurrentStoryMenuCanGoBackToCurrentStoryListMenu() {
        onView(withId(R.id.ViewCurrentSprintBtn)).perform(click());
        onView(withId(R.id.viewCurrentSprintSeeStoriesBtn)).perform(click());
        onView(allOf(withText("1:Story Title"))).perform(click());
        onView(withId(R.id.viewCurrentStoryMenuGoBackBtn)).perform(click());
        onView(withText("1:Story Title")).check(matches(isDisplayed()));
    }

}
