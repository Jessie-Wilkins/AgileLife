package com.actual.myapplication;

/**
 * Manages id variable and the generation process
 * to ensure a unique id for sprint objects.
 *
 * @author jessiewilkins
 * @since 2020-04
 */
public class SprintIdGenerator extends IdGenerator{

    private static long id = 0;

    protected SprintIdGenerator() {

    }

    @Override
    protected long getChildId() {
        return id;
    }

   /* public static long generateId() {
        return ++id;
    }

    public static void resetId() {
        id = 0;
    }*/

}
