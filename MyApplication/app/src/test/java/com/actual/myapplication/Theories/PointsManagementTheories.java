package com.actual.myapplication.Theories;

import net.jqwik.api.*;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

public class PointsManagementTheories {

    @Property
    public void tests(@ForAll int test_value) {
        assertEquals(true, Math.abs(test_value) >= 0);
    }

}
