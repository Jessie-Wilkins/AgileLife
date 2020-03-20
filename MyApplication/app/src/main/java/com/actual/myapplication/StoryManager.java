package com.actual.myapplication;

import java.util.ArrayList;

class StoryManager {
    private static final ArrayList<Story> story_list = new ArrayList<>();
    private static StoryManager story_mgr;
    private static int story_mgr_count = 0;
    private static final ArrayList<Story> deleted_story_list = new ArrayList<>();
    private static final ArrayList<Story> completed_story_list = new ArrayList<>();;

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
        return story_list.get(getIndex(id));
    }

    public void addStory(StoryBuilder builder) {
        Story story = new Story();
        story.setStoryAttributes(builder);
        story_list.add(story);
    }

    public void editStory(int id, StoryBuilder builder) {
        story_list.get(getIndex(id)).setStoryAttributes(builder);
    }

    public void editStoryWithOnlyChangedAttributes(int id, StoryBuilder builder) {
        story_list.get(getIndex(id)).setChangedStoryAttributes(builder);
    }

    public void deleteStory(int id) {
        initializeEmptyList(deleted_story_list);
        transferStoryFromListToList(id, story_list, deleted_story_list);
    }

    public Story getDeletedStory(int id) {
        try {
            return deleted_story_list.get(getIndex(id));
        }
        catch (Exception e) {
            return null;
        }
    }

    public void clearAllStoriesFromDeletedStoryList() {
        deleted_story_list.clear();
    }

    public int[] getDeletedStoriesIds() {
        int iter_index = 0;
        int[] id_array = new int[deleted_story_list.size()];
        for(Story del_story : deleted_story_list) {
            if(del_story !=null) {
                id_array[iter_index] = del_story.getId();
                iter_index++;
            }
        }
        return id_array;
    }

    public void retrieveStoryFromDeletedStoryList(int id) {
        initializeEmptyList(story_list);
        transferStoryFromListToList(id, deleted_story_list, story_list);
    }

    public void completeStory(int id) {
        initializeEmptyList(completed_story_list);
        transferStoryFromListToList(id, story_list, completed_story_list);
    }

    public Story getCompletedStory(int id) {
        return completed_story_list.get(getIndex(id));
    }

    public void retrieveStoryFromCompletedStoryList(int id) {
        initializeEmptyList(story_list);
        transferStoryFromListToList(id, completed_story_list, story_list);
    }

    //Private Utilities Section

    private void transferStoryFromListToList(int id, ArrayList<Story> from_story_list, ArrayList<Story> to_story_list) {
        to_story_list.add(getIndex(id), from_story_list.get(getIndex(id)));
        from_story_list.set(getIndex(id), null);
    }

    private int getIndex(int id) {
        return id - 1;
    }

    private void initializeEmptyList(ArrayList<Story> deleted_story_list) {
        if (deleted_story_list.isEmpty()) {
            deleted_story_list.add(0, null);
        }
    }

    public int[] getCompletedStoriesIds() {
        int iter_index = 0;
        int[] id_array = new int[completed_story_list.size()];
        for(Story comp_story : completed_story_list) {
            if(comp_story !=null) {
                id_array[iter_index] = comp_story.getId();
                iter_index++;
            }
        }
        return id_array;
    }
}
