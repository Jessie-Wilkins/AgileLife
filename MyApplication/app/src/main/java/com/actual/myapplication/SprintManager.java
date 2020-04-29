package com.actual.myapplication;

import java.util.ArrayList;
import java.util.List;

class SprintManager {

    private static SprintManager sprint_manager = new SprintManager();

    private static ArrayList<Sprint> current_sprint_list = new ArrayList<>();

    private static ArrayList<Sprint> future_sprint_list = new ArrayList<>();

    private static ArrayList<Sprint> removed_sprint_list = new ArrayList<>();

    private ArrayList<Sprint> saved_sprint_list = new ArrayList<>();

    private final SprintBuilder sprint_builder = SprintBuilder.initiateSprintBuilder();

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

    public void retrieveDeletedSprint(int id) {
        appendNullItemsToList(current_sprint_list);
        moveFromCurrentListToOtherList(removed_sprint_list, current_sprint_list, id);
    }

    public Sprint getNextOccurringVersionOfSprint(int id) {

        if(sprint_manager.getSprint(id).getFutureSprintId() == 0) {
            createFutureSprint(id);
        }

        return sprint_manager.getFutureSprint(sprint_manager.getSprint(id).getFutureSprintId());
    }

    public Sprint getFutureSprint(int id) {
        return future_sprint_list.get(getIndex(id));
    }

    public void setFutureSprintAsCurrentSprint(int id) {
        sprint_manager.appendNullItemsToList(current_sprint_list);
        sprint_manager.moveFromCurrentListToOtherList(future_sprint_list, current_sprint_list, id);
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

    private void createFutureSprint(int id) {
        sprint_builder.setLabel(sprint_manager.getSprint(id).getLabel());
        sprint_builder.setLength(sprint_manager.getSprint(id).getLength());
        sprint_builder.setFrequency(sprint_manager.getSprint(id).getFrequencyInDays());
        sprint_manager.addSprint(sprint_builder);
        sprint_manager.appendNullItemsToList(future_sprint_list);
        sprint_manager.moveFromCurrentListToOtherList(current_sprint_list, future_sprint_list, current_sprint_list.get(current_sprint_list.size()-1).getId());
        sprint_manager.getSprint(id).setFutureSprintId(future_sprint_list.get(future_sprint_list.size()-1).getId());
        sprint_manager.getFutureSprint(future_sprint_list.get(future_sprint_list.size()-1).getId()).setPastSprintId(id);
    }


}
