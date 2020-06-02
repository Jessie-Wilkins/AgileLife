package com.actual.myapplication.Theories;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import org.junit.runner.RunWith;

import com.actual.myapplication.PointsManagement;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitQuickcheck.class)
public class PointsManagementTheories {

    @Property public void testThatTotalPointsIsAlwaysCompletedPointsPlusUnfinishedPoints(int completed_points, int unfinished_points) {
        PointsManagement points_management = new PointsManagement();
        points_management.addPoints(unfinished_points);
        points_management.setCompletedPoints(completed_points);
        assertEquals(completed_points+unfinished_points, points_management.getTotalPoints());
    }

    @Property public void testThatPointsCannotBeCompletedIfBelowZero(@InRange(min = "0", max = "100000")int completed_points, @InRange(min = "0", max = "100000")int unfinished_points) {
        PointsManagement points_management = new PointsManagement();
        points_management.addPoints(unfinished_points);
        points_management.completePoints(completed_points);
        assertEquals(true, points_management.getPoints()>=0);
    }

    @Property public void testThatCapacityCanNeverBeSetBelowZero(int capacity) {
        PointsManagement points_management = new PointsManagement();
        points_management.setCapacity(capacity);
        assertEquals(true, points_management.getCapacity()>=0);
    }

    @Property public void testThatCapacityCanNeverBeRemovedBelowZero(@InRange(minInt = 0) int capacity1, int capacity2) {
        PointsManagement points_management = new PointsManagement();
        points_management.addCapacity(capacity1);
        points_management.removeCapacity(capacity2);
        assertEquals(true, points_management.getCapacity()>=0);
    }

}
