package com.actual.myapplication;

/**
 * Manages id variable and the generation process
 * to ensure a unique id for story objects.
 *
 * @author jessiewilkins
 * @since 2020-02
 */
public class SprintIdGenerator {

    private static long id = 0;

    protected SprintIdGenerator() {

    }

    public static long generateId() {
        return ++id;
    }

    public static void resetId() {
        id = 0;
    }

}
