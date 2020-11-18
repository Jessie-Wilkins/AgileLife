package com.example.myapplication;


import androidx.test.espresso.action.ViewActions;
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
import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class EditSprintMenuTest {

    SprintManager sprintManager;
    @Before
    public void setUp() {
        sprintManager = SprintManager.initiateSprintManager();
        SprintBuilder sprintBuilder = SprintBuilder.initiateSprintBuilder();
        sprintBuilder.setCapacity(9);
        sprintBuilder.setLabel("Test Title");
        sprintBuilder.setFrequency(14);
        sprintBuilder.setLength(7);
        sprintManager.addSprint(sprintBuilder);
    }

    @Rule
    public ActivityScenarioRule<MainMenu> activityScenarioRule
            = new ActivityScenarioRule<>(MainMenu.class);

  @Test
    public void AssigningSprintCapacityCausesPointsValueInEditSprintMenuToBeShown() {
        onView(withId(R.id.editSprintBtn)).perform(click());
        onView(allOf(withText("Test Title"))).perform(click());
        onView(withId(R.id.editSprintCapacityEditText)).check(matches(withText("9")));
    }

   @Test
    public void AssigningSprintTitleCausesTitleValueInEditSprintMenuToBeShown()  {
        onView(withId(R.id.editSprintBtn)).perform(click());
        onView(allOf(withText("Test Title"))).perform(click());
        onView(withId(R.id.editSprintTitleEditText)).check(matches(withText("Test Title")));
    }

    @Test
    public void AssigningSprintFrequencyCausesFrequencyValueInEditSprintMenuToBeShown()  {
        onView(withId(R.id.editSprintBtn)).perform(click());
        onView(allOf(withText("Test Title"))).perform(click());
        onView(withId(R.id.editSprintFrequencyEditText)).check(matches(withText("14")));
    }

    @Test
    public void AssigningSprintLengthCausesLengthValueInEditSprintMenuToBeShown()  {
        onView(withId(R.id.editSprintBtn)).perform(click());
        onView(allOf(withText("Test Title"))).perform(click());
        onView(withId(R.id.editSprintLengthEditText)).check(matches(withText("7")));
    }

    @Test
    public void ChangingCapacityInEditSprintMenuChangesActualSprintCapacityValue() {
        onView(withId(R.id.editSprintBtn)).perform(click());
        onView(allOf(withText("Test Title"))).perform(click());
        onView(withId(R.id.editSprintCapacityEditText)).perform(ViewActions.replaceText("7"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.editSprintSubmitBtn)).perform(click());
        assertEquals(7, sprintManager.getSprint(1).getCapacity());
    }

    @Test
    public void ChangingTitleInEditSprintMenuChangesActualSprintTitle() {
        onView(withId(R.id.editSprintBtn)).perform(click());
        onView(allOf(withText("Test Title"))).perform(click());
        onView(withId(R.id.editSprintTitleEditText)).perform(ViewActions.replaceText("New Title"));
        onView(withId(R.id.editSprintSubmitBtn)).perform(click());
        assertEquals("New Title", sprintManager.getSprint(1).getLabel());
    }

    @Test
    public void ChangingFrequencyInEditSprintMenuChangesActualSprintFrequency() {
        onView(withId(R.id.editSprintBtn)).perform(click());
        onView(allOf(withText("Test Title"))).perform(click());
        onView(withId(R.id.editSprintFrequencyEditText)).perform(ViewActions.replaceText("16"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.editSprintSubmitBtn)).perform(click());
        assertEquals(16, sprintManager.getSprint(1).getFrequencyInDays());
    }

    @Test
    public void ChangingLengthInEditSprintMenuChangesActualSprintLength() {
        onView(withId(R.id.editSprintBtn)).perform(click());
        onView(allOf(withText("Test Title"))).perform(click());
        onView(withId(R.id.editSprintLengthEditText)).perform(ViewActions.replaceText("9"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.editSprintSubmitBtn)).perform(click());
        assertEquals(9, sprintManager.getSprint(1).getLength());
    }

    @Test
    public void GivingTheSprintABlankTitleValueDoesNotChangeTheSprintTitleValue() {
        onView(withId(R.id.editSprintBtn)).perform(click());
        onView(allOf(withText("Test Title"))).perform(click());
        onView(withId(R.id.editSprintTitleEditText)).perform(ViewActions.replaceText(""), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.editSprintSubmitBtn)).perform(click());
        assertEquals("Test Title", sprintManager.getSprint(1).getLabel());
    }

    @Test
    public void GivingTheSprintABlankCapacityValueDoesNotChangeTheSprintCapacityValue() {
        onView(withId(R.id.editSprintBtn)).perform(click());
        onView(allOf(withText("Test Title"))).perform(click());
        onView(withId(R.id.editSprintCapacityEditText)).perform(ViewActions.replaceText(""), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.editSprintSubmitBtn)).perform(click());
        assertEquals(9, sprintManager.getSprint(1).getCapacity());
    }

    @Test
    public void GivingTheSprintABlankFrequencyValueDoesNotChangeTheSprintFrequencyValue() {
        onView(withId(R.id.editSprintBtn)).perform(click());
        onView(allOf(withText("Test Title"))).perform(click());
        onView(withId(R.id.editSprintFrequencyEditText)).perform(ViewActions.replaceText(""), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.editSprintSubmitBtn)).perform(click());
        assertEquals(14, sprintManager.getSprint(1).getFrequencyInDays());
    }

    @Test
    public void GivingTheSprintABlankLengthValueDoesNotChangeTheSprintLengthValue() {
        onView(withId(R.id.editSprintBtn)).perform(click());
        onView(allOf(withText("Test Title"))).perform(click());
        onView(withId(R.id.editSprintLengthEditText)).perform(ViewActions.replaceText(""), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.editSprintSubmitBtn)).perform(click());
        assertEquals(7, sprintManager.getSprint(1).getLength());
    }

    @Test
    public void SubmittingTheEditedSprintShouldTakeUserBackToMainMenu() {
        onView(withId(R.id.editSprintBtn)).perform(click());
        onView(allOf(withText("Test Title"))).perform(click());
        onView(withId(R.id.editSprintSubmitBtn)).perform(click());
        onView(withId(R.id.addNewStoryBtn)).check(matches(isDisplayed()));
    }

}
