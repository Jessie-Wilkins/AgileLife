package com.actual.myapplication;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class PointsManagementTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void canAddPoints() {
        PointsManagement pnt_mgt_obj = new PointsManagement();
        pnt_mgt_obj.addPoints(1);
        assertEquals(1, pnt_mgt_obj.getPoints());
    }

    @Test
    public void canRemovePoints() {
        PointsManagement pnt_mgt_obj = new PointsManagement();
        pnt_mgt_obj.addPoints(1);
        pnt_mgt_obj.removePoints(1);
        assertEquals(0, pnt_mgt_obj.getPoints());
    }

    @Test
    public void cannotRemovePointsBelowZero() {
        PointsManagement pnt_mgt_obj = new PointsManagement();
        pnt_mgt_obj.addPoints(1);
        pnt_mgt_obj.removePoints(1);
        pnt_mgt_obj.removePoints(1);
        assertEquals(0, pnt_mgt_obj.getPoints());
    }


}