package com.actual.myapplication;

class StoryBuilder {
    private static int builder_count = 0;
    private String title;
    private String description;
    private int points;
    private static StoryBuilder builder;
    private Story.StoryStatus status;
    private String sprint;
    private int completed_points;

    private StoryBuilder() {

    }

    public static StoryBuilder initiateBuilder() {
        if(builder_count == 0) {
            builder_count++;
            builder = new StoryBuilder();
            return builder;
        }
        else {
            return builder;
        }
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getPoints() {
        return this.points;
    }

    public void setStatus(Story.StoryStatus status) {
        this.status = status;
    }

    public Story.StoryStatus getStatus() {
        return this.status;
    }

    public void setSprint(String sprint) {
        this.sprint = sprint;
    }

    public String getSprint() {
        return this.sprint;
    }

    public void setCompletedPoints(int completed_points) {
        this.completed_points = completed_points;
    }

    public int getCompleted_points() {
        return this.completed_points;
    }
}
