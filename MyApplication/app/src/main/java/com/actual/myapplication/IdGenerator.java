package com.actual.myapplication;

/**
 * Manages id variable and the generation process
 * to ensure a unique id for story objects.
 *
 * @author jessiewilkins
 * @since 2020-02
 */
public abstract class IdGenerator {

    private static long id;

    protected static void setId(long inherited_id) {
        id = inherited_id;
    }

    protected abstract void callInheritedId();

    protected IdGenerator() {

    }

    public static long generateId() {
        return ++id;
    }

    public static void resetId() {
        id = 0;
    }
}
