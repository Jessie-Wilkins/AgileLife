package com.actual.myapplication;

import java.util.ArrayList;

/**
 * This class manages story objects and contains functions
 * and lists for editing, adding, and deleting stories.
 *
 * @author jessiewilkins
 * @since 2020-03-22
 */
class StoryManager {
    private static final ArrayList<Story> story_list = new ArrayList<>();
    private static StoryManager story_mgr = new StoryManager();
    private static final ArrayList<Story> deleted_story_list = new ArrayList<>();
    private static final ArrayList<Story> completed_story_list = new ArrayList<>();;

    private StoryManager() {

    }

    /**
     * Initiates story manager statically by clearing previous lists
     * and story ids.
     * @return story_mgr
     */
    public static StoryManager initiateStoryManager() {
        story_list.clear();
        IdGenerator.setStrategy(StoryIdGenerator.getStoryIdGenerator());
        IdGenerator.resetId();
        return story_mgr;

    }

    /**
     * Adds a story with default parameters
     */
    public void addStory() {
        story_list.add(new Story());
    }

    /**
     * Gets the specified story from the story list
     * @param id
     * @return Story (via story_list)
     */
    public Story getStory(long id) {
        return story_list.get(getIndex(id));
    }

    /**
     * Adds a story with the parameters from the story builder
     * @param builder
     */
    public void addStory(StoryBuilder builder) {
        Story story = new Story();
        story.setStoryAttributes(builder);
        story_list.add(story);
    }

    /**
     * Edits an existing specified story with parameters
     * specified in the story builder
     * @param id
     * @param builder
     */
    public void editStory(long id, StoryBuilder builder) {
        story_list.get(getIndex(id)).setStoryAttributes(builder);
    }

    /**
     * Edits an existing specified story with only
     * attributes that have changed in the builder
     * from the last "building"
     * @param id
     * @param builder
     */
    public void editStoryWithOnlyChangedAttributes(long id, StoryBuilder builder) {
        story_list.get(getIndex(id)).setChangedStoryAttributes(builder);
    }

    /**
     * Deletes the story with the specified id
     * @param id
     */
    public void deleteStory(long id) {
        initializeEmptyList(deleted_story_list);
        transferStoryFromListToList(id, story_list, deleted_story_list);
    }

    /**
     * Gets the deleted story from the deleted
     * list with the specified id.
     * @param id
     * @return Story (via deleted_story_list)
     */
    public Story getDeletedStory(long id) {
        try {
            return deleted_story_list.get(getIndex(id));
        }
        catch (Exception e) {
            return null;
        }
    }

    /**
     *
     */
    public void clearAllStoriesFromDeletedStoryList() {
        deleted_story_list.clear();
    }

    public long[] getDeletedStoriesIds() {
        long[] id_array = getStoryIds(deleted_story_list);
        return id_array;
    }

    public void retrieveStoryFromDeletedStoryList(long id) {
        initializeEmptyList(story_list);
        transferStoryFromListToList(id, deleted_story_list, story_list);
    }

    public void completeStory(long id) {
        initializeEmptyList(completed_story_list);
        transferStoryFromListToList(id, story_list, completed_story_list);
    }

    public Story getCompletedStory(long id) {
        return completed_story_list.get(getIndex(id));
    }

    public void retrieveStoryFromCompletedStoryList(long id) {
        initializeEmptyList(story_list);
        transferStoryFromListToList(id, completed_story_list, story_list);
    }

    public long[] getCompletedStoriesIds() {
        long[] id_array = getStoryIds(completed_story_list);
        return id_array;
    }

    public long[] getStoriesIds() {
        long[] id_array = getStoryIds(story_list);
        return id_array;
    }

    //Private Utilities Section

    private void transferStoryFromListToList(long id, ArrayList<Story> from_story_list, ArrayList<Story> to_story_list) {
        appendNullElements(id, from_story_list, to_story_list);
        to_story_list.set(getIndex(id), from_story_list.get(getIndex(id)));
        from_story_list.set(getIndex(id), null);
    }

    private void appendNullElements(long id, ArrayList<Story> from_story_list, ArrayList<Story> to_story_list) {
        while(to_story_list.size()<from_story_list.size()) {
            to_story_list.add(getIndex(id), null);
        }
    }

    private int getIndex(long id) {
        return (int) id - 1;
    }

    private void initializeEmptyList(ArrayList<Story> deleted_story_list) {
        if (deleted_story_list.isEmpty()) {
            deleted_story_list.add(0, null);
        }
    }

    private long[] getStoryIds(ArrayList<Story> completed_story_list) {
        int iter_index = 0;
        long[] id_array = new long[completed_story_list.size()];
        for (Story comp_story : completed_story_list) {
            if (comp_story != null) {
                id_array[iter_index] = comp_story.getId();
                iter_index++;
            }
        }
        return id_array;
    }
}
