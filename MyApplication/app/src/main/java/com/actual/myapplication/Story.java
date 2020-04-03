package com.actual.myapplication;

/**
 * Manages story details such as strings (titles, descriptions, etc.),
 * points management object, and the status enum.
 *
 * @author jessiewilkins
 * @since 2020-02
 */
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
    private final long id;

    public Story() {
        id = StoryIdGenerator.generateId();
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
        attributes.setAttributesToNotChanged();
    }
    public void setChangedStoryAttributes(StoryBuilder attributes) {
        if(attributes.isTitleChanged()) {
            this.title = attributes.getTitle();
        }
        if(attributes.isDescriptionChanged()) {
            this.description = attributes.getDescription();
        }
        if(attributes.arePointsChanged()) {
            this.points_management.setPoints(attributes.getPoints());
        }
        if(attributes.isStatusChanged()) {
            this.status = attributes.getStatus();
        }
        if(attributes.isSprintChanged()) {
            this.sprint = attributes.getSprint();
        }
        if(attributes.areCompletedPointsChanged()) {
            this.points_management.setCompletedPoints(attributes.getCompleted_points());
        }
        attributes.setAttributesToNotChanged();

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

    public void setSprint(String sprint) {
        this.sprint = sprint;
    }

    public long getId() {
        return id;
    }
}
