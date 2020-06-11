package com.actual.myapplication;

/**
 * Manages id variable and the generation process
 * to ensure a unique id for sprint objects.
 *
 * @author jessiewilkins
 * @since 2020-04
 */
public class SprintIdGenerator implements IdGeneratorStrategy{

    private static int id = 0;

    private static SprintIdGenerator id_generator = new SprintIdGenerator();

    private SprintIdGenerator() {

    }

    public static SprintIdGenerator getSprintIdGenerator() {
        return id_generator;
    }

    public int generateId() {
        return ++id;
    }

    public void resetId() {
        id = 0;
    }

}
