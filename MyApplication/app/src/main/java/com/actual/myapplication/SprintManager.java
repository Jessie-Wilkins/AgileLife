package com.actual.myapplication;

class SprintManager {

    private static SprintManager sprint_manager = new SprintManager();

    private Sprint sprint;

    private SprintManager() {

    }

    public static SprintManager initiateSprintManager() {
        return sprint_manager;
    }

    public void addSprint(SprintBuilder sprint_builder) {
        sprint = new Sprint();
    }

    public Sprint getSprint(long id) {
        return sprint;
    }
}
