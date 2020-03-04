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

    @Test
    public void canEnterPointsCapacity() {
        PointsManagement pnt_mgt_obj = new PointsManagement();
        pnt_mgt_obj.addPoints(1);
        pnt_mgt_obj.removePoints(1);
        pnt_mgt_obj.removePoints(1);
        pnt_mgt_obj.addCapacity(4);
        assertEquals(4, pnt_mgt_obj.getCapacity());
    }

    @Test
    public void canRemovePointsCapacity() {
        PointsManagement pnt_mgt_obj = new PointsManagement();
        pnt_mgt_obj.addPoints(1);
        pnt_mgt_obj.removePoints(1);
        pnt_mgt_obj.removePoints(1);
        pnt_mgt_obj.addCapacity(4);
        pnt_mgt_obj.removeCapacity(1);
        assertEquals(3, pnt_mgt_obj.getCapacity());
    }

    @Test
    public void cannotRemoveCapacityBelowZero() {
        PointsManagement pnt_mgt_obj = new PointsManagement();
        pnt_mgt_obj.addPoints(1);
        pnt_mgt_obj.removePoints(1);
        pnt_mgt_obj.removePoints(1);
        pnt_mgt_obj.addCapacity(4);
        pnt_mgt_obj.removeCapacity(1);
        pnt_mgt_obj.removeCapacity(4);
        assertEquals(3, pnt_mgt_obj.getCapacity());
    }

    @Test
    public void canMarkPointsAsCompleted() {
        PointsManagement pnt_mgt_obj = new PointsManagement();
        pnt_mgt_obj.addPoints(1);
        pnt_mgt_obj.removePoints(1);
        pnt_mgt_obj.removePoints(1);
        pnt_mgt_obj.addCapacity(4);
        pnt_mgt_obj.removeCapacity(1);
        pnt_mgt_obj.removeCapacity(4);
        pnt_mgt_obj.addPoints(3);
        pnt_mgt_obj.completePoints(2);
        assertEquals(1, pnt_mgt_obj.getPoints());
    }

    @Test
    public void canSeeCompletedPoints() {
        PointsManagement pnt_mgt_obj = new PointsManagement();
        pnt_mgt_obj.addPoints(1);
        pnt_mgt_obj.removePoints(1);
        pnt_mgt_obj.removePoints(1);
        pnt_mgt_obj.addCapacity(4);
        pnt_mgt_obj.removeCapacity(1);
        pnt_mgt_obj.removeCapacity(4);
        pnt_mgt_obj.addPoints(3);
        pnt_mgt_obj.completePoints(2);
        int complete_points = pnt_mgt_obj.getCompletedPoints();
        assertEquals(2, complete_points);
    }
}