package com.actual.myapplication;

import java.util.ArrayList;

class SprintManager {

    private static SprintManager sprint_manager = new SprintManager();

    private static ArrayList<Sprint> sprint_list = new ArrayList<>();

    private static ArrayList<Sprint> removed_sprint_list = new ArrayList<>();

    private SprintManager() {

    }

    public static SprintManager initiateSprintManager() {
        sprint_list.clear();
        return sprint_manager;
    }

    public void addSprint() {
        sprint_list.add(new Sprint());
    }

    public Sprint getSprint(int id) {
        return sprint_list.get(getIndex(id));
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

    public void removeSprint(int id) {
        appendNullItemsToList();
        moveToDeletedList(id);
    }

    public Sprint getRemovedSprint(int i) {
        return removed_sprint_list.get(getIndex(i));
    }

    private void moveToDeletedList(int id) {
        Sprint temp_sprint = sprint_list.get(getIndex(id));
        sprint_list.set(getIndex(id), null);
        removed_sprint_list.set(getIndex(id), temp_sprint);
    }

    private void appendNullItemsToList() {
        while(removed_sprint_list.size()<sprint_list.size()){
            removed_sprint_list.add(null);
        }
    }

}
