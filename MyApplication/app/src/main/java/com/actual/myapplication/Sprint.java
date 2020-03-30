package com.actual.myapplication;

class Sprint {
    private String label = "Default Label";
    private int length = 0;
    private int frequency = 0;
    private PointsManagement points_management = new PointsManagement();
    private StoryManager story_mgr = StoryManager.initiateStoryManager();
    private StoryBuilder story_builder = StoryBuilder.initiateBuilder();

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setFrequencyInDays(int frequency) {
        this.frequency = frequency;
    }

    public int getFrequencyInDays() {
        return this.frequency;
    }

    public void setCapacity(int capacity) {
        this.points_management.setCapacity(capacity);
    }

    public int getCapacity() {
        return this.points_management.getCapacity();
    }

    public void addExistingStory(int id) {
        story_mgr.getStory(id).setSprint(getLabel());
    }

    public void addNewStory() {
        this.story_builder.setSprint(getLabel());
        this.story_mgr.addStory(this.story_builder);
    }

    public void addNewStory(StoryBuilder story_builder) {
        this.story_mgr.addStory(story_builder);
    }

    public int getTotalAssignedPoints() {
        //for(int i = 0;)
        //this.story_mgr.getStory().getSprint()
        return 0;
    }
}