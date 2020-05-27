package com.actual.myapplication;


/**
 * Manages Point System by adding and removing points.
 * Manages several points variables involving assigned or total points,
 * current uncompleted points, and completed points. It also keeps track of
 * capacity.
 *
 * @author jessiewilkins
 * @since 2020-02
 */
public class PointsManagement {
    private int points = 0;
    private int capacity = 0;
    private int completed_points = 0;
    private int total_points = 0;

    /**
     * Sets the number of points that have not been completed
     * @param points
     */
    public void setPoints(int points) {
        this.points = points;
        this.total_points = this.points+this.completed_points;
    }

    /**
     * Sets the completed number of points
     * @param completed_points
     */
    public void setCompletedPoints(int completed_points) {
        this.completed_points = completed_points;
        this.total_points = this.points+this.completed_points;
    }

    /**
     * Increments the current number of uncompleted points
     * by the number of points specified
     * @param points
     */
    public void addPoints(int points) {
        this.points += points;
        this.total_points += points;
    }

    /**
     * Gets the total points (uncompleted points + completed points)
     * @return total_points
     */
    public  int getTotalPoints() {
        return this.total_points;
    }

    /**
     * Gets the number of uncompleted points
     * @return points
     */
    public int getPoints() {
        return this.points;
    }

    /**
     * Subtracts the specified number of points from
     * the uncompleted number of points
     * @param points
     */
    public void removePoints(int points) {
        this.points = subtractLatterFromFormerConditional(this.points, points, "points");
        this.total_points = subtractLatterFromFormerConditional(this.total_points, points, "total points");
    }

    /**
     * Increments the amount of capacity by the specified amount
     * @param capacity
     */
    public void addCapacity(int capacity) {
        this.capacity += capacity;
    }

    /**
     * Subtracts the specified amount from the amount of capacity
     * @param capacity
     */
    public void removeCapacity(int capacity) {
        this.capacity = subtractLatterFromFormerConditional(this.capacity, capacity, "capacity");
    }

    /**
     * Sets the capacity to the specified amount
     * @param capacity
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Gets the capacity
     * @return capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Decrements the number of uncompleted points and increments the number
     * of completed points by the amount specified
     * @param points
     */
    public void completePoints(int points) {
        this.points =  subtractLatterFromFormerConditional(this.points, points, "completed points");
        this.completed_points+=points;
    }

    /**
     * Gets the completed number of points
     * @return completed_points
     */
    public int getCompletedPoints() {
        return this.completed_points;
    }

    //Private Utilities Section

    private boolean formerIsGreaterThanOrEqualLatter(int former, int latter) {
        return former >= latter;
    }

    private int subtractLatterFromFormerConditional(int former, int latter, String object_of_message) {
        if(formerIsGreaterThanOrEqualLatter(former, latter)) {
            former -=latter;
            return former;
        }
        else {
            System.out.println("Cannot remove more "+object_of_message+" than allotted!");
            return former;
        }
    }
}
