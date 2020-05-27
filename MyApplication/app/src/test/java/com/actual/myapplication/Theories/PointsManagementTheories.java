package com.actual.myapplication.Theories;

import com.pholser.junit.quickcheck.Property;
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
        System.out.println("Completed Points: "+completed_points);
        System.out.println("Unfinished Points: "+unfinished_points);
        assertEquals(completed_points+unfinished_points, points_management.getTotalPoints());
    }

}
