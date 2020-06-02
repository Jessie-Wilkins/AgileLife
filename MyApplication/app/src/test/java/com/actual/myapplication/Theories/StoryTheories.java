package com.actual.myapplication.Theories;

import com.actual.myapplication.Story;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import java.util.ArrayList;

@RunWith(JUnitQuickcheck.class)
public class StoryTheories {

    private ArrayList<Integer> id_array = new ArrayList<>();

    @Property public void testThatStoriesCanGenerateAUniqueIdEveryTime() {
        Story story = new Story();

        assert(!id_array.contains(story.getId()));

        id_array.add((int) story.getId());
    }

}
