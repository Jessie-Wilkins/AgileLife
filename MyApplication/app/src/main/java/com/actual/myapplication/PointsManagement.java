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
        if(formerIsGreaterThanOrEqualLatter(this.points, points)) {
            this.points -=points;
        }
        else {
            System.out.println("Cannot remove more points than allotted!");
        }
    }

    public void addCapacity(int capacity) {
        this.capacity += capacity;
    }

    public void removeCapacity(int capacity) {
        if(formerIsGreaterThanOrEqualLatter(this.capacity, capacity)) {
            this.capacity -= capacity;
        }
        else {
            System.out.println("Cannot remove more capacity than allotted!");
        }
    }

    private boolean formerIsGreaterThanOrEqualLatter(int former, int latter) {
        return former >= latter;
    }

    public int getCapacity() {
        return capacity;
    }

    //Private Utilities Section

}
