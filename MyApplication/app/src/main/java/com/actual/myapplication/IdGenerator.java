package com.actual.myapplication;

/**
 * Manages id variable and the generation process
 * to ensure a unique id for story objects.
 *
 * @author jessiewilkins
 * @since 2020-02
 */
 public class IdGenerator{

    private static IdGeneratorStrategy strategy;

    private IdGenerator() {

    }

    public static void setStrategy(IdGeneratorStrategy strategy) {
        IdGenerator.strategy = strategy;
    }

    public static int generateId() {
        return strategy.generateId();
    }


    public static void resetId() {
        strategy.resetId();
    }
}
