package com.actual.myapplication;

class SprintBuilder {

    private static SprintBuilder sprint_builder = new SprintBuilder();

    private static String label;

    private static int length;

    private static int capacity;
    private static int frequency;

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

    public void setLength(int length) {
        this.length = length;
    }

    public int getLength() {
        return this.length;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int getFrequency() {
        return this.frequency;
    }
}
