package com.actual.myapplication;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class SprintTest {

    @Test
    public void canSetLabel() {
        Sprint spr_obj = new Sprint();
        spr_obj.setLabel("New Sprint");
        assertEquals("New Sprint", spr_obj.getLabel());
    }

    @Test
    public void canSetLength() {
        Sprint spr_obj = new Sprint();
        spr_obj.setLabel("New Sprint");
        spr_obj.setLength(3);
        assertEquals(3, spr_obj.getLength());
    }

}