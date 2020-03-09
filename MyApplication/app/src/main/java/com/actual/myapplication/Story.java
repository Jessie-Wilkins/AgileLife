package com.actual.myapplication;

class Story {
    private String title = "Default Title";
    private String description = "Default Description";
    private int points = 0;

    public String getTitle() {
        return this.title;
    }

    public void setStoryAttributes(StoryBuilder attributes) {
        this.title = attributes.getTitle();
        this.description = attributes.getDescription();
        this.points = attributes.getPoints();
    }

    public String getDescription() {
        return this.description;
    }

    public int getPoints() {
        return this.points;
    }
}
