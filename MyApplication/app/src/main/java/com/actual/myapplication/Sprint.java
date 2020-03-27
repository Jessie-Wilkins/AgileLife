package com.actual.myapplication;

class Sprint {
    private String label = "Default Label";
    private int length = 0;
    private int frequency = 0;
    private PointsManagement points_management = new PointsManagement();
    private int capacity = 0;
    private StoryManager story_mgr = StoryManager.initiateStoryManager();

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
        StoryBuilder builder = StoryBuilder.initiateBuilder();
        builder.setSprint(getLabel());
        story_mgr.getStory(id).setChangedStoryAttributes(builder);
    }
}
