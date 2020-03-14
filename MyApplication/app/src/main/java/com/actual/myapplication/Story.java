package com.actual.myapplication;

class Story {
    private String title = "Default Title";
    private String description = "Default Description";
    private final PointsManagement points_management = new PointsManagement();
    private StoryStatus status = StoryStatus.READY;
    public enum StoryStatus {
        READY,
        IN_PROGRESS,
        DONE
    }
    private String sprint = "Default Sprint";
    private final int id;

    public Story() {
        id = IdGenerator.generateId();
    }

    public String getTitle() {
        return this.title;
    }

    public void setStoryAttributes(StoryBuilder attributes) {
        this.title = attributes.getTitle();
        this.description = attributes.getDescription();
        this.points_management.setPoints(attributes.getPoints());
        this.status = attributes.getStatus();
        this.sprint = attributes.getSprint();
        this.points_management.setCompletedPoints(attributes.getCompleted_points());
    }

    public String getDescription() {
        return this.description;
    }

    public PointsManagement getPointsManagement() {
        return this.points_management;
    }

    public StoryStatus getStatus() {
        return this.status;
    }

    public String getSprint() {
        return this.sprint;
    }

    public int getId() {
        return id;
    }
}
