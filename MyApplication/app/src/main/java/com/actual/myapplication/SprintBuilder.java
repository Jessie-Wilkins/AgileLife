package com.actual.myapplication;

/**
 * This class builds sprint objects with the given fields.
 *
 * @author jessiewilkins
 * @since 2020-04-01
 */
class SprintBuilder {

    private static SprintBuilder sprint_builder = new SprintBuilder();

    private static String label;

    private static int length;

    private static int capacity;
    private static int frequency;

    /**
     * Made private so that it cannot be instantiated
     * multiple times.
     */
    private SprintBuilder () {

    }

    /**
     * Initiates the sprint builder in a way
     * that ensures there is only one sprint builder.
     * @return sprint_builder
     */
    public static SprintBuilder initiateSprintBuilder() {
        return sprint_builder;
    }

    /**
     * Sets the label or title of the sprint.
     * @param label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Gets the label of the sprint
     * @return label
     */
    public String getLabel() {
        return this.label;
    }

    /**
     * Sets the length of the sprint (in days)
     * @param length
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * Gets the length of the sprint (in days)
     * @return length
     */
    public int getLength() {
        return this.length;
    }

    /**
     * Sets the capacity of the sprint from
     * its assigned points object.
     * @param capacity
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Get the capacity of the sprint from
     * its assigned points object
     * @return capacity
     */
    public int getCapacity() {
        return this.capacity;
    }

    /**
     * Set the frequency of the sprint (in days)
     * @param frequency
     */
    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    /**
     * Get the frequency of the sprint (in days)
     * @return frequency
     */
    public int getFrequency() {
        return this.frequency;
    }
}
