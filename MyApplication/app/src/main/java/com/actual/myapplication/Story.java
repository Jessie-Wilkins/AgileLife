package com.actual.myapplication;

/**
 * Manages story details such as strings (titles, descriptions, etc.),
 * points management object, and the status enum.
 *
 * @author jessiewilkins
 * @since 2020-02
 */
public class Story {
    private String title = "Default Title";
    private String description = "Default Description";
    private final PointsManagement points_management = new PointsManagement();
    private StoryStatus status = StoryStatus.READY;

    public enum StoryStatus {
        READY,
        IN_PROGRESS,
        DONE
    }
    private String sprint_title_id = "Default Sprint";
    private final long id;

    /**
     * Creates a story object and creates an id for it
     */
    public Story() {
        IdGenerator.setStrategy(StoryIdGenerator.getStoryIdGenerator());
        id = IdGenerator.generateId();
    }

    /**
     * Get the title of the story
     * @return title
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Sets the story attributes from a story builder
     * @param attributes
     */
    public void setStoryAttributes(StoryBuilder attributes) {
        this.title = attributes.getTitle();
        this.description = attributes.getDescription();
        this.points_management.setPoints(attributes.getPoints());
        this.status = attributes.getStatus();
        this.sprint_title_id = attributes.getSprintTitleAndId();
        this.points_management.setCompletedPoints(attributes.getCompleted_points());
        attributes.setAttributesToNotChanged();
    }

    /**
     * Sets the story attributes from a story builder
     * based only on attributes that have changed
     * @param attributes
     */
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
            this.sprint_title_id = attributes.getSprintTitleAndId();
        }
        if(attributes.areCompletedPointsChanged()) {
            this.points_management.setCompletedPoints(attributes.getCompleted_points());
        }
        attributes.setAttributesToNotChanged();

    }

    /**
     * Gets the description from the story
     * @return description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Gets the point management object from the story
     * @return points_management
     */
    public PointsManagement getPointsManagement() {
        return this.points_management;
    }

    /**
     * Gets the status from the story
     * @return status
     */
    public StoryStatus getStatus() {
        return this.status;
    }

    /**
     * Gets the sprint title/id from the story
     * @return sprint
     */
    public String getSprintTitleAndId() {
        return this.sprint_title_id;
    }

    /**
     * Sets the sprint title/id
     * @param sprint
     */
    public void setSprintTitleAndId(String sprint) {
        this.sprint_title_id = sprint;
    }

    /**
     * Gets the id of the story
     * @return id
     */
    public long getId() {
        return id;
    }
}
