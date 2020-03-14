package com.actual.myapplication;
import java.lang.Enum;

class Story {
    private String title = "Default Title";
    private String description = "Default Description";
    private PointsManagement points = new PointsManagement();
    private StoryStatus status = StoryStatus.READY;
    public enum StoryStatus {
        READY,
        IN_PROGRESS,
        DONE
    }
    private String sprint = "Default Sprint";
    private int id;

    public Story() {
        id = IdGenerator.generateId();
    }

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
