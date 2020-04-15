package com.actual.myapplication;

/**
 * Manages id variable and the generation process
 * to ensure a unique id for story objects.
 *
 * @author jessiewilkins
 * @since 2020-02
 */
public class StoryIdGenerator implements IdGeneratorStrategy{

    private static long id = 0;

    private StoryIdGenerator() {

    }

    private static StoryIdGenerator id_generator = new StoryIdGenerator();

    public static StoryIdGenerator getStoryIdGenerator() {
        return id_generator;
    }

    public long generateId() {
        return ++id;
    }

    public void resetId() {
        id = 0;
    }



}
