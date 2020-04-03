package com.actual.myapplication;

/**
 * Manages id variable and the generation process
 * to ensure a unique id for story objects.
 *
 * @author jessiewilkins
 * @since 2020-02
 */
public class SprintIdGenerator extends IdGenerator{

    private static long id = 0;

    @Override
    protected void callInheritedId() {
        setId(id);
    }
}
