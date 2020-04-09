package com.actual.myapplication;

class SprintBuilder {

    private static SprintBuilder sprint_builder;

    private static boolean object_not_existent = true;

    public static SprintBuilder initiateSprintBuilder() {

        return getSprintBuilder();
    }

    private static SprintBuilder getSprintBuilder() {
        if(object_not_existent) {
            object_not_existent=false;
            initiateObject();
            return sprint_builder;
        }
        else {
            return sprint_builder;
        }
    }

    private static void initiateObject() {
        sprint_builder = new SprintBuilder();
    }
}
