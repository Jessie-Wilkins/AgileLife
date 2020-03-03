package com.actual.myapplication;

class PointsManagement {
    private int points = 0;
    private int capacity = 0;
    public void addPoints(int points) {
        this.points += points;
    }

    public int getPoints() {
        return points;
    }

    public void removePoints(int points) {
        this.points = subtractLatterFromFormerConditional(this.points, points, "points");
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

    public int completePoints(int points) {
        return 0;
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
