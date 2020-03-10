package com.actual.myapplication;

class Story {
    private String title = "Default Title";
    private String description = "Default Description";
    private PointsManagement points = new PointsManagement();
    private String status = "Default Status";
    private String sprint;

    public String getTitle() {
        return this.title;
    }

    public void setStoryAttributes(StoryBuilder attributes) {
        this.title = attributes.getTitle();
        this.description = attributes.getDescription();
        this.points.addPoints(attributes.getPoints());
        this.status = attributes.getStatus();
        this.sprint = attributes.getSprint();
        this.points.completePoints(attributes.getCompleted_points());
    }

    public String getDescription() {
        return this.description;
    }

    public PointsManagement getPoints() {
        return this.points;
    }

    public String getStatus() {
        return this.status;
    }

    public String getSprint() {
        return this.sprint;
    }
}
