package com.actual.myapplication;

class PointsManagement {
    private int points = 0;
    private int capacity = 0;
    private int completed_points = 0;
    private int total_points = 0;
    public void addPoints(int points) {
        this.points += points;
        this.total_points += points;
    }

    public  int getTotalPoints() {
        return this.total_points;
    }

    public int getPoints() {
        return this.points;
    }

    public void removePoints(int points) {
        this.points = subtractLatterFromFormerConditional(this.points, points, "points");
        this.total_points = subtractLatterFromFormerConditional(this.total_points, points, "total points");
    }

    public void addCapacity(int capacity) {
        this.capacity += capacity;
    }

    public void removeCapacity(int capacity) {
        this.capacity = subtractLatterFromFormerConditional(this.capacity, capacity, "capacity");
    }

    public int getCapacity() {
        return capacity;
    }

    public void completePoints(int points) {
        this.points =  subtractLatterFromFormerConditional(this.points, points, "completed points");
        this.completed_points+=points;
    }

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
