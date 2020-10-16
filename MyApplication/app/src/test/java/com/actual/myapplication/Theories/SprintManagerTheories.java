package com.actual.myapplication.Theories;

import com.actual.myapplication.Sprint;
import com.actual.myapplication.SprintManager;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import org.junit.runner.RunWith;

import java.util.ArrayList;

@RunWith(JUnitQuickcheck.class)
public class SprintManagerTheories {

    private ArrayList<Integer> id_array;

    @Property public void testThatSprintManagerCanGenerateAFutureSprintIdNotEqualToAnotherFutureSprintIdEveryTime(@InRange(minInt = 1, maxInt = 999999)int amount_of_times_to_generate) {
        SprintManager sprint_mgr = SprintManager.initiateSprintManager();
        id_array = new ArrayList<Integer>();
        int i;
        for(i = 0; i<amount_of_times_to_generate; i+=2) {
           sprint_mgr.addSprint();
           id_array.add(sprint_mgr.getNextOccurringVersionOfSprint(i+1).getId());
        }

        sprint_mgr.addSprint();

        assert(!id_array.contains(sprint_mgr.getNextOccurringVersionOfSprint(i+1).getId()));

    }

}
