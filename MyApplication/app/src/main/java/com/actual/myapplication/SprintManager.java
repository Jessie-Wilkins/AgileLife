package com.actual.myapplication;

import java.util.ArrayList;
import java.util.List;

class SprintManager {

    private static SprintManager sprint_manager = new SprintManager();

    private static ArrayList<Sprint> current_sprint_list = new ArrayList<>();

    private static ArrayList<Sprint> removed_sprint_list = new ArrayList<>();
    private ArrayList<Sprint> saved_sprint_list = new ArrayList<>();

    private SprintManager() {

    }

    public static SprintManager initiateSprintManager() {
        current_sprint_list.clear();
        return sprint_manager;
    }

    public void addSprint() {
        current_sprint_list.add(new Sprint());
    }

    public Sprint getSprint(int id) {
        return current_sprint_list.get(getIndex(id));
    }

    public void addSprint(SprintBuilder sprint_builder) {
        Sprint sprint = new Sprint();
        sprint.setLabel(sprint_builder.getLabel());
        sprint.setCapacity(sprint_builder.getCapacity());
        sprint.setFrequencyInDays(sprint_builder.getFrequency());
        sprint.setLength(sprint_builder.getLength());
        current_sprint_list.add(sprint);
    }

    public void removeSprint(int id) {
        appendNullItemsToList(removed_sprint_list);
        moveFromCurrentListToOtherList(current_sprint_list, removed_sprint_list, id);
    }

    public Sprint getRemovedSprint(int i) {
        return removed_sprint_list.get(getIndex(i));
    }

    public void saveSprint(int id) {
        appendNullItemsToList(saved_sprint_list);
        moveFromCurrentListToOtherList(current_sprint_list, saved_sprint_list, id);
    }

    public Sprint getSavedSprint(int id) {
        return saved_sprint_list.get(getIndex(id));
    }

    public void loadSprint(int id) {
        appendNullItemsToList(current_sprint_list);
        moveFromCurrentListToOtherList(saved_sprint_list, current_sprint_list, id);
    }

    //Private Utilities Section

    private int getIndex(int id) {
        return id - 1;
    }

    private void moveFromCurrentListToOtherList(List<Sprint> current_list, List<Sprint> other_list, int id) {
        Sprint temp_sprint = current_list.get(getIndex(id));
        current_list.set(getIndex(id), null);
        other_list.set(getIndex(id), temp_sprint);
    }

    private void appendNullItemsToList(List<Sprint> specific_sprint_list) {
        while(specific_sprint_list.size()< current_sprint_list.size()){
            specific_sprint_list.add(null);
        }
    }
}
