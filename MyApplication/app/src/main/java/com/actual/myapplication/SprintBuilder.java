package com.actual.myapplication;

class SprintBuilder {

    private static SprintBuilder sprint_builder = new SprintBuilder();

    private SprintBuilder () {

    }

    public static SprintBuilder initiateSprintBuilder() {
        return sprint_builder;
    }
}
