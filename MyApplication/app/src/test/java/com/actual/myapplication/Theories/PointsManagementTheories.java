package com.actual.myapplication.Theories;

import net.jqwik.api.*;
//import org.junit.Test;
//import org.junit.Test;

//import static org.junit.Assert.assertEquals;

public class PointsManagementTheories {

    @Property
    boolean tests(@ForAll int test_value) {
        return Math.abs(test_value) >= 0;
    }

}
