package com.actual.myapplication;

class Story {
    private String title = "Default Title";

    public String getTitle() {
        return this.title;
    }

    public void setStoryAttributes(StoryBuilder attributes) {
        this.title = attributes.getTitle();
    }
}
