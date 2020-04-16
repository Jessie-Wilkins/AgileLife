package com.actual.myapplication;

class SprintBuilder {

    private static SprintBuilder sprint_builder = new SprintBuilder();

    private static String label;

    private SprintBuilder () {

    }

    public static SprintBuilder initiateSprintBuilder() {
        return sprint_builder;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }
}
