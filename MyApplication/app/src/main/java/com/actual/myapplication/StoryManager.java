package com.actual.myapplication;

import java.util.ArrayList;

class StoryManager {
    private static final ArrayList<Story> story_list = new ArrayList<>();
    private static StoryManager story_mgr;
    private static int story_mgr_count = 0;

    private StoryManager() {

    }

    public static StoryManager initiateStoryManager() {
        story_list.clear();
        IdGenerator.resetId();
        if(story_mgr_count == 0) {
            story_mgr_count++;
            story_mgr = new StoryManager();
            return story_mgr;
        }
        else {
            return story_mgr;
        }

    }
    public void addStory() {
        story_list.add(new Story());
    }

    public Story getStory(int id) {
        return story_list.get(id-1);
    }

    public void addStory(StoryBuilder builder) {
        Story story = new Story();
        story.setStoryAttributes(builder);
        story_list.add(story);
    }

    public void editStory(int id, StoryBuilder builder) {
        story_list.get(id-1).setStoryAttributes(builder);
    }
}
