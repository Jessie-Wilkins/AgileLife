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
    private boolean completed_points_changed = false;
    private boolean points_changed = false;
    private boolean sprintChanged = false;
    private boolean statusChanged = false;
    private boolean descriptionChanged = false;
    private boolean titleChanged = false;

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
        setTitleChanged(true);
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setDescription(String description) {
        setDescriptionChanged(true);
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setPoints(int points) {
        this.points_changed = true;
        this.points = points;
    }

    public int getPoints() {
        return this.points;
    }

    public void setStatus(Story.StoryStatus status) {
        setStatusChanged(true);
        this.status = status;
    }

    public Story.StoryStatus getStatus() {
        return this.status;
    }

    public void setSprint(String sprint) {
        setSprintChanged(true);
        this.sprint = sprint;
    }

    public String getSprint() {
        return this.sprint;
    }

    public void setCompletedPoints(int completed_points) {
        this.completed_points_changed = true;
        this.completed_points = completed_points;
    }

    public int getCompleted_points() {
        return this.completed_points;
    }

    public boolean isTitleChanged() {
        return titleChanged;
    }

    public void setTitleChanged(boolean titleChanged) {
        this.titleChanged = titleChanged;
    }

    public boolean isDescriptionChanged() {
        return descriptionChanged;
    }

    public void setDescriptionChanged(boolean descriptionChanged) {
        this.descriptionChanged = descriptionChanged;
    }

    public boolean isStatusChanged() {
        return statusChanged;
    }

    public void setStatusChanged(boolean statusChanged) {
        this.statusChanged = statusChanged;
    }

    public boolean isSprintChanged() {
        return sprintChanged;
    }

    public void setSprintChanged(boolean sprintChanged) {
        this.sprintChanged = sprintChanged;
    }

    public boolean arePointsChanged() {
        return this.points_changed;
    }

    public boolean areCompletedPointsChanged() {
        return this.completed_points_changed;
    }

    public void setAttributesToNotChanged() {
        setDescriptionChanged(false);
        setSprintChanged(false);
        setStatusChanged(false);
        setTitleChanged(false);
        this.completed_points_changed = false;
        this.points_changed = false;
    }
}
