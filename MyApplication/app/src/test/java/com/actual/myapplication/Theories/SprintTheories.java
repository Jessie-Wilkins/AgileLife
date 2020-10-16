package com.actual.myapplication.Theories;

import com.actual.myapplication.Sprint;
import com.actual.myapplication.StoryManager;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import org.junit.runner.RunWith;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitQuickcheck.class)
public class SprintTheories {

    private ArrayList<Integer> id_array = new ArrayList<>();
    private StoryManager story_mgr = StoryManager.initiateStoryManager();

    @Property public void testThatSprintsCanGenerateAUniqueIdEveryTime(@InRange(minInt = 1, maxInt = 999999)int amount_of_times_to_generate) {
        Sprint sprint;
        for(int i = 0; i<amount_of_times_to_generate; i++) {
            sprint = new Sprint();
            id_array.add( sprint.getId());
        }

        sprint = new Sprint();

        assert(!id_array.contains(sprint.getId()));

    }

}
