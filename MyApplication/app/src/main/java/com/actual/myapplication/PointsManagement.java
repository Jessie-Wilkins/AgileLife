package com.actual.myapplication;

class PointsManagement {
    private int points = 0;
    public void addPoints(int points) {
        this.points += points;
    }

    public int getPoints() {
        return points;
    }

    public void removePoints(int points) {
        if(this.points > 0) {
            this.points -=points;
        }
        else {
            System.out.println("Cannot remove more points than allotted!");
        }
    }

}
