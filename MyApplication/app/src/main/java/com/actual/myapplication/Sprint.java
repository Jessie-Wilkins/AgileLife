package com.actual.myapplication;

/**
 * This class represents a sprint and contains methods and fields for
 * manipulating and holding relevant information.
 *
 * @author jessiewilkins
 * @since 2020-04-01
 */
public class Sprint {
    private String label = "Default Label";
    private int length = 0;
    private int frequency = 0;
    private PointsManagement points_management = new PointsManagement();
    private StoryManager story_mgr = StoryManager.initiateStoryManager();
    private StoryBuilder story_builder = StoryBuilder.initiateBuilder();

    private final int id;
    private int future_sprint_id = 0;
    private int past_sprint_id = 0;

    /**
     * Sets the id generator strategy.
     */
    public Sprint() {
        IdGenerator.setStrategy(SprintIdGenerator.getSprintIdGenerator());
        id = IdGenerator.generateId();
    }

    /**
     * Sets the label or title of the sprint
     * @param label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Gets the label or title of the sprint
     * @return label
     */
    public String getLabel() {
        return this.label;
    }

    /**
     * Sets the length of the sprint (in days)
     * @param length
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * Gets the length of the sprint (in days)
     * @return length
     */
    public int getLength() {
        return length;
    }

    /**
     * Sets the frequency of the sprint (in days)
     * @param frequency
     */
    public void setFrequencyInDays(int frequency) {
        this.frequency = frequency;
    }

    /**
     * Get the frequency of the sprint (in days)
     * @return frequency
     */
    public int getFrequencyInDays() {
        return this.frequency;
    }

    /**
     * Set the capacity of the sprint point object
     * @param capacity
     */
    public void setCapacity(int capacity) {
        this.points_management.setCapacity(capacity);
    }

    /**
     * Gets the capacity of the sprint
     * @return capacity (via points_management)
     */
    public int getCapacity() {
        return this.points_management.getCapacity();
    }

    /**
     * Adds a story from the story manager using the story id
     * @param id
     */
    public void addExistingStory(int id) {
        story_mgr.getStory(id).setSprintTitleAndId(getIdPlusLabel());
    }

    /**
     * Add brand new story to sprint
     */
    public void addNewStory() {
        this.story_builder.setSprintTitleAndId(getIdPlusLabel());
        this.story_mgr.addStory(this.story_builder);
    }

    /**
     * Add new story based on story builder attributes
     * @param story_builder
     */
    public void addNewStory(StoryBuilder story_builder) {
        this.story_mgr.addStory(story_builder);
    }

    /**
     * Gets the total assigned points from the stories assigned to the sprint
     * @return totalAssignedPoints
     */
    public int getTotalAssignedPoints() {
        int totalAssignedPoints = 0;

        totalAssignedPoints = iterateThroughStoryIdsForTotalPoints(totalAssignedPoints, PointTypes.TOTAL_POINTS);

        return totalAssignedPoints;
    }

    /**
     * Gets the total completed points from the stories assigned to the sprint
     * @return totalCompletedPoints
     */
    public int getTotalCompletedPoints() {
        int totalCompletedPoints = 0;

        totalCompletedPoints = iterateThroughStoryIdsForTotalPoints(totalCompletedPoints, PointTypes.COMPLETED_POINTS);

        return totalCompletedPoints;

    }

    /**
     * Gets the sprint id
     * @return id
     */
    public int getId() {
        return this.id;
    }

    /**
     * Gets the future sprint id
     * @return future_sprint_id
     */
    public int getFutureSprintId() {
        return future_sprint_id;
    }

    /**
     * Set the future sprint id
     * @param id
     */
    public void setFutureSprintId(int id) {
        future_sprint_id = id;
    }

    /**
     * Gets the past sprint id
     * @return past_sprint_id
     */
    public int getPastSprintId() {
        return past_sprint_id;
    }

    /**
     * Sets the past sprint id
     * @param id
     */
    public void setPastSprintId(int id) {
        past_sprint_id = id;
    }

    //Private Utilities
    private enum PointTypes {
        TOTAL_POINTS,
        COMPLETED_POINTS
    }

    private int iterateThroughStoryIdsForTotalPoints(int totalPoints, PointTypes point_types) {
        long [] stories_ids = this.story_mgr.getStoriesIds();
        for(long story_id : stories_ids) {
            if(this.story_mgr.getStory(story_id).getSprintTitleAndId().equals(getIdPlusLabel())) {
                if(point_types.equals(PointTypes.TOTAL_POINTS))
                    totalPoints += this.story_mgr.getStory(story_id).getPointsManagement().getTotalPoints();
                else
                    totalPoints += this.story_mgr.getStory(story_id).getPointsManagement().getCompletedPoints();
            }
        }
        return totalPoints;
    }

    private String getIdPlusLabel() {
        return this.id + ":" + getLabel();
    }
}
