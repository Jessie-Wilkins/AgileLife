package com.actual.myapplication;

public class IdGenerator {

    private static int id=0;

    private IdGenerator() {

    }

    public static int generateId() {
        return ++id;
    }

    public static void resetId() {
        id = 0;
    }
}
