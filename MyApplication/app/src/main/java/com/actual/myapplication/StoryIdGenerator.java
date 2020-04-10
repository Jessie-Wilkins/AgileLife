package com.actual.myapplication;

/**
 * Manages id variable and the generation process
 * to ensure a unique id for story objects.
 *
 * @author jessiewilkins
 * @since 2020-02
 */
public class StoryIdGenerator extends IdGenerator{

    private static long id = 0;

    protected StoryIdGenerator() {
        super.id = id;
    }

}
