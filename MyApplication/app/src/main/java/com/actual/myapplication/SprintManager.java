package com.actual.myapplication;

class SprintManager {

    private static boolean object_not_existent = true;

    private static SprintManager sprint_manager;

    private SprintManager() {

    }

    public static SprintManager initiateSprintManager() {
        if(object_not_existent) {
            object_not_existent=false;
            sprint_manager = new SprintManager();
            return sprint_manager;
        }
        else {
            return sprint_manager;
        }

    }
}
