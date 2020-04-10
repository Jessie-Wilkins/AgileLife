package com.actual.myapplication;

class SprintManager {

    private static SprintManager sprint_manager = new SprintManager();

    private SprintManager() {

    }

    public static SprintManager initiateSprintManager() {
        return sprint_manager;
    }

    public void addSprint(SprintBuilder sprint_builder) {

    }
}
