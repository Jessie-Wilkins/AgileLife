package com.actual.myapplication.Theories;

import org.junit.Test;

import org.junit.experimental.theories.*;
import org.junit.runner.RunWith;
import java.util.Random;
import static org.junit.Assert.assertThat;

@RunWith(value = Theories.class)
public class PointsManagementTheories {
    private static Random random_int = new Random();
    public static int [] randomly_generated_values = new int[100];

}
