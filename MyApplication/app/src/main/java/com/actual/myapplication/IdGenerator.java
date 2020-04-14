package com.actual.myapplication;

/**
 * Manages id variable and the generation process
 * to ensure a unique id for story objects.
 *
 * @author jessiewilkins
 * @since 2020-02
 */
 abstract class IdGenerator {

    protected long id;

    protected IdGenerator() {

    }

    protected abstract void setChildId(long child_id);

    protected abstract long getChildId();

    public long generateId() {
        id = getChildId();
        ++id;
        setChildId(id);
        return id;
    }


    public void resetId() {
        id = 0;
        setChildId(0);
    }
}
