package com.actual.myapplication;

/**
 * Manages id variable and the generation process
 * to ensure a unique id for story objects.
 *
 * @author jessiewilkins
 * @since 2020-02
 */
public class StoryIdGenerator implements IdGeneratorStrategy{

    private static int id = 0;

    private static StoryIdGenerator id_generator = new StoryIdGenerator();

    private StoryIdGenerator() {

    }

    public static StoryIdGenerator getStoryIdGenerator() {
        return id_generator;
    }

    public int generateId() {
        return ++id;
    }

    public void resetId() {
        id = 0;
    }



}
