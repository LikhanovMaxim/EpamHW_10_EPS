package com.epam.esp;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class RiskGroupTest {

    @Test
    public void testGetRange() throws Exception {
        RiskGroup group = new RiskGroup("NONE", new Range(1, 2));
        assertTrue(group.getRange().equals(new Range(1, 2)));
    }

    @Test
    public void testGetName() throws Exception {
        RiskGroup group = new RiskGroup("NONE", new Range(1, 2));
        assertTrue(group.getName().equals("NONE"));
    }
}