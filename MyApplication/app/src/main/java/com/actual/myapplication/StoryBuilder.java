package com.actual.myapplication;

class StoryBuilder {
    private static int builder_count = 0;
    private String title;

    private StoryBuilder() {

    }

    public static StoryBuilder initiateBuilder() {
        if(builder_count == 0) {
            return new StoryBuilder();
        }
        else {
            return null;
        }
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }
}
