package com.actual.myapplication;

import java.util.ArrayList;

class SprintManager {

    private static SprintManager sprint_manager = new SprintManager();

    private static ArrayList<Sprint> sprint_list = new ArrayList<>();

    private SprintManager() {

    }

    public static SprintManager initiateSprintManager() {
        sprint_list.clear();
        return sprint_manager;
    }

    public void addSprint() {
        sprint_list.add(new Sprint());
    }

    public Sprint getSprint(long id) {
        return sprint_list.get(getIndex((int) id));
    }

    private int getIndex(int id) {
        return id - 1;
    }

    public void addSprint(SprintBuilder sprint_builder) {
        Sprint sprint = new Sprint();
        sprint.setLabel(sprint_builder.getLabel());
        sprint.setCapacity(sprint_builder.getCapacity());
        sprint.setFrequencyInDays(sprint_builder.getFrequency());
        sprint.setLength(sprint_builder.getLength());
        sprint_list.add(sprint);
    }

    public void removeSprint(long id) {
        sprint_list.set(getIndex((int) id), null);
    }
}
