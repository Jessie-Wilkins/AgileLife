package com.actual.myapplication.Theories;

import com.actual.myapplication.Story;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import java.util.ArrayList;

@RunWith(JUnitQuickcheck.class)
public class StoryTheories {

    private ArrayList<Integer> id_array = new ArrayList<>();

    @Property public void testThatStoriesCanGenerateAUniqueIdEveryTime(@InRange(minInt = 1, maxInt = 9999999)int amount_of_times_to_generate) {
        Story story;
        for(int i = 0; i<amount_of_times_to_generate; i++) {
            story = new Story();
            id_array.add((int) story.getId());
        }

        story = new Story();

        assert(!id_array.contains(story.getId()));
    }

}
