package com.actual.myapplication;

/**
 * Builds object for setting variables in story.
 *
 * @author jessiewilkins
 * @since 2020-02
 */
public class StoryBuilder {
    private String title;
    private String description;
    private int points;
    private static StoryBuilder builder = new StoryBuilder();
    private Story.StoryStatus status;
    private String sprint_title_id = "DefaultSprint";
    private int completed_points;
    private boolean completed_points_changed = false;
    private boolean points_changed = false;
    private boolean sprintChanged = false;
    private boolean statusChanged = false;
    private boolean descriptionChanged = false;
    private boolean titleChanged = false;

    private StoryBuilder() {

    }

    /**
     * Initiates the builder statically.
     * @return builder
     */
    public static StoryBuilder initiateBuilder() {
        return builder;
    }

    /**
     * Resets the builder by setting null and
     * re-instantiating the object
     */
    public static void resetBuilderAsUninitiated() {
        builder = null;
        builder = new StoryBuilder();
    }

    /**
     * Sets the title of the story
     * @param title
     */
    public void setTitle(String title) {
        setTitleChanged(true);
        this.title = title;
    }

    /**
     * Gets the title of the story
     * @return title
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Sets the description of the story
     * @param description
     */
    public void setDescription(String description) {
        setDescriptionChanged(true);
        this.description = description;
    }

    /**
     * Gets the description of the story
     * @return description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Sets the points of the story
     * @param points
     */
    public void setPoints(int points) {
        setPointsChanged(true);
        this.points = points;
    }

    /**
     * Gets the points
     * @return points
     */
    public int getPoints() {
        return this.points;
    }

    /**
     * Sets the status of the story
     * @param status
     */
    public void setStatus(Story.StoryStatus status) {
        setStatusChanged(true);
        this.status = status;
    }

    /**
     * Gets the status of the story
     * @return status
     */
    public Story.StoryStatus getStatus() {
        return this.status;
    }

    /**
     * Sets the sprint title/id
     * @param sprint_title_id
     */
    public void setSprintTitleAndId(String sprint_title_id) {
        setSprintChanged(true);
        this.sprint_title_id = sprint_title_id;
    }

    /**
     * Gets the sprint title/id
     * @return sprint_title_id
     */
    public String getSprintTitleAndId() {
        return this.sprint_title_id;
    }

    /**
     * Sets the completed points for the story
     * @param completed_points
     */
    public void setCompletedPoints(int completed_points) {
        this.completed_points_changed = true;
        this.completed_points = completed_points;
    }

    /**
     * Gets the completed points
     * @return completed_points
     */
    public int getCompleted_points() {
        return this.completed_points;
    }

    /**
     * Returns boolean based on whether the title of the story has changed
     * @return titleChanged
     */
    public boolean isTitleChanged() {
        return titleChanged;
    }

    /**
     * Sets whether the title has changed or not.
     * @param titleChanged
     */
    private void setTitleChanged(boolean titleChanged) {
        this.titleChanged = titleChanged;
    }

    /**
     * Returns boolean based on whether the description has changed
     * @return
     */
    public boolean isDescriptionChanged() {
        return descriptionChanged;
    }

    /**
     * Sets whether the description has changed or not
     * @param descriptionChanged
     */
    private void setDescriptionChanged(boolean descriptionChanged) {
        this.descriptionChanged = descriptionChanged;
    }

    /**
     * Returns boolean based on whether the status has changed or not
     * @return
     */
    public boolean isStatusChanged() {
        return statusChanged;
    }

    /**
     * Sets whether the status has changed or not
     * @param statusChanged
     */
    private void setStatusChanged(boolean statusChanged) {
        this.statusChanged = statusChanged;
    }

    /**
     * Returns boolean based on whether the sprint title/id has changed or not
     * @return
     */
    public boolean isSprintChanged() {
        return sprintChanged;
    }

    /**
     * Sets whether the sprint has changed or not
     * @param sprintChanged
     */
    private void setSprintChanged(boolean sprintChanged) {
        this.sprintChanged = sprintChanged;
    }

    /**
     * Returns boolean based on whether the points have changed or not
     * @return
     */
    public boolean arePointsChanged() {
        return this.points_changed;
    }

    /**
     * Sets whether the points have changed or not
     * @param points_changed
     */
    private void setPointsChanged(boolean points_changed) {
        this.points_changed = points_changed;
    }

    /**
     * Returns boolean based on whether the completed points have changed or not
     * @return
     */
    public boolean areCompletedPointsChanged() {
        return this.completed_points_changed;
    }

    /**
     * Sets whether the completed points have changed or not
     * @param completed_points_changed
     */
    private void setCompletedPointsChanged(boolean completed_points_changed) {
        this.completed_points_changed = completed_points_changed;
    }

    /**
     * Sets all of the attributes as not changed
     */
    public void setAttributesToNotChanged() {
        setDescriptionChanged(false);
        setSprintChanged(false);
        setStatusChanged(false);
        setTitleChanged(false);
        setCompletedPointsChanged(false);
        setPointsChanged(false);
    }
}
