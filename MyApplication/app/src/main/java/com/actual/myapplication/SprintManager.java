package com.actual.myapplication;

import java.util.ArrayList;
import java.util.List;

class SprintManager {

    private static SprintManager sprint_manager = new SprintManager();

    private static ArrayList<Sprint> current_sprint_list = new ArrayList<>();

    private static ArrayList<Sprint> future_sprint_list = new ArrayList<>();

    private static ArrayList<Sprint> removed_sprint_list = new ArrayList<>();

    private static ArrayList<Sprint> saved_sprint_list = new ArrayList<>();

    private static ArrayList<Sprint> past_sprint_list = new ArrayList<>();

    private final SprintBuilder sprint_builder = SprintBuilder.initiateSprintBuilder();

    private SprintManager() {

    }

    /**
     * Initiates the SprintManager for first-time use.
     * @return SprintManager
     */
    public static SprintManager initiateSprintManager() {
        current_sprint_list.clear();
        saved_sprint_list.clear();
        removed_sprint_list.clear();
        future_sprint_list.clear();
        return sprint_manager;
    }

    /**
     * Adds a new sprint with default values
     */
    public void addSprint() {
        current_sprint_list.add(new Sprint());
    }

    /**
     * Gets the sprint by the specified id
     * @param id an integer that identifies each sprint
     * @return Sprint
     */
    public Sprint getSprint(int id) {
        return current_sprint_list.get(getIndex(id));
    }

    /**
     * Adds a sprint based off of the fields set in the sprint builder
     * @param sprint_builder a builder class containing all variables that can
     *                       be set in a sprint.
     */
    public void addSprint(SprintBuilder sprint_builder) {
        Sprint sprint = new Sprint();
        sprint.setLabel(sprint_builder.getLabel());
        sprint.setCapacity(sprint_builder.getCapacity());
        sprint.setFrequencyInDays(sprint_builder.getFrequency());
        sprint.setLength(sprint_builder.getLength());
        current_sprint_list.add(sprint);
    }

    /**
     * Removes the sprint based off of the id
     * @param id an integer that identifies each sprint
     */
    public void removeSprint(int id) {
        appendNullItemsToList(removed_sprint_list);
        moveFromCurrentListToOtherList(current_sprint_list, removed_sprint_list, id);
    }

    /**
     * Gets a sprint from the removed sprint list.
     * @param id an integer that identifies each sprint
     * @return Sprint
     */
    public Sprint getRemovedSprint(int id) {
        return removed_sprint_list.get(getIndex(id));
    }

    /**
     * Stores the sprint in the saved sprint list
     * @param id an integer that identifies each sprint
     */
    public void saveSprint(int id) {
        appendNullItemsToList(saved_sprint_list);
        moveFromCurrentListToOtherList(current_sprint_list, saved_sprint_list, id);
    }

    /**
     * Gets a saved sprint from the saved sprint list
     * @param id an integer that identifies each sprint
     * @return
     */
    public Sprint getSavedSprint(int id) {
        return saved_sprint_list.get(getIndex(id));
    }

    /**
     * Moves the saved sprint to the current sprint list
     * @param id an integer that identifies each sprint
     */
    public void loadSprint(int id) {
        appendNullItemsToList(current_sprint_list);
        moveFromCurrentListToOtherList(saved_sprint_list, current_sprint_list, id);
    }

    /**
     * Moves the removed or deleted sprint from the removed sprint list to the current sprint list
     * @param id an integer that identifies each sprint
     */
    public void retrieveDeletedSprint(int id) {
        appendNullItemsToList(current_sprint_list);
        moveFromCurrentListToOtherList(removed_sprint_list, current_sprint_list, id);
    }

    /**
     * Gets the next or future version of a sprint based of a current sprint's id
     * @param id an integer that identifies each sprint
     * @return
     */
    public Sprint getNextOccurringVersionOfSprint(int id) {

        if(sprint_manager.getSprint(id).getFutureSprintId() == 0) {
            createFutureSprint(id);
        }

        return sprint_manager.getFutureSprint(sprint_manager.getSprint(id).getFutureSprintId());
    }

    /**
     * Gets the future sprint using the future sprint's id
     * @param id an integer that identifies each sprint
     * @return
     */
    public Sprint getFutureSprint(int id) {
        return future_sprint_list.get(getIndex(id));
    }

    /**
     * Moves the future sprint into the current sprint list
     * and places the sprint previous to it to the past
     * sprint list
     * @param id an integer that identifies each sprint
     */
    public void setFutureSprintAsCurrentSprint(int id) {
        sprint_manager.appendNullItemsToList(current_sprint_list);
        sprint_manager.moveFromCurrentListToOtherList(future_sprint_list, current_sprint_list, id);
        sprint_manager.addToPastSprintList(sprint_manager.getSprint(id).getPastSprintId());
    }

    private void addToPastSprintList(int id) {
        sprint_manager.appendNullItemsToList(past_sprint_list);
        sprint_manager.moveFromCurrentListToOtherList(current_sprint_list, past_sprint_list, id);
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


    public Sprint getPastSprint(int id) {
        return past_sprint_list.get(getIndex(id));
    }
}
